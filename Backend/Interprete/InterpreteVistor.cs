
using Analizador;
using System.Globalization;

public class InterpreteVisitor : LanguageBaseVisitor<ValorWrapper>
{
    public string Salida = "";
    private Entorno EntornoActual = new Entorno(null);
    private ValorWrapper ValorVoid = new ValorVoid();
    private string ObtenerValor(ValorWrapper valor)
    {
        return valor switch
        {
            ValorInt v => v.Valor.ToString(),
            ValorFloat64 v => v.Valor.ToString("0.0", CultureInfo.InvariantCulture),
            ValorString v => v.Valor,
            ValorBoolean v => v.Valor.ToString(),
            ValorRune v => v.Valor.ToString(),
            ValorVoid v => "void",
            _ => throw new ArgumentException("Tipo de valor no soportado")
        };
    }

    private string ObtenerTipo(ValorWrapper valor)
    {
        return valor switch
        {
            ValorInt _ => "int",
            ValorFloat64 _ => "float64",
            ValorString _ => "string",
            ValorBoolean _ => "bool",
            ValorRune _ => "rune",
            ValorVoid _ => "void",
            ValorArreglo _ => "slice",
            _ => throw new ArgumentException("Tipo de valor no soportado")
        };
    }
    // VisitProgram
    public override ValorWrapper VisitProgram(LanguageParser.ProgramContext context)
    {
        foreach (var sentencia in context.declaraciones())
        {
            Visit(sentencia);
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
        return new ValorString(cadena.Substring(1, cadena.Length - 2));
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
    // VisitIdentificador
    public override ValorWrapper VisitIdentificador(LanguageParser.IdentificadorContext context)
    {
        return EntornoActual.GetVariable(context.IDENTIFICADOR().GetText());
    }
    // VisitDeclaracionExplicita
    public override ValorWrapper VisitDeclaracionExplicita(LanguageParser.DeclaracionExplicitaContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper expresion = Visit(context.expresion());
        string tipo = context.TIPO().GetText();
        if (expresion is ValorInt && tipo == "float64"){
            expresion = new ValorFloat64(float.Parse(ObtenerValor(expresion), CultureInfo.InvariantCulture));
            EntornoActual.DeclaracionVariable(identificador, expresion);
            return ValorVoid;
        } else if (!ObtenerTipo(expresion).Equals(tipo, StringComparison.Ordinal)){
            throw new Exception("Declaración: Tipo de Dato: " + tipo + " No Coincide con el Valor: " + ObtenerTipo(expresion));
        }else{
            EntornoActual.DeclaracionVariable(identificador, expresion);
            return ValorVoid;
        }
    }
    // VisitDeclaracionImplicita
    public override ValorWrapper VisitDeclaracionImplicita(LanguageParser.DeclaracionImplicitaContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper expresion = Visit(context.expresion());
        EntornoActual.DeclaracionVariable(identificador, expresion);
        return ValorVoid;
    }
    // VisitDeclaracionPorDefecto
    public override ValorWrapper VisitDeclaracionPorDefecto(LanguageParser.DeclaracionPorDefectoContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        string tipo = context.TIPO().GetText();
        switch (tipo){
            case "int":
                EntornoActual.DeclaracionVariable(identificador, new ValorInt(0));
                break;
            case "float64":
                EntornoActual.DeclaracionVariable(identificador, new ValorFloat64(0));
                break;
            case "string":
                EntornoActual.DeclaracionVariable(identificador, new ValorString(""));
                break;
            case "bool":
                EntornoActual.DeclaracionVariable(identificador, new ValorBoolean(false));
                break;
            case "rune":
                EntornoActual.DeclaracionVariable(identificador, new ValorRune('0'));
                break;
            default:
                throw new Exception("Tipo de Dato: " + tipo + " No Encontrado");
            }
        return ValorVoid;
    }
    //VisitAsignacionVariable
    public override ValorWrapper VisitAsignacionVariable(LanguageParser.AsignacionVariableContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper expresion = Visit(context.expresion());
        ValorWrapper variable = EntornoActual.GetVariable(identificador);

        if (expresion is ValorInt && variable is ValorFloat64){
            expresion = new ValorFloat64(float.Parse(ObtenerValor(expresion), CultureInfo.InvariantCulture));
            return EntornoActual.AsignacionVariable(identificador, expresion);
        } else if (ObtenerTipo(expresion).Equals(ObtenerTipo(variable), StringComparison.Ordinal)){
            return EntornoActual.AsignacionVariable(identificador, expresion);
        }
        throw new Exception("Asignación: Tipo de Dato: " + ObtenerTipo(expresion) + " No Coincide con el Valor: " + ObtenerTipo(variable));
    }
    // VisitFuncionEmbebidaPrintln
    public override ValorWrapper VisitFuncionEmbebidaPrintln(LanguageParser.FuncionEmbebidaPrintlnContext context)
    {
        List<string> ValoresSalida = new List<string>();

        foreach (var expre in context.expresion())
        {
            ValorWrapper expresion = Visit(expre);
            ValoresSalida.Add(ObtenerRepresentacion(expresion));
        }

        Salida += string.Join(" ", ValoresSalida) + "\n";
        return ValorVoid;
    }

    private string ObtenerRepresentacion(ValorWrapper valor)
    {
        if (valor is ValorArreglo Arreglo)
        {
            return "[" + string.Join(", ", Arreglo.Valores.Select(ObtenerRepresentacion)) + "]";
        }
        return ObtenerValor(valor);
    }
    // VisitFuncionEmbebidaAtoi
    public override ValorWrapper VisitFuncionEmbebidaAtoi(LanguageParser.FuncionEmbebidaAtoiContext context)
    {
        
        ValorWrapper expresion = Visit(context.expresion());
        if (expresion is ValorString){
            if (int.TryParse(ObtenerValor(expresion), out int result)){
                return new ValorInt(result);
            }
            throw new Exception("Función Atoi: Valor: " + ObtenerValor(expresion) + " No es un Entero");
        }
        throw new Exception("Función Atoi: Tipo de Dato: " + ObtenerTipo(expresion) + " No Coincide con el Valor: string");

    }
    // VisitFuncionEmbebidaParseFloat
    public override ValorWrapper VisitFuncionEmbebidaParseFloat(LanguageParser.FuncionEmbebidaParseFloatContext context)
    {
        ValorWrapper expresion = Visit(context.expresion());
        if (expresion is ValorString || expresion is ValorInt){
            if (float.TryParse(ObtenerValor(expresion), NumberStyles.Any, CultureInfo.InvariantCulture, out float result)){
                return new ValorFloat64(result);
            }
            throw new Exception("Función ParseFloat: Valor: " + ObtenerValor(expresion) + " No es un Decimal");
        }
        throw new Exception("Función ParseFloat: Tipo de Dato: " + ObtenerTipo(expresion) + " No Coincide con el Valor: string");
    }
    //VisitFuncionEmbebidaReflectTypeOf
    public override ValorWrapper VisitFuncionEmbebidaReflectTypeOf(LanguageParser.FuncionEmbebidaReflectTypeOfContext context)
    {
        ValorWrapper expresion = Visit(context.expresion());
        if(expresion is ValorArreglo Arreglo)
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
        Binaria binaria = new Binaria(izquierda, derecha, operador);
        return binaria.RealizarOperacion();
    }
    //VisitMultiplicacionDivisionModulo
    public override ValorWrapper VisitMultiplicacionDivisionModulo(LanguageParser.MultiplicacionDivisionModuloContext context)
    {
        ValorWrapper izquierda = Visit(context.izquierda);
        ValorWrapper derecha = Visit(context.derecha);
        string operador = context.operador.Text;
        Binaria binaria = new Binaria(izquierda, derecha, operador);
        return binaria.RealizarOperacion();
    }
    
    //VisitNegacionUnaria
    public override ValorWrapper VisitNegacionUnaria(LanguageParser.NegacionUnariaContext context)
    {
        ValorWrapper izquierda = Visit(context.izquierda);
        string operador = context.operador.Text;
        Unaria unaria = new Unaria(izquierda, operador);
        return unaria.RealizarOperacion();
    }
    //VisitNegacionLogica
    public override ValorWrapper VisitNegacionLogica(LanguageParser.NegacionLogicaContext context)
    {
        ValorWrapper izquierda = Visit(context.izquierda);
        string operador = context.operador.Text;
        Unaria unaria = new Unaria(izquierda, operador);
        return unaria.RealizarOperacion();
    }
    //VisitIgualdadDesigualdad
    public override ValorWrapper VisitIgualdadDesigualdad(LanguageParser.IgualdadDesigualdadContext context)
    {
        ValorWrapper izquierda = Visit(context.izquierda);
        ValorWrapper derecha = Visit(context.derecha);
        string operador = context.operador.Text;
        Binaria binaria = new Binaria(izquierda, derecha, operador);
        return binaria.RealizarOperacion();
    }
    //VisitRelacional
    public override ValorWrapper VisitRelacional(LanguageParser.RelacionalContext context)
    {
        ValorWrapper izquierda = Visit(context.izquierda);
        ValorWrapper derecha = Visit(context.derecha);
        string operador = context.operador.Text;
        Binaria binaria = new Binaria(izquierda, derecha, operador);
        return binaria.RealizarOperacion();
    }

    //VisitLogicoAnd
    public override ValorWrapper VisitLogicoAnd(LanguageParser.LogicoAndContext context)
    {
        ValorWrapper izquierda = Visit(context.izquierda);
        ValorWrapper derecha = Visit(context.derecha);
        string operador = context.operador.Text;
        Binaria binaria = new Binaria(izquierda, derecha, operador);
        return binaria.RealizarOperacion();
    }
    //VisitLogicoOr
    public override ValorWrapper VisitLogicoOr(LanguageParser.LogicoOrContext context)
    {
        ValorWrapper izquierda = Visit(context.izquierda);
        ValorWrapper derecha = Visit(context.derecha);
        string operador = context.operador.Text;
        Binaria binaria = new Binaria(izquierda, derecha, operador);
        return binaria.RealizarOperacion();
    }
    //VisitAsignacionVariableSuma
    public override ValorWrapper VisitAsignacionVariableSuma(LanguageParser.AsignacionVariableSumaContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        // Izquierda
        ValorWrapper izquierda = Visit(context.expresion());
        // Derecha
        ValorWrapper variable = EntornoActual.GetVariable(identificador);

        if (izquierda is ValorInt && variable is ValorFloat64){
            Binaria binaria = new Binaria(variable, izquierda, "+");
            ValorWrapper resultado = binaria.RealizarOperacion();
            return EntornoActual.AsignacionVariable(identificador, resultado);
        } else if (ObtenerTipo(izquierda).Equals(ObtenerTipo(variable), StringComparison.Ordinal)){
            Binaria binaria = new Binaria(variable, izquierda, "+");
            ValorWrapper resultado = binaria.RealizarOperacion();
            return EntornoActual.AsignacionVariable(identificador, resultado);
        }
        throw new Exception("Asignación: Tipo de Dato: " + ObtenerTipo(izquierda) + " No Coincide con el Valor: " + ObtenerTipo(variable));
    }

    // VisitAsignacionVariableResta
    public override ValorWrapper VisitAsignacionVariableResta(LanguageParser.AsignacionVariableRestaContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        // Izquierda
        ValorWrapper izquierda = Visit(context.expresion());
        // Derecha
        ValorWrapper variable = EntornoActual.GetVariable(identificador);

        if (izquierda is ValorInt && variable is ValorFloat64){
            Binaria binaria = new Binaria(variable, izquierda, "-");
            ValorWrapper resultado = binaria.RealizarOperacion();
            return EntornoActual.AsignacionVariable(identificador, resultado);
        } else if (ObtenerTipo(izquierda).Equals(ObtenerTipo(variable), StringComparison.Ordinal)){
            Binaria binaria = new Binaria(variable, izquierda, "-");
            ValorWrapper resultado = binaria.RealizarOperacion();
            return EntornoActual.AsignacionVariable(identificador, resultado);
        }
        throw new Exception("Asignación: Tipo de Dato: " + ObtenerTipo(izquierda) + " No Coincide con el Valor: " + ObtenerTipo(variable));
    }
    // VisitDeclaracionArregloExplicita
    public override ValorWrapper VisitDeclaracionArregloExplicita(LanguageParser.DeclaracionArregloExplicitaContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        string TipoArreglo = context.TIPO().GetText();
        List<ValorWrapper> ArregloAuxiliar = new List<ValorWrapper>();

        foreach (var expre in context.expresion())
        {
            ValorWrapper ValoresArreglo = Visit(expre);
            if (ObtenerTipo(ValoresArreglo) != TipoArreglo)
            {
                throw new Exception("Declaración de Arreglo: Tipo de Dato Arreglo: " + TipoArreglo + " No Coincide con el Valor: " + ObtenerTipo(ValoresArreglo));
            }
            ArregloAuxiliar.Add(ValoresArreglo);
        }
        ValorWrapper NuevoArreglo = new ValorArreglo(ArregloAuxiliar, TipoArreglo);
        EntornoActual.DeclaracionVariable(identificador, NuevoArreglo);
        return ValorVoid;
    }
    // VisitDeclaracionArregloPorDefecto
    public override ValorWrapper VisitDeclaracionArregloPorDefecto(LanguageParser.DeclaracionArregloPorDefectoContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        string TipoArreglo = context.TIPO().GetText();
        List<ValorWrapper> ArregloAuxiliar = new List<ValorWrapper>();
        ValorWrapper NuevoArreglo = new ValorArreglo(ArregloAuxiliar, TipoArreglo);
        EntornoActual.DeclaracionVariable(identificador, NuevoArreglo);
        return ValorVoid;
    }
    // VisitFuncionEmbebidaSlicesIndex
    public override ValorWrapper VisitFuncionEmbebidaSlicesIndex(LanguageParser.FuncionEmbebidaSlicesIndexContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper ArregloActual = EntornoActual.GetVariable(identificador);

        if (ArregloActual is ValorArreglo Arreglo)
        {
            ValorWrapper ValorBuscado = Visit(context.expresion());
            if(!(Arreglo.Tipo).Equals(ObtenerTipo(ValorBuscado), StringComparison.Ordinal))
            {
                throw new Exception("Función Slices: Tipo de Dato: " + ObtenerTipo(ValorBuscado) + " No Coincide con el Valor: " + Arreglo.Tipo);
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
        throw new Exception("Función Slices: La Variable: " + identificador + " No es un Arreglo");
    }

    // VisitFuncionEmbebidaStringsJoin
    public override ValorWrapper VisitFuncionEmbebidaStringsJoin(LanguageParser.FuncionEmbebidaStringsJoinContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper ArregloActual = EntornoActual.GetVariable(identificador);
        ValorWrapper Separador = Visit(context.expresion());

        if (!(Separador is ValorString))
            throw new Exception("Función Join: El Separador: " + ObtenerValor(Separador) + " No es un String");
        
        if (ArregloActual is ValorArreglo Arreglo1)
            if (Arreglo1.Tipo != "string")
            throw new Exception("Función Join: Tipo de Dato Arreglo: " + Arreglo1.Tipo + " No es un String");
        
        if (ArregloActual is ValorArreglo Arreglo2)
        {
            List<string> ValoresArreglo = Arreglo2.Valores.Select(valor => ObtenerValor(valor)).ToList();
            return new ValorString(string.Join(ObtenerValor(Separador), ValoresArreglo));
        }
        throw new Exception("Función Join: La Variable: " + identificador + " No es un Arreglo");
    }
    // VisitFuncionEmbebidaLen
    public override ValorWrapper VisitFuncionEmbebidaLen(LanguageParser.FuncionEmbebidaLenContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper ArregloActual = EntornoActual.GetVariable(identificador);

        if (ArregloActual is ValorArreglo Arreglo)
        {
            return new ValorInt(Arreglo.Valores.Count);
        }
        throw new Exception("Función Len: La Variable: " + identificador + " No es un Arreglo");
    }
    // VisitFuncionEmbebidaAppend
    public override ValorWrapper VisitFuncionEmbebidaAppend(LanguageParser.FuncionEmbebidaAppendContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper ArregloActual = EntornoActual.GetVariable(identificador);
        ValorWrapper ValorNuevo = Visit(context.expresion());

        if (ArregloActual is ValorArreglo Arreglo)
        {
            if (!Arreglo.Tipo.Equals(ObtenerTipo(ValorNuevo), StringComparison.Ordinal))
            {
                throw new Exception("Función Append: Tipo de Dato Arreglo: " + Arreglo.Tipo + " No Coincide con el Valor: " + ObtenerTipo(ValorNuevo));
            }
            Arreglo.Valores.Add(ValorNuevo);
            return ArregloActual;
        }
        throw new Exception("Función Append: La Variable: " + identificador + " No es un Arreglo");
    }
    // VisitAccesoArreglo
    public override ValorWrapper VisitAccesoArreglo(LanguageParser.AccesoArregloContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper ArregloActual = EntornoActual.GetVariable(identificador);
        ValorWrapper Indice = Visit(context.expresion());

        if (ArregloActual is not ValorArreglo Arreglo)
            throw new Exception("Acceso Arreglo: La Variable: " + identificador + " No es un Arreglo");
        
        if (Indice is not ValorInt IndiceInt)
            throw new Exception("Acceso Arreglo: Tipo de Dato: " + ObtenerTipo(Indice) + " No es un Entero");
            
        if ((IndiceInt.Valor >= 0) && (IndiceInt.Valor < Arreglo.Valores.Count))
            return Arreglo.Valores[IndiceInt.Valor];
        else
            throw new Exception("Acceso Arreglo: Indice: " + IndiceInt.Valor + " Fuera de Rango");
    }
    // VisitAsignacionArreglo
    public override ValorWrapper VisitAsignacionArreglo(LanguageParser.AsignacionArregloContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper ArregloActual = EntornoActual.GetVariable(identificador);
        ValorWrapper Indice = Visit(context.indice);
        ValorWrapper ValorNuevo = Visit(context.valornuevo);

        if (ArregloActual is not ValorArreglo Arreglo)
            throw new Exception("Asignación Arreglo: La Variable: " + identificador + " No es un Arreglo");
        
        if (Indice is not ValorInt IndiceInt)
            throw new Exception("Asignación Arreglo: Tipo de Dato: " + ObtenerTipo(Indice) + " No es un Entero");
            
        if ((IndiceInt.Valor >= 0) && (IndiceInt.Valor < Arreglo.Valores.Count))
        {
            if (Arreglo.Tipo.Equals(ObtenerTipo(ValorNuevo), StringComparison.Ordinal))
            {
                Arreglo.Valores[IndiceInt.Valor] = ValorNuevo;return ValorVoid;
            }
            throw new Exception("Asignación Arreglo: Tipo de Dato Arreglo: " + Arreglo.Tipo + " No Coincide con el Valor: " + ObtenerTipo(ValorNuevo));
        }
        throw new Exception("Asignación Arreglo: Indice: " + IndiceInt.Valor + " Fuera de Rango");
    }

    // VisitSentenciaIf
    public override ValorWrapper VisitSentenciaIf(LanguageParser.SentenciaIfContext context)
    {
        ValorWrapper Condicion = Visit(context.expresion());
        if (Condicion is not ValorBoolean CondicionBoolean)
            throw new Exception("Sentencia If: Tipo de Dato: " + ObtenerTipo(Condicion) + " No es un Booleano");

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
    // VisitSentenciaForSimple
   public override ValorWrapper VisitSentenciaForSimple(LanguageParser.SentenciaForSimpleContext context)
    {
        ValorWrapper Condicion = Visit(context.condicion);
        if (Condicion is not ValorBoolean CondicionWhile)
            throw new Exception("Sentencia For Simple: Tipo de Dato: " + ObtenerTipo(Condicion) + " No es un Booleano");
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
            throw new Exception("Sentencia For Compuesto: Tipo de Dato: " + ObtenerTipo(Condicion) + " No es un Booleano");

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

        ValorWrapper Arreglo = EntornoActual.GetVariable(Slice);

        if (Arreglo is not ValorArreglo Arreglo1)
            throw new Exception("Sentencia For Range: La Variable: " + Slice + " No es un Arreglo");

        for (int i = 0; i < Arreglo1.Valores.Count; i++)
        {
            // Crear un nuevo entorno para cada iteración
            Entorno EntornoPrevio = EntornoActual;
            EntornoActual = new Entorno(EntornoPrevio);
            // Asignar índice y valor dentro del nuevo entorno
            EntornoActual.DeclaracionVariable(Indice, new ValorInt(i));
            EntornoActual.DeclaracionVariable(Valor, Arreglo1.Valores[i]);
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
        // Construir la Matriz visitando el contenido
        ValorWrapper Matriz = VisitContenidoMatriz(context.contenido_matriz(), TipoMatriz);
        EntornoActual.DeclaracionVariable(identificador, Matriz);
        return ValorVoid;
    }

    private ValorWrapper VisitContenidoMatriz(LanguageParser.Contenido_matrizContext context, string TipoMatriz)
    {
        // Lista para almacenar todos los elementos de este nivel
        List<ValorWrapper> elementos = new List<ValorWrapper>();
        // Si no hay elementos, devolvemos un arreglo vacío
        if (context.elementos_matriz() == null)
        {
            return new ValorArreglo(elementos, TipoMatriz);
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
        return new ValorArreglo(elementos, TipoMatriz);
    }

    private ValorWrapper ProcesarListaValores(LanguageParser.Lista_valoresContext context, string TipoMatriz)
    {
        List<ValorWrapper> valores = new List<ValorWrapper>();
        
        // Si no hay expresiones, devolvemos una lista vacía
        if (context.expresion() == null || !context.expresion().Any())
        {
            return new ValorArreglo(valores, TipoMatriz);
        }
        // Visitar cada expresión y agregarla a la lista
        foreach (var expresion in context.expresion())
        {
            ValorWrapper valor = Visit(expresion);
            if (!TipoMatriz.Equals(ObtenerTipo(valor), StringComparison.Ordinal))
                throw new Exception($"Error de tipo: Se esperaba {TipoMatriz} pero se encontró {ObtenerTipo(valor)}");
            valores.Add(valor);
        }
        return new ValorArreglo(valores, TipoMatriz);
    }

    // VisitAsignacionMatriz
    public override ValorWrapper VisitAsignacionMatriz(LanguageParser.AsignacionMatrizContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper MatrizActual = EntornoActual.GetVariable(identificador);
        ValorWrapper NuevoValor = Visit(context.valornuevo);
        
        if (MatrizActual is not ValorArreglo Matriz)
            throw new Exception("Asignación Matriz: La Variable "+ identificador + "no es una Matriz");
        
        if (!Matriz.Tipo.Equals(ObtenerTipo(NuevoValor), StringComparison.Ordinal))
            throw new Exception("Asignación Matriz: Tipo de dato de la matriz "+Matriz.Tipo+" no coincide con el valor "+ObtenerTipo(NuevoValor)+" .");

        // Obtener los índices
        List<int> IndicesMatriz = new List<int>();
        foreach (var elemento in context.expresion())
        {
            ValorWrapper indice = Visit(elemento);
            if (indice is not ValorInt indiceInt)
                throw new Exception($"Asignación Matriz: Índice '{ObtenerTipo(indice)}' no es un entero.");
            IndicesMatriz.Add(indiceInt.Valor);
        }
        if (IndicesMatriz.Count > 0)
        {
            IndicesMatriz.RemoveAt(IndicesMatriz.Count - 1);
        }
        // Navegar por los niveles de la matriz hasta el penúltimo índice
        ValorArreglo SubMatrixAuxiliar = Matriz;
        for (int i = 0; i < IndicesMatriz.Count - 1; i++)
        {
            int indice = IndicesMatriz[i];
            // Verificar que el índice está dentro de los límites
            if (indice < 0 || indice >= SubMatrixAuxiliar.Valores.Count)
                throw new Exception($"Error: Índice fuera de rango: {indice}. Tamaño de la matriz: {SubMatrixAuxiliar.Valores.Count}");
            // Avanzar en la matriz
            if (SubMatrixAuxiliar.Valores[indice] is ValorArreglo siguienteNivel)
            {
                SubMatrixAuxiliar = siguienteNivel;
            }
            else
            {
                throw new Exception($"Error: La posición [{string.Join(", ", IndicesMatriz.Take(i + 1))}] no contiene una submatriz.");
            }
        }
        // Asignar el nuevo valor en la última posición
        int ultimoIndice = IndicesMatriz[^1]; // Último índice de la lista
        // Verificar que el índice final esté dentro de los límites
        if (ultimoIndice < 0 || ultimoIndice >= SubMatrixAuxiliar.Valores.Count)
            throw new Exception($"Error: Índice fuera de rango en la última dimensión: {ultimoIndice}. Tamaño: {SubMatrixAuxiliar.Valores.Count}");
        SubMatrixAuxiliar.Valores[ultimoIndice] = NuevoValor;
        return ValorVoid;
    }
}
