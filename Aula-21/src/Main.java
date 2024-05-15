import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void limparTela(){
        System.out.println("\033c");
    }

    public static int adicionarFuncionario(Scanner sc, List<Funcionario> funcionarios){

        int opcao, matricula;
        String nome;

        do {
            limparTela();
            System.out.println("#   SELECIONAR FUNCIONÁRIO   #");
            System.out.println("[1] Gerente");
            System.out.println("[2] Desenvolvedor");
            System.out.println("[3] Estagiário");
            System.out.print("Selecione uma opção: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch(opcao){
                case 1:
                    System.out.print("Digite o nome: ");
                    nome = sc.nextLine();
                    System.out.print("Digite a matricula: ");
                    matricula = Integer.parseInt(sc.nextLine());
                    System.out.print("Digite o nome da equipe: ");
                    String equipe = sc.nextLine();
                    System.out.print("Digite o bônus anual: ");
                    float bonusAnual = Float.parseFloat(sc.nextLine());
                    funcionarios.add(new Gerente(nome, matricula, bonusAnual, equipe));
                    break;
                
                case 2:

                    break;

                case 3:

                    break;

                default: System.out.println("OPÇÃO INVÁLIDA! Digite novamente...");

            }
        } while(opcao != 4);
        
        return 0;
    }
    public static void main(String[] args) throws Exception {

        Scanner sc =new Scanner(System.in);

        List<Funcionario> funcionarios = new ArrayList<>();

        int opcao;

        do {
            System.out.print("\033c");
            System.out.println("#        MENU        ");
            System.out.println("[1] Adicionar funcionário");
            System.out.println("[2] Remover funcionário");
            System.out.println("[3] Listar funcionários");
            System.out.println("[4] Finalizar programa");
            System.out.print("Selecione uma opção: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch(opcao){
                case 1:
                    adicionarFuncionario(sc, funcionarios);
                    break;

                case 2:
                break;

                case 3:
                break;

                case 4:
                break;

                default: System.out.println("OPÇÃO INVÁLIDA! Digite novamente...");
            }

        } while(opcao != 4);

    }
}
