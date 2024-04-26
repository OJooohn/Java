public class Peca {

  private String icone;
  private int posX;
  private int posY;
  private int movimentos;
  private boolean isBlack;
  private boolean isWhite;

  public Peca(String icone, int posX, int posY, boolean isWhite, boolean isBlack) {
    this.icone = icone;
    this.posX = posX;
    this.posY = posY;
    this.movimentos = 0;
    this.isWhite = isWhite;
    this.isBlack = isBlack;
  }

  public String getIcone() {
    return this.icone;
  }

  public int getposX() {
    return this.posX;
  }

  public int getposY() {
    return this.posY;
  }

  public int getMovimentos() {
    return this.movimentos;
  }

  public boolean getIsWhite(){
    return this.isWhite;
  }

  public boolean getIsBlack(){
    return this.isBlack;
  }

  public void setIcone(String icone) {
    this.icone = icone;
  }

  public void setposX(int posX) {
    this.posX = posX;
  }

  public void setposY(int posY) {
    this.posY = posY;
  }

  public void setMovimentos(int movimentos) {
    this.movimentos = movimentos;
  }

  public void aumentarMovimentos() {
    this.setMovimentos(getMovimentos() + 1);
  }

  public boolean movimentarPeca(int linha, int coluna) {
    boolean verificado = false;
    return this.verificado;
  }

}
