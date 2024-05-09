package Exercicios;
import java.util.Scanner;

public class Exercicio8 {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.print("Informe um número: ");
        int num = input.nextInt();

        if(num >= 50){
            System.out.println("O número " + num + " é maior ou igual a 50!");
        } else {
            System.out.println("O número " + num + " é menor que 50!");
        }

    }

}
