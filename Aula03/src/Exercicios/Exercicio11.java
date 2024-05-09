package Exercicios;
import java.util.Random;
import java.util.Scanner;

public class Exercicio11 {
  
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    Random rand = new Random();

    int[] vetorA = new int[5];
    int[] vetorB = new int[5];
    int i, resultado = 0;

    for(i = 0; i < 5; i++){
      vetorA[i] = rand.nextInt(10);
      vetorB[i] = rand.nextInt(10);
    }

    for(i = 0; i < 5; i++){
      resultado += (vetorA[i] * vetorB[i]);
    }

    System.out.println("Vetor A");
    for(i = 0; i < 5; i++){
      System.out.print("[" + vetorA[i] + "]: ");
    }
    System.out.println("\nVetor B");
    for(i = 0; i < 5; i++){
      System.out.print("[" + vetorB[i] + "]: ");
    }
    System.out.println("Produto Escalar = " + resultado);

  }

}
