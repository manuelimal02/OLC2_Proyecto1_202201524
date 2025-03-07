public interface Invocable
{
    int Aridad();
    ValorWrapper Invoke(List<ValorWrapper> argumentos, InterpreteVisitor visitor);
}