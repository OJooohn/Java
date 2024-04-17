import java.util.Random;
import java.util.Scanner;

public class Main {

  public static final String RED = "\033[0;31m";
  public static final String GREEN = "\033[0;32m";
  public static final String WHITE = "\033[0;37m";

  static void imprimirSeparador(Tabuleiro tabuleiro){
    for(int i = 0; i <= tabuleiro.getColuna(); i++){
      System.out.print("-----");
    }
    System.out.println("----");
  }
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    Random rn = new Random();
    int posX, posY;
    boolean setPers = false;
    
    System.out.print(">> Digite a quantidade de linhas: ");
    int linhas = Integer.parseInt(input.nextLine());
    
    System.out.print(">> Digite a quantidade de colunas: ");
    int colunas = Integer.parseInt(input.nextLine());
    
    Tabuleiro tabulerio = new Tabuleiro(linhas, colunas);
    
    tabulerio.novoTabulero();

    // Aliado
    posX = rn.nextInt(linhas);
    posY = rn.nextInt(colunas);
    tabulerio.setPersonagem(posX, posY);

    // Primeiro inimigo
    setPers = false;
    while(!setPers){
      posX = rn.nextInt(linhas);
      posY = rn.nextInt(colunas);
      //System.out.println("Rand = " + posX + " | " + posY + " | " + tabulerio.getMatriz(posX, posY));
      if(tabulerio.getMatriz(posX, posY) == '.'){
        setPers = true;
        tabulerio.setInimigos(posX, posY);
        break;
      }
      
    }
    
    // Segundo inimigo
    setPers = false;
    while(!setPers){
      posX = rn.nextInt(linhas);
      posY = rn.nextInt(colunas);
      //System.out.println("Rand2 = " + posX + " | " + posY + " | " + tabulerio.getMatriz(posX, posY));
      if(tabulerio.getMatriz(posX, posY) == '.'){
        setPers = true;
        tabulerio.setInimigos(posX, posY);
        break;
      }
      
    }
    tabulerio.imprimirTabuleiro();

    String opcao = "0";
    boolean menu = true;
    int personagem, jogo;

    while(menu){

      jogo = tabulerio.statusJogo();

      if(jogo == 2){
        System.out.println("\033c");
        imprimirSeparador(tabulerio);
        tabulerio.imprimirTabuleiro();
        imprimirSeparador(tabulerio);
        System.out.println("|");
        System.out.println("| Voce " + RED + "perdeu " + WHITE + "o jogo!");
        System.out.println("|");
        imprimirSeparador(tabulerio);
        break;
      }
      
      if(jogo == 1){
        System.out.println("\033c");
        imprimirSeparador(tabulerio);
        tabulerio.imprimirTabuleiro();
        imprimirSeparador(tabulerio);
        System.out.println("|");
        System.out.println("| Voce " + GREEN + "ganhou " + WHITE + "o jogo!");
        System.out.println("|");
        imprimirSeparador(tabulerio);
        break;
      }

      System.out.println("\033c");
      System.out.println("| Selecione o personagem: ");
      System.out.println("| Legenda: [linha][coluna]");
      tabulerio.imprimirPersonagens();
      imprimirSeparador(tabulerio);
      tabulerio.imprimirTabuleiro();
      imprimirSeparador(tabulerio);
      System.out.println("| Selecione o movimento: ");
      System.out.println("| [W] Subir");
      System.out.println("| [A] Esquerda");
      System.out.println("| [S] Descer");
      System.out.println("| [D] Direita");
      System.out.println("| [5] Sair");
      System.out.print(">> Selecione o personagem: ");
      personagem = Integer.parseInt(input.nextLine()) - 1;
      System.out.print(">> Selecione o movimento: ");
      opcao = input.nextLine();
      opcao = opcao.toUpperCase();

      switch(opcao){
        
        case "W":
          tabulerio.moverPersonagem(1, personagem, input);
        break;
          
        case "S":
          tabulerio.moverPersonagem(2, personagem, input);
        break;
          
        case "A":
          tabulerio.moverPersonagem(3, personagem, input);
        break;
          
        case "D":
          tabulerio.moverPersonagem(4, personagem, input);
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
