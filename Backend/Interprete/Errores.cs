using Antlr4.Runtime;
using Antlr4.Runtime.Misc;

public class ErrorSemantico : Exception
{

    private string MensajeError;
    private Antlr4.Runtime.IToken LineaComlumna;

    public ErrorSemantico(string MensajeError, Antlr4.Runtime.IToken LineaComlumna)
    {
        this.MensajeError = MensajeError;
        this.LineaComlumna = LineaComlumna;
    }

    public override string Message
    {
        get
        {
            return "Error Semántico - " + MensajeError + " En línea: " + LineaComlumna.Line + ", Columna: " + LineaComlumna.Column;
        }
    }
}


public class ErrorLexico : BaseErrorListener, IAntlrErrorListener<int>
{
    public void SyntaxError(TextWriter output, IRecognizer recognizer, int offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
    {
        throw new ParseCanceledException($"Error Léxico En Línea: '{line}', Columna: '{charPositionInLine}': {msg}.");
    }

}


public class ErrorSintactico : BaseErrorListener
{
    public override void SyntaxError(TextWriter output, IRecognizer recognizer, IToken offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
    {
        throw new ParseCanceledException($"Error Sintáctico En Línea: '{line}', Columna: '{charPositionInLine}': {msg}.");
    }
}