using Antlr4.Runtime;
using Antlr4.Runtime.Misc;
using System.Text;

public class Error
{
    public static List<FilaTablaErrores> TablaGlobalErrores = new();

    public string ExportarTablaErrores()
    {
        var sb = new StringBuilder();

        sb.AppendLine("<html><head>");
        sb.AppendLine("<style>");
        sb.AppendLine("body { font-family: Arial, sans-serif; text-align: center; }");
        sb.AppendLine("h2 { margin-bottom: 20px; }");
        sb.AppendLine("table { width: 80%; margin: auto; border-collapse: collapse; }");
        sb.AppendLine("th, td { border: 1px solid black; padding: 8px; text-align: center; }");
        sb.AppendLine("th { background-color: #DC3545; color: white; }");
        sb.AppendLine("tr:nth-child(even) { background-color: #f8d7da; }");
        sb.AppendLine("td:last-child { font-weight: bold; }");
        sb.AppendLine(".footer { margin-top: 20px; text-align: right; font-style: italic; }");
        sb.AppendLine("</style>");
        sb.AppendLine("</head><body>");

        sb.AppendLine("<h2>Tabla de Errores</h2>");

        sb.AppendLine("<table>");
        sb.AppendLine("<tr><th>No</th><th>Descripción</th><th>Línea</th><th>Columna</th><th>Tipo</th></tr>");

        foreach (var error in TablaGlobalErrores)
        {
            sb.AppendLine($"<tr><td>{error.No}</td><td>{error.Descripcion}</td><td>{error.Linea}</td><td>{error.Columna}</td><td>{error.Tipo}</td></tr>");
        }

        sb.AppendLine("</table>");

        sb.AppendLine("<div class='footer'>Desarrollado por: Tu Nombre</div>");
        sb.AppendLine("</body></html>");

        return sb.ToString();
    }
}

public class ErrorSemantico : Exception
{
    private string MensajeError;
    private Antlr4.Runtime.IToken LineaColumna;

    public ErrorSemantico(string MensajeError, Antlr4.Runtime.IToken LineaColumna)
    {
        this.MensajeError = MensajeError;
        this.LineaColumna = LineaColumna;
    }

    public override string Message
    {
        get
        {
            Error.TablaGlobalErrores.Add(new FilaTablaErrores
            {
                No = Error.TablaGlobalErrores.Count + 1,
                Descripcion = MensajeError,
                Linea = LineaColumna.Line,
                Columna = LineaColumna.Column,
                Tipo = "Semántico"
            });
            return $"{MensajeError} En línea: {LineaColumna.Line}, Columna: {LineaColumna.Column}";
        }
    }
}

public class ErrorLexico : BaseErrorListener, IAntlrErrorListener<int>
{
    public void SyntaxError(TextWriter output, IRecognizer recognizer, int offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
    {
        Error.TablaGlobalErrores.Add(new FilaTablaErrores
        {
            No = Error.TablaGlobalErrores.Count + 1,
            Descripcion = msg,
            Linea = line,
            Columna = charPositionInLine,
            Tipo = "Léxico"
        });
        throw new ParseCanceledException($"Error Léxico En Línea: '{line}', Columna: '{charPositionInLine}': {msg}.");
    }
}

public class ErrorSintactico : BaseErrorListener
{
    public override void SyntaxError(TextWriter output, IRecognizer recognizer, IToken offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
    {
        Error.TablaGlobalErrores.Add(new FilaTablaErrores
        {
            No = Error.TablaGlobalErrores.Count + 1,
            Descripcion = msg,
            Linea = line,
            Columna = charPositionInLine,
            Tipo = "Sintáctico"
        });
        throw new ParseCanceledException($"Error Sintáctico En Línea: '{line}', Columna: '{charPositionInLine}': {msg}.");
    }
}

public class FilaTablaErrores
{
    public int No { get; set; }
    public string Descripcion { get; set; } = "";
    public int Linea { get; set; }
    public int Columna { get; set; }
    public string Tipo { get; set; } = "";
}
