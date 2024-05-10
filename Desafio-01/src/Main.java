import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    List<Aluno> turma = new ArrayList<Aluno>();

    String matricula, nome;
    float nota1, nota2;
    int i;

    Aluno[] alunos = new Aluno[5];

    for(i = 0; i < 5; i++) {
      System.out.println("Cadastro Aluno " + (i + 1));
      System.out.print("Informe a matrícula: ");
      matricula = input.nextLine();

      System.out.print("Informe seu nome: ");
      nome = input.nextLine();

      System.out.print("Informe a nota1: ");
      nota1 = Float.parseFloat(input.nextLine());
      
      System.out.print("Informe a nota2: ");
      nota2 = Float.parseFloat(input.nextLine());

      alunos[i].CadastroAluno(matricula, nome, nota1, nota2);

    }

    for(i = 0; i < 5; i++){
      alunos[i].calcularMedia(true);
    }

  }
}
