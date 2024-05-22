package GerenciamentoTarefas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {

    private List<Tarefa> tarefas;

    public ListaTarefas(){
        this.tarefas = new ArrayList<>();
    }

    public void adicionar(Tarefa tarefa){
        this.tarefas.add(tarefa);
    }

    public void remover(Tarefa tarefa){
        this.tarefas.remove(tarefa);
    }

    public void listarTodas(){
        for(Tarefa t : tarefas){
            System.out.println(t);
        }
    }

    public void listarPorCategoria(CategoriaTarefa categoria){
        for(Tarefa t : tarefas){
            if(t.getCategoria() == categoria){
                System.out.println(t);
            }
        }
    }

}
