using static ManejoValorWrappper;
using Analizador;
using System.Globalization;

public class InterpreteVisitor : LanguageBaseVisitor<ValorWrapper>
{
    private static readonly HashSet<string> PalabrasReservadas = new HashSet<string>
    {
        "if", "else", "while", "for", "return", "class", "public", "private", "static", "void", 
    };

    public string Salida = "";
    public Entorno EntornoActual = new Entorno(null);
    private ValorWrapper ValorVoid = new ValorVoid();

    private ValorFuncion? MainFunction = null;

    // VisitProgram
    public override ValorWrapper VisitProgram(LanguageParser.ProgramContext context)
    {
        foreach (var sentencia in context.declaraciones())
        {
            Visit(sentencia);
        }

        if (MainFunction != null)
        {
            try
            {
                MainFunction.Invocable.Invoke(new List<ValorWrapper>(), this);
            }
            catch (Exception ex)
            {
                throw new ErrorSemantico(ex.Message, context.Start);
            }
        }
        else
        {
            throw new ErrorSemantico("No se encontró la función 'main' en el programa.", context.Start);
        }

        return ValorVoid;
    }
    //VisitExpresionSentencia
    public override ValorWrapper VisitExpresionSentencia(LanguageParser.ExpresionSentenciaContext context)
    {
        return Visit(context.expresion());
    }
    // VisitBloque
    public override ValorWrapper VisitBloque(LanguageParser.BloqueContext context)
    {
        Entorno EntornoPrevio =  EntornoActual;
        EntornoActual = new Entorno(EntornoPrevio);
        foreach (var sentencia in context.declaraciones())
        {
            Visit(sentencia);
        }
        EntornoActual = EntornoPrevio;
        return ValorVoid;
    }

    //VisitEntero
    public override ValorWrapper VisitEntero(LanguageParser.EnteroContext context)
    {
        return new ValorInt(int.Parse(context.ENTERO().GetText()));
    }
    //VisitDecimal
    public override ValorWrapper VisitDecimal(LanguageParser.DecimalContext context)
    {
        return new ValorFloat64(float.Parse(context.DECIMAL().GetText(), CultureInfo.InvariantCulture));
    }
    // VisitCadena
    public override ValorWrapper VisitCadena(LanguageParser.CadenaContext context)
    {
        string cadena = context.CADENA().GetText();
        cadena = cadena.Substring(1, cadena.Length - 2);
        cadena = cadena
            .Replace("\\\"", "\"")
            .Replace("\\\\", "\\")
            .Replace("\\n", "\n")
            .Replace("\\r", "\r")
            .Replace("\\t", "\t");
        return new ValorString(cadena);
    }
    // VisitBooleano
    public override ValorWrapper VisitBooleano(LanguageParser.BooleanoContext context)
    {
        return new ValorBoolean(bool.Parse(context.BOOLEANO().GetText()));
    }

    // VisitCaracter
    public override ValorWrapper VisitCaracter(LanguageParser.CaracterContext context)
    {
        string caracter = context.CARACTER().GetText();
        return new ValorRune(caracter[1]);
    }
    // VisitNil
    public override ValorWrapper VisitNil(LanguageParser.NilContext context)
    {
        return new ValorNil();
    }
    // VisitIdentificador
    public override ValorWrapper VisitIdentificador(LanguageParser.IdentificadorContext context)
    {
        return EntornoActual.Obtener(context.IDENTIFICADOR().GetText(), context.Start);
    }
    // VisitDeclaracionExplicita
    public override ValorWrapper VisitDeclaracionExplicita(LanguageParser.DeclaracionExplicitaContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper expresion = Visit(context.expresion());
        string tipo = context.TIPO().GetText();
        if (expresion is ValorInt && tipo == "float64"){
            expresion = new ValorFloat64(float.Parse(ObtenerValor(expresion), CultureInfo.InvariantCulture));
            EntornoActual.Declarar(identificador, expresion, context.Start.Line, context.Start.Column, context.Start);
            return ValorVoid;
        } else if (!ObtenerTipo(expresion).Equals(tipo, StringComparison.Ordinal)){
            throw new ErrorSemantico("Declaración: Tipo de Dato: " + tipo + " No Coincide con el Valor: " + ObtenerTipo(expresion), context.Start);
        }else{
            EntornoActual.Declarar(identificador, expresion, context.Start.Line, context.Start.Column, context.Start);
            return ValorVoid;
        }
    }
    // VisitDeclaracionImplicita
    public override ValorWrapper VisitDeclaracionImplicita(LanguageParser.DeclaracionImplicitaContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper expresion = Visit(context.expresion());
        EntornoActual.Declarar(identificador, expresion, context.Start.Line, context.Start.Column, context.Start);
        return ValorVoid;
    }
    // VisitDeclaracionPorDefecto
    public override ValorWrapper VisitDeclaracionPorDefecto(LanguageParser.DeclaracionPorDefectoContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        string tipo = context.TIPO().GetText();
        switch (tipo){
            case "int":
                EntornoActual.Declarar(identificador, new ValorInt(0), context.Start.Line, context.Start.Column, context.Start);
                break;
            case "float64":
                EntornoActual.Declarar(identificador, new ValorFloat64(0), context.Start.Line, context.Start.Column, context.Start);
                break;
            case "string":
                EntornoActual.Declarar(identificador, new ValorString(""), context.Start.Line, context.Start.Column, context.Start);
                break;
            case "bool":
                EntornoActual.Declarar(identificador, new ValorBoolean(false), context.Start.Line, context.Start.Column, context.Start);
                break;
            case "rune":
                EntornoActual.Declarar(identificador, new ValorRune('0'), context.Start.Line, context.Start.Column, context.Start);
                break;
            default:
                throw new ErrorSemantico("Tipo de Dato: " + tipo + " No Encontrado", context.Start);
            }
        return ValorVoid;
    }
    //VisitAsignacionVariable
    public override ValorWrapper VisitAsignacionVariable(LanguageParser.AsignacionVariableContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper expresion = Visit(context.expresion());
        ValorWrapper variable = EntornoActual.Obtener(identificador, context.Start);

        if (expresion is ValorInt && variable is ValorFloat64){
            expresion = new ValorFloat64(float.Parse(ObtenerValor(expresion), CultureInfo.InvariantCulture));
            return EntornoActual.Asignar(identificador, expresion, context.Start);
        } else if (ObtenerTipo(expresion).Equals(ObtenerTipo(variable), StringComparison.Ordinal)){
            return EntornoActual.Asignar(identificador, expresion, context.Start);
        }
        throw new ErrorSemantico("Asignación: Tipo de Dato: " + ObtenerTipo(expresion) + " No Coincide con el Valor: " + ObtenerTipo(variable), context.Start);
    }
    // VisitFuncionEmbebidaPrintln
    public override ValorWrapper VisitFuncionEmbebidaPrintln(LanguageParser.FuncionEmbebidaPrintlnContext context)
    {
        if (context.expresion() == null)
        {
            Salida += "\n";
            return ValorVoid;
        }

        List<string> ValoresSalida = new List<string>();

        foreach (var expre in context.expresion())
        {
            ValorWrapper expresion = Visit(expre);
            ValoresSalida.Add(ObtenerValor(expresion));
        }

        Salida += string.Join(" ", ValoresSalida) + "\n";
        return ValorVoid;
    }

    // VisitFuncionEmbebidaAtoi
    public override ValorWrapper VisitFuncionEmbebidaAtoi(LanguageParser.FuncionEmbebidaAtoiContext context)
    {
        
        ValorWrapper expresion = Visit(context.expresion());
        if (expresion is ValorString){
            if (int.TryParse(ObtenerValor(expresion), out int result)){
                return new ValorInt(result);
            }
            throw new ErrorSemantico("Función Atoi: Valor: " + ObtenerValor(expresion) + " No es un Entero", context.Start);
        }
        throw new ErrorSemantico("Función Atoi: Tipo de Dato: " + ObtenerTipo(expresion) + " No Coincide con el Valor: string", context.Start);

    }
    // VisitFuncionEmbebidaParseFloat
    public override ValorWrapper VisitFuncionEmbebidaParseFloat(LanguageParser.FuncionEmbebidaParseFloatContext context)
    {
        ValorWrapper expresion = Visit(context.expresion());
        if (expresion is ValorString || expresion is ValorInt){
            if (float.TryParse(ObtenerValor(expresion), NumberStyles.Any, CultureInfo.InvariantCulture, out float result)){
                return new ValorFloat64(result);
            }
            throw new ErrorSemantico("Función ParseFloat: Valor: " + ObtenerValor(expresion) + " No es un Decimal", context.Start);
        }
        throw new ErrorSemantico("Función ParseFloat: Tipo de Dato: " + ObtenerTipo(expresion) + " No Coincide con el Valor: string", context.Start);
    }
    //VisitFuncionEmbebidaReflectTypeOf
    public override ValorWrapper VisitFuncionEmbebidaReflectTypeOf(LanguageParser.FuncionEmbebidaReflectTypeOfContext context)
    {
        ValorWrapper expresion = Visit(context.expresion());
        if(expresion is ValorSlice Arreglo)
        {
            return new ValorString("[]"+Arreglo.Tipo);
        }
        return new ValorString(ObtenerTipo(expresion));
    }
    // VisitParentesis
    public override ValorWrapper VisitParentesis(LanguageParser.ParentesisContext context)
    {
        return Visit(context.expresion());
    }
    // VisitSumaResta
    public override ValorWrapper VisitSumaResta(LanguageParser.SumaRestaContext context)
    {
        ValorWrapper izquierda = Visit(context.izquierda);
        ValorWrapper derecha = Visit(context.derecha);
        string operador = context.operador.Text;
        Binaria binaria = new Binaria(izquierda, derecha, operador, context.Start);
        return binaria.RealizarOperacion();
    }
    //VisitMultiplicacionDivisionModulo
    public override ValorWrapper VisitMultiplicacionDivisionModulo(LanguageParser.MultiplicacionDivisionModuloContext context)
    {
        ValorWrapper izquierda = Visit(context.izquierda);
        ValorWrapper derecha = Visit(context.derecha);
        string operador = context.operador.Text;
        Binaria binaria = new Binaria(izquierda, derecha, operador, context.Start);
        return binaria.RealizarOperacion();
    }
    //VisitNegacionUnaria
    public override ValorWrapper VisitNegacionUnaria(LanguageParser.NegacionUnariaContext context)
    {
        ValorWrapper izquierda = Visit(context.izquierda);
        string operador = context.operador.Text;
        Unaria unaria = new Unaria(izquierda, operador, context.Start);
        return unaria.RealizarOperacion();
    }
    //VisitNegacionLogica
    public override ValorWrapper VisitNegacionLogica(LanguageParser.NegacionLogicaContext context)
    {
        ValorWrapper izquierda = Visit(context.izquierda);
        string operador = context.operador.Text;
        Unaria unaria = new Unaria(izquierda, operador, context.Start);
        return unaria.RealizarOperacion();
    }
    //VisitIgualdadDesigualdad
    public override ValorWrapper VisitIgualdadDesigualdad(LanguageParser.IgualdadDesigualdadContext context)
    {
        ValorWrapper izquierda = Visit(context.izquierda);
        ValorWrapper derecha = Visit(context.derecha);
        string operador = context.operador.Text;
        Binaria binaria = new Binaria(izquierda, derecha, operador, context.Start);
        return binaria.RealizarOperacion();
    }
    //VisitRelacional
    public override ValorWrapper VisitRelacional(LanguageParser.RelacionalContext context)
    {
        ValorWrapper izquierda = Visit(context.izquierda);
        ValorWrapper derecha = Visit(context.derecha);
        string operador = context.operador.Text;
        Binaria binaria = new Binaria(izquierda, derecha, operador, context.Start);
        return binaria.RealizarOperacion();
    }

    //VisitLogicoAnd
    public override ValorWrapper VisitLogicoAnd(LanguageParser.LogicoAndContext context)
    {
        ValorWrapper izquierda = Visit(context.izquierda);
        ValorWrapper derecha = Visit(context.derecha);
        string operador = context.operador.Text;
        Binaria binaria = new Binaria(izquierda, derecha, operador, context.Start);
        return binaria.RealizarOperacion();
    }
    //VisitLogicoOr
    public override ValorWrapper VisitLogicoOr(LanguageParser.LogicoOrContext context)
    {
        ValorWrapper izquierda = Visit(context.izquierda);
        ValorWrapper derecha = Visit(context.derecha);
        string operador = context.operador.Text;
        Binaria binaria = new Binaria(izquierda, derecha, operador, context.Start);
        return binaria.RealizarOperacion();
    }
    //VisitAsignacionVariableSuma
    public override ValorWrapper VisitAsignacionVariableSuma(LanguageParser.AsignacionVariableSumaContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        // Izquierda
        ValorWrapper izquierda = Visit(context.expresion());
        // Derecha
        ValorWrapper variable = EntornoActual.Obtener(identificador, context.Start);

        if (izquierda is ValorInt && variable is ValorFloat64){
            Binaria binaria = new Binaria(variable, izquierda, "+", context.Start);
            ValorWrapper resultado = binaria.RealizarOperacion();
            return EntornoActual.Asignar(identificador, resultado, context.Start);
        } else if (ObtenerTipo(izquierda).Equals(ObtenerTipo(variable), StringComparison.Ordinal)){
            Binaria binaria = new Binaria(variable, izquierda, "+", context.Start);
            ValorWrapper resultado = binaria.RealizarOperacion();
            return EntornoActual.Asignar(identificador, resultado, context.Start);
        }
        throw new ErrorSemantico("Asignación: Tipo de Dato: " + ObtenerTipo(izquierda) + " No Coincide con el Valor: " + ObtenerTipo(variable), context.Start);
    }
    // VisitAsignacionVariableResta
    public override ValorWrapper VisitAsignacionVariableResta(LanguageParser.AsignacionVariableRestaContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        // Izquierda
        ValorWrapper izquierda = Visit(context.expresion());
        // Derecha
        ValorWrapper variable = EntornoActual.Obtener(identificador, context.Start);

        if (izquierda is ValorInt && variable is ValorFloat64){
            Binaria binaria = new Binaria(variable, izquierda, "-", context.Start);
            ValorWrapper resultado = binaria.RealizarOperacion();
            return EntornoActual.Asignar(identificador, resultado, context.Start);
        } else if (ObtenerTipo(izquierda).Equals(ObtenerTipo(variable), StringComparison.Ordinal)){
            Binaria binaria = new Binaria(variable, izquierda, "-", context.Start);
            ValorWrapper resultado = binaria.RealizarOperacion();
            return EntornoActual.Asignar(identificador, resultado, context.Start);
        }
        throw new ErrorSemantico("Asignación: Tipo de Dato: " + ObtenerTipo(izquierda) + " No Coincide con el Valor: " + ObtenerTipo(variable), context.Start);
    }

    // VisitCreacionArreglo 
    public override ValorWrapper VisitCreacionArreglo(LanguageParser.CreacionArregloContext context)
    {
        List<ValorWrapper> ValoresArreglo = new List<ValorWrapper>();
        string TipoArreglo = context.TIPO().GetText();
        foreach (var expre in context.expresion())
        {
            ValorWrapper ValoresArregloAuxiliar = Visit(expre);
            if (ObtenerTipo(ValoresArregloAuxiliar) != TipoArreglo)
            {
                throw new ErrorSemantico("Creación de Arreglo: Tipo de Dato Arreglo: " + TipoArreglo + " No Coincide con el Valor: " + ObtenerTipo(ValoresArregloAuxiliar), context.Start);
            }
            ValoresArreglo.Add(ValoresArregloAuxiliar);
        }
        return new ValorSlice(ValoresArreglo, TipoArreglo);
    }
    // VisitDeclaracionArregloExplicita
    public override ValorWrapper VisitDeclaracionArregloExplicita(LanguageParser.DeclaracionArregloExplicitaContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper NuevoArreglo = Visit(context.expresion());
        EntornoActual.Declarar(identificador, NuevoArreglo, context.Start.Line, context.Start.Column, context.Start);
        return ValorVoid;
    }
    // VisitDeclaracionArregloPorDefecto
    public override ValorWrapper VisitDeclaracionArregloPorDefecto(LanguageParser.DeclaracionArregloPorDefectoContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        string TipoArreglo = context.TIPO().GetText();
        List<ValorWrapper> ArregloAuxiliar = new List<ValorWrapper>();
        ValorWrapper NuevoArreglo = new ValorSlice(ArregloAuxiliar, TipoArreglo);
        EntornoActual.Declarar(identificador, NuevoArreglo, context.Start.Line, context.Start.Column, context.Start);
        return ValorVoid;
    }
    // VisitFuncionEmbebidaSlicesIndex
    public override ValorWrapper VisitFuncionEmbebidaSlicesIndex(LanguageParser.FuncionEmbebidaSlicesIndexContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper ArregloActual = EntornoActual.Obtener(identificador, context.Start);

        if (ArregloActual is ValorSlice Arreglo)
        {
            ValorWrapper ValorBuscado = Visit(context.expresion());
            if(!(Arreglo.Tipo).Equals(ObtenerTipo(ValorBuscado), StringComparison.Ordinal))
            {
                throw new ErrorSemantico("Función Slices: Tipo de Dato: " + ObtenerTipo(ValorBuscado) + " No Coincide con el Valor: " + Arreglo.Tipo, context.Start);
            }
            
            for (int i = 0; i < Arreglo.Valores.Count; i++)
            {
                if (Arreglo.Valores[i].Equals(ValorBuscado))
                {
                    return new ValorInt(i);
                }
            }
            return new ValorInt(-1);
        }
        throw new ErrorSemantico("Función Slices: La Variable: " + identificador + " No es un Arreglo", context.Start);
    }

    // VisitFuncionEmbebidaStringsJoin
    public override ValorWrapper VisitFuncionEmbebidaStringsJoin(LanguageParser.FuncionEmbebidaStringsJoinContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper ArregloActual = EntornoActual.Obtener(identificador, context.Start);
        ValorWrapper Separador = Visit(context.expresion());

        if (!(Separador is ValorString))
            throw new ErrorSemantico("Función Join: El Separador: " + ObtenerValor(Separador) + " No es un String", context.Start);
        
        if (ArregloActual is ValorSlice Arreglo1)
            if (Arreglo1.Tipo != "string")
            throw new ErrorSemantico("Función Join: Tipo de Dato Arreglo: " + Arreglo1.Tipo + " No es un String", context.Start);
        
        if (ArregloActual is ValorSlice Arreglo2)
        {
            List<string> ValoresArreglo = Arreglo2.Valores.Select(valor => ObtenerValor(valor)).ToList();
            return new ValorString(string.Join(ObtenerValor(Separador), ValoresArreglo));
        }
        throw new ErrorSemantico("Función Join: La Variable: " + identificador + " No es un Arreglo", context.Start);
    }
    // VisitFuncionEmbebidaLen
    public override ValorWrapper VisitFuncionEmbebidaLen(LanguageParser.FuncionEmbebidaLenContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper ArregloActual = EntornoActual.Obtener(identificador, context.Start);
        if (context.expresion().Length > 0)
        {
            foreach (var expr in context.expresion())
            {
                ValorWrapper IndiceAuxiliar = Visit(expr);
                if (!(IndiceAuxiliar is ValorInt indice))
                    throw new ErrorSemantico("Función Len: El índice debe ser un entero", context.Start);
                if (ArregloActual is ValorSlice ArregloAuxiliar)
                {
                    if (indice.Valor < 0 || indice.Valor >= ArregloAuxiliar.Valores.Count)
                        throw new ErrorSemantico($"Función Len: Índice fuera de rango en {identificador}", context.Start);
                    ArregloActual = ArregloAuxiliar.Valores[indice.Valor];
                }
                else
                {
                    throw new ErrorSemantico($"Función Len: La variable {identificador} no es un arreglo en el nivel esperado", context.Start);
                }
            }
        }
        if (ArregloActual is ValorSlice ArregloFinal)
        {
            return new ValorInt(ArregloFinal.Valores.Count);
        }
        throw new ErrorSemantico($"Función Len: {identificador} no es un arreglo", context.Start);
    }

    // VisitFuncionEmbebidaAppend
    public override ValorWrapper VisitFuncionEmbebidaAppend(LanguageParser.FuncionEmbebidaAppendContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper ArregloActual = EntornoActual.Obtener(identificador, context.Start);
        ValorWrapper ValorNuevo = Visit(context.expresion());

        if (ArregloActual is ValorSlice Arreglo)
        {
            if (!Arreglo.Tipo.Equals(ObtenerTipo(ValorNuevo), StringComparison.Ordinal))
            {
                throw new ErrorSemantico("Función Append: Tipo de Dato Arreglo: " + Arreglo.Tipo + " No Coincide con el Valor: " + ObtenerTipo(ValorNuevo), context.Start);
            }
            Arreglo.Valores.Add(ValorNuevo);
            return ArregloActual;
        }
        throw new ErrorSemantico("Función Append: La Variable: " + identificador + " No es un Arreglo", context.Start);
    }
    // VisitAccesoArreglo
    public override ValorWrapper VisitAccesoArreglo(LanguageParser.AccesoArregloContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper ArregloActual = EntornoActual.Obtener(identificador, context.Start);
        ValorWrapper Indice = Visit(context.expresion());

        if (ArregloActual is not ValorSlice Arreglo)
            throw new ErrorSemantico("Acceso Arreglo: La Variable: " + identificador + " No es un Arreglo", context.Start);
        
        if (Indice is not ValorInt IndiceInt)
            throw new ErrorSemantico("Acceso Arreglo: Tipo de Dato: " + ObtenerTipo(Indice) + " No es un Entero", context.Start);
            
        if ((IndiceInt.Valor >= 0) && (IndiceInt.Valor < Arreglo.Valores.Count))
            return Arreglo.Valores[IndiceInt.Valor];
        else
            throw new ErrorSemantico("Acceso Arreglo: Indice: " + IndiceInt.Valor + " Fuera de Rango", context.Start);
    }
    // VisitAsignacionArreglo
    public override ValorWrapper VisitAsignacionArreglo(LanguageParser.AsignacionArregloContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper ArregloActual = EntornoActual.Obtener(identificador, context.Start);
        ValorWrapper Indice = Visit(context.indice);
        ValorWrapper ValorNuevo = Visit(context.valornuevo);

        if (ArregloActual is not ValorSlice Arreglo)
            throw new ErrorSemantico("Asignación Arreglo: La Variable: " + identificador + " No es un Arreglo", context.Start);
        
        if (Indice is not ValorInt IndiceInt)
            throw new ErrorSemantico("Asignación Arreglo: Tipo de Dato: " + ObtenerTipo(Indice) + " No es un Entero", context.Start);
            
        if ((IndiceInt.Valor >= 0) && (IndiceInt.Valor < Arreglo.Valores.Count))
        {
            if (Arreglo.Tipo.Equals(ObtenerTipo(ValorNuevo), StringComparison.Ordinal))
            {
                Arreglo.Valores[IndiceInt.Valor] = ValorNuevo;
                return ValorVoid;
            }
            throw new ErrorSemantico("Asignación Arreglo: Tipo de Dato Arreglo: " + Arreglo.Tipo + " No Coincide con el Valor: " + ObtenerTipo(ValorNuevo), context.Start);
        }
        throw new ErrorSemantico("Asignación Arreglo: Indice: " + IndiceInt.Valor + " Fuera de Rango", context.Start);
    }

    // VisitSentenciaIf
    public override ValorWrapper VisitSentenciaIf(LanguageParser.SentenciaIfContext context)
    {
        ValorWrapper Condicion = Visit(context.expresion());
        if (Condicion is not ValorBoolean CondicionBoolean)
            throw new ErrorSemantico("Sentencia If: Tipo de Dato: " + ObtenerTipo(Condicion) + " No es un Booleano", context.Start);

        if (CondicionBoolean.Valor)
        {
            Visit(context.sentencia(0));
        }
        else if (context.sentencia().Length > 1)
        {
            Visit(context.sentencia(1));
        }
        return Condicion;
    }
    // VisitSentenciaSwitch
    public override ValorWrapper VisitSentenciaSwitch(LanguageParser.SentenciaSwitchContext context)
    {  
        ValorWrapper Condicion = Visit(context.condicion);
        bool CasoCoincide = false;

        foreach (var caso in context.casos_switch())
        {
            ValorWrapper CondicionCaso = Visit(caso.expresion());

            if (Condicion.Equals(CondicionCaso))
            {
                CasoCoincide = true;
                try
                {
                    foreach (var sentencia in caso.declaraciones())
                    {
                        Visit(sentencia);
                    }
                }
                catch (ExceptionBreack)
                {
                    break;
                }
                break; 
            }
        }
        if (!CasoCoincide && context.default_switch() != null)
        {
            try
            {
                foreach (var sentencia in context.default_switch().declaraciones())
                {
                    Visit(sentencia);
                }
            }
            catch (ExceptionBreack)
            {
                // Ignorar y salir del switch
            }
        }
        return ValorVoid;
    }
    //VisitSentenciaBreak
    public override ValorWrapper VisitSentenciaBreak(LanguageParser.SentenciaBreakContext context)
    {
        throw new ExceptionBreack();
    }
    //VisitSentenciaContinue
    public override ValorWrapper VisitSentenciaContinue(LanguageParser.SentenciaContinueContext context)
    {
        throw new ExceptionContinue();
    }
    //VisitSentenciaReturn
    public override ValorWrapper VisitSentenciaReturn(LanguageParser.SentenciaReturnContext context)
    {
        ValorWrapper Valor = ValorVoid;
        if (context.expresion() != null)
        {
            Valor = Visit(context.expresion());
        }
        throw new ExceptionReturn(Valor);
    }
    // VisitSentenciaForSimple
   public override ValorWrapper VisitSentenciaForSimple(LanguageParser.SentenciaForSimpleContext context)
    {
        ValorWrapper Condicion = Visit(context.condicion);
        if (Condicion is not ValorBoolean CondicionWhile)
            throw new ErrorSemantico("Sentencia For Simple: Tipo de Dato: " + ObtenerTipo(Condicion) + " No es un Booleano", context.Start);
        while (CondicionWhile.Valor)
        {
            try
            {
                Visit(context.sentencia());
            }
            catch (ExceptionContinue)
            {
                Visit(context.expresion());
                Condicion = Visit(context.condicion);
                CondicionWhile = (ValorBoolean)Condicion;
                continue;
            }
            catch (ExceptionBreack)
            {
                break;
            }
            Visit(context.expresion());
            Condicion = Visit(context.condicion);
            CondicionWhile = (ValorBoolean)Condicion;
        }
        return ValorVoid;
    }
    // VisitSentenciaForCompuesta
    public override ValorWrapper VisitSentenciaForCompuesta(LanguageParser.SentenciaForCompuestaContext context)
    {
        Entorno EntornoPrevio = EntornoActual;
        EntornoActual = new Entorno(EntornoActual);
        Visit(context.for_init());
        VisitCuerpoFor(context);
        EntornoActual = EntornoPrevio;
        return ValorVoid;
    }
    public void VisitCuerpoFor(LanguageParser.SentenciaForCompuestaContext context)
    {
        ValorWrapper Condicion = Visit(context.condicion);
        if (Condicion is not ValorBoolean CondicionWhile)
            throw new ErrorSemantico("Sentencia For Compuesto: Tipo de Dato: " + ObtenerTipo(Condicion) + " No es un Booleano", context.Start);

        while (CondicionWhile.Valor) 
        {
            try 
            {
                Visit(context.sentencia());
            }
            catch (ExceptionContinue) 
            {
                Visit(context.incremento);
                Condicion = Visit(context.condicion);
                CondicionWhile = (ValorBoolean)Condicion;
                continue;
            }
            catch (ExceptionBreack) 
            {
                return;
            }
            Visit(context.incremento);
            Condicion = Visit(context.condicion);
            CondicionWhile = (ValorBoolean)Condicion;
        }
    }
    // VisitSentenciaForRange
    public override ValorWrapper VisitSentenciaForRange(LanguageParser.SentenciaForRangeContext context)
    {
        string Indice = context.indice.Text;
        string Valor = context.valor.Text;
        string Slice = context.slice.Text;

        ValorWrapper Arreglo = EntornoActual.Obtener(Slice, context.Start);

        if (Arreglo is not ValorSlice Arreglo1)
            throw new ErrorSemantico("Sentencia For Range: La Variable: " + Slice + " No es un Arreglo", context.Start);

        for (int i = 0; i < Arreglo1.Valores.Count; i++)
        {
            // Crear un nuevo EntornoActual para cada iteración
            Entorno EntornoPrevio = EntornoActual;
            EntornoActual = new Entorno(EntornoPrevio);
            // Asignar índice y valor dentro del nuevo EntornoActual
            EntornoActual.Declarar(Indice, new ValorInt(i), context.Start.Line, context.Start.Column, context.Start);
            EntornoActual.Declarar(Valor, Arreglo1.Valores[i], context.Start.Line, context.Start.Column, context.Start);
            // Ejecutar la sentencia dentro del for
            Visit(context.sentencia());
            EntornoActual = EntornoPrevio;
        }
        return ValorVoid;
    }
    public override ValorWrapper VisitDeclaracionMatrizExplicita(LanguageParser.DeclaracionMatrizExplicitaContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        string TipoMatriz = context.TIPO().GetText();
        // Construir La Matriz
        ValorWrapper Matriz = VisitContenidoMatriz(context.contenido_matriz(), TipoMatriz);
        EntornoActual.Declarar(identificador, Matriz, context.Start.Line, context.Start.Column, context.Start);
        return ValorVoid;
    }

    private ValorWrapper VisitContenidoMatriz(LanguageParser.Contenido_matrizContext context, string TipoMatriz)
    {
        // Lista para almacenar todos los elementos de este nivel
        List<ValorWrapper> elementos = new List<ValorWrapper>();
        // Si no hay elementos, devolvemos un arreglo vacío
        if (context.elementos_matriz() == null)
        {
            return new ValorSlice(elementos, TipoMatriz);
        }
        // Visitar cada elemento de la Matriz
        foreach (var elemento in context.elementos_matriz().elemento_matriz())
        {
            if (elemento.contenido_matriz() != null)
            {
                // Es una SubMatriz, visitar recursivamente
                elementos.Add(VisitContenidoMatriz(elemento.contenido_matriz(), TipoMatriz));
            }
            else if (elemento.lista_valores() != null)
            {
                // Es una lista de valores, procesarla
                elementos.Add(ProcesarListaValores(elemento.lista_valores(), TipoMatriz));
            }
        }
        // Crear y devolver el arreglo que representa esta Matriz o SubMatriz
        return new ValorSlice(elementos, TipoMatriz);
    }

    private ValorWrapper ProcesarListaValores(LanguageParser.Lista_valoresContext context, string TipoMatriz)
    {
        List<ValorWrapper> valores = new List<ValorWrapper>();
        
        // Si no hay expresiones, devolvemos una lista vacía
        if (context.expresion() == null || !context.expresion().Any())
        {
            return new ValorSlice(valores, TipoMatriz);
        }
        // Visitar cada expresión y agregarla a la lista
        foreach (var expresion in context.expresion())
        {
            ValorWrapper valor = Visit(expresion);
            if (!TipoMatriz.Equals(ObtenerTipo(valor), StringComparison.Ordinal))
                throw new ErrorSemantico($"Error de tipo: Se esperaba {TipoMatriz} pero se encontró {ObtenerTipo(valor)}", context.Start);
            valores.Add(valor);
        }
        return new ValorSlice(valores, TipoMatriz);
    }

    // VisitAsignacionMatriz
    public override ValorWrapper VisitAsignacionMatriz(LanguageParser.AsignacionMatrizContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper MatrizActual = EntornoActual.Obtener(identificador, context.Start);
        ValorWrapper NuevoValor = Visit(context.valornuevo);
        
        if (MatrizActual is not ValorSlice Matriz)
            throw new ErrorSemantico("Asignación Matriz: La Variable "+ identificador + "no es una Matriz", context.Start);
        
        if (!Matriz.Tipo.Equals(ObtenerTipo(NuevoValor), StringComparison.Ordinal))
            throw new ErrorSemantico("Asignación Matriz: Tipo de dato de la matriz "+Matriz.Tipo+" no coincide con el valor "+ObtenerTipo(NuevoValor)+" .", context.Start);

        // Obtener los índices
        List<int> IndicesMatriz = new List<int>();
        foreach (var elemento in context.expresion())
        {
            ValorWrapper indice = Visit(elemento);
            if (indice is not ValorInt indiceInt)
                throw new ErrorSemantico($"Asignación Matriz: Índice '{ObtenerTipo(indice)}' no es un entero.", context.Start);
            IndicesMatriz.Add(indiceInt.Valor);
        }
        if (IndicesMatriz.Count > 0)
        {
            IndicesMatriz.RemoveAt(IndicesMatriz.Count - 1);
        }
        // Navegar por los niveles de la matriz hasta el penúltimo índice
        ValorSlice SubMatrixAuxiliar = Matriz;
        for (int i = 0; i < IndicesMatriz.Count - 1; i++)
        {
            int indice = IndicesMatriz[i];
            // Verificar que el índice está dentro de los límites
            if (indice < 0 || indice >= SubMatrixAuxiliar.Valores.Count)
                throw new ErrorSemantico($"Error Asignación: Índice fuera de rango: {indice}. Tamaño de la matriz: {SubMatrixAuxiliar.Valores.Count}", context.Start);
            // Avanzar en la matriz
            if (SubMatrixAuxiliar.Valores[indice] is ValorSlice siguienteNivel)
            {
                SubMatrixAuxiliar = siguienteNivel;
            }
            else
            {
                throw new ErrorSemantico($"Error Asignación: La posición [{string.Join(", ", IndicesMatriz.Take(i + 1))}] no contiene una submatriz.", context.Start);
            }
        }
        // Asignar el nuevo valor en la última posición
        int ultimoIndice = IndicesMatriz[^1]; // Último índice de la lista
        // Verificar que el índice final esté dentro de los límites
        if (ultimoIndice < 0 || ultimoIndice >= SubMatrixAuxiliar.Valores.Count)
            throw new ErrorSemantico($"Error Asignación: Índice fuera de rango en la última dimensión: {ultimoIndice}. Tamaño: {SubMatrixAuxiliar.Valores.Count}", context.Start);
        SubMatrixAuxiliar.Valores[ultimoIndice] = NuevoValor;
        return ValorVoid;
    }

    // VisitAccesoMatriz
    public override ValorWrapper VisitAccesoMatriz(LanguageParser.AccesoMatrizContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper MatrizActual = EntornoActual.Obtener(identificador, context.Start);

        if (MatrizActual is not ValorSlice Matriz)
            throw new ErrorSemantico("Acceso Matriz: La Variable '" + identificador + "' no es una Matriz.", context.Start);
        
        // Obtener los índices
        List<int> IndicesMatriz = new List<int>();
        foreach (var elemento in context.expresion())
        {
            ValorWrapper indice = Visit(elemento);
            if (indice is not ValorInt indiceInt)
                throw new ErrorSemantico($"Acceso Matriz: Índice '{ObtenerTipo(indice)}' no es un entero.", context.Start);
            IndicesMatriz.Add(indiceInt.Valor);
        }

        // Navegar por los niveles de la matriz
        ValorSlice SubMatriz = Matriz;
        for (int i = 0; i < IndicesMatriz.Count; i++)
        {
            int indice = IndicesMatriz[i];

            // Verificar que el índice está dentro del rango
            if (indice < 0 || indice >= SubMatriz.Valores.Count)
                throw new ErrorSemantico($"Error Acceso: Índice fuera de rango: {indice}. Tamaño del arreglo: {SubMatriz.Valores.Count}", context.Start);

            // Si es el último índice, retornar el valor
            if (i == IndicesMatriz.Count - 1)
                return SubMatriz.Valores[indice];

            // Verificar que el siguiente nivel sigue siendo una matriz
            if (SubMatriz.Valores[indice] is not ValorSlice nuevaSubMatriz)
                throw new ErrorSemantico($"Error Acceso: Intento de acceso en un nivel inválido. La posición [{string.Join(", ", IndicesMatriz)}] no contiene una matriz.", context.Start);
            
            SubMatriz = nuevaSubMatriz;
        }

        throw new ErrorSemantico("Acceso Matriz: No se pudo acceder correctamente a la matriz.", context.Start);
    }
    // VisitLlamadaFuncion
    public override ValorWrapper VisitLlamadaFuncion(LanguageParser.LlamadaFuncionContext context)
    {
        ValorWrapper llamada = Visit(context.expresion());
        foreach (var call in context.llamada())
        {
            if (llamada is ValorFuncion FuncionValor)
            {
                llamada = VisitCallAuxiliar(FuncionValor.Invocable, call.argumento());
            }
            else
            {
                throw new ErrorSemantico("Error de llamada: No se puede llamar a un valor que no es una función.", context.Start);
            }
        }
        return llamada;
    }

    // VisitCallAuxiliar
    public ValorWrapper VisitCallAuxiliar(Invocable Invocable, LanguageParser.ArgumentoContext context)
    {
        List<ValorWrapper> argumento = new List<ValorWrapper>();
        if (context != null)
        {
            foreach (var expre in context.expresion())
            {
                argumento.Add(Visit(expre));
            }
        }
         if (context != null && argumento.Count != Invocable.Aridad())
         {
             throw new ErrorSemantico("Error de llamada: Se esperaban " + Invocable.Aridad() + " argumentos, pero se recibieron " + argumento.Count, context.Start);
         }
        return Invocable.Invoke(argumento, this);
    }
    //VisitDeclaracionFuncion
    public override ValorWrapper VisitDeclaracionFuncion(LanguageParser.DeclaracionFuncionContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        var funcionForranea = new FuncionForanea(EntornoActual, context);
        var valorFuncion = new ValorFuncion(funcionForranea, identificador);
        EntornoActual.Declarar(identificador, valorFuncion, context.Start.Line, context.Start.Column, context.Start);

        if (identificador == "main")
        {
            MainFunction = valorFuncion;
        }

        return ValorVoid;
    }

    // VisitDeclaracionStruct
    public override ValorWrapper VisitDeclaracionStruct(LanguageParser.DeclaracionStructContext context)
    {
        string NombreStruct = context.IDENTIFICADOR().GetText();
        Dictionary<string, string> AtributoStruct = new();
        EntornoActual.DeclararStruct(NombreStruct, AtributoStruct, context.Start);
        foreach (var Atributo in context.atributos())
        {
            for (int i = 0; i < Atributo.tipo_struct().Length; i++)
            {
                string TipoAtributo = Atributo.tipo_struct(i).GetText();
                string NombreAtributo = Atributo.IDENTIFICADOR(i).GetText();
                if (TipoAtributo == NombreStruct)
                {
                    AtributoStruct.Add(NombreAtributo, TipoAtributo);
                    continue;
                }
                if (!VerificarTipoPrimitivo(TipoAtributo) && !EntornoActual.ExisteStruct(TipoAtributo))
                {
                    throw new ErrorSemantico($"Error: Se intenta usar el struct '{TipoAtributo}', pero no está definido.", context.Start);
                }
                if (AtributoStruct.ContainsKey(NombreAtributo))
                {
                    throw new ErrorSemantico($"Error: El atributo '{NombreAtributo}' ya está definido en el struct '{NombreStruct}'.", context.Start);
                }

                AtributoStruct.Add(NombreAtributo, TipoAtributo);
            }
        }
        return ValorVoid;
    }

    // VisitAsignacionInstancia
    public override ValorWrapper VisitAsignacionInstancia(LanguageParser.AsignacionInstanciaContext context)
    {
        string NombreStruct = context.IDENTIFICADOR().GetText();

        if (!EntornoActual.ExisteStruct(NombreStruct))
        {
            throw new ErrorSemantico($"Error: El struct '{NombreStruct}' no está definido.", context.Start);
        }
        Dictionary<string, string> AtributosStruct = EntornoActual.ObtenerStruct(NombreStruct, context.Start);
        Dictionary<string, ValorWrapper> AtributosNuevaInstancia = new();

        for (int i = 0; i < context.atributos_instancia().IDENTIFICADOR().Length; i++)
        {
            string NombreAtributo = context.atributos_instancia().IDENTIFICADOR(i).GetText();
            ValorWrapper ValorAtributo = Visit(context.atributos_instancia().expresion(i)); 

            if (!AtributosStruct.ContainsKey(NombreAtributo))
            {
                throw new ErrorSemantico($"Error: El NombreAtributo '{NombreAtributo}' no existe en el struct '{NombreStruct}'.", context.Start);
            }

            string TipoAtributoEsperado = AtributosStruct[NombreAtributo];

            if (ValorAtributo is ValorNil)
            {
                if (VerificarTipoPrimitivo(TipoAtributoEsperado))
                {
                    throw new ErrorSemantico($"Error: El Atributo '{NombreAtributo}' de '{NombreStruct}' no puede ser 'nil' porque se esperaba un tipo primitivo '{TipoAtributoEsperado}'.", context.Start);
                }
            }
            else if (!ObtenerTipo(ValorAtributo).Equals(TipoAtributoEsperado))
            {
                throw new ErrorSemantico($"Error: El Atributo '{NombreAtributo}' de '{NombreStruct}' esperaba un Atributo de tipo '{TipoAtributoEsperado}', pero se recibió '{ObtenerTipo(ValorAtributo)}'.", context.Start);
            }

            AtributosNuevaInstancia[NombreAtributo] = ValorAtributo;
        }

        foreach (var NombreAtributo in AtributosStruct)
        {
            if (!AtributosNuevaInstancia.ContainsKey(NombreAtributo.Key))
            {
                string tipo = NombreAtributo.Value;
                AtributosNuevaInstancia[NombreAtributo.Key] = ObtenerValorPorDefecto(tipo, context.Start);
            }
        }

        ValorStruct NuevaInstancia = new(AtributosNuevaInstancia, NombreStruct);
        return NuevaInstancia;
    }

    private ValorWrapper ObtenerValorPorDefecto(string tipo,  Antlr4.Runtime.IToken token)
    {
        if (tipo == "int") return new ValorInt(0);
        if (tipo == "float64") return new ValorFloat64(0);
        if (tipo == "string") return new ValorString("");
        if (tipo == "bool") return new ValorBoolean(false);
        if (tipo == "rune") return new ValorRune(' ');
        
        if (EntornoActual.ExisteStruct(tipo))
        {
            Dictionary<string, string> atributosDefinidos = EntornoActual.ObtenerStruct(tipo, token);
            Dictionary<string, ValorWrapper> atributosInicializados = new();

            foreach (var atributo in atributosDefinidos)
            {
                atributosInicializados[atributo.Key] = ObtenerValorPorDefecto(atributo.Value, token);
            }

            return new ValorStruct(atributosInicializados, tipo);
        }

        throw new ErrorSemantico($"Error: Tipo '{tipo}' desconocido.", token);
    }

    //VisitAccesoStruct
    public override ValorWrapper VisitAccesoStruct(LanguageParser.AccesoStructContext context)
    {
        string NombreInstancia = context.IDENTIFICADOR(0).GetText();
        
        ValorWrapper InstanciaActual = EntornoActual.Obtener(NombreInstancia, context.Start);
        
        for (int i = 1; i < context.IDENTIFICADOR().Length; i++)
        {
            string atributo = context.IDENTIFICADOR(i).GetText();

            if (InstanciaActual is ValorStruct StructAuxiliar)
            {
                InstanciaActual = StructAuxiliar.ObtenerAtributo(atributo);
            }
            else
            {
                throw new ErrorSemantico($"Error: '{NombreInstancia}' no es una ArregloActual válida para acceder a '{atributo}'.", context.Start);
            }
        }
        return InstanciaActual;
    }

    // VisitAsignacionAtributoInstancia
    public override ValorWrapper VisitAsignacionAtributoInstancia(LanguageParser.AsignacionAtributoInstanciaContext context)
    {
        string NombreInstancia = context.IDENTIFICADOR(0).GetText();
        ValorWrapper InstanciaActual = EntornoActual.Obtener(NombreInstancia, context.Start);
        ValorWrapper NuevoValor = Visit(context.expresion());

        // Recorrer los atributos anidados
        for (int i = 1; i < context.IDENTIFICADOR().Length - 1; i++)
        {
            string atributo = context.IDENTIFICADOR(i).GetText();

            if (InstanciaActual is ValorStruct StructAuxiliar)
            {
                InstanciaActual = StructAuxiliar.ObtenerAtributo(atributo);
            }
            else
            {
                throw new ErrorSemantico($"Error: '{NombreInstancia}' no es una ArregloActual válida para acceder a '{atributo}'.", context.Start);
            }
        }

        string AtributoFinal = context.IDENTIFICADOR().Last().GetText();

        if (InstanciaActual is ValorStruct InstanciaModificable)
        {
            ValorWrapper ValorExistente = InstanciaModificable.ObtenerAtributo(AtributoFinal);
            string TipoEsperado;

            if (ValorExistente is ValorNil)
            {
                var DefinicionStruct = EntornoActual.ObtenerStruct(InstanciaModificable.NombreStruct, context.Start);
                if (!DefinicionStruct.TryGetValue(AtributoFinal, out string? tipoEsperadoNullable) || tipoEsperadoNullable == null)
                {
                    throw new ErrorSemantico($"Error: El atributo '{AtributoFinal}' no existe en la definición del struct '{InstanciaModificable.NombreStruct}'.", context.Start);
                }
                TipoEsperado = tipoEsperadoNullable;
            }
            else
            {
                // Obtener el tipo desde el valor actual
                TipoEsperado = ObtenerTipo(ValorExistente);
            }

            if (!ObtenerTipo(NuevoValor).Equals(TipoEsperado, StringComparison.Ordinal))
            {
                throw new ErrorSemantico($"Error: No se puede asignar un valor de tipo '{ObtenerTipo(NuevoValor)}' al atributo '{AtributoFinal}' de tipo '{TipoEsperado}'.", context.Start);
            }

            // Asignar nuevo valor
            InstanciaModificable.AsignarAtributo(AtributoFinal, NuevoValor);
        }


        return NuevoValor;
    }
    // VisitIncremento
    public override ValorWrapper VisitIncremento(LanguageParser.IncrementoContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper variable = EntornoActual.Obtener(identificador, context.Start);

        if (variable is ValorInt)
        {
            ValorInt valor = (ValorInt)variable;
            ValorInt nuevoValor = new(valor.Valor + 1);
            EntornoActual.Asignar(identificador, nuevoValor, context.Start);
            return nuevoValor;
        }
        else if (variable is ValorFloat64)
        {
            ValorFloat64 valor = (ValorFloat64)variable;
            ValorFloat64 nuevoValor = new(valor.Valor + 1);
            EntornoActual.Asignar(identificador, nuevoValor, context.Start);
            return nuevoValor;
        }
        else
        {
            throw new ErrorSemantico("Incremento: Tipo de Dato: " + ObtenerTipo(variable) + " No es un Entero o Float64", context.Start);
        }
    }
    // VisitDecremento
    public override ValorWrapper VisitDecremento(LanguageParser.DecrementoContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper variable = EntornoActual.Obtener(identificador, context.Start);

        if (variable is ValorInt)
        {
            ValorInt valor = (ValorInt)variable;
            ValorInt nuevoValor = new(valor.Valor - 1);
            EntornoActual.Asignar(identificador, nuevoValor, context.Start);
            return nuevoValor;
        }
        else if (variable is ValorFloat64)
        {
            ValorFloat64 valor = (ValorFloat64)variable;
            ValorFloat64 nuevoValor = new(valor.Valor - 1);
            EntornoActual.Asignar(identificador, nuevoValor, context.Start);
            return nuevoValor;
        }
        else
        {
            throw new ErrorSemantico("Decremento: Tipo de Dato: " + ObtenerTipo(variable) + " No es un Entero o Float64", context.Start);
        }
    }

}
