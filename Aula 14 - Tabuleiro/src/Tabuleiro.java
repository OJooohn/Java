import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Tabuleiro{

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
  
  private int linhas;
  private int colunas;
  private int pontuacao;
  private char matriz[][];
  private List<Personagem> personagens = new ArrayList<>();

  Tabuleiro(int linhas, int colunas){
    this.linhas = linhas;
    this.colunas = colunas;
    this.pontuacao = 0;
  }

  int getLinha(){
    return this.linhas;
  }

  int getColuna(){
    return this.colunas;
  }

  int getPontuacao(){
    return this.pontuacao;
  }

  void setPontuacao(int pontuacao){
    this.pontuacao = pontuacao;
  }

  char getMatriz(int x, int y){
    return this.matriz[x][y];
  }

  int getPersSize(){
    return this.personagens.size();
  }

  void setPersonagem(int x, int y){
    this.personagens.add(new Jogador(x, y));
    this.matriz[x][y] = 'O';
  }

  void setInimigos(int x, int y){
    this.personagens.add(new Inimigo(x, y));
    this.matriz[x][y] = 'X';
  }

  void novoTabulero(){
    this.matriz = new char[this.linhas][this.colunas];
    for(int i = 0; i < this.linhas; i++){
      for(int j = 0; j < this.colunas; j++){
        matriz[i][j] = '.';
      }
    }
  }

  int statusJogo(){
    if(personagens.get(0).getIcone() == 'X'){
      return 2;
    }
    if(personagens.get(0).getIcone() == 'O' && personagens.size() == 1){
      return 1;
    } else {
      return 0;
    }
  }

  void imprimirTabuleiro(){
    //char[] alfabeto = new char[26] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'}; 
    int i, j;

    System.out.print("|      ");
    for(i = 0; i < this.colunas; i++){
      System.out.print("[" + PURPLE_BOLD);
      System.out.printf("%2d", i + 1);
      System.out.print(RESET + " ]");
      //System.out.print("[" + PURPLE + deci.format(i + 1) + WHITE + " ]");
    }
    System.out.println(" |");

    char letra = 'A';
    for(i = 0; i < this.linhas; i++, letra++){
      //System.out.print("| ");
      //System.out.print("[" + BLUE_BOLD);
      //System.out.printf("%2d", i + 1);
      //System.out.print(RESET + " ]");
      System.out.print("| [ " + BLUE_BOLD + letra + WHITE + " ]");
      //System.out.print("[ " + BLUE + (i + 1) + WHITE + " ]");

      for(j = 0; j < this.colunas; j++){
        System.out.print("[ ");
        if(matriz[i][j] == 'O'){
          System.out.print(GREEN + matriz[i][j] + RESET);
        } else if(matriz[i][j] == 'X'){
          System.out.print(RED + matriz[i][j] + RESET);
        } else {
          System.out.print(BLACK_BOLD + matriz[i][j]);
        }
         
        System.out.print(RESET + " ]");
      }

    System.out.println(" |");
    }
  }
  
  void moverPersonagem(int mov, int personagem, Scanner input){
    Personagem p = personagens.get(personagem);
    int i;

    char icone;
    if(personagens.get(personagem).getIcone() == 'X')
      icone = 'X';
    else
      icone = 'O';

    switch(mov){
      case 1:
      if(p.getX() == 0){
        System.out.println(">> Fora dos limites");
        System.out.println(">> Pressione qualquer tecla para continuar...");
        input.nextLine();
        break;
      } else {

        if(icone == 'O' && getMatriz(p.getX() - 1, p.getY()) == 'X'){
          for(i = 0; i < personagens.size(); i++){
            if(personagens.get(i).getX() == p.getX() - 1 && personagens.get(i).getY() == p.getY()){
              this.setPontuacao(this.getPontuacao() + 1);
              personagens.remove(i);
              break;
            }
          }
        }

        if(icone == 'X' && getMatriz(p.getX() - 1, p.getY()) == 'O'){
          personagens.remove(0);
        }

        matriz[p.getX()][p.getY()] = '.';
        p.setX(p.getX() - 1);
        matriz[p.getX()][p.getY()] = icone;
      }
      break;

      case 2:
      if(p.getX() == this.linhas - 1){
        System.out.println(">> Fora dos limites");
        System.out.println(">> Aperte qualquer tecla para continuar...");
        input.nextLine();
        break;
      } else {

        if(icone == 'O' && getMatriz(p.getX() + 1, p.getY()) == 'X'){
          for(i = 0; i < personagens.size(); i++){
            if(personagens.get(i).getX() == p.getX() + 1 && personagens.get(i).getY() == p.getY()){
              this.setPontuacao(this.getPontuacao() + 1);
              personagens.remove(i);
              break;
            }
          }
        }

        if(icone == 'X' && getMatriz(p.getX() + 1, p.getY()) == 'O'){
          personagens.remove(0);
        }

        matriz[p.getX()][p.getY()] = '.';
        p.setX(p.getX() + 1);
        matriz[p.getX()][p.getY()] = icone;
      }
      break;

      case 3:
      if(p.getY() == 0){
        System.out.println(">> Fora dos limites");
        System.out.println(">> Aperte qualquer tecla para continuar...");
        input.nextLine();
        break;
      } else {

        if(icone == 'O' && getMatriz(p.getX(), p.getY() - 1) == 'X'){
          for(i = 0; i < personagens.size(); i++){
            if(personagens.get(i).getY() == p.getY() - 1 && personagens.get(i).getX() == p.getX()){
              this.setPontuacao(this.getPontuacao() + 1);
              personagens.remove(i);
              break;
            }
          }
        }

        if(icone == 'X' && getMatriz(p.getX(), p.getY() - 1) == 'O'){
          personagens.remove(0);
        }

        matriz[p.getX()][p.getY()] = '.';
        p.setY(p.getY() - 1);
        matriz[p.getX()][p.getY()] = icone;
      }
      break;

      case 4:
      if(p.getY() == this.colunas - 1){
        System.out.println(">> Fora dos limites");
        System.out.println(">> Aperte qualquer tecla para continuar...");
        input.nextLine();
        break;
      } else {

        if(icone == 'O' && getMatriz(p.getX(), p.getY() + 1) == 'X'){
          for(i = 0; i < personagens.size(); i++){
            if(personagens.get(i).getY() == p.getY() + 1 && personagens.get(i).getX() == p.getX()){
              this.setPontuacao(this.getPontuacao() + 1);
              personagens.remove(i);
              break;
            }
          }
        }
        
        if(icone == 'X' && getMatriz(p.getX(), p.getY() + 1) == 'O'){
          personagens.remove(0);
        }

        matriz[p.getX()][p.getY()] = '.';
        p.setY(p.getY() + 1);
        matriz[p.getX()][p.getY()] = icone;
      }
      break;
    }
  }

  public void moverInimigos(int personagem, int dificuldade){
    int chance = 0;

    switch(dificuldade){
      case 1: chance = 10;
      break;

      case 2: chance = 8;
      break;

      case 3: chance = 6;
      break;

      case 4: chance = 4;
      break;

      case 5: chance = 2;
      break;

      case 6: chance = 1;
      break;
    }
    
    Personagem aliado = personagens.get(0);
    Personagem inimigo = personagens.get(personagem);

    Random rn = new Random();

    int mover = rn.nextInt(chance); // 0, 1, 2, 3 --> sendo mover > 0 --> 75% de chance de se mover
    int pos; // 0 para X e 1 para Y
    int dX = aliado.getX() - inimigo.getX(), dY = aliado.getY() - inimigo.getY();

    if(dX < 0)
      dX = dX * -1;

    if(dY < 0)
      dY = dY * -1;

    if(dX > dY)
      pos = 0;
    else 
      pos = 1;

    // Y = ROXO | X = AZUL

    if(mover == 0){
      if(pos == 0){
        if(inimigo.getX() > aliado.getX()){
          if(getMatriz(inimigo.getX() - 1, inimigo.getY()) == 'X'){
             return;
          } else {
            if(getMatriz(inimigo.getX() - 1, inimigo.getY()) == 'O'){
              personagens.remove(0);
            }
            this.matriz[inimigo.getX()][inimigo.getY()] = '.';
            inimigo.setX(inimigo.getX() - 1);
            this.matriz[inimigo.getX()][inimigo.getY()] = 'X';
            return;
          }
        } else {
          if(getMatriz(inimigo.getX() + 1, inimigo.getY()) == 'X'){
            return;
          } else {
            if(getMatriz(inimigo.getX() + 1, inimigo.getY()) == 'O'){
              personagens.remove(0);
            }
            this.matriz[inimigo.getX()][inimigo.getY()] = '.';
            inimigo.setX(inimigo.getX() + 1);
            this.matriz[inimigo.getX()][inimigo.getY()] = 'X';
            return;
          }
        }
      } else {
        if(inimigo.getY() > aliado.getY()){
          if(getMatriz(inimigo.getX(), inimigo.getY() - 1) == 'X'){
            return;
          } else {
            if(getMatriz(inimigo.getX(), inimigo.getY() - 1) == 'O'){
              personagens.remove(0);
            }
            System.out.println("Y diminuindo");
            this.matriz[inimigo.getX()][inimigo.getY()] = '.';
            inimigo.setY(inimigo.getY() - 1);
            this.matriz[inimigo.getX()][inimigo.getY()] = 'X';
          }
        } else {
          if(getMatriz(inimigo.getX(), inimigo.getY() + 1) == 'X'){
            return;
          } else {
            if(getMatriz(inimigo.getX(), inimigo.getY() + 1) == 'O'){
              personagens.remove(0);
            }
            System.out.println("Y aumentando");
            this.matriz[inimigo.getX()][inimigo.getY()] = '.';
            inimigo.setY(inimigo.getY() + 1);
            this.matriz[inimigo.getX()][inimigo.getY()] = 'X';
          }
        }
      }
    }
  }
}