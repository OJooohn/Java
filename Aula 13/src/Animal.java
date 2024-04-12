public class Animal {
  
  private String nome;
  private String sexo;
  private int idade;

  public void emitirSom(){
    System.out.println("O animal esta fazendo barulho...");
  }

  public void envelhecer(){
    // this.idade += 1;
    this.setIdade(this.getIdade() + 1);
  }

  public void setNome(String nome){
    this.nome = nome;
  }

  public void setSexo(String sexo){
    this.sexo = sexo;
  }

  public void setIdade(int idade){
    this.idade = idade;
  }

  public String getNome(){
    return this.nome;
  }

  public String getSexo(){
    return this.sexo;
  }

  public int getIdade(){
    return this.idade;
  }

  @Override
  public String toString() {
    return "Animal - [ Nome = " + this.getNome()
    + " ] - [ Sexo = " + this.getSexo()
    + " ] - [ Idade = " + this.getIdade() + " ]";
  }

}
