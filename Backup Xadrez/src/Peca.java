public class Peca {

  private String icone;
  private int posX;
  private int posY;

  public Peca(String icone, int posX, int posY){
    this.icone = icone;
    this.posX = posX;
    this.posY = posY;
  }

  public String getIcone(){
    return this.icone;
  }

  public int getposX(){
    return this.posX;
  }

  public int getposY(){
    return this.posY;
  }

  public void setIcone(String icone){
    this.icone = icone;
  }

  public void setposX(int posX){
    this.posX = posX;
  }

  public void setposY(int posY){
    this.posY = posY;
  }
  
}
