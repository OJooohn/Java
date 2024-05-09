public class Gato extends Animal{
  
  private String cor;
  private boolean cacando;

  public void mudarCacando(){
    // this.cacando = ! this.cacando;
    this.setCacando(!this.getCacando());
    System.out.println("Gato está... " + this.getCacando());
  }

  public void setCor(String cor){
    this.cor = cor;
  }
  
  public void setCacando(boolean cacando){
    this.cacando = cacando;
  }

  public String getCor(){
    return this.cor;
  }

  public boolean getCacando(){
    return this.cacando;
  }

  @Override
  public String toString() {
    return "Gato - [ Nome = " + this.getNome()
    + " ] - [ Sexo = " + this.getSexo()
    + " ] - [ Idade = " + this.getIdade()
    + " ] - [ Cor: " + this.getCor() + " ]";
  }

}
