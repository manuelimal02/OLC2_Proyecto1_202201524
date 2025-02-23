
using Analizador;
using System.Globalization;

public class InterpreteVisitor : LanguageBaseVisitor<ValorWrapper>
{
    public string Salida = "";
    private Entorno EntornoActual = new Entorno(null);
    private ValorWrapper ValorVoid = new ValorVoid();
    private string GetValorWrapper(ValorWrapper valor)
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

    private string GetTipoValor(ValorWrapper valor)
    {
        return valor switch
        {
            ValorInt _ => "int",
            ValorFloat64 _ => "float64",
            ValorString _ => "string",
            ValorBoolean _ => "bool",
            ValorRune _ => "rune",
            ValorVoid _ => "void",
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
            expresion = new ValorFloat64(float.Parse(GetValorWrapper(expresion), CultureInfo.InvariantCulture));
            EntornoActual.DeclracionVariable(identificador, expresion);
            return ValorVoid;
        } else if (!GetTipoValor(expresion).Equals(tipo, StringComparison.Ordinal)){
            Salida += "Decla: Tipo de Dato: " + tipo + " No Coincide con el Valor: " + GetTipoValor(expresion)+ "\n";
            return ValorVoid;
        }else{
            EntornoActual.DeclracionVariable(identificador, expresion);
            return ValorVoid;
        }
    }
    // VisitDeclaracionImplicita
    public override ValorWrapper VisitDeclaracionImplicita(LanguageParser.DeclaracionImplicitaContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper expresion = Visit(context.expresion());
        EntornoActual.DeclracionVariable(identificador, expresion);
        return ValorVoid;
    }
    // VisitDeclaracionPorDefecto
    public override ValorWrapper VisitDeclaracionPorDefecto(LanguageParser.DeclaracionPorDefectoContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        string tipo = context.TIPO().GetText();
        switch (tipo){
            case "int":
                EntornoActual.DeclracionVariable(identificador, new ValorInt(0));
                break;
            case "float64":
                EntornoActual.DeclracionVariable(identificador, new ValorFloat64(0));
                break;
            case "string":
                EntornoActual.DeclracionVariable(identificador, new ValorString(""));
                break;
            case "bool":
                EntornoActual.DeclracionVariable(identificador, new ValorBoolean(false));
                break;
            case "rune":
                EntornoActual.DeclracionVariable(identificador, new ValorRune('0'));
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
        ValorWrapper valor = EntornoActual.GetVariable(identificador);

        if (expresion is ValorInt && valor is ValorFloat64){
            expresion = new ValorFloat64(float.Parse(GetValorWrapper(expresion), CultureInfo.InvariantCulture));
            return EntornoActual.AsignacionVariable(identificador, expresion);
        } else if (GetTipoValor(expresion).Equals(GetTipoValor(valor), StringComparison.Ordinal)){
            return EntornoActual.AsignacionVariable(identificador, expresion);
        }
        Salida += "Asig: Tipo de Dato: " + GetTipoValor(expresion) + " No Coincide con el Valor: " + GetTipoValor(valor) + "\n";
        return ValorVoid;
    }
    // VisitFuncionEmbebidaPrintln
    public override ValorWrapper VisitFuncionEmbebidaPrintln(LanguageParser.FuncionEmbebidaPrintlnContext context)
    {
        List<string> ValoresSalida = new List<string>();

        foreach (var expre in context.expresion())
        {
            ValorWrapper expresion = Visit(expre);
            ValoresSalida.Add(GetValorWrapper(expresion)); 
        }

        Salida += string.Join(" ", ValoresSalida) + "\n";
        return ValorVoid;
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

}