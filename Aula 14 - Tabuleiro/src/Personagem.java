public class Personagem{

  private int posX;
  private int posY;
  private char icone;

  Personagem(int posX, int posY, char icone){
    this.posX = posX;
    this.posY = posY;
    this.icone = icone;
  }

  void setX(int x){
    this.posX = x;
  }

  void setY(int y){
    this.posY = y;
  }

  int getX(){
    return this.posX;
  }

  int getY(){
    return this.posY;
  }

  char getIcone(){
    return this.icone;
  }

}