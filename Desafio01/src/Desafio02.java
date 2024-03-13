import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Desafio02 {

  static void impressao(Object matricula, Object nome, Object nota1, Object nota2, Object notaFinal){
    System.out.println("matricula: " + matricula);
    System.out.println("Nome: " + nome);
    if((float)notaFinal >= 6){
      System.out.println("Aprovado: ( x ) Sim ( ) Não");
    } else {
      System.out.println("Aprovado: (  ) Sim ( x ) Não");
    }
    System.out.println("nota1: " + nota1);
    System.out.println("nota2: " + nota2);
    System.out.println("Nota final: " + notaFinal);
  }
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    List<Object[]> vetor = new ArrayList<>();
    
    int i = 0;

    while(i < 5){
      System.out.println("Digite as informaçoes do aluno " + (i + 1));

      System.out.println("Informe sua matrícula: ");
      String matricula = input.nextLine();
      
      System.out.print("Informe seu nome: ");
      String nome = input.nextLine();

      System.out.print("Informe a nota1: ");
      float nota1 = input.nextFloat();
      
      System.out.print("Informe a nota2: ");
      float nota2 = Float.parseFloat(input.nextLine());

      float mediaFinal = (nota1 + nota2) / 2;

      vetor.add(new Object[]{matricula, nome, nota1, nota2, mediaFinal});
      
      i++;
    }
    
    for(Object[] aluno : vetor){
      impressao(aluno[0], aluno[1], aluno[2], aluno[3], aluno[4]);
    }

  }


}
