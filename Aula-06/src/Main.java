import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner leitor = new Scanner(System.in);
        List<Aluno> turma = new ArrayList<Aluno>();
        
        Aluno novoAluno = new Aluno();
        novoAluno.matricula = leitor.nextLine();
        novoAluno.nome = leitor.nextLine();

        novoAluno.setNota1(7.3f);

        System.out.println(novoAluno.getNota1());

        turma.add(novoAluno);

        leitor.close();

    }

}
