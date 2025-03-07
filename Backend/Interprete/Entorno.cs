public class Entorno
{

    public Dictionary<string, ValorWrapper> Variable = new Dictionary<string, ValorWrapper>();

    private Entorno? EntornoPadre;

    public Entorno(Entorno? EntornoPadre)
    {
        this.EntornoPadre = EntornoPadre;
    }


    public ValorWrapper Obtener(string identificador)
    {
        if (Variable.ContainsKey(identificador)){
            return Variable[identificador];
        }

        if (EntornoPadre != null){
            return EntornoPadre.Obtener(identificador);
        }
        throw new Exception("Variable: " + identificador + " No Encontrada");
      
    }

    public void Declarar(string identificador, ValorWrapper valor)
    {
        if (Variable.ContainsKey(identificador)){
            throw new Exception("Variable: " + identificador + " Ya Existe");
        } else {
            Variable.Add(identificador, valor);
        }
    }

    public ValorWrapper Asignar (string identificador, ValorWrapper valor)
    {
        if (Variable.ContainsKey(identificador)){
            Variable[identificador] = valor;
            return valor;
        } 
        if (EntornoPadre != null){
            return EntornoPadre.Asignar(identificador, valor);
        }
        throw new Exception("Variable: " + identificador + " No Encontrada");
    }
}