package Exercicios;
import java.util.Scanner;

public class Ex4 {

  static float conversao(float cotacao, float dolares){

    return (cotacao / dolares);

  }
  
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    float cotacao, dolares;

    System.out.print("Digite a quantidade de dolares: ");
    dolares = Float.parseFloat(input.nextLine());

    System.out.print("Digite o valor da cotação: ");
    cotacao = Float.parseFloat(input.nextLine());

    System.out.println("Total = R$ " + conversao(cotacao, dolares));

    input.close();

  }

}
