public class Entorno
{

    public Dictionary<string, ValorWapper> Variable = new Dictionary<string, ValorWapper>();

    public ValorWapper GetVariable(string identificador)
    {
        if (Variable.ContainsKey(identificador))
        {
            return Variable[identificador];
        } else {
            throw new Exception("Variable: " + identificador + " No Encontrada");
        }
    }

    public void DeclracionVariable(string identificador, ValorWapper valor)
    {
        if (Variable.ContainsKey(identificador)){
            throw new Exception("Variable: " + identificador + " Ya Existe");
        } else {
            Variable.Add(identificador, valor);
        }
    }

    public ValorWapper AsignacionVariable (string identificador, ValorWapper valor)
    {
        if (Variable.ContainsKey(identificador)){
            Variable[identificador] = valor;
            return valor;
        } else {
            throw new Exception("Variable: " + identificador + " No Encontrada");
        }
    }
}