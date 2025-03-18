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

    //---------------------------------------------------------------------------------------------------------------------
    private string ObtenerTipoSimbolo(ValorWrapper valor)
    {
        return valor switch
        {
            ValorInt _ => "Variable",
            ValorFloat64 _ => "Variable",
            ValorString _ => "Variable",
            ValorBoolean _ => "Variable",
            ValorRune _ => "Variable",
            ValorSlice _ => "Slice",
            ValorFuncion _ => "Funcion",
            ValorStruct _ => "Struct",  
            _ => throw new ArgumentException("Obtener Tipo: Tipo de valor no soportado")
        };
    }
    //---------------------------------------------------------------------------------------------------------------------
    private string ObtenerTipoDato(ValorWrapper valor)
    {
        return valor switch
        {
            ValorInt _ => "int",
            ValorFloat64 _ => "float64",
            ValorString _ => "string",
            ValorBoolean _ => "bool",
            ValorRune _ => "rune",
            ValorSlice Slice => Slice.Tipo,
            ValorFuncion _ => "Funcion",
            ValorVoid _ => "void",
            ValorNil _ => "nil",
            ValorStruct Struct => Struct.NombreStruct,  
            _ => throw new ArgumentException("Obtener Tipo: Tipo de valor no soportado")
        };
    }
    //---------------------------------------------------------------------------------------------------------------------
    private string ObtenerValor(ValorWrapper valor)
    {
        return valor switch
        {
            ValorInt v => v.Valor.ToString(),
            ValorFloat64 v => v.Valor.ToString("0.0", CultureInfo.InvariantCulture),
            ValorString v => v.Valor,
            ValorBoolean v => v.Valor.ToString(),
            ValorRune v => v.Valor.ToString(),
            ValorSlice v => RepresentacionSlice(v),
            ValorFuncion v => "Funcion",
            ValorVoid _ => "void",
            ValorNil _ => "nil",
            ValorStruct v => RepresentacionStruct(v),
            _ => throw new ArgumentException("Obtener Valor: Tipo de valor no soportado")
        };
    }
    //---------------------------------------------------------------------------------------------------------------------
    private string RepresentacionStruct(ValorStruct structValor)
    {
        List<string> atributos = new List<string>();
        foreach (var atributo in structValor.Atributos)
        {
            string nombre = atributo.Key;
            ValorWrapper valor = atributo.Value;
            string valorRepresentado = valor switch
            {
                ValorStruct structAnidado => RepresentacionStruct(structAnidado),
                ValorSlice Slice => RepresentacionSlice(Slice),
                _ => ObtenerValor(valor)
            };
            atributos.Add($"{nombre}: {valorRepresentado}");
        }
        return $"{structValor.NombreStruct}{{ {string.Join(", ", atributos)} }}";
    }
    //---------------------------------------------------------------------------------------------------------------------
    private string RepresentacionSlice(ValorSlice Slice)
    {
        if (Slice.Valores.Count == 0)
            return "[]";
        if (Slice.Valores.All(v => v is ValorSlice))
        {
            return "[" + string.Join(", ", Slice.Valores.Select(v => RepresentacionSlice((ValorSlice)v))) + "]";
        }
        return "[" + string.Join(", ", Slice.Valores.Select(ObtenerValor)) + "]";
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
    //---------------------------------------------------------------------------------------------------------------------
    public ValorWrapper Obtener(string identificador)
    {
        if (Simbolo.ContainsKey(identificador)){
            return Simbolo[identificador];
        }

        if (EntornoPadre != null){
            return EntornoPadre.Obtener(identificador);
        }
        throw new Exception("Simbolo: " + identificador + " No Encontrado");
      
    }
    public void Declarar(string identificador, ValorWrapper valor, int linea, int columna)
    {
        if (Simbolo.ContainsKey(identificador)){
            throw new Exception("Simbolo: " + identificador + " Ya Existe");
        } else {
            Simbolo.Add(identificador, valor);
            TablaGlobalSimbolos.Add(new FilaTablaSimbolos
            {
                Identificador = identificador,
                TipoSimbolo = ObtenerTipoSimbolo(valor),
                TipoDato = ObtenerTipoDato(valor),
                Valor = ObtenerValor(valor),
                Linea = linea,
                Columna = columna
            });
        }
    }
    public ValorWrapper Asignar (string identificador, ValorWrapper valor)
    {
        if (Simbolo.ContainsKey(identificador)){
            Simbolo[identificador] = valor;
            return valor;
        } 
        if (EntornoPadre != null){
            return EntornoPadre.Asignar(identificador, valor);
        }
        throw new Exception("Simbolo: " + identificador + " No Encontrado.");
    }
    public void DeclararStruct(string nombre, Dictionary<string, string> atributos)
    {
        if (Struct.ContainsKey(nombre))
        {
            throw new Exception($"Error: El struct '{nombre}' ya está definido.");
        }
        Struct[nombre] = atributos;
    }
    public Dictionary<string, string> ObtenerStruct(string nombre)
    {
        if (Struct.ContainsKey(nombre))
        {
            return Struct[nombre];
        }
        if (EntornoPadre != null)
        {
            return EntornoPadre.ObtenerStruct(nombre);
        }
        throw new Exception($"Error: El struct '{nombre}' no está definido.");
    }
    public bool ExisteStruct(string nombre)
    {
        if (Struct.ContainsKey(nombre))
        {
            return true;
        }
        return EntornoPadre?.ExisteStruct(nombre) ?? false;
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