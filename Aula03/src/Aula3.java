import java.util.Scanner;

public class Aula3 {

    public static void main(String[] args){

        int[] numeros = new int[10];
        Scanner leitor = new Scanner(System.in);

        System.out.println("~ digite cinco números ~ ");


        for(int i = 0; i < numeros.length; i++){
           System.out.print("Numero (" + (i + 1) + "): ");
           numeros[i] = Integer.parseInt(leitor.nextLine());
        }

        int soma = 0;
        System.out.print("\n\nNumeros na lista: ");
        for(int i = 0; i < numeros.length; i++){
            soma += numeros[i];
            System.out.print(numeros[i] + " - ");
        }

        float media = soma / numeros.length;
        System.out.print("Media: " + media);


    }

}
