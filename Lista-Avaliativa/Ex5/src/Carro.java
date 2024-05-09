public class Carro {
  
  private String marca;
  private String modelo;
  private int ano;
  private String placa;
  private float velocidadeAtual;

  Carro(String marca, String modelo, int ano, String placa){
    this.marca = marca;
    this.modelo = modelo;
    this.ano = ano;
    this.placa = placa;
    this.velocidadeAtual = 0;
  }

  void acelerar(){
    if(this.getVelocidade() < 220){
      this.setVelocidade(getVelocidade() + 5);
      System.out.println(">> Velocidade alterada para: " + this.getVelocidade() + " km/h");
    } else {
      System.out.println(">> Velocidade máxima atingida!");
    }
  }

  void frear(){
    if(this.getVelocidade() > 4){
      this.setVelocidade(getVelocidade() - 5);
      System.out.println(">> Velocidade alterada para: " + this.getVelocidade() + " km/h");
    } else {
      System.out.println(">> O carro está parado!");
    }
  }

  void listar(){
    System.out.println(">> Carro listado\n");
    System.out.println("~~ Placa: " + this.getPlaca());
    System.out.println("~~ Marca: " + this.getMarca());
    System.out.println("~~ Modelo: " + this.getModelo());
    System.out.println("~~ Ano: " + this.getAno());
    System.out.println("~~ Velocidade atual: " + this.getVelocidade() + " km/h");
  }

  void setVelocidade(float velocidadeAtual){
    this.velocidadeAtual = velocidadeAtual;
  }

  String getMarca(){
    return marca;
  }

  String getModelo(){
    return modelo;
  }

  int getAno(){
    return ano;
  }

  String getPlaca(){
    return placa;
  }

  float getVelocidade(){
    return velocidadeAtual;
  }



}
