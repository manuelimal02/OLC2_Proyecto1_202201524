public class Binaria
{
    private ValorWrapper Derecha;
    private ValorWrapper Izquierda;
    private string Operador;

    public Binaria(ValorWrapper izquierda, ValorWrapper derecha, string operador)
    {
        Izquierda = izquierda;
        Derecha = derecha;
        Operador = operador;
    }
    public ValorWrapper RealizarOperacion()
    {
        switch (Operador)
        {
            case "+":
                // int + int = int
                if (Izquierda is ValorInt izquierdaInt && Derecha is ValorInt derechaInt){
                    return new ValorInt(izquierdaInt.Valor + derechaInt.Valor);
                // float64 + float64 = float64
                } if (Izquierda is ValorFloat64 izquierdaFloat && Derecha is ValorFloat64 derechaFloat){
                    return new ValorFloat64(izquierdaFloat.Valor + derechaFloat.Valor);
                // string + string = string
                }if (Izquierda is ValorString izquierdaString && Derecha is ValorString derechaString){
                    return new ValorString(izquierdaString.Valor + derechaString.Valor);
                // int + float64 = float64
                }if (Izquierda is ValorInt izquierdaInt2 && Derecha is ValorFloat64 derechaFloat2){
                    return new ValorFloat64(izquierdaInt2.Valor + derechaFloat2.Valor);
                // float64 + int = float64
                }if (Izquierda is ValorFloat64 izquierdaFloat2 && Derecha is ValorInt derechaInt2){
                    return new ValorFloat64(izquierdaFloat2.Valor + derechaInt2.Valor);
                } throw new Exception("Tipos de datos no soportados para la operacion +");
            default:
                throw new Exception("Operador no soportado");
        }
    }
}