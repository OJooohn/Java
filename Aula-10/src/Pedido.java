import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private int numeroPedido;
    private String nomeCliente;
    private String enderecoCliente;
    private List<Pizza> pizzas;

    Pedido(int numeroPedido, String nomeCliente, String enderecoCliente) {
        this.numeroPedido = numeroPedido;
        this.nomeCliente = nomeCliente;
        this.enderecoCliente = enderecoCliente;
        this.pizzas = new ArrayList<Pizza>();
    }

    void adicionarPizza(Pizza pizza) {
        this.pizzas.add(pizza);
    }

    void verPedido() {
        System.out.println("+--------------------------------------");
        System.out.println("| Pedido N° " + this.numeroPedido);
        System.out.println("| >> Nome Cliente: " + this.nomeCliente);
        System.out.println("| >> Endereco: " + this.enderecoCliente);
        System.out.println("| >> Pizzas: ");

        for (int i = 0; i < this.pizzas.size(); i++) {
            Pizza pi = this.pizzas.get(i);
            System.out.println("| >>>>> [ R$" + pi.getValor() + " ] " + pi.getNome());
        }

        float soma = 0;
        for (int i = 0; i < this.pizzas.size(); i++) {
            soma += this.pizzas.get(i).getValor();
        }

        System.out.println("| Valor Total: [ R$ " + soma + " ] ");
        System.out.println("+--------------------------------------");
    }

    int getNumeroPedido() {
        return this.numeroPedido;
    }

    String getNomeCliente() {
        return this.nomeCliente;
    }

    float valorPedido() {
        float soma = 0;
        for (int i = 0; i < this.pizzas.size(); i++) {
            soma += this.pizzas.get(i).getValor();
        }
        return soma;
    }

    int quantidadePizzas() {
        return pizzas.size();
    }

}
