public abstract record ValorWrapper;

public record ValorInt(int Valor) : ValorWrapper;

public record ValorFloat64(float Valor) : ValorWrapper;

public record ValorString(string Valor) : ValorWrapper;

public record ValorBoolean(bool Valor) : ValorWrapper;

public record ValorRune(char Valor) : ValorWrapper;

public record ValorArreglo(List<ValorWrapper> Valores, string Tipo) : ValorWrapper;

public record ValorVoid : ValorWrapper;