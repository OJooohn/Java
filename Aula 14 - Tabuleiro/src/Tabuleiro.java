import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tabuleiro{

  public static final String YELLOW = "\033[0;33m";
  public static final String WHITE = "\033[0;37m";
  public static final String RED = "\033[0;31m";
  
  private int linhas;
  private int colunas;
  private char matriz[][];
  private List<Personagem> personagens = new ArrayList<>();

  Tabuleiro(int linhas, int colunas){
    this.linhas = linhas;
    this.colunas = colunas;
  }

  void setPersonagem(int x, int y){
    this.personagens.add(new Jogador(x, y));
    this.matriz[x][y] = 'O';
  }

  void setInimigos(int x, int y){
    this.personagens.add(new Inimigo(x, y));
    this.matriz[x][y] = 'X';
  }

  int getLinha(){
    return this.linhas;
  }

  int getColuna(){
    return this.colunas;
  }

  void novoTabulero(){
    this.matriz = new char[this.linhas][this.colunas];
    for(int i = 0; i < this.linhas; i++){
      for(int j = 0; j < this.colunas; j++){
        matriz[i][j] = '.';
      }
    }
  }

  void imprimirTabuleiro(){
    for(int i = 0; i < this.linhas; i++){
      for(int j = 0; j < this.colunas; j++){
        System.out.print("[ ");
        if(matriz[i][j] == 'O'){
          System.out.print(YELLOW + matriz[i][j] + WHITE);
        } else if(matriz[i][j] == 'X'){
          System.out.print(RED + matriz[i][j] + WHITE);
        } else {
          System.out.print(matriz[i][j]);
        }
         
        System.out.print(WHITE + " ]");
      }
      System.out.println();
    }
  }

  /*void imprimirPersonagens(){
    for(int i = 0; i < personagens.size(); i++){
      System.out.println("| (" + );
    }
  }*/

  void moverPersonagem(int mov){
    Personagem p = personagens.get(0);
    matriz[p.getX()][p.getY()] = '.';
    switch(mov){
      case 1:
        p.setX(p.getX() - 1);
        matriz[p.getX()][p.getY()] = 'O';
      break;

      case 2:
        p.setX(p.getX() + 1);
        matriz[p.getX()][p.getY()] = 'O';
      break;

      case 3:
        p.setY(p.getY() - 1);
        matriz[p.getX()][p.getY()] = 'O';
      break;

      case 4:
        p.setY(p.getY() + 1);
        matriz[p.getX()][p.getY()] = 'O';
      break;
    }
  }

}
