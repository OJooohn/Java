package Exercicios;
import java.util.Scanner;

public class Exercicio09 {
  
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    int[] vetorA = new int[5];
    int[] vetorB = new int[5];
    int[] vetorC = new int[5];
    int i;

    // 0,2,4
    System.out.println("Preencha o vetor A:");
    for(i = 0; i < 5; i++){
      System.out.print("Digite o valor de indice [" + i + "]: ");
      vetorA[i] = input.nextInt();
    }

    //1,3
    System.out.println("Preencha o vetor B:");
    for(i = 0; i < 5; i++){
      System.out.print("Digite o valor de indice [" + i + "]: ");
      vetorB[i] = input.nextInt();
    }

    for(i = 0; i < 5; i++){
      if(i % 2 == 0){
        vetorC[i] = vetorA[i];
      } else {
        vetorC[i] = vetorB[i];
      }
    }

    System.out.println("Vetor C:");
    for(i = 0; i < 5; i++){
      System.out.print("[" + vetorC[i] + "] ");
    }

  }

}
