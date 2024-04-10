import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private int numero;
    private String pessoa;
    private String endereco;
    private List<Pizza> pizzas;

    Pedido(int numero, String pessoa, String endereco){
        this.setNumero(numero);
        this.setPessoa(pessoa);
        this.setEndereco(endereco);
        this.pizzas = new ArrayList<Pizza>();
    }

    void adicionarPizza(Pizza novaPizza){
        this.pizzas.add(novaPizza);
    }

    void verPedido(){
        System.out.println();
        System.out.println("+-------------------------");
        System.out.println("| Pedido Numero: " + this.getNumero());
        System.out.println("| Cliente: " + this.getPessoa());
        System.out.println("| Entregar em: " + this.getEndereco());
        System.out.println("| Pizzas no pedido: ");

        for (int i = 0; i < pizzas.size(); i++) {
            System.out.println("| >>  " + pizzas.get(i).getNome());
        }

        System.out.println("+-------------------------");

    }

    int quantidadeDePizzas(){
        return this.pizzas.size();
    }

    float valorPedido(){
        float soma = 0;

        for(int i = 0; i < this.pizzas.size(); i++){
            soma += this.pizzas.get(i).getValor();
        }

        return soma;
    }

    int getNumero(){
        return this.numero;
    }

    String getPessoa(){
        return this.pessoa;
    }

    String getEndereco(){
        return this.endereco;
    }

    List<Pizza> getPizzas(){
        return this.pizzas;
    }

    void setNumero(int numero){
        this.numero = numero;
    }

    void setPessoa(String pessoa){
        this.pessoa = pessoa;
    }

    void setEndereco(String endereco){
        this.endereco = endereco;
    }

    void setPizzas(List<Pizza> pizzas){
        this.pizzas = pizzas;
    }

}
