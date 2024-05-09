package Exercicios;
import java.util.Scanner;

public class Ex1 {

  static float Media(float nota1, float nota2, float nota3){

    return (nota1 + nota2 + nota3) / 3;

  }
  
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    float nota1, nota2, nota3;

    System.out.print("Digite a nota1: ");
    nota1 = Float.parseFloat(input.nextLine());

    System.out.print("Digite a nota2: ");
    nota2 = Float.parseFloat(input.nextLine());

    System.out.print("Digite a nota3: ");
    nota3 = Float.parseFloat(input.nextLine());

    System.out.println("Média aritmética final do aluno = " + Media(nota1, nota2, nota3));

    input.close();

  }

}
