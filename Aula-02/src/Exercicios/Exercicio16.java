package Exercicios;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio16 {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    DecimalFormat deci = new DecimalFormat("0.00");

    System.out.print("Digite a nota1: ");
    float nota1 = input.nextFloat();
    
    System.out.print("Digite a nota2: ");
    float nota2 = input.nextFloat();

    System.out.print("Digite a nota3: ");
    float nota3 = input.nextFloat();

    System.out.print("Digite o peso1; ");
    int peso1 = input.nextInt();
    
    System.out.print("Digite o peso2; ");
    int peso2 = input.nextInt();

    System.out.print("Digite o peso3; ");
    int peso3 = input.nextInt();

    System.out.println("A média ponderada do aluno é: " + deci.format((((nota1 * peso1) + (nota2 * peso2) + (nota3 * peso3)) / (peso1 + peso2 + peso3))));

    input.close();

  }
  
}
