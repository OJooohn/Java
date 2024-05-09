package Exercicios;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio02 {
  
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    DecimalFormat deci = new DecimalFormat("0.00");

    int tam, i;
    System.out.print("Digite um número: ");
    tam = input.nextInt();

    int[] vetor = new int[tam];

    for(i = 0; i < vetor.length; i++){
      System.out.print("Digite o número[" + (i + 1) + "]: ");
      vetor[i] = input.nextInt();
    }

    System.out.println("Vetor de números:");
    for(i = 0; i < vetor.length; i++){
      System.out.print("Posiçao [" + i + "] -> " + vetor[i]);
      if(vetor[i] == 0){
        System.out.println(" | Zero");
      } else if(vetor[i] > 0){
        System.out.println(" | Positivo");
      } else {
        System.out.println(" | Negativo");
      }
      
    }

  }

}
