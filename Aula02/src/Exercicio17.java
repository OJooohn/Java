import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio17 {
  
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    DecimalFormat deci = new DecimalFormat("0.00");

    System.out.print("Digite a nota1: ");
    float nota1 = input.nextFloat();

    System.out.print("Digite a nota2: ");
    float nota2 = input.nextFloat();
    
    System.out.print("Digite a nota3: ");
    float nota3 = input.nextFloat();

    System.out.println("A média harmônica do aluno é: " + deci.format((3 / ((1 / nota1) + (1 / nota2) + (1 / nota3)))));

  }

}
