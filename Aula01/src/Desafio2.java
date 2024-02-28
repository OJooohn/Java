import java.util.Scanner;

public class Desafio2 {
  
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    System.out.print("Informe o primeiro número: ");
    int num1 = input.nextInt();

    System.out.print("Informe o segundo número: ");
    int num2 = input.nextInt();

    int soma = num1 + num2;

    System.out.print("A soma é " + soma);
  }

}
