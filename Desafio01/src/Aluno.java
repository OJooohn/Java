import java.util.ArrayList;

public class Aluno {

    String nome, matricula;
    float nota1, nota2, notaFinal;
    boolean aprovado;

   void calcularMedia(boolean mostrar){
    notaFinal = (nota1 + nota2) / 2;

    if(notaFinal >= 6){
      aprovado = true;
    } else {
      aprovado = false;
    }

    if(mostrar){
      System.out.println("Nome do Aluno: " + nome);
      System.out.println("Nota1: " + nota1);
      System.out.println("Nota2: " + nota2);
      System.out.println("Média do Aluno: " + notaFinal);
      if(aprovado){
        System.out.println("Status: Aprovado");
      } else {
        System.out.println("Status: Reprovado");
      }
    }

   }
  
}
