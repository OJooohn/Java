import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  
  static void cadastro(List<Jogador> jogadores, Scanner input){
    
    System.out.print(">> Digite o nome: ");
    String nome = input.nextLine();

    System.out.print(">> Digite a pontuaçao: ");
    int pontuacao = Integer.parseInt(input.nextLine());

    System.out.print(">> Digite o nivel: ");
    int nivel = Integer.parseInt(input.nextLine());

    jogadores.add(new Jogador(nome, pontuacao, nivel));

  }

  static void atualizar(List<Jogador> jogadores, Scanner input){

    int i = 0;
    boolean verificado = false;

    while(verificado == false){

      System.out.print(">> Informe o nome do jogador a ser atualizado: ");
      String nome = input.nextLine();
  
      for(i = 0; i < jogadores.size(); i++){
        if(nome.equals(jogadores.get(i).getNome())){
          verificado = true;
          break;
        }
      }

      if(verificado == false)
        System.out.println(">> Nenhum jogador encontrado! Digite outro nome...\n\n");

    }

    System.out.println("\n");
    System.out.println("[1] Atualizar pontuacao");
    System.out.println("[2] Atualizar nivel");
    System.out.print("Opcao: ");
    String opcao = input.nextLine();

    switch(opcao){
      case "1": 
      System.out.print(">> Informe a nova pontuaçao do jogador: ");
      int pontuacao = Integer.parseInt(input.nextLine());
      jogadores.get(i).atualizarPontuacao(pontuacao);
      break;

      case "2":
      System.out.print(">> Informe o novo nivel do jogador: ");
      int nivel = Integer.parseInt(input.nextLine());
      jogadores.get(i).atualizarNivel(nivel);
      break;
    }
  }

  static void listar(List<Jogador> jogadores){
    System.out.println("\n\n>> Jogadores listados\n");
    for(int i = 0; i < jogadores.size(); i++){
      jogadores.get(i).listar();
    }
  }

  public static void main(String[] args) {

    List<Jogador> jogadores = new ArrayList<Jogador>();
    
    Scanner input = new Scanner(System.in);
    boolean menu = true;

    while(menu){
      String opcao;
      System.out.println("\n\n");
      System.out.println("[0] Finalizar Programa");
      System.out.println("[1] Adicionar jogador");
      System.out.println("[2] Atualizar jogador");
      System.out.println("[3] Listar jogador");
      System.out.print(">> Opcao: ");
      opcao = input.nextLine();

      switch(opcao){
        case "0": menu = false;
        break;

        case "1": cadastro(jogadores, input);
        break;

        case "2": atualizar(jogadores, input);
        break;

        case "3": listar(jogadores);
        break;
      }
    }

  }

}
