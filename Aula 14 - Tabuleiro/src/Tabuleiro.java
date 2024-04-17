import java.sql.Array;
import java.text.DecimalFormat;
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

  char getMatriz(int x, int y){
    return this.matriz[x][y];
  }

  int getPersSize(){
    return this.personagens.size();
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

  void novoTabulero(){
    this.matriz = new char[this.linhas][this.colunas];
    for(int i = 0; i < this.linhas; i++){
      for(int j = 0; j < this.colunas; j++){
        matriz[i][j] = '.';
      }
    }
  }

  void imprimirTabuleiro(){
    int i;
    System.out.print("|      ");
    for(i = 0; i < this.colunas; i++){
      System.out.print("[ " + (i + 1) + " ]");
    }
    System.out.println(" |");
    for(i = 0; i < this.linhas; i++){
      System.out.print("| ");
      System.out.print("[ " + (i + 1) + " ]");
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
    System.out.println(" |");
    }
  }
  

  void imprimirPersonagens(){
    for(int i = 0; i < personagens.size(); i++){
      Personagem p = personagens.get(i);
      if(personagens.get(i).getIcone() == 'O')
        System.out.println("| (" + (i + 1) + ") - [ " + YELLOW + p.getIcone() + WHITE + " ] - Aliado  - Posicao [" + (p.getX() + 1) + "][" + (p.getY() + 1) + "]");
      else
        System.out.println("| (" + (i + 1) + ") - [ " + RED + p.getIcone() + WHITE + " ] - Inimigo - Posicao [" + (p.getX() + 1) + "][" + (p.getY() + 1) + "]");
    }
  }

  void moverPersonagem(int mov, int personagem, Scanner input){
    Personagem p = personagens.get(personagem);
    int i, posX, posY;

    char icone;
    if(personagens.get(personagem).getIcone() == 'X')
      icone = 'X';
    else
      icone = 'O';

    switch(mov){
      case 1:
      if(p.getX() == 0){
        System.out.println(">> Fora dos limites");
        System.out.println(">> Aperte qualquer tecla para continuar...");
        input.nextLine();
        break;
      } else {
        if(icone == 'O' && getMatriz(p.getX() - 1, p.getY()) == 'X'){
          for(i = 0; i < personagens.size(); i++){
            if(personagens.get(i).getX() == p.getX() - 1 && personagens.get(i).getY() == p.getY()){
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

}