public class Unaria {
    private ValorWrapper Izquierda;
    private string Operador;

    public Unaria(ValorWrapper izquierda, string operador)
    {
        Izquierda = izquierda;
        Operador = operador;
    }
    public ValorWrapper RealizarOperacion()
    {
        switch (Operador)
        {
            case "-":
                return RestaUnaria();
            case "!":
                return NegacionUnaria();
            default:
                throw new Exception("Operador: " + Operador + " No Encontrado");
        }
    }

    public ValorWrapper RestaUnaria()
    {
        //-int
        if (Izquierda is ValorInt)
        {
            return new ValorInt(-((ValorInt)Izquierda).Valor);
        }
        //-float64
        if (Izquierda is ValorFloat64)
        {
            return new ValorFloat64(-((ValorFloat64)Izquierda).Valor);
        }
        throw new Exception("Tipos de datos no soportados para la operación -");
    }

    public ValorWrapper NegacionUnaria()
    {
        //!bool
        if (Izquierda is ValorBoolean)
        {
            return new ValorBoolean(!((ValorBoolean)Izquierda).Valor);
        }
        throw new Exception("Tipos de datos no soportados para la operación !");
    }

}