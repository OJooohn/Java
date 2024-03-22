public class Televisao {

  private int canal;
  private int volume;
  private boolean ligado;

  Televisao(){
    canal = 22;
    volume = 50;
    ligado = true;
  }

  Televisao(boolean status, int ch, int vl){
    canal = ch;
    volume = vl;
    ligado = status;
  }

  void aumentarVolume(){
    if(this.volume <= 95)
      this.setVolume(this.getVolume() + 5);
    else 
      System.out.println(">> Volume maximo atingido");
  }

  // "this.var" serve para a variavel da classe
  void setVolume(int volume){
    this.volume = volume;
    System.out.println(">> Volume alterado para: " + volume);
  }
  void setCanal(int canal){
    this.canal = canal;
    System.out.println(">> Canal alterado para: " + canal);
  }
  void setLigado(boolean ligado){
    this.ligado = ligado;
  }

  int getVolume(){
    return this.volume;
  }

  int getCanal(){
    return this.canal;
  }

  boolean getLigado(){
    return this.ligado;
  }
  
}
