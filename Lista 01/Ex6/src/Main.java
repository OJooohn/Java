import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  static void novaAgenda(List<Agenda> agendas, Scanner input){
    System.out.println(">> Adicionar Agenda\n");

    boolean verificado = false;
    String nomeAgenda = "";

    while(verificado == false){
      System.out.print("Informe o nome da Agenda: ");
      nomeAgenda = input.nextLine();

      if(agendas.size() != 0){
        for(int i = 0; i < agendas.size(); i++){
          if(nomeAgenda.equals(agendas.get(i).getNomeAgenda())){
            System.out.println(">> Nome de agenda ja cadastrada! Digite novamente...\n\n");
            verificado = false;
            break;
          } else {
            verificado = true;
          }
        }
      } else {
        verificado = true;
      }
    }

    agendas.add(new Agenda(nomeAgenda));

  }

  static void selecionarAgenda(List<Agenda> agendas, Scanner input){

    System.out.println(">> Selecionar Agenda\n");

    boolean verificado = false;
    String nomeAgenda = "";
    int i = 0;

    while(verificado == false){
      System.out.print("Informe o nome da agenda: ");
      nomeAgenda = input.nextLine();

      if(agendas.size() == 0){
        System.out.println(">> Nenhuma agenda cadastrada!\n");
      } else {
        for(i = 0; i < agendas.size(); i++){
          if(nomeAgenda.equals(agendas.get(i).getNomeAgenda())){
            verificado = true;
            break;
          } else {
            verificado = false;
          }
        }
      }

      if(verificado == false)
        System.out.println(">> Agenda nao cadastrada! Digite novamente...\n\n");
    }

    menuAgenda(agendas, input, i);

  }

  static void novoContato(List<Agenda> agendas, Scanner input, int i){
    System.out.println(">> Novo Contato\n");
    
    System.out.print("Informe o nome do contato: ");
    String nome = input.nextLine();
    
    System.out.print("Informe o telefone do contato: ");
    String telefone = input.nextLine();
    
    agendas.get(i).novoContato(nome, telefone);
  }
  
  static void excluirContato(List<Agenda> agendas, Scanner input, int i){
    System.out.println(">> Excluir Contato\n");

    boolean verificado = false;
    int j = 0;
    String nome = "";

    while(verificado == false){
      System.out.print("Informe o nome do contato: ");
      nome = input.nextLine();

      for(j = 0; j < agendas.get(i).contatos.size(); j++){
        if(nome.equals(agendas.get(i).contatos.get(j).getNome())){
          verificado = true;
          break;
        } else {
          verificado = false;
        }
      }

      if(verificado == false){
        System.out.println(">> Nome nao registrado nos cadastros! Digite novamente...\n\n");
      }
    }

    verificado = false;
    while(verificado == false){
      System.out.println("\n>> Contato");
      System.out.println("Nome: " + agendas.get(i).contatos.get(j).getNome());
      System.out.println("Telefone: " + agendas.get(i).contatos.get(j).getTelefone());
      System.out.print("Deseja remover o contato? (S/N): ");
      String opcao = input.nextLine();
      opcao = opcao.toLowerCase();

      if(opcao.equals("s"))
        break;
      else 
        return;
    }

    agendas.get(i).excluirContato(j);

  }

  static void atualizarContato(List<Agenda> agendas, Scanner input, int i){
    System.out.println(">> Atualizar Contato\n");
    boolean verificado = false;
    int j = 0;
    String nome = "";

    while(verificado == false){
      System.out.print("Informe o nome do contato: ");
      nome = input.nextLine();

      for(j = 0; j < agendas.get(i).contatos.size(); j++){
        if(nome.equals(agendas.get(i).contatos.get(j).getNome())){
          verificado = true;
          break;
        } else {
          verificado = false;
        }
      }

      if(verificado == false){
        System.out.println(">> Nome nao registrado nos cadastros! Digite novamente...\n\n");
      }
    }

    System.out.print("Informe o novo número de telefone: ");
    String telefone = input.nextLine();
    agendas.get(i).contatos.get(j).novoTelefone(telefone);

  }

  static void listarContatos(List<Agenda> agendas, Scanner input, int i){
    System.out.println("\n\n>> Listar contatos | Agenda: " + agendas.get(i).getNomeAgenda() + "\n");
    System.out.println("\n==============================");

    for(int j = 0; j < agendas.get(i).contatos.size(); j++){
      System.out.println("Contato [" + (j + 1) + "]");
      System.out.println("Nome: " + agendas.get(i).contatos.get(j).getNome());
      System.out.println("Telefone: " + agendas.get(i).contatos.get(j).getTelefone());
      System.out.println("\n==============================");
    }

  }
  
  static void menuAgenda(List<Agenda> agendas, Scanner input, int i){
    boolean menu = true;
    String opcao = "";

    while(menu){
      System.out.println("\n\n>> Menu Agenda: " + agendas.get(i).getNomeAgenda());
      System.out.println("[0] Menu Incial");
      System.out.println("[1] Adicionar Contato");
      System.out.println("[2] Excluir Contato");
      System.out.println("[3] Atualizar Contato");
      System.out.println("[4] Listar Contatos");
      System.out.print(">> Opçao: ");
      opcao = input.nextLine();

      switch(opcao){
        case "0": return;

        case "1":  novoContato(agendas, input, i);
        break;

        case "2": excluirContato(agendas, input, i);
        break;

        case "3": atualizarContato(agendas, input, i);
        break;

        case "4": listarContatos(agendas, input, i);
        break;
      }
    }
  }
  
  public static void main(String[] args) {

    List<Agenda> agendas = new ArrayList<Agenda>();
    
    Scanner input = new Scanner(System.in);
    boolean menu = true;

    while(menu){
      System.out.println("\n\n[0] Finalizar programa");
      System.out.println("[1] Adicionar Agenda");
      System.out.println("[2] Selecionar Agenda");
      System.out.print(">> Opcao: ");
      String opcao = input.nextLine();

      switch(opcao){
        case "0": menu = false;
        break;

        case "1": novaAgenda(agendas, input);
        break;

        case "2": selecionarAgenda(agendas, input);
        break;

        default: System.out.println(">> Opçao inválida! Digite novamente...\n\n");
      }
    }

    input.close();

  }

}
