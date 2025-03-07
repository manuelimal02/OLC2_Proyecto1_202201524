public abstract record ValorWrapper;

public record ValorInt(int Valor) : ValorWrapper;

public record ValorFloat64(float Valor) : ValorWrapper;

public record ValorString(string Valor) : ValorWrapper;

public record ValorBoolean(bool Valor) : ValorWrapper;

public record ValorRune(char Valor) : ValorWrapper;

public record ValorArreglo(List<ValorWrapper> Valores, string Tipo) : ValorWrapper;

public record ValorFuncion(Invocable Invocable, string identificador) : ValorWrapper;

public record ValorStruct(Dictionary<string, ValorWrapper> Atributos, string NombreStruct) : ValorWrapper
{
    public ValorWrapper ObtenerAtributo(string atributo)
    {
        if (Atributos.ContainsKey(atributo))
        {
            return Atributos[atributo];
        }
        throw new Exception($"El atributo '{atributo}' no existe en la estructura '{NombreStruct}'.");
    }

    public void AsignarAtributo(string atributo, ValorWrapper valor)
    {
        if (!Atributos.ContainsKey(atributo))
        {
            throw new Exception($"El atributo '{atributo}' no existe en la estructura '{NombreStruct}'.");
        }
        Atributos[atributo] = valor;
    }
}




public record ValorVoid : ValorWrapper;