package GerenciamentoTarefas;

public class CategoriaTarefa {

    private String categoria;

    public CategoriaTarefa(String categoria) {
        this.categoria = categoria;
    }

    public String getNomeCategoria(){
        return this.categoria;
    }

    @Override
    public String toString() {
        return this.getNomeCategoria();
    }
}
