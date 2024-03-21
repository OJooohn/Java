import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

      Scanner input = new Scanner(System.in);

      List<Aluno> turma = new ArrayList<Aluno>();
      int i;

      for(i = 0; i < 2; i++){
        System.out.print("\n");
        Aluno umAluno = new Aluno();

        System.out.print("Digite a matricula: ");
        umAluno.matricula = input.nextLine();
  
        System.out.print("Digite a nome: ");
        umAluno.nome = input.nextLine();
  
        System.out.print("Quantas ntoas quer digitar?  ");
        int qtd_notas = Integer.parseInt(input.nextLine());


        for(int j = 0; j < qtd_notas; j++){
          System.out.print("-- Nota (" + j + "): ");
          float novaNota = Float.parseFloat(input.nextLine());
          umAluno.notas.add(novaNota);
        }

        turma.add(umAluno);
      }

      //Mostrar alunos
      for(i = 0; i < turma.size(); i++){
        turma.get(i).mostrar();
      }

    }
}
