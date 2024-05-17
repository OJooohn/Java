import java.util.Scanner;

public class Main {

    public static void pressToContinue(Scanner sc){
        System.out.println("Press any key to continue...");
        sc.nextLine();
    }

    public static String getInputNome(Scanner sc){
        System.out.print("Digite o nome: ");
        return sc.nextLine();
    }

    public static String getInputNumero(Scanner sc){
        System.out.print("Digite o número: ");
        return sc.nextLine();
    }

    public static void adicionarContato(Scanner sc, AgendaTelefonica agenda){

        boolean contatoAdicionado = false;
        int opcao;
        String nome, numero;

        do{
            System.out.print("\033c");
            System.out.println("#   ADICIONAR CONTATO   #");
            System.out.println("[1] Contato Profissional");
            System.out.println("[2] Contato Pessoal");
            System.out.println("[3] Voltar");
            System.out.print("Selecione uma opção: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch(opcao){
                case 1:
                    nome = getInputNome(sc);
                    numero = getInputNumero(sc);
                    System.out.print("Digite o email: ");
                    String email = sc.nextLine();
                    agenda.adicionar(opcao, nome, numero, email, "");
                    contatoAdicionado = true;
                    break;
                
                case 2:
                    nome = getInputNome(sc);
                    numero = getInputNumero(sc);
                    System.out.print("Digite a data de nascimento: ");
                    String dataNascimento = sc.nextLine();
                    agenda.adicionar(opcao, nome, numero, "", dataNascimento);
                    contatoAdicionado = true;
                    break;
                
                case 3:
                    return;

                default:
                    System.out.println("Opção inválida! Digite novamente...");
                    pressToContinue(sc);
            }
        }while(!contatoAdicionado);
    }

    public static void removerContato(Scanner sc, AgendaTelefonica agenda){
        
        while(true){
            System.out.print("\033c");
            System.out.println("#      REMOVER CONTATO      #");
            System.out.print("Digite o número do contato: ");
            String numero = sc.nextLine();
            int contato = agenda.buscar(numero);
            if(contato == -1){
                System.out.println("Contato não cadastrado!");
                pressToContinue(sc);
            } else {
                agenda.remover(contato);
                System.out.println("Contato removido!");
                pressToContinue(sc);
                return;
            }
        }
    }

    public static void buscarContato(Scanner sc, AgendaTelefonica agenda){

        while(true){
            System.out.print("\033c");
            System.out.println("#      BUSCAR CONTATO      #");
            System.out.print("Digite o número do contato: ");
            String numero = sc.nextLine();
            int contato = agenda.buscar(numero);
            if(contato == -1){
                System.out.println("Contato não cadastrado!");
                pressToContinue(sc);
            } else {
                agenda.listar(false, contato);
                pressToContinue(sc);
                return;
            }
        }
    }

    public static void main(String[] args){
        
        AgendaTelefonica agenda = new AgendaTelefonica();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do{
            System.out.print("\033c");
            System.out.println("#      MENU      #");
            System.out.println("[1] Adicionar contato");
            System.out.println("[2] Remover contato");
            System.out.println("[3] Listar contatos");
            System.out.println("[4] Buscar contato");
            System.out.println("[5] Finalizar programa");
            System.out.print("Selecione uma opção: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch(opcao){
                case 1:
                    adicionarContato(sc, agenda);
                    break;

                case 2:
                    removerContato(sc, agenda);
                    break;
                
                case 3:
                    agenda.listar(true, 0);
                    pressToContinue(sc);
                    break;

                case 4:
                    buscarContato(sc, agenda);
                    break;
                
                case 5:
                    System.out.println(">> Saindo...");
                    break;
                
                default:
                    System.out.println("Opção inválida! Digite novamente...");
                    pressToContinue(sc);
            }
        }while(opcao != 5);

        sc.close();

    }
}
