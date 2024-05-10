import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  static float verificarPositivo(String texto){

    Scanner input = new Scanner(System.in);
    boolean verificar = false;
    float nota = 0;

    while(verificar == false){
      System.out.print(texto);
      nota = Float.parseFloat(input.nextLine());

      if(nota >= 0 && nota <= 10)
        verificar = true;
      else
        System.out.println("Nota invalida, tente novamente...");
    }

    return nota;
  }

  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    String matricula, nome;
    float nota1 = 0, nota2 = 0, nota3 = 0, nota4 = 0, nota5 = 0;
    int i;
    boolean valor = false;

    List<Aluno> turma = new ArrayList<Aluno>();

    for(i = 0; i < 2; i++){
      System.out.println("Cadastro aluno [" + (i + 1) + "]");

      System.out.print("Informe a matrícula: ");
      matricula = input.nextLine();

      System.out.print("Informe seu nome: ");
      nome = input.nextLine();

      nota1 = verificarPositivo("Digite a nota1: ");
      nota2 = verificarPositivo("Digite a nota2: ");
      nota3 = verificarPositivo("Digite a nota3: ");
      nota4 = verificarPositivo("Digite a nota4: ");
      nota5 = verificarPositivo("Digite a nota5: ");

      turma.add(new Aluno(matricula, nome, nota1, nota2, nota3, nota4, nota5));

    }

    i = 1;
    for(Aluno aluno : turma){
      System.out.println("Informaçoes Aluno [" + i + "]");
      aluno.Imprimir();
      i++;
    }

  }

}
