import java.util.ArrayList;

public class Aluno {

    String nome, matricula;
    float nota1, nota2, notaFinal;
    boolean aprovado;

    void CadastroAluno(String mtr, String nm, float n1, float n2){
      matricula = mtr;
      nome = nm;
      nota1 = n1;
      nota2 = n2;
    }

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
