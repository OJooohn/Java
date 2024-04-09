import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int getInt(Scanner input, String texto){
        System.out.print(texto);
        String digitado = input.nextLine();

        return Integer.parseInt(digitado);
    }

    public static String getString(Scanner input, String texto){
        System.out.print(texto);
        String digitado = input.nextLine();

        return digitado;
    }

    public static void mostrarMenu(){
        System.out.println("\033c");
        System.out.println();
        System.out.println("+------- PIZZARIA MAIS LEGAL ------------------");
        System.out.println("+---------- MENU / OPÇÕES ---------------------");
        System.out.println("| [1] - Fazer um pedido");
        System.out.println("| [2] - Candelar um Pedido");
        System.out.println("| [3] - Mostrar Pedidos");
        System.out.println("| [4] - Ver Cardapio");
        System.out.println("| [5] - Sair");
        System.out.println("+----------------------------------------------");
        System.out.println();
    }

    public static void mostarCardapio(List<Pizza> cardapio){
        System.out.println("\033c");
        System.out.println("+------- PIZZARIA MAIS LEGAL ------------------");
        System.out.println("+------------ CARDAPIO ------------------------");

        for (int i = 0; i < cardapio.size(); i++) {
            String nomePizza = cardapio.get(i).getNome();
            float valorPizza = cardapio.get(i).getValor();
            System.out.println("| ( " + (i+1) +  " ) Valor: R$" + valorPizza + " Nome: " + nomePizza);
        }

        System.out.println("+----------------------------------------------");
        System.out.println();

    }

    public static void resumoPedidos(List<Pedido> pedidos){
        System.out.println("\033c");
        System.out.println("+----------------------------------------------");
        System.out.println("| Resumo dos pedidos: ");

        for (int i = 0; i < pedidos.size(); i++) {
            int noPedido = pedidos.get(i).getNumero();
            String nomePessoa = pedidos.get(i).getPessoa();
            float valor = pedidos.get(i).valorPedido();
            int qtd = pedidos.get(i).quantidadeDePizzas();

            System.out.println("| > Pedido N° " + noPedido + " - Pessoa: " + nomePessoa + " - Qtd Pizzas: " + qtd + " - Total: " + valor);

        }

        System.out.println();

    }

    public static int IndiceParaRemover(List<Pedido> pedidos, int numDigitado){
        int i = 0;

        for(i = 0; i < pedidos.size(); i++){
            if(numDigitado == pedidos.get(i).getNumero())
                return i;
        }

        return -1;
    }

    public static void balancoDoDia(List<Pedido> pedidos){

        float soma = 0;

        for(int i = 0; i < pedidos.size(); i++){
            float valor = pedidos.get(i).valorPedido();
            soma += valor;
        }

        int qtdPedidos = pedidos.size();
        float media = soma / qtdPedidos;

        System.out.println("| > Balanco do Dia: ");
        System.out.println("| >> Total Pedidos [ " + qtdPedidos + " ] - Valor Médio [ R$" + media + " ] - Ganhos do dia [ R$" + soma + " ]");
        System.out.println("| ");
        System.out.println("+----------------------------------------------");
        System.out.println();

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean menu = true;
        
        List<Pedido> pedidos = new ArrayList<Pedido>();
        List<Pizza> cardapio = new ArrayList<Pizza>();
        cardapio.add(new Pizza("Muzzarela", 19.9f, "Queijo Muzzarela"));
        cardapio.add(new Pizza("4 Queijos", 29.9f, "Queijo 1, Queijo 2, Queijo 3 e Muzzarela"));
        cardapio.add(new Pizza("Frango com Catup", 19.9f, "Frango e Queijo 2"));
        // Criando as listas para pedidos e o cardápio, e adicionando pizzas ja pré-definidas

        while(menu){

            mostrarMenu(); // Mostrar menu principal
            
            // getInt() -> irá retornar um valor inteiro digitado
            int op = getInt(input, ">> Digite uma opçao: ");

            switch(op){
                case 1:
                // getString() -> irá retornar a String digitada
                    String nome = getString(input, ">> Digite seu nome: ");
                    String endereco = getString(input, ">> Digite o endereço: ");
                
                    int numPedido = pedidos.size();
                    Pedido novoPedido = new Pedido(numPedido, nome, endereco);
                    // novoPedido -> fará um novo pedido e a variável será usada para concluir o restante do pedido

                    int qtdPizzas = getInt(input, ">> Digite a quantidade de pizzas: ");

                    // ao digitar a qtd de pizzas desejada, entrará no loop para digitar o número da pizza -> chamando na variável novoPedido e adicionando então as pizzas
                    for(int i = 0; i < qtdPizzas; i++){
                        int numeroPizza = getInt(input, "Qual pizza voce quer? ") - 1;
                        novoPedido.adicionarPizza(cardapio.get(numeroPizza));
                    }

                    // vai mostrar o resumo do pedido na classe Pedido, verificando o nome, endereço, e as pizzas escolhidas
                    novoPedido.verPedido();
                    // adicionando então o pedido no ArrayList
                    pedidos.add(novoPedido);

                    System.out.println("Aperte qualquer tecla para continuar...\n");
                    input.nextLine();
                break;

                case 2:
                    resumoPedidos(pedidos);

                    int noPedido = getInt(input, "Qual pedido voce quer cancelar? ");
                    noPedido = IndiceParaRemover(pedidos, noPedido); // Vai passar por uma verificação -> se o pedido foi realizado

                    // caso o pedido não foi realizado irá verificar neste if
                    if(noPedido == -1)
                        System.out.println(">> Pedido inválido!\n");
                    else
                        pedidos.remove(noPedido);

                    System.out.println("Aperte qualquer tecla para continuar...\n");
                    input.nextLine();
                    
                break;

                case 3:
                    resumoPedidos(pedidos);
                    balancoDoDia(pedidos);

                break;

                case 4: 
                    mostarCardapio(cardapio);
                    System.out.println("Aperte qualquer tecla para continuar...\n");
                    input.nextLine();
                break;

                case 5: menu = false;
                break;

                default: 
                    System.out.println(">> Opçao inválida! Digite novamente...\n\n");
                    System.out.println("Aperte qualquer tecla para continuar...\n");
                    input.nextLine();
                break;
            }

        }

        input.close();

    }

    
}