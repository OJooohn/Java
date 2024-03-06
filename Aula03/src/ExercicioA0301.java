import java.util.Scanner;

public class ExercicioA0301 {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    //int[] arrayOfInts = new int[42];
    //int[] primes = {2,3,5,7, 7+4};
    // .lenght -> retorna tamanho

    int[] numeros = new int[5];
    int i = 0, soma = 0;

    for(i = 0; i < numeros.length; i++){
      System.out.print("Digite o número [" + (i+1) + "]: ");
      numeros[i] = Integer.parseInt(input.nextLine());
      soma += numeros[i];
    }

    System.out.println("Números da lista: ");
    for(i = 0; i < numeros.length; i++){
      System.out.print("[" + numeros[i] + "] ");
    }
    System.out.println("\nMédia: " + (soma / 5));

  }
  
}
