import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        List<Aluno> turma = new ArrayList<Aluno>();

        Aluno aluno1 = new Aluno("AL01", "José", 9.7f, 3.2f);
        Aluno aluno2 = new Aluno("AL02", "Maria", 3.7f, 7.89f);

        aluno1.calcularMedia(false);
        aluno2.calcularMedia(true);

        turma.add(aluno1);
        turma.add(aluno2);

    }

}
