import java.util.ArrayList;
import java.util.List;

public interface ListaTarefas {

    public void adicionar(List<Tarefa> tarefas);
    public void remover(List<Tarefa> tarefas);
    public void concluir(List<Tarefa> tarefas);
    public void listarTodos(List<Tarefa> tarefas);
    public void listarPorCategoria(List<Tarefa> tarefas);

}
