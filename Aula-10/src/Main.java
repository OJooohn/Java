import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void mostrarCardapio(List<Pizza> cardapio) {
        System.out.println("+--------------------------------------");
        System.out.println("+-------- PIZZARIA FELIZ ---------------");
        System.out.println("+----------- CARDAPIO ------------------");

        for (int i = 0; i < cardapio.size(); i++) {
            // cardapio.get(i).verPizza();
            System.out.println("| ( " + (i + 1) + " ) Valor: [ R$" + cardapio.get(i).getValor() + " ] Nome: "
                    + cardapio.get(i).getNome());

        }

        System.out.println("+--------------------------------------");
    }

    public static void balancoEPedidos(List<Pedido> pedidos) {
        System.out.println("| > Pedidos: ");

        int qtdPizzas = 0;
        float somaValorPedidos = 0;
        int qtdPedidos = pedidos.size();

        for (int i = 0; i < qtdPedidos; i++) {
            Pedido umPedido = pedidos.get(i);

            qtdPizzas += umPedido.quantidadePizzas();
            somaValorPedidos += umPedido.valorPedido();

            System.out.println("| >> [N° " + umPedido.getNumeroPedido() + "]  - R$ " + umPedido.valorPedido() + " - "
                    + umPedido.getNomeCliente());
        }

        float mediaValor = somaValorPedidos / qtdPedidos;

        System.out.println("| > Qtd de Pedidos [ " + qtdPedidos + " ] - Qtd Pizzas [ " + qtdPizzas + " ]");
        System.out.println("| > Faturamento [ R$" + somaValorPedidos + " ] - Valor Médio [ " + mediaValor + " ]");
    }

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        List<Pizza> cardapio = new ArrayList<Pizza>();
        List<Pedido> pedidos = new ArrayList<Pedido>();

        cardapio.add(new Pizza("Muzzarela", 19.9f, "| Queijo |"));
        cardapio.add(new Pizza("4 Quejos", 29.9f, "| Queijo 1 | Queijo 2 | Queijo 3 | Queijo 4 |"));
        cardapio.add(new Pizza("Calabresa", 22.9f, "| Queijo | Calabresa |"));
        cardapio.add(new Pizza("Mexicana", 22.9f, "| Bacon | Calabresa | Pimenta | Pimentão |"));
        cardapio.add(new Pizza("Chocolate", 34.9f, "| Chocolate |"));

        System.out.println();

        while (true) {

            System.out.println();
            System.out.println("+--------------------------------------");
            System.out.println("+-------- PIZZARIA FELIZ ---------------");
            System.out.println("| [1] - Ver Cardapio ");
            System.out.println("| [2] - Fazer um Pedido ");
            System.out.println("| [3] - Cancelar um Pedido ");
            System.out.println("| [4] - Balanço do Caixa ");
            System.out.println("+--------------------------------------");
            System.out.println();

            System.out.print("| > Escolha uma opção: ");
            int op = Integer.parseInt(leitor.nextLine());

            switch (op) {

                case 1:
                    mostrarCardapio(cardapio);
                    break;

                case 2:
                    System.out.println("+--------------------------------------");
                    System.out.println("+---------- NOVO PEDIDO ---------------");

                    // nome
                    System.out.print("| > Digite seu nome: ");
                    String nome = leitor.nextLine();

                    // endereco
                    System.out.print("| > Digite seu endereço: ");
                    String endereco = leitor.nextLine();

                    Pedido novoPedido = new Pedido(pedidos.size(), nome, endereco);

                    // pizzas
                    System.out.print("| > Quantas pizzas voce quer? ");
                    int qtsPizzas = Integer.parseInt(leitor.nextLine());

                    mostrarCardapio(cardapio);

                    for (int i = 0; i < qtsPizzas; i++) {
                        System.out.print("| > Escolha a pizza: ");
                        int numPizza = Integer.parseInt(leitor.nextLine());
                        novoPedido.adicionarPizza(cardapio.get(numPizza));
                    }

                    // adicionar ele em algum lugar
                    pedidos.add(novoPedido);
                    System.out.println("+---------- PEDIDO FINALIZADO ---------");
                    System.out.println("+--------------------------------------");

                    break;

                case 3:
                    System.out.println("+--------------------------------------");
                    System.out.println("+------- REMOVER PEDIDO ---------------");

                    for (int i = 0; i < pedidos.size(); i++) {
                        Pedido umPedido = pedidos.get(i);
                        System.out.println("| >> [N° " + umPedido.getNumeroPedido() + "]  - R$ "
                                + umPedido.valorPedido() + " - " + umPedido.getNomeCliente());
                    }

                    System.out.print("| > Qual pedido quer remover? ");
                    int nPedido = Integer.parseInt(leitor.nextLine());

                    for (int i = 0; i < pedidos.size(); i++) {

                        if (nPedido == pedidos.get(i).getNumeroPedido()) {
                            pedidos.remove(i);
                            break;
                        }

                    }

                    System.out.println(" ~ pedido não encontrado ~ ");

                    break;

                case 4:
                    System.out.println("+--------------------------------------");
                    System.out.println("+---------- CAIXA E PEDIDOS ---------");
                    balancoEPedidos(pedidos);
                    System.out.println("+--------------------------------------");
                    break;

                default:
                    System.out.println(" ~ opção inválida ~ ");
                    break;

            }

            System.out.print(" ~ enter para voltar ao menu ~ ");
            leitor.nextLine();

        }

        // Pedido pedido = new Pedido(1, "João", "Positivo");
        // pedido.adicionarPizza(cardapio.get(2));
        // pedido.verPedido();

    }

}