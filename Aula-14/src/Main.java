import java.util.Random;
import java.util.Scanner;

public class Main {

  public static final String RESET = "\033[0m";  // Text Reset

  // Regular Colors
  public static final String BLACK = "\033[0;30m";   // BLACK
  public static final String RED = "\033[0;31m";     // RED
  public static final String GREEN = "\033[0;32m";   // GREEN
  public static final String YELLOW = "\033[0;33m";  // YELLOW
  public static final String BLUE = "\033[0;34m";    // BLUE
  public static final String PURPLE = "\033[0;35m";  // PURPLE
  public static final String CYAN = "\033[0;36m";    // CYAN
  public static final String WHITE = "\033[0;37m";   // WHITE

  // Bold
  public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
  public static final String RED_BOLD = "\033[1;31m";    // RED
  public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
  public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
  public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
  public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
  public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
  public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

  static void imprimirSeparador(Tabuleiro tabuleiro){
    System.out.print("|");
    for(int i = 0; i <= tabuleiro.getColuna(); i++){
      System.out.print("-----");
    }
    System.out.println("--|");
  }

  static void atualizarTela(Tabuleiro tabuleiro){
    
    System.out.println("\033c");
      System.out.println("|----------------------------------------|");
      System.out.println("|               TABULEIRO                |");
      
      imprimirSeparador(tabuleiro);
      tabuleiro.imprimirTabuleiro();
      imprimirSeparador(tabuleiro);
      
      System.out.println("|               MOVIMENTOS               |");
      System.out.println("|----------------------------------------|");
      System.out.println("| [W] - Subir                            |");
      System.out.println("| [A] - Esquerda                         |");
      System.out.println("| [S] - Descer                           |");
      System.out.println("| [D] - Direita                          |");
      System.out.println("| [5] - Sair                             |");
      System.out.println("|----------------------------------------|");
    System.out.print("| Computando movimentos");
    // Thread.sleep(400); 400ms
    try { 
      System.out.print(".");
      Thread.sleep(400);
      System.out.print(".");
      Thread.sleep(400);
      System.out.print(".");
      Thread.sleep(400);
      System.out.print(".");
      Thread.sleep(400);
    } catch(InterruptedException ex){ 
      return;
    } 

  }

  // Atualmente a % de movimentos dos inimigos é de 75%, pode melhorar colocando movimentos a cada 2 rodadas
  // Para melhorar o jogo, colocar vidas no personagem??
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    Random rn = new Random();

    int posX, posY, quantInimigos = 0, dificuldade = 0, rodada = 1;
    int jogo, i = 0, tamTab = 0, linhas = 0, colunas = 0, pointsMult = 0;
    boolean setPers = false, menu = true, dif = false;
    String opcao = "0";

    do{
      System.out.println("\033c");
      System.out.println("|----------------------------------------|");
      System.out.println("|           DEFINIR TAMANHO              |");
      System.out.println("|----------------------------------------|");
      System.out.println("| Tamanho mínimo: 5");
      System.out.print("| > Digite a quantidade de linhas: ");
      linhas = Integer.parseInt(input.nextLine());

      System.out.print("| > Digite a quantidade de colunas: ");
      colunas = Integer.parseInt(input.nextLine());

      if(linhas >= 5 && colunas >= 5)
        tamTab = 1;
      else{
        System.out.println("|----------------------------------------|");
        System.out.println("| >> Tamanho menor que o mínimo!...      |");
        System.out.println("|----------------------------------------|");
        System.out.print("| >> Digite qualquer tecla para continuar...");
        input.nextLine();
      }

    }while(tamTab == 0);
    
    
    Tabuleiro tabulerio = new Tabuleiro(linhas, colunas);
    
    tabulerio.novoTabulero();

    // Aliado
    posX = rn.nextInt(linhas);
    posY = rn.nextInt(colunas);
    tabulerio.setPersonagem(posX, posY);

    while(dif == false){
      System.out.println("\033c");
      System.out.println("|----------------------------------------|");
      System.out.println("|       SELECIONAR DIFICULDADE           |");
      System.out.println("|----------------------------------------|");
      System.out.println("| [1] - Muito fácil                      |");
      System.out.println("| [2] - Fácil                            |");
      System.out.println("| [3] - Médio                            |");
      System.out.println("| [4] - Difícil                          |");
      System.out.println("| [5] - Muito Difícil                    |");
      System.out.println("| [6] - " + RED + "HARDCORE" + WHITE + "                         |");
      System.out.print("| >> Selecione a dificuldade: ");
      dificuldade = Integer.parseInt(input.nextLine());

      int quantCasas = linhas * colunas;

      switch(dificuldade){
        case 1:
        pointsMult = 1;
        if(quantCasas >= 25 && quantCasas <= 35)
          quantInimigos = 2;
          else
          quantInimigos = 4;
        
        dif = true;
        break;

        case 2: 
        pointsMult = 1;
        if(quantCasas >= 25 && quantCasas <= 35)
          quantInimigos = 4;
          else
          quantInimigos = 9;

        dif = true;
        break;

        case 3:
        pointsMult = 2;
          if(quantCasas >= 25 && quantCasas <= 35)
            quantInimigos = 6;
          else
            quantInimigos = 11;

        dif = true;
        break;

        case 4:
        pointsMult = 4;
          if(quantCasas >= 25 && quantCasas <= 35)
            quantInimigos = 8;
          else
            quantInimigos = 13;
        
        dif = true;
        break;

        case 5:
        pointsMult = 6;
          if(quantCasas >= 25 && quantCasas <= 35)
            quantInimigos = 10;
          else
            quantInimigos = 15;
        
        dif = true;
        break;

        case 6:
        pointsMult = 10;
          if(quantCasas >= 25 && quantCasas <= 35)
            quantInimigos = 12;
          else
            quantInimigos = 17;
        
        dif = true;
        break;

        default:
          System.out.println("|----------------------------------------|");
          System.out.println("| > Opcao inválida! Digite novamente     |");
          System.out.println("|----------------------------------------|");
          System.out.print("| > Aperta qualquer tecla para continuar...");
          input.nextLine();
        break;
      }
    }

    // Posicionar inimigos
    for(i = 0; i < quantInimigos; i++){
      setPers = false;
      while(!setPers){
        posX = rn.nextInt(linhas);
        posY = rn.nextInt(colunas);
        if(tabulerio.getMatriz(posX, posY) == '.'){
          setPers = true;
          tabulerio.setInimigos(posX, posY);
          break;
        }
      }
    }
    tabulerio.imprimirTabuleiro();

    while(menu){

      jogo = tabulerio.statusJogo();

      if(jogo == 2){
        System.out.println("\033c");
        System.out.println("|----------------------------------------|");
        System.out.println("|               TABULEIRO                |");
        imprimirSeparador(tabulerio);
        tabulerio.imprimirTabuleiro();
        System.out.println("|----------------------------------------|");
        System.out.println("|               " + RED_BOLD + "GAME OVER" + RESET + "                |");
        System.out.println("|----------------------------------------|");
        System.out.print("| " + WHITE_BOLD + "PONTUAÇÃO: ");
        System.out.printf("%3d", tabulerio.getPontuacao() * pointsMult);
        System.out.println(RESET + "                         |");
        System.out.println("|----------------------------------------|");
        break;
      }
      
      if(jogo == 1){
        System.out.println("\033c");
        System.out.println("|----------------------------------------|");
        System.out.println("|               TABULEIRO                |");
        imprimirSeparador(tabulerio);
        tabulerio.imprimirTabuleiro();
        imprimirSeparador(tabulerio);
        System.out.println("|              " + GREEN_BOLD + "VOCÊ GANHOU" + RESET + "               |");
        System.out.println("|----------------------------------------|");
        System.out.print("| " + WHITE_BOLD + "PONTUAÇÃO: ");
        System.out.printf("%3d", tabulerio.getPontuacao() * pointsMult);
        System.out.println(RESET + "                         |");
        System.out.println("|----------------------------------------|");
        break;
      }

      System.out.println("\033c");
      System.out.println("|----------------------------------------|");
      System.out.println("|               TABULEIRO                |");

      imprimirSeparador(tabulerio);
      tabulerio.imprimirTabuleiro();
      imprimirSeparador(tabulerio);
      System.out.print(WHITE_BOLD + "| RODADA: ");
      System.out.printf("%2d", rodada);
      System.out.println(RESET + "                             |");
      System.out.println("|----------------------------------------|");
      System.out.println("|               MOVIMENTOS               |");
      System.out.println("|----------------------------------------|");
      System.out.println("| [" + WHITE_BOLD + "W" + RESET + "] - Subir                            |");
      System.out.println("| [" + WHITE_BOLD + "A" + RESET + "] - Esquerda                         |");
      System.out.println("| [" + WHITE_BOLD + "S" + RESET + "] - Descer                           |");
      System.out.println("| [" + WHITE_BOLD + "D" + RESET + "] - Direita                          |");
      System.out.println("| [" + WHITE_BOLD + "5" + RESET + "] - Sair                             |");
      System.out.print("| >> Selecione uma opção: ");
      opcao = input.nextLine();
      opcao = opcao.toUpperCase();

      switch(opcao){

        case "0":
        break;
        
        case "W":
          tabulerio.moverPersonagem(1, 0, input);
          // Selecionar automaticamente movimento dos Inimigos, de acordo com a posição do Aliado
          if(rodada % 2 == 0){
            if(tabulerio.getPersSize() == 1){
              break;
            }
            atualizarTela(tabulerio);
            for(i = 1; i < tabulerio.getPersSize(); i++){
              tabulerio.moverInimigos(i, dificuldade);
            }
          }
        break;
          
        case "S":
          tabulerio.moverPersonagem(2, 0, input);
          // Selecionar automaticamente movimento dos Inimigos, de acordo com a posição do Aliado
          if(rodada % 2 == 0){
            if(tabulerio.getPersSize() == 1){
              break;
            }
            atualizarTela(tabulerio);
            for(i = 1; i < tabulerio.getPersSize(); i++){
              tabulerio.moverInimigos(i, dificuldade);
            }
          }
        break;
          
        case "A":
          tabulerio.moverPersonagem(3, 0, input);
          // Selecionar automaticamente movimento dos Inimigos, de acordo com a posição do Aliado
          if(rodada % 2 == 0){
            if(tabulerio.getPersSize() == 1){
              break;
            }
            atualizarTela(tabulerio);
            for(i = 1; i < tabulerio.getPersSize(); i++){
              tabulerio.moverInimigos(i, dificuldade);
            }
          }
        break;
          
        case "D":
          tabulerio.moverPersonagem(4, 0, input);
          // Selecionar automaticamente movimento dos Inimigos, de acordo com a posição do Aliado
          if(rodada % 2 == 0){
            if(tabulerio.getPersSize() == 1){
              break;
            }
            atualizarTela(tabulerio);
            for(i = 1; i < tabulerio.getPersSize(); i++){
              tabulerio.moverInimigos(i, dificuldade);
            }
          }
        break;

        case "5":
        System.out.println("|----------------------------------------|");
        System.out.println("| > Saindo...                            |");
        System.out.println("|----------------------------------------|");
          menu = false;
        break;

        default:
          rodada--;
          System.out.println("|----------------------------------------|");
          System.out.println("| > Opcao inválida! Digite novamente...");
          System.out.println("|----------------------------------------|");
          System.out.print("|> Pressione qualquer tecla para continuar...");
          input.nextLine();
        break;
        
      }
      rodada++;

    }

    input.close();
    
  }
  
}
