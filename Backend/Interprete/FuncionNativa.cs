using Analizador;

public class FuncionForanea : Invocable
{
    private Entorno Clousure;
    private LanguageParser.DeclaracionFuncionContext context;

    private string TipoRetornoEsperado;
    private string NombreFuncion;

    public FuncionForanea(Entorno clousure, LanguageParser.DeclaracionFuncionContext context)
    {
        Clousure = clousure;
        this.context = context;
        this.TipoRetornoEsperado = context.TIPO()?.GetText() ?? "void"; 
        this.NombreFuncion = context.IDENTIFICADOR().GetText();
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
            HashSet<string> ParametrosDeclarados = new HashSet<string>();
            for (int i = 0; i < context.parametros().IDENTIFICADOR().Length; i++)
            {
                string NombreParametro = context.parametros().IDENTIFICADOR(i).GetText();
                string TipoParametro = context.parametros().tipo_funcion(i).GetText();
                if (!ParametrosDeclarados.Add(NombreParametro))
                {
                    throw new Exception($"Error de declaración: El nombre del parámetro '{NombreParametro}' ya existe.");
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

                if (!ObtenerTipo(VarRetorno.Valor).Equals(TipoRetornoEsperado))
                {
                    throw new Exception($"Error de retorno: La función '{NombreFuncion}' esperaba '{TipoRetornoEsperado}', pero se retornó '{ObtenerTipo(VarRetorno.Valor)}'.");
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
            ValorSlice Arreglo => Arreglo.Tipo,
            ValorStruct Struct => Struct.NombreStruct,
            ValorVoid _ => "void",
            _ => throw new ArgumentException("Tipo de valor no soportado")
        };
    }
}