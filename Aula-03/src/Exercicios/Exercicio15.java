package Exercicios;
import java.util.Scanner;

public class Exercicio15 {
  
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    int[] vetor = new int[5];
    int i = 1;

    System.out.print("Digite o valor do indice [0]: ");
    vetor[0] = input.nextInt();

    while(i < 5){
      
      System.out.print("Digite o valor do indice [" + i + "]: ");
      vetor[i] = input.nextInt();

      if(vetor[i] > vetor[i - 1]){
        i++;
      }

    }

    System.out.println("Vetor finalizado");
    for(i = 0; i < 5; i++){
      System.out.print("[" + vetor[i] + "] ");
    }

  }

}
