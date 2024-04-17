import java.text.DecimalFormat;
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

    int posX, posY, quantInimigos = 0, dificuldade = 0;
    boolean setPers = false, menu = true;
    
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

    while(dificuldade < 1){
      System.out.println("\033c");
      System.out.println("| Selecione a dificuldade: ");
      System.out.println("| [1] Muito fácil");
      System.out.println("| [2] Fácil");
      System.out.println("| [3] Médio");
      System.out.println("| [4] Difícil");
      System.out.println("| [5] Muito Difícil");
      System.out.println("| [6] " + RED + "HARDCORE" + WHITE);
      System.out.print("| >> Selecione a dificuldade: ");
      dificuldade = Integer.parseInt(input.nextLine());

      switch(dificuldade){
        case 1: quantInimigos = 1;
        break;

        case 2: quantInimigos = 2;
        break;

        case 3: quantInimigos = 4;
        break;

        case 4: quantInimigos = 6;
        break;

        case 5: quantInimigos = 7;
        break;

        case 6: quantInimigos = 10;
        break;

        default:
          System.out.println("| >> Opcao inválida! Digite novamente...\n\n");
          System.out.println(">> Aperta qualquer tecla para continuar...");
          input.nextLine();
        break;
      }
    }

    for(int i = 0; i < quantInimigos; i++){
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
    }
    tabulerio.imprimirTabuleiro();
    
    // Segundo inimigo
    /*setPers = false;
    while(!setPers){
      posX = rn.nextInt(linhas);
      posY = rn.nextInt(colunas);
      //System.out.println("Rand2 = " + posX + " | " + posY + " | " + tabulerio.getMatriz(posX, posY));
      if(tabulerio.getMatriz(posX, posY) == '.'){
        setPers = true;
        tabulerio.setInimigos(posX, posY);
        break;
      }
    }*/

    String opcao = "0";
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

      System.out.println("| (0) - " + RED + "Terminar jogo!" + WHITE);
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
      System.out.print("| >> Selecione o personagem: ");
      personagem = Integer.parseInt(input.nextLine()) - 1;

      if(personagem == -1){
        System.out.println("\033c");
        imprimirSeparador(tabulerio);
        tabulerio.imprimirTabuleiro();
        imprimirSeparador(tabulerio);
        System.out.println("|");
        System.out.println("| Voce " + RED + "perdeu " + WHITE + "o jogo por desistencia...");
        System.out.println("|");
        imprimirSeparador(tabulerio);
        break;
      }

      if(personagem < 0 || personagem >= tabulerio.getPersSize()){
        System.out.println("| >> Personagem inexistente! Digite novamente...\n\n");
        System.out.println(">> Aperta qualquer tecla para continuar...");
        input.nextLine();
        opcao = "0";
      } else {
        System.out.print("| >> Selecione o movimento: ");
        opcao = input.nextLine();
        opcao = opcao.toUpperCase();
      }

      switch(opcao){

        case "0":
        break;
        
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
          System.out.println(">> Aperta qualquer tecla para continuar...");
          input.nextLine();
        break;
        
      }

    }

    input.close();

  }

}
