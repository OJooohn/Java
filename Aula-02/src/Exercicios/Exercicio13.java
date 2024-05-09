package Exercicios;
import java.util.Scanner;

public class Exercicio13 {
  
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    System.out.print("Digite o valor de A1: ");
    int a1 = input.nextInt();

    System.out.print("Digite o valor de n:");
    int n = input.nextInt();

    System.out.print("Digite o valor de r: ");
    int r = input.nextInt();

    System.out.println("O n-ésimo valor da PA é: " + (a1 + ((n - 1) * r)));

    input.close();

  }

}
