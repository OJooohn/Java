import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  static void adicionarProduto(List<Produto> produtos, Scanner input){

    System.out.println("\n>> Adicionar Produto\n");
    boolean verificado = false;
    String nomeProduto = "", codigo = "";
    int i = 0, quantidade = 0;
    float preco = 0;

    while(verificado == false){
      System.out.print("Informe o nome do produto: ");
      nomeProduto = input.nextLine();

      if(produtos.size() != 0){
        for(i = 0; i < produtos.size(); i++){
          if(nomeProduto.equals(produtos.get(i).getNomeProduto())){
            verificado = false;
            break;
          } else {
            verificado = true;
          }
        }
      } else {
        verificado = true;
      }

      if(verificado == false){
        System.out.println("\n>> Nome de produto já registrado! Digite novamente...\n");
      }
    }
    verificado = false;

    while(verificado == false){
      System.out.print("Informe o código do produto: ");
      codigo = input.nextLine();

      if(produtos.size() != 0){
        for(i = 0; i < produtos.size(); i++){
          if(codigo.equals(produtos.get(i).getCodigo())){
            verificado = false;
            break;
          } else {
            verificado = true;
          }
        }
      } else {
        verificado = true;
      }

      if(verificado == false){
        System.out.println("\n>> Código de produto já registrado! Digite novamente...\n");
      }
    }

    verificado = false;
    while(verificado == false){
      quantidade = 1;
      System.out.print("Informe a quantidade de produtos em estoque: ");
      quantidade = Integer.parseInt(input.nextLine());
      
      if(quantidade >= 0){
        verificado = true;
      } else {
        verificado = false;
        System.out.println("\n>> Nao é possível ter uma quantidade negativa de produtos! Digite novamente...\n");
      }
    }

    verificado = false;
    while(verificado == false){
      System.out.print("Informe o preço do produto: ");
      preco = Float.parseFloat(input.nextLine());
      
      if(preco > 0){
        verificado = true;
      } else {
        verificado = false;
        System.out.println("\n>> Nao é possível ter preço com valor negativo! Digite novamente...\n");
      }
    }
    
    produtos.add(new Produto(nomeProduto, codigo, quantidade, preco));

  }

  static void removerProduto(List<Produto> produtos, Scanner input){
    System.out.println("\n>> Remover Produto\n");
    boolean menu = true;

    while(menu){
      System.out.println("[0] Menu principal");
      System.out.println("[1] Selecionar por nome");
      System.out.println("[2] Selecionar por código");
      System.out.print(">> Opçao: ");
      String opcao = input.nextLine();

      switch(opcao){
        case "0": return;

        case "1": removerPorNome(produtos, input);
        menu = false;
        break;

        case "2": removerPorCodigo(produtos, input);
        menu = false;
        break;
        
        default: System.out.println("\n>> Opçao inválida! Digite novamente...\n");
        break;
      }
    }
  }

  static void removerPorNome(List<Produto> produtos, Scanner input){

    System.out.println("\n>> Remover por nome");
    boolean verificado = false;
    String nome = "";
    int i = 0;

    while(verificado == false){
      System.out.print("Informe o nome do produto: ");
      nome = input.nextLine();

      if(produtos.size() != 0){
        for(i = 0; i < produtos.size(); i++){
          if(nome.equals(produtos.get(i).getNomeProduto())){
            verificado = true;
            break;
          } else {
            verificado = false;
          }
        }
      }

      if(verificado == false)
        System.out.println("\n>> Nome nao registrado no estoque! Digite novamente...\n");


      System.out.println("\nNome: " + produtos.get(i).getNomeProduto());
      System.out.println("\nCódigo: " + produtos.get(i).getCodigo());
      System.out.println("\nQuantidade em estoque: " + produtos.get(i).getQuantidade());
      System.out.println("\nPreço: " + produtos.get(i).getPreco());
      System.out.print(">> Deseja exlcuir o produto? (S/N): ");
      String opcao = input.nextLine();
      opcao.toLowerCase();

      if(opcao.equals("s")){
        produtos.remove(i);
        System.out.println("\n>> Produto excluído com sucesso!\n\n");
      } else {
        System.out.println("\nExclusão cancelada!\n");
      }
      
    }

  }

  static void removerPorCodigo(List<Produto> produtos, Scanner input){
    System.out.println("\n>> Remover por nome");
    boolean verificado = false;
    String codigo = "";
    int i = 0;

    while(verificado == false){
      System.out.print("Informe o nome do produto: ");
      codigo = input.nextLine();

      if(produtos.size() != 0){
        for(i = 0; i < produtos.size(); i++){
          if(codigo.equals(produtos.get(i).getCodigo())){
            verificado = true;
            break;
          } else {
            verificado = false;
          }
        }
      }

    if(verificado == false)
      System.out.println("\n>> Código nao registrado no estoque! Digite novamente...\n");

      System.out.println("\nNome: " + produtos.get(i).getNomeProduto());
      System.out.println("Código: " + produtos.get(i).getCodigo());
      System.out.println("Quantidade em estoque: " + produtos.get(i).getQuantidade());
      System.out.println("Preço: " + produtos.get(i).getPreco());
      System.out.print(">> Deseja exlcuir o produto? (S/N): ");
      String opcao = input.nextLine();
      opcao.toLowerCase();

      if(opcao.equals("s")){
        produtos.remove(i);
        System.out.println("\n>> Produto excluído com sucesso!\n\n");
      } else {
        System.out.println("\nExclusão cancelada!\n");
      }
      
      
    }
  }

  static void atualizarProduto(List<Produto> produtos, Scanner input){

    System.out.println("\n>> Atualizar Produto\n");
    boolean menu = true;

    while(menu){
      System.out.println("[0] Menu principal");
      System.out.println("[1] Selecionar por nome");
      System.out.println("[2] Selecionar por código");
      System.out.print(">> Opçao: ");
      String opcao = input.nextLine();

      switch(opcao){
        case "0": return;

        case "1": atualizarPorNome(produtos, input);
        menu = false;
        break;

        case "2": atualizarPorCodigo(produtos, input);
        menu = false;
        break;

        default: System.out.println("\n>> Opçao inválida! Digite novamente...\n");
        break;
      }
    }

  }

  static void atualizarPorNome(List<Produto> produtos, Scanner input){

    System.out.println("\n>> Atualizar por nome");
    boolean verificado = false;
    String nome = "";
    int i = 0;

    while(verificado == false){
      System.out.print("Informe o nome do produto: ");
      nome = input.nextLine();

      if(produtos.size() != 0){
        for(i = 0; i < produtos.size(); i++){
          if(nome.equals(produtos.get(i).getNomeProduto())){
            verificado = true;
            break;
          } else {
            verificado = false;
          }
        }
      }

      if(verificado == false)
        System.out.println("\n>> Nome nao registrado no estoque! Digite novamente...\n");
      else
        atualizarMenu(produtos, input, i);
    } 

  }

  static void atualizarPorCodigo(List<Produto> produtos, Scanner input){

    System.out.println("\n>> Atualizar por código");
    boolean verificado = false;
    String codigo = "";
    int i = 0;

    while(verificado == false){
      System.out.print("Informe o código do produto: ");
      codigo = input.nextLine();

      if(produtos.size() != 0){
        for(i = 0; i < produtos.size(); i++){
          if(codigo.equals(produtos.get(i).getCodigo())){
            verificado = true;
            break;
          } else {
            verificado = false;
          }
        }
      }

      if(verificado == false)
        System.out.println("\n>> Código nao registrado no estoque! Digite novamente...\n");
      else
        atualizarMenu(produtos, input, i);
    } 

  }

  static void atualizarMenu(List<Produto> produtos, Scanner input, int i){

    System.out.println("\n>> Atualizar produto | " + produtos.get(i).getNomeProduto());
    boolean menu = true, verificado;
    float preco = 0;
    int quantidade = 0;

    while(menu){
      verificado = false;
      System.out.println("[1] Atualizar quantidade");
      System.out.println("[2] Atualizar preço");
      System.out.print(">> Opçao: ");
      String opcao = input.nextLine();

      switch(opcao){

        case "1":
        while(verificado == false){
          System.out.print("Informe a nova quantidade de produtos em estoque: ");
          quantidade = Integer.parseInt(input.nextLine());
          
          if(quantidade >= 0){
            verificado = true;
          } else {
            verificado = false;
            System.out.println("\n>> Nao é possível ter uma quantidade negativa de produtos! Digite novamente...\n");
          }
        }
        produtos.get(i).atualizarQuantidade(quantidade);
        menu = false;
        break;

        case "2":
        while(verificado == false){
          System.out.print("Informe o novo preço do produto: ");
          preco = Float.parseFloat(input.nextLine());

          if(preco > 0){
            verificado = true;
          } else {
            verificado = false;
            System.out.println("\n>> Nao é possível ter preço com valor negativo! Digite novamente...\n");
          }
        }

        produtos.get(i).atualizarPreco(preco);
        menu = false;
        break;

        default: System.out.println("\n>> Opçao inválida! Digite novamente...\n");
        break;
      }
    }

    return;

  }
  
  static void listarProdutos(List<Produto> produtos, Scanner input){
    System.out.println("\n\n>> Produtos Listados");
    System.err.println("\n=============================\n");
    for(int i = 0; i < produtos.size(); i++){
      produtos.get(i).listar();
    }
  }
  
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    List<Produto> produtos = new ArrayList<Produto>();
    boolean menu = true;
    
    while(menu){
      System.err.println("\n\n[0] Finalizar Programa");
      System.err.println("[1] Adicionar Produto");
      System.err.println("[2] Remover Produto");
      System.err.println("[3] Atualizar Produto");
      System.err.println("[4] Listar Produtos");
      System.out.print(">> Opçao: ");
      String opcao = input.nextLine();

      switch(opcao){
        case "0": menu = false;
        break;

        case "1": adicionarProduto(produtos, input);
        break;

        case "2": removerProduto(produtos, input);
        break;

        case "3": atualizarProduto(produtos, input);
        break;

        case "4": listarProdutos(produtos, input);
        break;

        default: System.out.println("\n>> Opçao inválida! Digite novamente...\n");
        break;
      }
    }

    input.close();

  }

}
