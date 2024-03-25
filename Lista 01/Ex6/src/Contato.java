public class Contato {
  
  private String nome;
  private String telefone;

  Contato(String nome, String telefone){
    this.nome = nome;
    this.telefone = telefone;
  }

  String getNome(){
    return this.nome;
  }

  String getTelefone(){
    return this.telefone;
  }

  void novoTelefone(String telefone){
    this.telefone = "";
    this.telefone = telefone;
    System.out.println("\n>> Número de telefone atualizado para: " + this.telefone);
  }

}
