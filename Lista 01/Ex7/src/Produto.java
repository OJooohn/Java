public class Produto {
  
  private String nomeProduto;
  private String codigo;
  private int quantidade;
  private float preco;

  Produto(String nomeProduto, String codigo, int quantidade, float preco){
    this.nomeProduto = nomeProduto;
    this.codigo = codigo;
    this.quantidade = quantidade;
    this.preco = preco;
  }

  String getNomeProduto(){
    return this.nomeProduto;
  }

  String getCodigo(){
    return this.codigo;
  }

  int getQuantidade(){
    return this.quantidade;
  }

  float getPreco(){
    return this.preco;
  }

  void atualizarQuantidade(int quantidade){
    this.quantidade = quantidade;
  }

  void atualizarPreco(float preco){
    this.preco = preco;
  }

  void listar(){
    System.out.println("~~ Nome: " + this.nomeProduto);
    System.out.println("~~ Codigo: " + this.codigo);
    System.out.println("~~ Quantiade em estoque: " + this.quantidade);
    System.out.println("~~ Preco: R$ " + this.preco);
    System.out.println("\n=============================\n");
  }
  
}
