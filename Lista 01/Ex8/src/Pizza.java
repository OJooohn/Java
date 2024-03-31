public class Pizza {

  private String nome;
  private float preco;
  private String igredientes;

  Pizza(String nome, float preco, String igredientes){
    this.nome = nome;
    this.preco = preco;
    this.igredientes = igredientes;
  }

  String getNome(){
    return nome;
  }

  float getPreco(){
    return preco;
  }

  String getIgredientes(){
    return igredientes;
  }
  
  void listar(){
    System.out.println(">> Pizza: " + getNome());
    System.out.println(">> Preço: " + getPreco());
    System.out.println("Igredientes: " + getIgredientes());
    System.out.println("\n===========================\n");
  }

}