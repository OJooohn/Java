package Exercicios;
import java.util.Scanner;

public class Exercicio3 {
    
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int num1 = input.nextInt();

        System.out.print("Digite o segundo número: ");
        int num2 = input.nextInt();

        if(num1 == num2){
            System.out.println("Sequência de números inválida");
        } else if(num1 > num2){
            System.out.println("O número " + num1 + " é maior que o número " + num2);
        } else {
            System.out.println("O número " + num2 + " é maior que o número " + num1);
        }

        input.close();

    }

}
