import java.util.Random;
import java.util.Scanner;

public class Main {

  public static final String RED = "\033[0;31m";
  public static final String GREEN = "\033[0;32m";
  public static final String WHITE = "\033[0;37m";

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

    int posX, posY, quantInimigos = 0, dificuldade = 0;
    boolean setPers = false, menu = true, dif = false;
    String opcao = "0";
    int jogo, i = 0, tamTab = 0, linhas = 0, colunas = 0;

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

      switch(dificuldade){
        case 1: quantInimigos = 1; dif = true;
        break;

        case 2: quantInimigos = 2; dif = true;
        break;

        case 3: quantInimigos = 4; dif = true;
        break;

        case 4: quantInimigos = 6; dif = true;
        break;

        case 5: quantInimigos = 7; dif = true;
        break;

        case 6: quantInimigos = 10; dif = true;
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
        imprimirSeparador(tabulerio);
        System.out.println("| Voce " + RED + "perdeu " + WHITE + "o jogo!                    |");
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
        System.out.println("| Voce " + GREEN + "ganhou " + WHITE + "o jogo!            |");
        imprimirSeparador(tabulerio);
        break;
      }

      System.out.println("\033c");
      System.out.println("|----------------------------------------|");
      System.out.println("|               TABULEIRO                |");

      imprimirSeparador(tabulerio);
      tabulerio.imprimirTabuleiro();
      imprimirSeparador(tabulerio);
      
      System.out.println("|               MOVIMENTOS               |");
      System.out.println("|----------------------------------------|");
      System.out.println("| [W] - Subir                            |");
      System.out.println("| [A] - Esquerda                         |");
      System.out.println("| [S] - Descer                           |");
      System.out.println("| [D] - Direita                          |");
      System.out.println("| [5] - Sair                             |");
      System.out.print("| >> Opcao: ");
      opcao = input.nextLine();
      opcao = opcao.toUpperCase();

      switch(opcao){

        case "0":
        break;
        
        case "W":
          tabulerio.moverPersonagem(1, 0, input);
          atualizarTela(tabulerio);
          // Selecionar automaticamente movimento dos Inimigos, de acordo com a posição do Aliado
          for(i = 1; i < tabulerio.getPersSize(); i++){
            tabulerio.moverInimigos(i);
          }
        break;
          
        case "S":
          tabulerio.moverPersonagem(2, 0, input);
          atualizarTela(tabulerio);
          // Selecionar automaticamente movimento dos Inimigos, de acordo com a posição do Aliado
          for(i = 1; i < tabulerio.getPersSize(); i++){
            tabulerio.moverInimigos(i);
          }
        break;
          
        case "A":
          tabulerio.moverPersonagem(3, 0, input);
          atualizarTela(tabulerio);
          // Selecionar automaticamente movimento dos Inimigos, de acordo com a posição do Aliado
          for(i = 1; i < tabulerio.getPersSize(); i++){
            tabulerio.moverInimigos(i);
          }
        break;
          
        case "D":
          tabulerio.moverPersonagem(4, 0, input);
          atualizarTela(tabulerio);
          // Selecionar automaticamente movimento dos Inimigos, de acordo com a posição do Aliado
          for(i = 1; i < tabulerio.getPersSize(); i++){
            tabulerio.moverInimigos(i);
          }
        break;

        case "5":
        System.out.println("|----------------------------------------|");
        System.out.println("| > Saindo...                            |");
        System.out.println("|----------------------------------------|");
          menu = false;
        break;

        default:
          System.out.println("|----------------------------------------|");
          System.out.println("| > Opcao inválida! Digite novamente...");
          System.out.println("|----------------------------------------|");
          System.out.print("|> Pressione qualquer tecla para continuar...");
          input.nextLine();
        break;
        
      }

    }

    input.close();
    
  }
  
}
