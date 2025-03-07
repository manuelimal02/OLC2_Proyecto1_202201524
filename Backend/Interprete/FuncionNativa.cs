using Analizador;

public class FuncionForanea : Invocable
{
    private Entorno Clousure;
    private LanguageParser.DeclaracionFuncionContext context;

    private string TipoRetornoEsperado;

    public FuncionForanea(Entorno clousure, LanguageParser.DeclaracionFuncionContext context)
    {
        Clousure = clousure;
        this.context = context;
         this.TipoRetornoEsperado = context.TIPO()?.GetText() ?? "void"; 
    }
    public int Aridad()
    {
       if (context.parametros() != null)
       {
           return context.parametros().IDENTIFICADOR().Length;
       }
       return 0;
    }

    public ValorWrapper Invoke(List<ValorWrapper> argumentos, InterpreteVisitor visitor)
    {
        var NuevoEntorno = new Entorno(Clousure);
        var EntornoDespuesDeLlamada= visitor.EntornoActual;
        visitor.EntornoActual = NuevoEntorno;
        if (context.parametros() != null)
        {
            HashSet<string> nombresParametros = new HashSet<string>();
            for (int i = 0; i < context.parametros().IDENTIFICADOR().Length; i++)
            {
                string NombreParametro = context.parametros().IDENTIFICADOR(i).GetText();
                string TipoParametro = context.parametros().TIPO(i).GetText();
                if (!nombresParametros.Add(NombreParametro))
                {
                    throw new Exception($"Error de declaración: El nombre del parámetro '{NombreParametro}' ya existe.");
                }

                if(argumentos[i] is ValorArreglo Arreglo)
                {
                    if (Arreglo.Tipo.Equals(TipoParametro))
                    {
                        NuevoEntorno.Declarar(NombreParametro, argumentos[i]);
                        continue;
                    }
                    else
                    {
                        throw new Exception($"Se esperaba el tipo '{TipoParametro}' en el parametro '{NombreParametro}' pero se recibió: '{Arreglo.Tipo}'");
                    }
                }

                if (!ObtenerTipo(argumentos[i]).Equals(TipoParametro))
                {
                    throw new Exception($"Se esperaba el tipo '{TipoParametro}' en el parametro '{NombreParametro}' pero se recibió: '{ObtenerTipo(argumentos[i])}'");
                }
                else
                {
                    NuevoEntorno.Declarar(NombreParametro, argumentos[i]);
                }
            }
        }
        
        try {

            foreach (var sentencia in context.declaraciones())
            {
                visitor.Visit(sentencia);
            }

        } catch (ExceptionReturn VarRetorno) {
                visitor.EntornoActual = EntornoDespuesDeLlamada;
                string TipoRetornado = ObtenerTipo(VarRetorno.Valor);

                if (VarRetorno.Valor is ValorArreglo Arreglo){
                    if (Arreglo.Tipo.Equals(TipoRetornoEsperado))
                    {
                        return VarRetorno.Valor;
                    }
                    else
                    {
                        throw new Exception($"Error de retorno: Se esperaba '{TipoRetornoEsperado}', pero se retornó '{Arreglo.Tipo}'.");
                    }
                }

                if (TipoRetornado != TipoRetornoEsperado)
                {
                    throw new Exception($"Error de retorno: Se esperaba '{TipoRetornoEsperado}', pero se retornó '{TipoRetornado}'.");
                }
                return VarRetorno.Valor;
        }
        visitor.EntornoActual = EntornoDespuesDeLlamada;
        return new ValorVoid();

    }

     private string ObtenerTipo(ValorWrapper valor)
    {
        return valor switch
        {
            ValorInt _ => "int",
            ValorFloat64 _ => "float64",
            ValorString _ => "string",
            ValorBoolean _ => "bool",
            ValorRune _ => "rune",
            ValorVoid _ => "void",
            ValorArreglo _ => "slice",
            _ => throw new ArgumentException("Tipo de valor no soportado")
        };
    }
}