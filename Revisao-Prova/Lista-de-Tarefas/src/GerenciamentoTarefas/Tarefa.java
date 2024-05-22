package GerenciamentoTarefas;

public class Tarefa {

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

    public String imprimirStatus(){
        if(this.getConcluido())
            return "concluído";
        else
            return "não concluído";
    }

    @Override
    public String toString() {
        return
        "\nCategoria: " + categoria +
        "\nDescrição: " + descricao +
        "\nStatus: " + imprimirStatus();
    }
}
