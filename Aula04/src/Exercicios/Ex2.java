package Exercicios;
import java.util.Scanner;

public class Ex2 {

  static float consumo(int distancia, float combustivel){

    return distancia / combustivel;

  }
  
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    int distancia;
    float combustivel;

    System.out.print("Digite a distancia percorrida: ");
    distancia = Integer.parseInt(input.nextLine());

    System.out.print("Digite o total de combustivel gasto; ");
    combustivel = Float.parseFloat(input.nextLine());

    System.out.println("Consumo médio do veiculo = " + consumo(distancia, combustivel));

  }

}
