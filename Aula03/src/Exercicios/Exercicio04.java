package Exercicios;
import java.util.Scanner;

public class Exercicio04 {
  
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    int[] vetor = new int[5];
    int var, i;

    System.out.print("Digite o valor da variavel: ");
    var = input.nextInt();

    for(i = 0; i < vetor.length; i++){
      System.out.print("Digite o valor do indice [" + (i + 1) + "]: ");
      vetor[i] = Integer.parseInt(input.nextLine());
    }

    for(i = 0; i < vetor.length; i++){
      if(vetor[i] < var){
        System.out.println("Indice [" + i + "] menor que [" + var + "]");
      }
    }

  }

}
