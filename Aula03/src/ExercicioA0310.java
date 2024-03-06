import java.util.Scanner;

public class ExercicioA0310 {
  
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    int[] vetorA = new int[5];
    int[] vetorB = new int[5];
    int i, aux = 0;

    System.out.println("Preencha o vetor A");
    for(i = 0; i < 5; i++){
      System.out.print("Digite o valor do indice [" + i + "]: ");
      vetorA[i] = input.nextInt();
    }
    System.out.println("Preencha o vetor B");
    for(i = 0; i < 5; i++){
      System.out.print("Digite o valor do indice [" + i + "]: ");
      vetorB[i] = input.nextInt();
    }

    for(i = 0; i < 5; i++){
      aux = vetorA[i];
      vetorA[i] = vetorB[4 - i];
      vetorB[4 - i] = aux;
    }
    
    System.out.println("Vetor A após a troca");
    for(i = 0; i < 5; i++){
      System.out.print("[" + vetorA[i] + "] ");
    }
    System.out.println("\nVetor B após a troca");
    for(i = 0; i < 5; i++){
      System.out.print("[" + vetorB[i] + "] ");
    }

  }

}
