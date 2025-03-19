public class Unaria {
    private ValorWrapper Izquierda;
    private string Operador;
    private Antlr4.Runtime.IToken LineaColumna;

    public Unaria(ValorWrapper izquierda, string operador, Antlr4.Runtime.IToken LineaColumna)
    {
        Izquierda = izquierda;
        Operador = operador;
        this.LineaColumna = LineaColumna;
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
                throw new ErrorSemantico("Operador: " + Operador + " No Encontrado", this.LineaColumna);
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
        throw new ErrorSemantico("Tipos de datos no soportados para la operación -", this.LineaColumna);
    }

    public ValorWrapper NegacionUnaria()
    {
        //!bool
        if (Izquierda is ValorBoolean)
        {
            return new ValorBoolean(!((ValorBoolean)Izquierda).Valor);
        }
        throw new ErrorSemantico("Tipos de datos no soportados para la operación !", this.LineaColumna);
    }

}