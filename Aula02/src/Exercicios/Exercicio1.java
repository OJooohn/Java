package Exercicios;
import java.util.Scanner;

public class Exercicio1 {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int num = input.nextInt();

        if(num <= 10){
            System.out.println("Número menor ou igual a 10!");
        } else {
            System.out.println("Número maior do que 10!");
        }

    }

}
