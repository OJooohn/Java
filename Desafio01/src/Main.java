import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    Aluno aluno1 = new Aluno();

    aluno1.matricula = "AL01";
    aluno1.nome = "José";
    aluno1.nota1 = 9.7f;
    aluno1.nota2 = 3.2f;

    Aluno aluno2 = new Aluno();

    aluno2.matricula = "AL02";
    aluno2.nome = "Maria";
    aluno2.nota1 = 3.7f;
    aluno2.nota2 = 7.89f;

    aluno1.calcularMedia(true);
    aluno2.calcularMedia(false);
    
  }
}
