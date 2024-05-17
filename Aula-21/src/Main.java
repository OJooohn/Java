import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void limparTela(){
        System.out.println("\033c");
    }

    public static String getInputNome(Scanner sc){
        System.out.print("Digite o nome: ");
        return sc.nextLine();
    }

    public static int getInputMatricula(Scanner sc){
        System.out.print("Digite a matricula: ");
        return Integer.parseInt(sc.nextLine());
    }

    public static void adicionarFuncionario(Scanner sc, List<Funcionario> funcionarios){

        boolean cadastroCompleto = false;
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
                    nome = getInputNome(sc);
                    matricula = getInputMatricula(sc);
                    System.out.print("Digite o nome da equipe: ");
                    String equipe = sc.nextLine();
                    System.out.print("Digite o bônus anual: ");
                    float bonusAnual = Float.parseFloat(sc.nextLine());
                    funcionarios.add(new Gerente(nome, matricula, bonusAnual, equipe));
                    cadastroCompleto = true;
                    break;
                
                case 2:
                    nome = getInputNome(sc);
                    matricula = getInputMatricula(sc);
                    Desenvolvedor novoDesenvolvedor = new Desenvolvedor(nome, matricula);
                    String tecnologia;
                    do{
                        System.out.println("[0] Para concluir cadastro");
                        System.out.print("Digite a tecnologia: ");
                        tecnologia = sc.nextLine();
                        if(tecnologia.equals("0"))
                            break;
                        novoDesenvolvedor.adicionarTecnologia(tecnologia);
                    }while(!tecnologia.equals("0"));
                    funcionarios.add(novoDesenvolvedor);
                    cadastroCompleto = true;
                    break;

                case 3:
                    nome = getInputNome(sc);
                    matricula = getInputMatricula(sc);
                    System.out.print("Digite a quantidade de horas trabalhadas: ");
                    int horasTrabalhadas = Integer.parseInt(sc.nextLine());
                    System.out.print("Digite o nome do supervisor: ");
                    String supervisor = sc.nextLine();
                    funcionarios.add(new Estagiario(nome, matricula, horasTrabalhadas, supervisor));
                    cadastroCompleto = true;
                    break;

                default: System.out.println("OPÇÃO INVÁLIDA! Digite novamente...");

            }
        } while(!cadastroCompleto);
    }

    public static void removerFuncionario(Scanner sc, List<Funcionario> funcionarios){

        boolean funcionarioExistente = false;
        int matriculaDigitada;

        while(!funcionarioExistente){
            System.out.println("#   REMOVER FUNCIONÁRIO   #");
            System.out.print("Digite a matrícula remover: ");
            matriculaDigitada = Integer.parseInt(sc.nextLine());

            for(Funcionario f : funcionarios){
                if(matriculaDigitada == f.getMatricula()){
                    funcionarios.remove(f);
                    System.out.println("Funcionário removida");
                    return;
                }
            }

            System.out.println("Funionário não cadastrado! Digite novamente...");
        }

    }

    public static void listarFuncionarios(List<Funcionario> funcionarios){
        for(Funcionario f : funcionarios){
            System.out.println("=====================================");
            System.out.println(f);
        }
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
                    removerFuncionario(sc, funcionarios);
                    break;

                case 3:
                    listarFuncionarios(funcionarios);
                break;

                case 4:
                break;

                default: System.out.println("OPÇÃO INVÁLIDA! Digite novamente...");
            }

        } while(opcao != 4);

    }
}
