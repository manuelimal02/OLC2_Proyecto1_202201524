using System.Globalization;
public class ManejoValorWrappper{
    public static string ObtenerTipo(ValorWrapper valor)
    {
        return valor switch
        {
            ValorInt _ => "int",
            ValorFloat64 _ => "float64",
            ValorString _ => "string",
            ValorBoolean _ => "bool",
            ValorRune _ => "rune",
            ValorVoid _ => "void",
            ValorNil _ => "nil",
            ValorFuncion _ => "funcion",
            ValorStruct Struct => Struct.NombreStruct,
            ValorSlice Slice => Slice.Tipo,
            _ => throw new ArgumentException("Obtener Tipo: Tipo de valor no soportado.")
        };
    }

    public static string ObtenerValor(ValorWrapper valor)
    {
        return valor switch
        {
            ValorInt v => v.Valor.ToString(),
            ValorFloat64 v => v.Valor.ToString("0.0", CultureInfo.InvariantCulture),
            ValorString v => v.Valor,
            ValorBoolean v => v.Valor.ToString(),
            ValorRune v => v.Valor.ToString(),
            ValorVoid _ => "void",
            ValorNil _ => "nil",
            ValorFuncion v => "Funcion",
            ValorStruct v => RepresentacionStruct(v),
            ValorSlice v => RepresentacionSlice(v),
            _ => throw new ArgumentException("Obtener Valor: Tipo de valor no soportado.")
        };
    }

    public static string RepresentacionStruct(ValorStruct StructActual)
    {
        List<string> AtributosStruct = new List<string>();
        foreach (var atributo in StructActual.Atributos)
        {
            string nombre = atributo.Key;
            ValorWrapper valor = atributo.Value;
            string valorRepresentado = valor switch
            {
                ValorStruct structAnidado => RepresentacionStruct(structAnidado),
                ValorSlice Slice => RepresentacionSlice(Slice),
                _ => ObtenerValor(valor)
            };
            AtributosStruct.Add($"{nombre}: {valorRepresentado}");
        }
        return $"{StructActual.NombreStruct}{{ {string.Join(", ", AtributosStruct)} }}";
    }
   
    public static string RepresentacionSlice(ValorSlice Slice)
    {
        if (Slice.Valores.Count == 0)
            return "[]";
        if (Slice.Valores.All(v => v is ValorSlice))
        {
            return "[" + string.Join(", ", Slice.Valores.Select(v => RepresentacionSlice((ValorSlice)v))) + "]";
        }
        return "[" + string.Join(", ", Slice.Valores.Select(ObtenerValor)) + "]";
    }

    public static bool VerificarTipoPrimitivo(string tipo)
    {
        return tipo == "int" || tipo == "float64" || tipo == "string" || tipo == "bool" || tipo == "rune";
    }

    public static string ObtenerTipoSimbolo(ValorWrapper valor)
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
}