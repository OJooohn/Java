public class Peca {

  private String icone;
  private int posX;
  private int posY;
  private int movimentos;

  public Peca(String icone, int posX, int posY){
    this.icone = icone;
    this.posX = posX;
    this.posY = posY;
    this.movimentos = 0;
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

  public int getMovimentos(){
    return this.movimentos;
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

  public void setMovimentos(int movimentos){
    this.movimentos = movimentos;
  }
  
  public void aumentarMovimentos(){
    this.setMovimentos(getMovimentos() + 1);
  }
  
}
