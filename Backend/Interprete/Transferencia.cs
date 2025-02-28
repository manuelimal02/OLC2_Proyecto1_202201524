public class ExceptionBreack : Exception
{
    public ExceptionBreack() : base("Breack Fuera de Ciclo")
    {
    }
}

public class ExceptionContinue : Exception
{
    public ExceptionContinue() : base("Continue Fuera de Ciclo")
    {
    }
}

public class ExceptionReturn : Exception
{
    public ValorWrapper Valor { get; }
    public ExceptionReturn(ValorWrapper valor) : base("Return Fuera de Funcion")
    {
        Valor = valor;
    }
}