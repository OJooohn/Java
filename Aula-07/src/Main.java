import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner leitor = new Scanner(System.in);
        List<Aluno> turma = new ArrayList<Aluno>();
        
        for(int i = 0; i < 2; i++){
            System.out.print("\n\n");
            Aluno umAluno = new Aluno();

            System.out.print("Matricula: ");
            umAluno.matricula = leitor.nextLine();

            System.out.print("Nome: ");
            umAluno.nome = leitor.nextLine();

            System.out.print("Quantas notas quer digitar? ");
            int qtd_notas = Integer.parseInt(leitor.nextLine());

            for (int j = 0; j < qtd_notas; j++) {
                System.out.print("-- Nota (" + j + "): ");
                float novaNota = Float.parseFloat(leitor.nextLine());
                umAluno.notas.add(novaNota);
            }
            
            turma.add(umAluno);
            // turma.add(new Aluno(matricula, nome, nota1, nota2));
        }
        

        // mostrar alunos
        for (int i = 0; i < turma.size(); i++) {
            turma.get(i).mostrar();
        }

        leitor.close();

    }

}
