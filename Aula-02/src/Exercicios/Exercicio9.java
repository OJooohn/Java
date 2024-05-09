package Exercicios;
import java.util.Scanner;

public class Exercicio9 {
    
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Informe o valor da variável A: ");
        int a = input.nextInt();
        
        System.out.print("Informe o valor da variável B: ");
        int b = input.nextInt();

        if(a != b){

            if(a > b){
                System.out.println("Os números são diferentes! E o número " + a + " é maior que o número " + b);
            } else {
                System.out.println("Os números são diferentes! E o número " + b + " é maior que o número " + a);
            }

        } else {
            System.out.println("Os números são iguais!");
        }

        input.close();

    }

}
