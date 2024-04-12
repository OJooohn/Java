public class Vaca extends Animal{
  
  private String dieta;
  private String manchas;

  public void pastar(){
    System.out.println("muu... muu... pastoreando...");
  }

  public void produzirLeite(){
    System.out.println("muu... muu... produzindo leite...");
  }

  public void setDieta(String dieta){
    this.dieta = dieta;
  }

  public void setManchas(String manchas){
    this.manchas = manchas;
  }

  public String getDieta(){
    return this.dieta;
  }

  public String getManchas(){
    return this.manchas;
  }

  @Override
  public String toString() {
    return "Vaca - [ Nome = " + this.getNome()
    + " ] - [ Sexo = " + this.getSexo()
    + " ] - [ Idade = " + this.getIdade()
    + " ] - [ Dieta = " + this.getDieta()
    + " ] - [ Manchas = " + this.getManchas() + " ]";
  }

}
