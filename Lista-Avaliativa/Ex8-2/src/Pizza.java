public class Pizza {

    private String nome;
    private float valor;
    private String ingredientes; // "Queijo | Tomate | Presunto"

    // String[] ingredientes;
    // List<String> ingredientes = new ArrayList<>(); // ["Queijo", "Tomate","Presunto"]

    Pizza(String nome, float valor, String ingredientes){
        this.setNome(nome);
        this.setValor(valor);
        this.setIngredientes(ingredientes);
    }

    String getNome(){
     return this.nome;   
    }

    float getValor(){
        return this.valor;
    }

    String getIngredientes(){
        return this.ingredientes;
    }

    void setNome(String nome){
        this.nome = nome;
    }

    void setValor(float valor){
        this.valor = valor;
    }

    void setIngredientes(String ingredientes){
        this.ingredientes = ingredientes;
    }

}
