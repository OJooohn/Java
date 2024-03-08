import java.util.Scanner;

public class ExercicioA0313 {
  
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    int n, i;
    System.out.print("Informe o valor de n: ");
    n = input.nextInt();

    int[] vetor = new int[n];
    vetor[0] = 1;
    vetor[1] = 1;
    for(i = 2; i < n; i++){
      vetor[i] = vetor[i - 2] + vetor[i - 1];
    }

    System.out.println("N-ésimo número de fibonacci");
    for(i = 0; i < n; i++){
      System.out.print("[" + vetor[i] + "] ");
    }

  }

}
