package Exercicios;
import java.util.Random;
import java.util.Scanner;

public class Exercicio08 {
  
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    Random rand = new Random();

    int[] vetorA = new int[5];
    int[] vetorB = new int[5];
    int[] vetorC = new int[10];
    int i;

    for(i = 0; i < 5; i++){
      vetorA[i] = rand.nextInt(50);
      vetorB[i] = rand.nextInt(50);
    }

    System.out.println("Vetor A");
    for(i = 0; i < 5; i++){
      System.out.print("[" + vetorA[i] + "] ");
    }

    System.out.println("\nVetor B");
    for(i = 0; i < 5; i++){
      System.out.print("[" + vetorB[i] + "] ");
    }

    System.out.println("\nVetor C");
    for(i = 0; i < 5; i++){
      vetorC[i] = vetorA[i];
      vetorC[i + 5] = vetorB[i];
    }

    for(i = 0; i < 10; i++){
      System.out.print("[" + vetorC[i] + "] ");
    }

  }

}
