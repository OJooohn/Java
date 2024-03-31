public class Pedido {
  
  // sabor vai ser usado para adicionar uma pizza padrão ao pedido
  private String sabor;
  private String endereco;
  private boolean cancelado;
  private float preco;

  Pedido(String sabor, String endereco, float preco){
    this.sabor = sabor;
    this.endereco = endereco;
    this.cancelado = false;
    this.preco = preco;
  }

  String getSabor(){
    return this.sabor;
  }

  String getEndereco(){
    return this.endereco;
  }

  Boolean getStatus(){
    return this.cancelado;
  }

  float getPreco(){
    return this.preco;
  }

  void setStatus(){
    this.cancelado = true;
  }

  void listar(int i){
    System.out.println("ID: " + (i + 1));
    System.out.println(">> Sabor: " + getSabor());
    System.out.println(">> Endereço: " + getEndereco());

    if(getStatus())
      System.out.println(">> Pedido: Cancelado");
    else
      System.out.println(">> Status: Em andamento");

    System.out.println("\n===========================\n");
  }

}
