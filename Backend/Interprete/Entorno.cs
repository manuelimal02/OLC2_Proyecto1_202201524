public class Entorno
{

    public Dictionary<string, ValorWrapper> Simbolo = new Dictionary<string, ValorWrapper>();
    public Dictionary<string, Dictionary<string, string>> Struct = new();

    private Entorno? EntornoPadre;

    public Entorno(Entorno? EntornoPadre)
    {
        this.EntornoPadre = EntornoPadre;
    }


    public ValorWrapper Obtener(string identificador)
    {
        if (Simbolo.ContainsKey(identificador)){
            return Simbolo[identificador];
        }

        if (EntornoPadre != null){
            return EntornoPadre.Obtener(identificador);
        }
        throw new Exception("Simbolo: " + identificador + " No Encontrado");
      
    }

    public void Declarar(string identificador, ValorWrapper valor)
    {
        if (Simbolo.ContainsKey(identificador)){
            throw new Exception("Simbolo: " + identificador + " Ya Existe");
        } else {
            Simbolo.Add(identificador, valor);
        }
    }

    public ValorWrapper Asignar (string identificador, ValorWrapper valor)
    {
        if (Simbolo.ContainsKey(identificador)){
            Simbolo[identificador] = valor;
            return valor;
        } 
        if (EntornoPadre != null){
            return EntornoPadre.Asignar(identificador, valor);
        }
        throw new Exception("Simbolo: " + identificador + " No Encontrado.");
    }

    //Metodos Para Structs
    public void DeclararStruct(string nombre, Dictionary<string, string> atributos)
    {
        if (Struct.ContainsKey(nombre))
        {
            throw new Exception($"Error: El struct '{nombre}' ya está definido.");
        }
        Struct[nombre] = atributos;
    }


    public Dictionary<string, string> ObtenerStruct(string nombre)
    {
        if (Struct.ContainsKey(nombre))
        {
            return Struct[nombre];
        }
        if (EntornoPadre != null)
        {
            return EntornoPadre.ObtenerStruct(nombre);
        }
        throw new Exception($"Error: El struct '{nombre}' no está definido.");
    }

     public bool ExisteStruct(string nombre)
    {
        if (Struct.ContainsKey(nombre))
        {
            return true;
        }
        return EntornoPadre?.ExisteStruct(nombre) ?? false;
    }
}