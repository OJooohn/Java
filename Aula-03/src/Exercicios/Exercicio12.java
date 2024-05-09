package Exercicios;
import java.util.Random;
import java.util.Scanner;

public class Exercicio12 {
  
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    Random rand = new Random();

    int[] vetor = new int[12];
    int i, resultado = 1;

    System.out.println("Preencha o vetor");
    for(i = 0; i < 12; i++){
      System.out.print("Digite o valor do indice [" + i + "]: ");
      vetor[i] = input.nextInt();
    }

    for(i = 0; i < 12; i++){
      if(vetor[i] > 0){
        if(vetor[i] % 2 == 0){
          resultado *= vetor[i];
        }
      }
    }

    System.out.println("Produto dos elementos = " + resultado);

  }

}
