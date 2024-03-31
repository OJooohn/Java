import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  static void NovoPedido(Scanner input, List<Pedido> pedidos, List<Pizza> pizzas){

    String sabor = "";
    boolean verificado = false;
    int i = 0;

    System.out.println("\n===========================\n");
    for(i = 0; i < pizzas.size(); i++){
      pizzas.get(i).listar();
    }

    while(verificado == false){

      System.out.print("Digite a pizza (sabor): ");
      sabor = input.nextLine();

      for(i = 0; i < pizzas.size(); i++){
        if(sabor.equals(pizzas.get(i).getNome())){
          verificado = true;
          break;
        } else {
          verificado = false;
        }
      }

      if(verificado == false)
        System.out.println(">> Sabor digitado nao listado no cardápio! Digite novamente...\n\n");
    }

    System.out.print("Digite o endereço de entrega: ");
    String endereco = input.nextLine();

    System.out.println(">> Pedido realizado com sucesso!\n\n");
    System.out.print("Pressiona qualquer tecla para continuar...");
    input.nextLine();
    pedidos.add(new Pedido(sabor, endereco, pizzas.get(i).getPreco()));

  }

  static void CancelarPedido(Scanner input, List<Pedido> pedidos){

    boolean verificado = false;
    int ID = 0, i = 0;

    if(pedidos.size() != 0){
      
      while(verificado == false){
        for(i = 0; i < pedidos.size(); i++){
          
        }
  
        System.out.print("Digite o ID do pedido (índice): ");
        ID = Integer.parseInt(input.nextLine());
  
        if(ID <= pedidos.size() && ID >= 1){
          verificado = true;
        }

        if(verificado == false){
          System.out.println(">> Nenhum pedido com este ID! Digite novamente...\n\n");
        }
       
      }

      System.out.println(">> Pedido cancelado!\n\n");
      System.out.print("Pressiona qualquer tecla para continuar...");
      input.nextLine();
      pedidos.get(i - 1).setStatus();

    } else {
      System.out.println(">> Nenhum pedido realizado! faça um pedido antes...\n\n");
      System.out.print("Pressiona qualquer tecla para continuar...");
      input.nextLine();
      return;
    }

  }

  static void LisarPedidos(Scanner input, List<Pedido> pedidos){
    if(pedidos.size() != 0){
      System.out.println("\n===========================\n");
      for(int i = 0; i < pedidos.size(); i++){
        pedidos.get(i).listar(i);
      }

    } else {
      System.out.println(">> Nenhum pedido feito! Antes realize um pedido...\n\n");
    }

    System.out.print("Pressiona qualquer tecla para continuar...");
    input.nextLine();
  }

  static void AdicionarSabor(Scanner input, List<Pizza> pizzas){

    boolean verificado = false;
    String nome = "";
    int i = 0;

    while(verificado == false){
      System.out.print("Digite o sabor da pizza: ");
      nome = input.nextLine();

      for(i = 0; i < pizzas.size(); i++){
        if(nome.equals(pizzas.get(i).getNome())){
          verificado = false;
          System.out.println("Sabor de pizza já está no cardápio! Digite novamente...\n\n");
          break;
        } else {
          verificado = true;
        }
      }

    }

    System.out.print("Digite o preço da pizza: ");
    float preco = Float.parseFloat(input.nextLine());

    System.out.print("Digite os igredientes: ");
    String igredientes = input.nextLine();

    System.out.println(">> Novo sabor adicionado ao cardápio!\n");
    System.out.print("Pressiona qualquer tecla para continuar...");
    input.nextLine();
    pizzas.add(new Pizza(nome, preco, igredientes));

  }

  static void Relatorio(Scanner input, List<Pedido> pedidos){

    float soma = 0;
    int i = 0;

    if(pedidos.size() != 0){

      for(i = 0; i < pedidos.size(); i++){
        soma += pedidos.get(i).getPreco();
      }
  
      float media = soma / pedidos.size();
  
      System.out.println("Relatório:\n");
      System.out.println(">> Total pedidos: " + pedidos.size());
      System.out.println(">> Média de preço: " + media);

    } else {
      System.out.println(">> Nenhum pedido realizado! Faça um pedido antes...\n\n");
    }

    System.out.print("Pressiona qualquer tecla para continuar...");
    input.nextLine();

  }
  
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    List<Pedido> pedidos = new ArrayList<Pedido>();
    List<Pizza> pizzas = new ArrayList<Pizza>();
    pizzas.add(new Pizza("Calabresa", 29.99f, "Molho de tomate, Queijo Muçarela, Calabresa"));
    pizzas.add(new Pizza("4 Queijos", 35.99f, "Molho de tomate, Queijo Muçarela, Provolone, Gorgonzola e Parmesão"));
    pizzas.add(new Pizza("Frango", 39.99f, "Queijo Muçarela, Molho de tomate e Frango desfiado"));

    String opcao = "";

    while(opcao.equals("6") == false){
      System.out.print("\033c");
      System.out.println("[1] Fazer pedido");
      System.out.println("[2] Cancelar pedido");
      System.out.println("[3] Listar pedidos");
      System.out.println("[4] Adicionar sabor");
      System.out.println("[5] Relatório pedidos");
      System.out.println("[6] Finalizar programa");
      System.out.print("Opcao: ");
      opcao = input.nextLine();

      switch(opcao){
        case "1":
        System.out.print("\033c");
        System.out.print(">> Novo Pedido");
        NovoPedido(input, pedidos, pizzas);
        break;
        
        case "2":
        System.out.print(">> Cancelar Pedido");
        System.out.print("\033c");
        CancelarPedido(input, pedidos);
        break;
        
        case "3":
        System.out.print(">> Listar Pedidos");
        System.out.print("\033c");
        LisarPedidos(input, pedidos);
        break;
        
        case "4":
        System.out.print(">> Adicionar Sabor");
        System.out.print("\033c");
        AdicionarSabor(input, pizzas);
        break;
        
        case "5":
        System.out.print("\033c");
        Relatorio(input, pedidos);
        break;

        case "6":
        opcao = "6";
        return;

        default: System.out.println(">> Opçao inválida! Digite novamente...\n\n");
      }
    }

    input.close();

  }

}
