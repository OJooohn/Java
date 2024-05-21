import java.util.ArrayList;
import java.util.List;

public class Main implements ListaTarefas{

    public static void main(String[] args) {

        List<CategoriaTarefa> categorias = new ArrayList<CategoriaTarefa>();
        categorias.add(new CategoriaTarefa("trabalho"));
        categorias.add(new CategoriaTarefa("estudo"));
        categorias.add(new CategoriaTarefa("pessoal"));

        List<Tarefa> tarefas = new ArrayList<>();
        tarefas.add(new Tarefa("Descrição", categorias.get(0)));


        System.out.println("Hello world!");
    }

    @Override
    public void adicionar(List<Tarefa> tarefas) {
        tarefas.add(new Tarefa());
    }

    @Override
    public void remover(List<Tarefa> tarefas) {

    }

    @Override
    public void concluir(List<Tarefa> tarefas) {

    }

    @Override
    public void listarTodos(List<Tarefa> tarefas) {

    }

    @Override
    public void listarPorCategoria(List<Tarefa> tarefas) {

    }
}