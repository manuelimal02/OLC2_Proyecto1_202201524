using static ManejoValorWrappper;
using System.Globalization;
using System.Text;
public class Entorno
{

    public static List<FilaTablaSimbolos> TablaGlobalSimbolos = new();
    public Dictionary<string, ValorWrapper> Simbolo = new Dictionary<string, ValorWrapper>();
    public Dictionary<string, Dictionary<string, string>> Struct = new();

    private Entorno? EntornoPadre;

    public Entorno(Entorno? EntornoPadre)
    {
        this.EntornoPadre = EntornoPadre;
    }
    public ValorWrapper Obtener(string identificador, Antlr4.Runtime.IToken token)
    {
        if (Simbolo.ContainsKey(identificador)){
            return Simbolo[identificador];
        }

        if (EntornoPadre != null){
            return EntornoPadre.Obtener(identificador, token);
        }
        throw new ErrorSemantico("Simbolo: " + identificador + " No Encontrado", token);
      
    }
    public void Declarar(string identificador, ValorWrapper valor, int linea, int columna, Antlr4.Runtime.IToken token)
    {
        if (Simbolo.ContainsKey(identificador)){
            throw new ErrorSemantico("Simbolo: " + identificador + " Ya Existe", token);
        } else {
            Simbolo.Add(identificador, valor);
            TablaGlobalSimbolos.Add(new FilaTablaSimbolos
            {
                Identificador = identificador,
                TipoSimbolo = ObtenerTipoSimbolo(valor),
                TipoDato = ObtenerTipo(valor),
                Valor = ObtenerValor(valor),
                Linea = linea,
                Columna = columna
            });
        }
    }
    public ValorWrapper Asignar (string identificador, ValorWrapper valor, Antlr4.Runtime.IToken token)
    {
        if (Simbolo.ContainsKey(identificador)){
            Simbolo[identificador] = valor;
            return valor;
        } 
        if (EntornoPadre != null){
            return EntornoPadre.Asignar(identificador, valor, token);
        }
        throw new ErrorSemantico("Simbolo: " + identificador + " No Encontrado.", token);
    }
    public void DeclararStruct(string nombre, Dictionary<string, string> atributos, Antlr4.Runtime.IToken token)
    {
        if (Struct.ContainsKey(nombre))
        {
            throw new ErrorSemantico($"Error: El struct '{nombre}' ya está definido.", token);
        }
        Struct[nombre] = atributos;
    }
    public Dictionary<string, string> ObtenerStruct(string nombre, Antlr4.Runtime.IToken token)
    {
        if (Struct.ContainsKey(nombre))
        {
            return Struct[nombre];
        }
        if (EntornoPadre != null)
        {
            return EntornoPadre.ObtenerStruct(nombre, token);
        }
        throw new ErrorSemantico($"Error: El struct '{nombre}' no está definido.", token);
    }
    public bool ExisteStruct(string nombre)
    {
        if (Struct.ContainsKey(nombre))
        {
            return true;
        }
        return EntornoPadre?.ExisteStruct(nombre) ?? false;
    }

    //---------------------------------------------------------------------------------------------------------------------
    public string ExportarTablaHtml()
    {
        var TablaSb = new StringBuilder();
        
        TablaSb.AppendLine("<html><head>");
        TablaSb.AppendLine("<style>");
        TablaSb.AppendLine("body { font-family: Arial, sans-serif; text-align: center; }");
        TablaSb.AppendLine("h2 { margin-bottom: 20px; }");
        TablaSb.AppendLine("table { width: 80%; margin: auto; border-collapse: collapse; }");
        TablaSb.AppendLine("th, td { border: 1px solid black; padding: 8px; text-align: center; }");
        TablaSb.AppendLine("th { background-color: #007BFF; color: white; }");
        TablaSb.AppendLine("tr:nth-child(even) { background-color: #f2f2f2; }");
        TablaSb.AppendLine("td:last-child { font-weight: bold; }");
        TablaSb.AppendLine(".footer { margin-top: 20px; text-align: right; font-style: italic; }");
        TablaSb.AppendLine("</style>");
        TablaSb.AppendLine("</head><body>");
        TablaSb.AppendLine("<h2>Tabla De Símbolos</h2>");
        TablaSb.AppendLine("<table>");
        TablaSb.AppendLine("<tr><th>ID</th><th>Tipo Símbolo</th><th>Tipo Dato</th><th>Valor</th><th>Línea</th><th>Columna</th></tr>");
        foreach (var fila in TablaGlobalSimbolos)
        {
            TablaSb.AppendLine($"<tr><td>{fila.Identificador}</td><td>{fila.TipoSimbolo}</td><td>{fila.TipoDato}</td><td>{fila.Valor}</td><td>{fila.Linea}</td><td>{fila.Columna}</td></tr>");
        }
        TablaSb.AppendLine("</table>");
        TablaSb.AppendLine("<div class='footer'>Carlos Manuel Lima Y Lima</div>");
        TablaSb.AppendLine("</body></html>");
        
        return TablaSb.ToString();
    }
}

public class FilaTablaSimbolos
{
    public string Identificador { get; set; } = "";
    public string TipoSimbolo { get; set; } = "";
    public string TipoDato { get; set; } = "";
    public string Valor { get; set; } = "";
    public int Linea { get; set; }
    public int Columna { get; set; }
}