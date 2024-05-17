public interface OperacoesAgenda {
    
    public void adicionar(int tipo, String nome, String numero, String email, String dataNascimento);
    public void remover(int indice);
    public void listar(boolean listarTodos, int indice);
    public int buscar(String numero);

}
