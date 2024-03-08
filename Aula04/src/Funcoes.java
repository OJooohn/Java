import java.util.Arrays;
import java.util.Scanner;

public class Funcoes {
  
  static int LerNumero(String texto){
    Scanner input = new Scanner(System.in);

    System.out.print(texto);
    int num = Integer.parseInt(input.nextLine());

    return num;
  }

  static int Somar(int[] numeros, boolean mostrar){

    int soma = 0;

    for(int i = 0; i < numeros.length; i++){
      soma += numeros[i];
    }

    if(mostrar){
      System.out.println("A soma do array " + Arrays.toString(numeros) + "  " + soma);
    }

    return soma;

  }

  static void maior(int[] numeros, boolean mostrar){
    int maior = numeros[0];

    for(int i = 0; i < numeros.length; i++){
      if(numeros[i] > maior){
        maior = numeros[i];
      }
    }
  }

  public static void main(String[] args) {
    
    int[] numeros = new int[2];
    numeros[0] = LerNumero("Digite um número: ");
    numeros[1] = LerNumero("Digite outro número: ");
    Somar(numeros, true);


  }

}
