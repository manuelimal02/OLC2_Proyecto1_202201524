using Analizador;
using System.Text;

public class ASTVisitor : LanguageBaseVisitor<string>
{
    private int nodeId = 0;
    private StringBuilder dotBuilder = new StringBuilder();
    private List<string> edges = new List<string>();

    public ASTVisitor()
    {
        dotBuilder.AppendLine("digraph AST {");
    }

    private int GetNextNodeId() => nodeId++;

    private string AddNode(string label)
    {
        int id = GetNextNodeId();
        dotBuilder.AppendLine($"  {id} [label=\"{label}\"];");
        return id.ToString();
    }

    private void AddEdge(string parent, string child)
    {
        edges.Add($"  {parent} -> {child};");
    }

    public override string VisitProgram(LanguageParser.ProgramContext context)
    {
        string rootNode = AddNode("Program");

        foreach (var sentencia in context.declaraciones())
        {
            string childNode = Visit(sentencia);
            AddEdge(rootNode, childNode);
        }

        return rootNode;
    }

    public override string VisitEntero(LanguageParser.EnteroContext context)
    {
        return AddNode($"Entero: {context.ENTERO().GetText()}");
    }

    public override string VisitDecimal(LanguageParser.DecimalContext context)
    {
        return AddNode($"Decimal: {context.DECIMAL().GetText()}");
    }

    public override string VisitCadena(LanguageParser.CadenaContext context)
    {
        return AddNode($"Cadena: {context.CADENA().GetText()}");
    }

    public override string VisitBooleano(LanguageParser.BooleanoContext context)
    {
        return AddNode($"Booleano: {context.BOOLEANO().GetText()}");
    }

    public override string VisitIdentificador(LanguageParser.IdentificadorContext context)
    {
        return AddNode($"Identificador: {context.IDENTIFICADOR().GetText()}");
    }

    public override string VisitDeclaracionExplicita(LanguageParser.DeclaracionExplicitaContext context)
    {
        string node = AddNode($"Declaración\nvar: {context.IDENTIFICADOR().GetText()} ({context.TIPO().GetText()})");

        string exprNode = Visit(context.expresion());
        AddEdge(node, exprNode);

        return node;
    }


    public string GetDotRepresentation()
    {
        foreach (var edge in edges)
        {
            dotBuilder.AppendLine(edge);
        }

        dotBuilder.AppendLine("}");
        return dotBuilder.ToString();
    }
}
