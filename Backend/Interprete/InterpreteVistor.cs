
using Analizador;
using System.Globalization;

public class InterpreteVisitor : LanguageBaseVisitor<ValorWrapper>
{
    private static readonly HashSet<string> PalabrasReservadas = new HashSet<string>
    {
        "if", "else", "while", "for", "return", "class", "public", "private", "static", "void"
    };


    public string Salida = "";
    public Entorno EntornoActual = new Entorno(null);
    private ValorWrapper ValorVoid = new ValorVoid();

    private ValorFuncion MainFunction = null;
    public string ObtenerValor(ValorWrapper valor)
    {
        return valor switch
        {
            ValorInt v => v.Valor.ToString(),
            ValorFloat64 v => v.Valor.ToString("0.0", CultureInfo.InvariantCulture),
            ValorString v => v.Valor,
            ValorBoolean v => v.Valor.ToString(),
            ValorRune v => v.Valor.ToString(),
            _ => throw new ArgumentException("Obtener Valor: Tipo de valor no soportado")
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
            ValorSlice Slice => Slice.Tipo,
            ValorFuncion _ => "funcion",
            ValorStruct Struct => Struct.NombreStruct, 
            _ => throw new ArgumentException("Obtener Tipo: Tipo de valor no soportado")
        };
    }

    private bool EsTipoPrimitivo(string tipo)
    {
        return tipo == "int" || tipo == "float64" || tipo == "string" || tipo == "bool" || tipo == "rune";
    }


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
                throw new Exception("Error al ejecutar la función main: " + ex.Message);
            }
        }
        else
        {
            throw new Exception("No se encontró la función 'main' en el programa.");
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
    // VisitIdentificador
    public override ValorWrapper VisitIdentificador(LanguageParser.IdentificadorContext context)
    {
        return EntornoActual.Obtener(context.IDENTIFICADOR().GetText());
    }
    // VisitDeclaracionExplicita
    public override ValorWrapper VisitDeclaracionExplicita(LanguageParser.DeclaracionExplicitaContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        //if (PalabrasReservadas.Contains(identificador))
        //    throw new Exception("Declaración: '" + identificador + "' es una palabra reservada");
        ValorWrapper expresion = Visit(context.expresion());
        string tipo = context.TIPO().GetText();
        if (expresion is ValorInt && tipo == "float64"){
            expresion = new ValorFloat64(float.Parse(ObtenerValor(expresion), CultureInfo.InvariantCulture));
            EntornoActual.Declarar(identificador, expresion);
            return ValorVoid;
        } else if (!ObtenerTipo(expresion).Equals(tipo, StringComparison.Ordinal)){
            throw new Exception("Declaración: Tipo de Dato: " + tipo + " No Coincide con el Valor: " + ObtenerTipo(expresion));
        }else{
            EntornoActual.Declarar(identificador, expresion);
            return ValorVoid;
        }
    }
    // VisitDeclaracionImplicita
    public override ValorWrapper VisitDeclaracionImplicita(LanguageParser.DeclaracionImplicitaContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        //if (PalabrasReservadas.Contains(identificador))
        //    throw new Exception("Declaración: '" + identificador + "' es una palabra reservada");
        ValorWrapper expresion = Visit(context.expresion());
        EntornoActual.Declarar(identificador, expresion);
        return ValorVoid;
    }
    // VisitDeclaracionPorDefecto
    public override ValorWrapper VisitDeclaracionPorDefecto(LanguageParser.DeclaracionPorDefectoContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        //if (PalabrasReservadas.Contains(identificador))
        //    throw new Exception("Declaración: '" + identificador + "' es una palabra reservada");
        string tipo = context.TIPO().GetText();
        switch (tipo){
            case "int":
                EntornoActual.Declarar(identificador, new ValorInt(0));
                break;
            case "float64":
                EntornoActual.Declarar(identificador, new ValorFloat64(0));
                break;
            case "string":
                EntornoActual.Declarar(identificador, new ValorString(""));
                break;
            case "bool":
                EntornoActual.Declarar(identificador, new ValorBoolean(false));
                break;
            case "rune":
                EntornoActual.Declarar(identificador, new ValorRune('0'));
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
        ValorWrapper variable = EntornoActual.Obtener(identificador);

        if (expresion is ValorInt && variable is ValorFloat64){
            expresion = new ValorFloat64(float.Parse(ObtenerValor(expresion), CultureInfo.InvariantCulture));
            return EntornoActual.Asignar(identificador, expresion);
        } else if (ObtenerTipo(expresion).Equals(ObtenerTipo(variable), StringComparison.Ordinal)){
            return EntornoActual.Asignar(identificador, expresion);
        }
        throw new Exception("Asignación: Tipo de Dato: " + ObtenerTipo(expresion) + " No Coincide con el Valor: " + ObtenerTipo(variable));
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
            ValoresSalida.Add(ObtenerRepresentacion(expresion));
        }

        Salida += string.Join(" ", ValoresSalida) + "\n";
        return ValorVoid;
    }

    private string ObtenerRepresentacion(ValorWrapper valor)
    {
        if (valor is ValorSlice Arreglo)
        {
            return "[" + string.Join(", ", Arreglo.Valores.Select(ObtenerRepresentacion)) + "]";
        }
        if (valor is ValorStruct Struct)
        {
            return ObtenerRepresentacionStruct(Struct);
        }
        return ObtenerValor(valor);
    }

    private string ObtenerRepresentacionStruct(ValorStruct StructValorAuxiliar)
    {
        List<string> atributos = new List<string>();

        foreach (var NombreAtributo in StructValorAuxiliar.Atributos)
        {
            string nombre = NombreAtributo.Key;
            string valor = ObtenerRepresentacion(NombreAtributo.Value);
            atributos.Add($"{nombre}: {valor}");
        }

        return $"{StructValorAuxiliar.NombreStruct}{{ {string.Join(", ", atributos)} }}";
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
        ValorWrapper variable = EntornoActual.Obtener(identificador);

        if (izquierda is ValorInt && variable is ValorFloat64){
            Binaria binaria = new Binaria(variable, izquierda, "+");
            ValorWrapper resultado = binaria.RealizarOperacion();
            return EntornoActual.Asignar(identificador, resultado);
        } else if (ObtenerTipo(izquierda).Equals(ObtenerTipo(variable), StringComparison.Ordinal)){
            Binaria binaria = new Binaria(variable, izquierda, "+");
            ValorWrapper resultado = binaria.RealizarOperacion();
            return EntornoActual.Asignar(identificador, resultado);
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
        ValorWrapper variable = EntornoActual.Obtener(identificador);

        if (izquierda is ValorInt && variable is ValorFloat64){
            Binaria binaria = new Binaria(variable, izquierda, "-");
            ValorWrapper resultado = binaria.RealizarOperacion();
            return EntornoActual.Asignar(identificador, resultado);
        } else if (ObtenerTipo(izquierda).Equals(ObtenerTipo(variable), StringComparison.Ordinal)){
            Binaria binaria = new Binaria(variable, izquierda, "-");
            ValorWrapper resultado = binaria.RealizarOperacion();
            return EntornoActual.Asignar(identificador, resultado);
        }
        throw new Exception("Asignación: Tipo de Dato: " + ObtenerTipo(izquierda) + " No Coincide con el Valor: " + ObtenerTipo(variable));
    }
    // VisitDeclaracionArregloExplicita
    public override ValorWrapper VisitDeclaracionArregloExplicita(LanguageParser.DeclaracionArregloExplicitaContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        //if (PalabrasReservadas.Contains(identificador))
        //    throw new Exception("Declaración: '" + identificador + "' es una palabra reservada");
        
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
        ValorWrapper NuevoArreglo = new ValorSlice(ArregloAuxiliar, TipoArreglo);
        EntornoActual.Declarar(identificador, NuevoArreglo);
        return ValorVoid;
    }
    // VisitDeclaracionArregloPorDefecto
    public override ValorWrapper VisitDeclaracionArregloPorDefecto(LanguageParser.DeclaracionArregloPorDefectoContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        //if (PalabrasReservadas.Contains(identificador))
        //    throw new Exception("Declaración: '" + identificador + "' es una palabra reservada");
        string TipoArreglo = context.TIPO().GetText();
        List<ValorWrapper> ArregloAuxiliar = new List<ValorWrapper>();
        ValorWrapper NuevoArreglo = new ValorSlice(ArregloAuxiliar, TipoArreglo);
        EntornoActual.Declarar(identificador, NuevoArreglo);
        return ValorVoid;
    }
    // VisitFuncionEmbebidaSlicesIndex
    public override ValorWrapper VisitFuncionEmbebidaSlicesIndex(LanguageParser.FuncionEmbebidaSlicesIndexContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper ArregloActual = EntornoActual.Obtener(identificador);

        if (ArregloActual is ValorSlice Arreglo)
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
        ValorWrapper ArregloActual = EntornoActual.Obtener(identificador);
        ValorWrapper Separador = Visit(context.expresion());

        if (!(Separador is ValorString))
            throw new Exception("Función Join: El Separador: " + ObtenerValor(Separador) + " No es un String");
        
        if (ArregloActual is ValorSlice Arreglo1)
            if (Arreglo1.Tipo != "string")
            throw new Exception("Función Join: Tipo de Dato Arreglo: " + Arreglo1.Tipo + " No es un String");
        
        if (ArregloActual is ValorSlice Arreglo2)
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
        ValorWrapper ArregloActual = EntornoActual.Obtener(identificador);

        if (ArregloActual is ValorSlice Arreglo)
        {
            return new ValorInt(Arreglo.Valores.Count);
        }
        throw new Exception("Función Len: La Variable: " + identificador + " No es un Arreglo");
    }
    // VisitFuncionEmbebidaAppend
    public override ValorWrapper VisitFuncionEmbebidaAppend(LanguageParser.FuncionEmbebidaAppendContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper ArregloActual = EntornoActual.Obtener(identificador);
        ValorWrapper ValorNuevo = Visit(context.expresion());

        if (ArregloActual is ValorSlice Arreglo)
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
        ValorWrapper ArregloActual = EntornoActual.Obtener(identificador);
        ValorWrapper Indice = Visit(context.expresion());

        if (ArregloActual is not ValorSlice Arreglo)
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
        ValorWrapper ArregloActual = EntornoActual.Obtener(identificador);
        ValorWrapper Indice = Visit(context.indice);
        ValorWrapper ValorNuevo = Visit(context.valornuevo);

        if (ArregloActual is not ValorSlice Arreglo)
            throw new Exception("Asignación Arreglo: La Variable: " + identificador + " No es un Arreglo");
        
        if (Indice is not ValorInt IndiceInt)
            throw new Exception("Asignación Arreglo: Tipo de Dato: " + ObtenerTipo(Indice) + " No es un Entero");
            
        if ((IndiceInt.Valor >= 0) && (IndiceInt.Valor < Arreglo.Valores.Count))
        {
            if (Arreglo.Tipo.Equals(ObtenerTipo(ValorNuevo), StringComparison.Ordinal))
            {
                Arreglo.Valores[IndiceInt.Valor] = ValorNuevo;
                return ValorVoid;
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

        ValorWrapper Arreglo = EntornoActual.Obtener(Slice);

        if (Arreglo is not ValorSlice Arreglo1)
            throw new Exception("Sentencia For Range: La Variable: " + Slice + " No es un Arreglo");

        for (int i = 0; i < Arreglo1.Valores.Count; i++)
        {
            // Crear un nuevo EntornoActual para cada iteración
            Entorno EntornoPrevio = EntornoActual;
            EntornoActual = new Entorno(EntornoPrevio);
            // Asignar índice y valor dentro del nuevo EntornoActual
            EntornoActual.Declarar(Indice, new ValorInt(i));
            EntornoActual.Declarar(Valor, Arreglo1.Valores[i]);
            // Ejecutar la sentencia dentro del for
            Visit(context.sentencia());
            EntornoActual = EntornoPrevio;
        }
        return ValorVoid;
    }
    public override ValorWrapper VisitDeclaracionMatrizExplicita(LanguageParser.DeclaracionMatrizExplicitaContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        //if (PalabrasReservadas.Contains(identificador))
        //    throw new Exception("Declaración: '" + identificador + "' es una palabra reservada");
        string TipoMatriz = context.TIPO().GetText();
        // Construir la Matriz visitando el contenido
        ValorWrapper Matriz = VisitContenidoMatriz(context.contenido_matriz(), TipoMatriz);
        EntornoActual.Declarar(identificador, Matriz);
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
                throw new Exception($"Error de tipo: Se esperaba {TipoMatriz} pero se encontró {ObtenerTipo(valor)}");
            valores.Add(valor);
        }
        return new ValorSlice(valores, TipoMatriz);
    }

    // VisitAsignacionMatriz
    public override ValorWrapper VisitAsignacionMatriz(LanguageParser.AsignacionMatrizContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper MatrizActual = EntornoActual.Obtener(identificador);
        ValorWrapper NuevoValor = Visit(context.valornuevo);
        
        if (MatrizActual is not ValorSlice Matriz)
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
        ValorSlice SubMatrixAuxiliar = Matriz;
        for (int i = 0; i < IndicesMatriz.Count - 1; i++)
        {
            int indice = IndicesMatriz[i];
            // Verificar que el índice está dentro de los límites
            if (indice < 0 || indice >= SubMatrixAuxiliar.Valores.Count)
                throw new Exception($"Error Asignación: Índice fuera de rango: {indice}. Tamaño de la matriz: {SubMatrixAuxiliar.Valores.Count}");
            // Avanzar en la matriz
            if (SubMatrixAuxiliar.Valores[indice] is ValorSlice siguienteNivel)
            {
                SubMatrixAuxiliar = siguienteNivel;
            }
            else
            {
                throw new Exception($"Error Asignación: La posición [{string.Join(", ", IndicesMatriz.Take(i + 1))}] no contiene una submatriz.");
            }
        }
        // Asignar el nuevo valor en la última posición
        int ultimoIndice = IndicesMatriz[^1]; // Último índice de la lista
        // Verificar que el índice final esté dentro de los límites
        if (ultimoIndice < 0 || ultimoIndice >= SubMatrixAuxiliar.Valores.Count)
            throw new Exception($"Error Asignación: Índice fuera de rango en la última dimensión: {ultimoIndice}. Tamaño: {SubMatrixAuxiliar.Valores.Count}");
        SubMatrixAuxiliar.Valores[ultimoIndice] = NuevoValor;
        return ValorVoid;
    }

    // VisitAccesoMatriz
    public override ValorWrapper VisitAccesoMatriz(LanguageParser.AccesoMatrizContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper MatrizActual = EntornoActual.Obtener(identificador);

        if (MatrizActual is not ValorSlice Matriz)
            throw new Exception("Acceso Matriz: La Variable '" + identificador + "' no es una Matriz.");
        
        // Obtener los índices
        List<int> IndicesMatriz = new List<int>();
        foreach (var elemento in context.expresion())
        {
            ValorWrapper indice = Visit(elemento);
            if (indice is not ValorInt indiceInt)
                throw new Exception($"Acceso Matriz: Índice '{ObtenerTipo(indice)}' no es un entero.");
            IndicesMatriz.Add(indiceInt.Valor);
        }

        // Navegar por los niveles de la matriz
        ValorSlice SubMatriz = Matriz;
        for (int i = 0; i < IndicesMatriz.Count; i++)
        {
            int indice = IndicesMatriz[i];

            // Verificar que el índice está dentro del rango
            if (indice < 0 || indice >= SubMatriz.Valores.Count)
                throw new Exception($"Error Acceso: Índice fuera de rango: {indice}. Tamaño del arreglo: {SubMatriz.Valores.Count}");

            // Si es el último índice, retornar el valor
            if (i == IndicesMatriz.Count - 1)
                return SubMatriz.Valores[indice];

            // Verificar que el siguiente nivel sigue siendo una matriz
            if (SubMatriz.Valores[indice] is not ValorSlice nuevaSubMatriz)
                throw new Exception($"Error Acceso: Intento de acceso en un nivel inválido. La posición [{string.Join(", ", IndicesMatriz)}] no contiene una matriz.");
            
            SubMatriz = nuevaSubMatriz;
        }

        throw new Exception("Acceso Matriz: No se pudo acceder correctamente a la matriz.");
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
                throw new Exception("Error de llamada: No se puede llamar a un valor que no es una función.");
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
             throw new Exception("Error de llamada: Se esperaban " + Invocable.Aridad() + " argumentos, pero se recibieron " + argumento.Count);
         }
        return Invocable.Invoke(argumento, this);
    }
    //VisitDeclaracionFuncion
    public override ValorWrapper VisitDeclaracionFuncion(LanguageParser.DeclaracionFuncionContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        var funcionForranea = new FuncionForanea(EntornoActual, context);
        var valorFuncion = new ValorFuncion(funcionForranea, identificador);
        EntornoActual.Declarar(identificador, valorFuncion);

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

        foreach (var Atributo in context.atributos())
        {
            for (int i = 0; i < Atributo.tipo_struct().Length; i++)
            {
                string TipoAtributo = Atributo.tipo_struct(i).GetText();
                string NombreAtributo = Atributo.IDENTIFICADOR(i).GetText();

                if (!EsTipoPrimitivo(TipoAtributo) && !EntornoActual.ExisteStruct(TipoAtributo))
                {
                    throw new Exception($"Error: Se intenta usar el struct '{TipoAtributo}', pero no está definido.");
                }

                if (AtributoStruct.ContainsKey(NombreAtributo))
                {
                    throw new Exception($"Error: El NombreAtributo '{NombreAtributo}' ya está definido en el struct '{NombreStruct}'.");
                }

                AtributoStruct.Add(NombreAtributo, TipoAtributo);
            }
        }

        EntornoActual.DeclararStruct(NombreStruct, AtributoStruct);
        return ValorVoid;
    }

    // VisitAsignacionInstancia
    public override ValorWrapper VisitAsignacionInstancia(LanguageParser.AsignacionInstanciaContext context)
    {
        string NombreStruct = context.IDENTIFICADOR().GetText();

        if (!EntornoActual.ExisteStruct(NombreStruct))
        {
            throw new Exception($"Error: El struct '{NombreStruct}' no está definido.");
        }
        Dictionary<string, string> AtributosStruct = EntornoActual.ObtenerStruct(NombreStruct);
        Dictionary<string, ValorWrapper> AtributosNuevaInstancia = new();

        for (int i = 0; i < context.atributos_instancia().IDENTIFICADOR().Length; i++)
        {
            string NombreAtributo = context.atributos_instancia().IDENTIFICADOR(i).GetText();
            ValorWrapper ValorAtributo = Visit(context.atributos_instancia().expresion(i)); 

            if (!AtributosStruct.ContainsKey(NombreAtributo))
            {
                throw new Exception($"Error: El NombreAtributo '{NombreAtributo}' no existe en el struct '{NombreStruct}'.");
            }

            string TipoAtributoEsperado = AtributosStruct[NombreAtributo];

            if (!ObtenerTipo(ValorAtributo).Equals(TipoAtributoEsperado))
            {
                throw new Exception($"Error: El Atributo '{NombreAtributo}' de '{NombreStruct}' esperaba un Atributo de tipo '{TipoAtributoEsperado}', pero se recibió '{ObtenerTipo(ValorAtributo)}'.");
            }

            AtributosNuevaInstancia[NombreAtributo] = ValorAtributo;
        }

        foreach (var NombreAtributo in AtributosStruct)
        {
            if (!AtributosNuevaInstancia.ContainsKey(NombreAtributo.Key))
            {
                string tipo = NombreAtributo.Value;
                AtributosNuevaInstancia[NombreAtributo.Key] = ObtenerValorPorDefecto(tipo);
            }
        }

        ValorStruct NuevaInstancia = new(AtributosNuevaInstancia, NombreStruct);
        return NuevaInstancia;
    }

    private ValorWrapper ObtenerValorPorDefecto(string tipo)
    {
        if (tipo == "int") return new ValorInt(0);
        if (tipo == "float64") return new ValorFloat64(0);
        if (tipo == "string") return new ValorString("");
        if (tipo == "bool") return new ValorBoolean(false);
        if (tipo == "rune") return new ValorRune(' ');
        
        if (EntornoActual.ExisteStruct(tipo))
        {
            Dictionary<string, string> atributosDefinidos = EntornoActual.ObtenerStruct(tipo);
            Dictionary<string, ValorWrapper> atributosInicializados = new();

            foreach (var atributo in atributosDefinidos)
            {
                atributosInicializados[atributo.Key] = ObtenerValorPorDefecto(atributo.Value);
            }

            return new ValorStruct(atributosInicializados, tipo);
        }

        throw new Exception($"Error: Tipo '{tipo}' desconocido.");
    }

    //VisitAccesoStruct
    public override ValorWrapper VisitAccesoStruct(LanguageParser.AccesoStructContext context)
    {
        string NombreInstancia = context.IDENTIFICADOR(0).GetText();
        
        ValorWrapper InstanciaActual = EntornoActual.Obtener(NombreInstancia);
        
        for (int i = 1; i < context.IDENTIFICADOR().Length; i++)
        {
            string atributo = context.IDENTIFICADOR(i).GetText();

            if (InstanciaActual is ValorStruct StructAuxiliar)
            {
                InstanciaActual = StructAuxiliar.ObtenerAtributo(atributo);
            }
            else
            {
                throw new Exception($"Error: '{NombreInstancia}' no es una estructura válida para acceder a '{atributo}'.");
            }
        }
        return InstanciaActual;
    }

    // VisitAsignacionAtributoInstancia
    public override ValorWrapper VisitAsignacionAtributoInstancia(LanguageParser.AsignacionAtributoInstanciaContext context)
    {
        string NombreInstancia = context.IDENTIFICADOR(0).GetText();
        ValorWrapper InstanciaActual = EntornoActual.Obtener(NombreInstancia);
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
                throw new Exception($"Error: '{NombreInstancia}' no es una estructura válida para acceder a '{atributo}'.");
            }
        }

        string AtributoFinal = context.IDENTIFICADOR().Last().GetText();

        if (InstanciaActual is ValorStruct InstanciaModificable)
        {
            ValorWrapper ValorExistente = InstanciaModificable.ObtenerAtributo(AtributoFinal);

            if (!ObtenerTipo(NuevoValor).Equals(ObtenerTipo(ValorExistente), StringComparison.Ordinal))
            {
                throw new Exception($"Error: No se puede asignar un valor de tipo '{ObtenerTipo(NuevoValor)}' al atributo '{AtributoFinal}' de tipo '{ObtenerTipo(ValorExistente)}'.");
            }

            // Asignar nuevo valor
            InstanciaModificable.AsignarAtributo(AtributoFinal, NuevoValor);
        }
        else
        {
            throw new Exception($"Error: No se puede asignar a '{AtributoFinal}' porque '{InstanciaActual}' no es un struct.");
        }

        return NuevoValor;
    }
    // VisitIncremento
    public override ValorWrapper VisitIncremento(LanguageParser.IncrementoContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper variable = EntornoActual.Obtener(identificador);

        if (variable is ValorInt)
        {
            ValorInt valor = (ValorInt)variable;
            ValorInt nuevoValor = new(valor.Valor + 1);
            EntornoActual.Asignar(identificador, nuevoValor);
            return nuevoValor;
        }
        else if (variable is ValorFloat64)
        {
            ValorFloat64 valor = (ValorFloat64)variable;
            ValorFloat64 nuevoValor = new(valor.Valor + 1);
            EntornoActual.Asignar(identificador, nuevoValor);
            return nuevoValor;
        }
        else
        {
            throw new Exception("Incremento: Tipo de Dato: " + ObtenerTipo(variable) + " No es un Entero o Float64");
        }
    }
    // VisitDecremento
    public override ValorWrapper VisitDecremento(LanguageParser.DecrementoContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper variable = EntornoActual.Obtener(identificador);

        if (variable is ValorInt)
        {
            ValorInt valor = (ValorInt)variable;
            ValorInt nuevoValor = new(valor.Valor - 1);
            EntornoActual.Asignar(identificador, nuevoValor);
            return nuevoValor;
        }
        else if (variable is ValorFloat64)
        {
            ValorFloat64 valor = (ValorFloat64)variable;
            ValorFloat64 nuevoValor = new(valor.Valor - 1);
            EntornoActual.Asignar(identificador, nuevoValor);
            return nuevoValor;
        }
        else
        {
            throw new Exception("Decremento: Tipo de Dato: " + ObtenerTipo(variable) + " No es un Entero o Float64");
        }
    }

}
