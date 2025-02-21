public abstract record ValorWapper;

public record ValorInt(int Valor) : ValorWapper;

public record ValorFloat64(float Valor) : ValorWapper;

public record ValorString(string Valor) : ValorWapper;

public record ValorBoolean(bool Valor) : ValorWapper;

public record ValorRune(char Valor) : ValorWapper;

public record ValorVoid : ValorWapper;