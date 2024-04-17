import java.util.Random;
import java.util.Scanner;

public class Main {

  static int Rand(int min, int max){
    return min + (int)(Math.random() * ((max - min) + 1));
  }

  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    
    System.out.print(">> Digite a quantidade de linhas: ");
    int linhas = Integer.parseInt(input.nextLine());
    
    System.out.print(">> Digite a quantidade de colunas: ");
    int colunas = Integer.parseInt(input.nextLine());
    
    Tabuleiro tabulerio = new Tabuleiro(linhas, colunas);
    
    tabulerio.novoTabulero();
    tabulerio.imprimirTabuleiro();

    System.out.print(">> Digite a linha inicial do personagem: ");
    int x = Integer.parseInt(input.nextLine()) - 1;

    System.out.print(">> Digite a coluna inicial do personagem: ");
    int y = Integer.parseInt(input.nextLine()) - 1;

    tabulerio.setPersonagem(x, y);
    tabulerio.imprimirTabuleiro();

    int posX, posY;
    
    posX = Rand(0, linhas);
    posY = Rand(0, colunas);
    tabulerio.setInimigos(posX, posY);
    posX = Rand(0, linhas);
    posY = Rand(0, colunas);
    tabulerio.setInimigos(posX, posY);
    
    String opcao = "0";
    boolean menu = true;

    while(menu){

      System.out.println("\033c");
      tabulerio.imprimirTabuleiro();
      System.out.println("----------------------------");
      System.out.println("[W] Subir");
      System.out.println("[S] Descer");
      System.out.println("[A] Esquerda");
      System.out.println("[D] Direita");
      System.out.println("[5] Sair");
      System.out.print(">> Opcao: ");
      opcao = input.nextLine();
      opcao = opcao.toUpperCase();

      switch(opcao){
        
        case "W":
          tabulerio.moverPersonagem(1);
        break;
          
        case "S":
          tabulerio.moverPersonagem(2);
        break;
          
        case "A":
          tabulerio.moverPersonagem(3);
        break;
          
        case "D":
          tabulerio.moverPersonagem(4);
        break;

        case "5":
          System.out.println(">> Saindo...");
          menu = false;
        break;

        default:
          System.out.println(">> Opcao inválida! Digite novamente...\n\n");
          System.out.println(">> Aperta qualquer tecla...");
          input.nextLine();
        
      }

    }

    input.close();

  }

}
