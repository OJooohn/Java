public class Cachorro extends Animal{
  
  private String raca;
  private String porte;

  public void buscarOsso(){
    System.out.println("woof... woof... cade... au... au... osso?...");
  }

  public void setRaca(String raca){
    this.raca = raca;
  }

  public void setPorte(String porte){
    this.porte = porte;
  }

  public String getRaca(){
    return this.raca;
  }

  public String getPorte(){
    return this.porte;
  }

  @Override
  public String toString() {
    return "Cachorro - [ Nome = " + this.getNome()
    + " ] - [ Sexo = " + this.getSexo()
    + " ] - [ Idade = " + this.getIdade()
    + " ] - [ Raca = " + this.getRaca()
    + " ] - [ Porte = " + this.getPorte() + " ]";
  }

}
