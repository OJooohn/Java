package Exercicios;
import java.util.Arrays;
import java.util.Scanner;

public class Exercicio03 {

  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    int tam, i;
    System.out.print("Digite o tamanho do vetor: ");
    tam = input.nextInt();

    int[] vetor1 = new int[tam];
    int[] vetor2 = new int[tam];

    for(i = 0; i < vetor1.length; i++){
      System.out.print("Digite o número do vetor[" + i + "]: ");
      vetor1[i] = input.nextInt();
      vetor2[i] = 2 * vetor1[i];
    }

    for(i = 0; i < vetor1.length; i++){
      System.out.print("[" + vetor2[i] + "] ");
    }

  }
  
}
