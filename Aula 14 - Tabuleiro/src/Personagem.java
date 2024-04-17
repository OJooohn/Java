public class Personagem{

  private int posX;
  private int posY;

  Personagem(int posX, int posY){
    this.posX = posX;
    this.posY = posY;
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

}