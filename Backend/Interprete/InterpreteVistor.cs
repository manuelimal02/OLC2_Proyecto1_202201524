
using Analizador;

public class InterpreteVisitor : LanguageBaseVisitor<ValorWapper>
{

    public string Salida = "";
    private Entorno EntornoActual = new Entorno();

    private ValorWapper ValorVoid = new ValorVoid();

    private string ObtenerValor(ValorWapper valor)
    {
        return valor switch
        {
            ValorInt v => v.Valor.ToString(),
            ValorFloat64 v => v.Valor.ToString(),
            ValorString v => v.Valor,
            ValorBoolean v => v.Valor.ToString(),
            ValorRune v => v.Valor.ToString(),
            ValorVoid v => "void",
            _ => throw new ArgumentException("Tipo de valor no soportado")
        };
    }

    // VisitProgram
    public override ValorWapper VisitProgram(LanguageParser.ProgramContext context)
    {
        foreach (var sentencia in context.declaraciones())
        {
            Visit(sentencia);
        }
        return ValorVoid;
    }

    //VisitEntero
    public override ValorWapper VisitEntero(LanguageParser.EnteroContext context)
    {
        return new ValorInt(int.Parse(context.ENTERO().GetText()));
    }

    //VisitDecimal
    public override ValorWapper VisitDecimal(LanguageParser.DecimalContext context)
    {
        return new ValorFloat64(float.Parse(context.DECIMAL().GetText()));
    }

    // VisitCadena
    public override ValorWapper VisitCadena(LanguageParser.CadenaContext context)
    {
        string cadena = context.CADENA().GetText();
        return new ValorString(cadena.Substring(1, cadena.Length - 2));
    }

    // VisitBooleano
    public override ValorWapper VisitBooleano(LanguageParser.BooleanoContext context)
    {
        return new ValorBoolean(bool.Parse(context.BOOLEANO().GetText()));
    }

    // VisitCaracter
    public override ValorWapper VisitCaracter(LanguageParser.CaracterContext context)
    {
        return new ValorRune(char.Parse(context.CARACTER().GetText()));
    }

    public override ValorWapper VisitIdentificador(LanguageParser.IdentificadorContext context)
    {
        return EntornoActual.GetVariable(context.IDENTIFICADOR().GetText());
    }
    // VisitDeclaracionExplicita

    public override ValorWapper VisitDeclaracionExplicita(LanguageParser.DeclaracionExplicitaContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWapper valor = Visit(context.expresion());
        string tipo = context.TIPO().GetText();

        if (valor is ValorInt && tipo != "int"){
            Salida += "Tipo de Dato NO Coincide con el Valor:";
        } else if (valor is ValorFloat64 && tipo != "float64"){
            Salida += "Tipo de Dato NO Coincide con el Valor:";
        } else if (valor is ValorString && tipo != "string"){
           Salida += "Tipo de Dato NO Coincide con el Valor:";
        } else if (valor is ValorBoolean && tipo != "bool"){
            Salida += "Tipo de Dato NO Coincide con el Valor:";
        } else if (valor is ValorRune && tipo != "rune"){
           Salida += "Tipo de Dato NO Coincide con el Valor:";
        }
        EntornoActual.DeclracionVariable(identificador, valor);
        return ValorVoid;
    }

    // VisitDeclaracionImplicita
    
    public override ValorWapper VisitDeclaracionImplicita(LanguageParser.DeclaracionImplicitaContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWapper valor = Visit(context.expresion());
        EntornoActual.DeclracionVariable(identificador, valor);
        return ValorVoid;
    }
    // VisitDeclaracionPorDefecto

    public override ValorWapper VisitDeclaracionPorDefecto(LanguageParser.DeclaracionPorDefectoContext context)
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
                EntornoActual.DeclracionVariable(identificador, new ValorRune(' '));
                break;
            default:
                throw new Exception("Tipo de Dato: " + tipo + " No Encontrado");
            }
        return ValorVoid;
    }

    // VisitFuncionEmbebidaPrintln
    public override ValorWapper VisitFuncionEmbebidaPrintln(LanguageParser.FuncionEmbebidaPrintlnContext context)
    {
    List<string> valores = new List<string>();

    foreach (var expre in context.expresion())
    {
        ValorWapper valor = Visit(expre);
        valores.Add(ObtenerValor(valor)); 
    }

    Salida += string.Join(" ", valores) + "\n";
    return ValorVoid;
    }


    // VisitDeclaraciones
    // VisitParentesis
    // VisitIdentificador
    // VisitRestaUnaria
    // VisitExprStmt
}



