public class Binaria
{
    private ValorWrapper Derecha;
    private ValorWrapper Izquierda;
    private string Operador;
    private Antlr4.Runtime.IToken LineaColumna;

    public Binaria(ValorWrapper izquierda, ValorWrapper derecha, string operador, Antlr4.Runtime.IToken LineaColumna)
    {
        Izquierda = izquierda;
        Derecha = derecha;
        Operador = operador;
        this.LineaColumna = LineaColumna;
    }
    
    public ValorWrapper RealizarOperacion() 
    {
        switch (Operador)
        {
            case "+":
                return Suma();
            case "-":
                return Resta();
            case "*":
                return Multiplicacion();
            case "/":
                return Division();
            case "%":
                return Modulo();
            case "==":
                return Igualdad();
            case "!=":
                return Desigualdad();
            case ">":
                return Mayor();
            case "<":
                return Menor();
            case ">=":
                return MayorIgual();
            case "<=":
                return MenorIgual();
            case "&&":
                return OperacionAnd();
            case "||":
                return OperacionOr();
            default:
                throw new ErrorSemantico("Operador: " + Operador + " No Encontrado", this.LineaColumna);
        }
    }

    public ValorWrapper Suma(){
        // int + int = int
        if (Izquierda is ValorInt izqInt && Derecha is ValorInt derInt)
            return new ValorInt(izqInt.Valor + derInt.Valor);
        // float64 + float64 = float64
        if (Izquierda is ValorFloat64 izqFloat && Derecha is ValorFloat64 derFloat)
            return new ValorFloat64(izqFloat.Valor + derFloat.Valor);
        // string + string = string
        if (Izquierda is ValorString izqStr && Derecha is ValorString derStr)
            return new ValorString(izqStr.Valor + derStr.Valor);
        // int + float64 = float64
        if (Izquierda is ValorInt izqInt2 && Derecha is ValorFloat64 derFloat2)
            return new ValorFloat64(izqInt2.Valor + derFloat2.Valor);
        // float64 + int = float64
        if (Izquierda is ValorFloat64 izqFloat2 && Derecha is ValorInt derInt2)
            return new ValorFloat64(izqFloat2.Valor + derInt2.Valor);
        
        throw new ErrorSemantico("Tipos de datos no soportados para la operación +", this.LineaColumna);
    }

    public ValorWrapper Resta(){
        // int - int = int
        if (Izquierda is ValorInt izqInt && Derecha is ValorInt derInt)
            return new ValorInt(izqInt.Valor - derInt.Valor);
        // float64 - float64 = float64
        if (Izquierda is ValorFloat64 izqFloat && Derecha is ValorFloat64 derFloat)
            return new ValorFloat64(izqFloat.Valor - derFloat.Valor);
        // int - float64 = float64
        if (Izquierda is ValorInt izqInt2 && Derecha is ValorFloat64 derFloat2)
            return new ValorFloat64(izqInt2.Valor - derFloat2.Valor);
        // float64 - int = float64
        if (Izquierda is ValorFloat64 izqFloat2 && Derecha is ValorInt derInt2)
            return new ValorFloat64(izqFloat2.Valor - derInt2.Valor);
        throw new ErrorSemantico("Tipos de datos no soportados para la operación -", this.LineaColumna);
    }

    public ValorWrapper Multiplicacion(){
        // int * int = int
        if (Izquierda is ValorInt izqInt && Derecha is ValorInt derInt)
            return new ValorInt(izqInt.Valor * derInt.Valor);
        // float64 * float64 = float64
        if (Izquierda is ValorFloat64 izqFloat && Derecha is ValorFloat64 derFloat)
            return new ValorFloat64(izqFloat.Valor * derFloat.Valor);
        // int * float64 = float64
        if (Izquierda is ValorInt izqInt2 && Derecha is ValorFloat64 derFloat2)
            return new ValorFloat64(izqInt2.Valor * derFloat2.Valor);
        // float64 * int = float64
        if (Izquierda is ValorFloat64 izqFloat2 && Derecha is ValorInt derInt2)
            return new ValorFloat64(izqFloat2.Valor * derInt2.Valor);
        throw new ErrorSemantico("Tipos de datos no soportados para la operación *", this.LineaColumna);
    }

    public ValorWrapper Division(){
        // Division por 0
        if (Derecha is ValorInt derInt1 && derInt1.Valor == 0)
            throw new ErrorSemantico("Division por 0", this.LineaColumna);
        // int / int = int
        if (Izquierda is ValorInt izqInt && Derecha is ValorInt derInt3)
            return new ValorInt(izqInt.Valor / derInt3.Valor);
        // float64 / float64 = float64
        if (Izquierda is ValorFloat64 izqFloat && Derecha is ValorFloat64 derFloat)
            return new ValorFloat64(izqFloat.Valor / derFloat.Valor);
        // int / float64 = float64
        if (Izquierda is ValorInt izqInt2 && Derecha is ValorFloat64 derFloat2)
            return new ValorFloat64(izqInt2.Valor / derFloat2.Valor);
        // float64 / int = float64
        if (Izquierda is ValorFloat64 izqFloat2 && Derecha is ValorInt derInt2)
            return new ValorFloat64(izqFloat2.Valor / derInt2.Valor);
        throw new ErrorSemantico("Tipos de datos no soportados para la operación /", this.LineaColumna);
    }

    public ValorWrapper Modulo(){
        // Modulo por 0
        if (Derecha is ValorInt derInt1 && derInt1.Valor == 0)
            throw new ErrorSemantico("Modulo por 0", this.LineaColumna);
        // int % int = int
        if (Izquierda is ValorInt izqInt && Derecha is ValorInt derInt)
            return new ValorInt(izqInt.Valor % derInt.Valor);
        throw new ErrorSemantico("Tipos de datos no soportados para la operación %", this.LineaColumna);
    }

    public ValorWrapper Igualdad(){
        // int == int = bool
        if (Izquierda is ValorInt izqInt && Derecha is ValorInt derInt)
            return new ValorBoolean(izqInt.Valor == derInt.Valor);
        // float64 == float64 = bool
        if (Izquierda is ValorFloat64 izqFloat && Derecha is ValorFloat64 derFloat)
            return new ValorBoolean(izqFloat.Valor == derFloat.Valor);
        // string == string = bool
        if (Izquierda is ValorString izqStr && Derecha is ValorString derStr)
            return new ValorBoolean(izqStr.Valor == derStr.Valor);
        // bool == bool = bool
        if (Izquierda is ValorBoolean izqBool && Derecha is ValorBoolean derBool)
            return new ValorBoolean(izqBool.Valor == derBool.Valor);
        // rune == rune = bool
        if (Izquierda is ValorRune izqRune && Derecha is ValorRune derRune)
            return new ValorBoolean(izqRune.Valor == derRune.Valor);
        // int == float64 = bool
        if (Izquierda is ValorInt izqInt2 && Derecha is ValorFloat64 derFloat2)
            return new ValorBoolean(izqInt2.Valor == derFloat2.Valor);
        // float64 == int = bool
        if (Izquierda is ValorFloat64 izqFloat2 && Derecha is ValorInt derInt2)
            return new ValorBoolean(izqFloat2.Valor == derInt2.Valor);
        // Soporte para nil
        if (Izquierda is ValorNil && Derecha is ValorNil)
            return new ValorBoolean(true);
            
        throw new ErrorSemantico("Tipos de datos no soportados para la operación ==", this.LineaColumna);
    }

    public ValorWrapper Desigualdad(){
        // int != int = bool
        if (Izquierda is ValorInt izqInt && Derecha is ValorInt derInt)
            return new ValorBoolean(izqInt.Valor != derInt.Valor);
        // float64 != float64 = bool
        if (Izquierda is ValorFloat64 izqFloat && Derecha is ValorFloat64 derFloat)
            return new ValorBoolean(izqFloat.Valor != derFloat.Valor);
        // string != string = bool
        if (Izquierda is ValorString izqStr && Derecha is ValorString derStr)
            return new ValorBoolean(izqStr.Valor != derStr.Valor);
        // bool != bool = bool
        if (Izquierda is ValorBoolean izqBool && Derecha is ValorBoolean derBool)
            return new ValorBoolean(izqBool.Valor != derBool.Valor);
        // rune != rune = bool
        if (Izquierda is ValorRune izqRune && Derecha is ValorRune derRune)
            return new ValorBoolean(izqRune.Valor != derRune.Valor);
        // int != float64 = bool
        if (Izquierda is ValorInt izqInt2 && Derecha is ValorFloat64 derFloat2)
            return new ValorBoolean(izqInt2.Valor != derFloat2.Valor);
        // float64 != int = bool
        if (Izquierda is ValorFloat64 izqFloat2 && Derecha is ValorInt derInt2)
            return new ValorBoolean(izqFloat2.Valor != derInt2.Valor);
        throw new ErrorSemantico("Tipos de datos no soportados para la operación !=", this.LineaColumna);
    }

    public ValorWrapper Mayor(){
        // int > int = bool
        if (Izquierda is ValorInt izqInt && Derecha is ValorInt derInt)
            return new ValorBoolean(izqInt.Valor > derInt.Valor);
        // float64 > float64 = bool
        if (Izquierda is ValorFloat64 izqFloat && Derecha is ValorFloat64 derFloat)
            return new ValorBoolean(izqFloat.Valor > derFloat.Valor);
        // int > float64 = bool
        if (Izquierda is ValorInt izqInt2 && Derecha is ValorFloat64 derFloat2)
            return new ValorBoolean(izqInt2.Valor > derFloat2.Valor);
        // float64 > int = bool
        if (Izquierda is ValorFloat64 izqFloat2 && Derecha is ValorInt derInt2)
            return new ValorBoolean(izqFloat2.Valor > derInt2.Valor);
        // rune > rune = bool
        if (Izquierda is ValorRune izqRune && Derecha is ValorRune derRune)
            return new ValorBoolean(izqRune.Valor > derRune.Valor);
        throw new ErrorSemantico("Tipos de datos no soportados para la operación >", this.LineaColumna);
    }

    public ValorWrapper Menor(){
        // int < int = bool
        if (Izquierda is ValorInt izqInt && Derecha is ValorInt derInt)
            return new ValorBoolean(izqInt.Valor < derInt.Valor);
        // float64 < float64 = bool
        if (Izquierda is ValorFloat64 izqFloat && Derecha is ValorFloat64 derFloat)
            return new ValorBoolean(izqFloat.Valor < derFloat.Valor);
        // int < float64 = bool
        if (Izquierda is ValorInt izqInt2 && Derecha is ValorFloat64 derFloat2)
            return new ValorBoolean(izqInt2.Valor < derFloat2.Valor);
        // float64 < int = bool
        if (Izquierda is ValorFloat64 izqFloat2 && Derecha is ValorInt derInt2)
            return new ValorBoolean(izqFloat2.Valor < derInt2.Valor);
        // rune < rune = bool
        if (Izquierda is ValorRune izqRune && Derecha is ValorRune derRune)
            return new ValorBoolean(izqRune.Valor < derRune.Valor);
        throw new ErrorSemantico("Tipos de datos no soportados para la operación <", this.LineaColumna);
    }

    public ValorWrapper MayorIgual(){
        // int >= int = bool
        if (Izquierda is ValorInt izqInt && Derecha is ValorInt derInt)
            return new ValorBoolean(izqInt.Valor >= derInt.Valor);
        // float64 >= float64 = bool
        if (Izquierda is ValorFloat64 izqFloat && Derecha is ValorFloat64 derFloat)
            return new ValorBoolean(izqFloat.Valor >= derFloat.Valor);
        // int >= float64 = bool
        if (Izquierda is ValorInt izqInt2 && Derecha is ValorFloat64 derFloat2)
            return new ValorBoolean(izqInt2.Valor >= derFloat2.Valor);
        // float64 >= int = bool
        if (Izquierda is ValorFloat64 izqFloat2 && Derecha is ValorInt derInt2)
            return new ValorBoolean(izqFloat2.Valor >= derInt2.Valor);
        // rune >= rune = bool
        if (Izquierda is ValorRune izqRune && Derecha is ValorRune derRune)
            return new ValorBoolean(izqRune.Valor >= derRune.Valor);
        throw new ErrorSemantico("Tipos de datos no soportados para la operación >=", this.LineaColumna);
    }
    public ValorWrapper MenorIgual(){
        // int <= int = bool
        if (Izquierda is ValorInt izqInt && Derecha is ValorInt derInt)
            return new ValorBoolean(izqInt.Valor <= derInt.Valor);
        // float64 <= float64 = bool
        if (Izquierda is ValorFloat64 izqFloat && Derecha is ValorFloat64 derFloat)
            return new ValorBoolean(izqFloat.Valor <= derFloat.Valor);
        // int <= float64 = bool
        if (Izquierda is ValorInt izqInt2 && Derecha is ValorFloat64 derFloat2)
            return new ValorBoolean(izqInt2.Valor <= derFloat2.Valor);
        // float64 <= int = bool
        if (Izquierda is ValorFloat64 izqFloat2 && Derecha is ValorInt derInt2)
            return new ValorBoolean(izqFloat2.Valor <= derInt2.Valor);
        // rune <= rune = bool
        if (Izquierda is ValorRune izqRune && Derecha is ValorRune derRune)
            return new ValorBoolean(izqRune.Valor <= derRune.Valor);
        throw new ErrorSemantico("Tipos de datos no soportados para la operación <=", this.LineaColumna);
    }

    public ValorWrapper OperacionAnd(){
        // bool && bool = bool
        if (Izquierda is ValorBoolean izqBool && Derecha is ValorBoolean derBool)
            return new ValorBoolean(izqBool.Valor && derBool.Valor);
        throw new ErrorSemantico("Tipos de datos no soportados para la operación &&", this.LineaColumna);
    }

    public ValorWrapper OperacionOr(){
        // bool || bool = bool
        if (Izquierda is ValorBoolean izqBool && Derecha is ValorBoolean derBool)
            return new ValorBoolean(izqBool.Valor || derBool.Valor);
        throw new ErrorSemantico("Tipos de datos no soportados para la operación ||", this.LineaColumna);
    }
}
