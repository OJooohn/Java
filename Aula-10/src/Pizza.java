public class Pizza {

    private String nome;
    private float valor;

    private String ingredientes; // Queijo | Presunto | Molho
    // String[] aingredientes; // ["Queijo", "Presunto", "Molho"]

    Pizza(String nome, float valor, String ingredientes) {
        this.nome = nome;
        this.valor = valor;
        this.ingredientes = ingredientes;
    }

    void verPizza() {
        System.out.println("| >>  Nome: " + nome + " - Valor R$" + valor + " - Ingredientes: " + ingredientes);
    }

    String getNome() {
        return this.nome;
    }

    float getValor() {
        return this.valor;
    }

    String getIngredientes() {
        return this.ingredientes;
    }

}