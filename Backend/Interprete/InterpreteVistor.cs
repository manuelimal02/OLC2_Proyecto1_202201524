
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
            ValorFloat64 v => v.Valor.ToString(),
            ValorString v => v.Valor,
            ValorBoolean v => v.Valor.ToString(),
            ValorRune v => v.Valor.ToString(),
            ValorVoid v => "void",
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

    public override ValorWrapper VisitIdentificador(LanguageParser.IdentificadorContext context)
    {
        return EntornoActual.GetVariable(context.IDENTIFICADOR().GetText());
    }
    // VisitDeclaracionExplicita

    public override ValorWrapper VisitDeclaracionExplicita(LanguageParser.DeclaracionExplicitaContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper valor = Visit(context.expresion());
        string tipo = context.TIPO().GetText();

        if (valor is ValorInt && tipo != "int"){
            Salida += "Tipo de Dato NO Coincide con el Valor:";
            return ValorVoid;
        } else if (valor is ValorFloat64 && tipo != "float64"){
            Salida += "Tipo de Dato NO Coincide con el Valor:";
            return ValorVoid;
        } else if (valor is ValorString && tipo != "string"){
           Salida += "Tipo de Dato NO Coincide con el Valor:";
           return ValorVoid;
        } else if (valor is ValorBoolean && tipo != "bool"){
            Salida += "Tipo de Dato NO Coincide con el Valor:";
            return ValorVoid;
        } else if (valor is ValorRune && tipo != "rune"){
           Salida += "Tipo de Dato NO Coincide con el Valor:";
           return ValorVoid;
        }
        EntornoActual.DeclracionVariable(identificador, valor);
        return ValorVoid;
    }

    // VisitDeclaracionImplicita
    
    public override ValorWrapper VisitDeclaracionImplicita(LanguageParser.DeclaracionImplicitaContext context)
    {
        string identificador = context.IDENTIFICADOR().GetText();
        ValorWrapper valor = Visit(context.expresion());
        EntornoActual.DeclracionVariable(identificador, valor);
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
                EntornoActual.DeclracionVariable(identificador, new ValorRune(' '));
                break;
            default:
                throw new Exception("Tipo de Dato: " + tipo + " No Encontrado");
            }
        return ValorVoid;
    }

    // VisitFuncionEmbebidaPrintln
    public override ValorWrapper VisitFuncionEmbebidaPrintln(LanguageParser.FuncionEmbebidaPrintlnContext context)
    {
        List<string> ValoresSalida = new List<string>();

        foreach (var expre in context.expresion())
        {
            ValorWrapper valor = Visit(expre);
            ValoresSalida.Add(GetValorWrapper(valor)); 
        }

        Salida += string.Join(" ", ValoresSalida) + "\n";
        return ValorVoid;
    }


    // VisitDeclaraciones
    // VisitParentesis
    // VisitIdentificador
    // VisitRestaUnaria
    // VisitExprStmt
}



