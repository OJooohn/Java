import java.util.Scanner;

public class Desafio {

  static String Media(float nota1, float nota2){

    if(((nota1 + nota2) / 2) > 6){
      return "aprovado";
    } else {
      return "reprovado";
    }

  }
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    int matricula;
    float nota1, nota2;
    String nome;

    System.out.print("Informe sua matrícula: ");
    matricula = Integer.parseInt(input.nextLine());

    System.out.print("Informe seu nome: ");
    nome = input.nextLine();

    System.out.print("Informe a nota1: ");
    nota1 = Float.parseFloat(input.nextLine());

    System.out.print("Infotme a nota2: ");
    nota2 = Float.parseFloat(input.nextLine());

    System.out.println("Aluno: " + nome);
    System.out.println("Matrícula: " + matricula);
    System.out.println("Média final: " + ((nota1 + nota2) / 2));
    System.out.println("Aluno está " + Media(nota1, nota2));

  }
}
