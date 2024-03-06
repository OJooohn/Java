import java.util.Scanner;

public class ExercicioA0304 {
  
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    int[] vetor = new int[5];
    int var, i;

    System.out.print("Digite o valor da variavel: ");
    var = input.nextInt();

    for(i = 0; i < vetor.length; i++){
      System.out.print("Digite o vlaor do indice [" + (i + 1) + "]: ");
      vetor[i] = input.nextInt();
    }

    for(i = 0; i < vetor.length; i++){
      if(vetor[i] < var){
        System.out.println("Indice [" + i + "] menor que [" + var + "]");
      }
    }

  }

}
