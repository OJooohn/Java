import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main {
  
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    boolean menu = true;
    int op = 0;

    Deque<String> aluno = new ArrayDeque<>();

    while(menu){
      System.out.println("[1] Entrar na fila");
      System.out.println("[2] Sair da fila");
      System.out.println("[3] Mostrar fila");
      System.out.println("[4] Sair");
      System.out.print("Opcao: ");
      op = Integer.parseInt(input.nextLine());

      String nome;

      switch(op){
        case 1:
          System.out.print("Informe seu nome: ");
          nome = input.nextLine();
          aluno.add(nome);
          break;
          
        case 2:
          aluno.removeFirst(); 
          System.out.print(">> Aluno saiu da fila!\n\n");
        break;

        case 3:
        System.out.println("Fila impressa:");
          System.out.println(aluno);
        break;

        case 4: menu = false;
        break;

        default: System.out.println(">> Opcao inválida! Digite novamente...\n\n");
        break;
      }
    }

    input.close();

  }

}
