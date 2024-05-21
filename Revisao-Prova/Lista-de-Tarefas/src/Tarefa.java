public class Tarefa implements ListaTarefas{

    private String descricao;
    private boolean concluido;
    private CategoriaTarefa categoria;

    Tarefa(String descricao, CategoriaTarefa categoria){
        this.descricao = descricao;
        this.concluido = false;
        this.categoria = categoria;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public boolean getConcluido(){
        return this.concluido;
    }

    public CategoriaTarefa getCategoria(){
        return this.categoria;
    }

    @Override
    public void adicionar() {

    }

    @Override
    public void remover() {

    }

    @Override
    public void concluir() {

    }

    @Override
    public void listarTodos() {

    }

    @Override
    public void listarPorCategoria() {

    }
}
