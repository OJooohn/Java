package Exercicios;
import java.util.Scanner;

public class Exercicio05 {
  
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    int[] vetor = new int[5];
    int i, n, quant = 0;

    for(i = 0; i < vetor.length; i++){
      System.out.print("Digite o valor do indice [" + (i + 1) + "]: ");
      vetor[i] = input.nextInt();
    }

    System.out.print("Digite o valor de n: ");
    n = input.nextInt();

    for(i = 0; i < vetor.length; i++){
      if(vetor[i] == n){
        quant++;
      }
    }

    System.out.println("Número de vezes que o número [" + n + "] aparece no vetor: " + quant);

  }

}
