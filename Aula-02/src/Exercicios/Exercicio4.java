package Exercicios;
import java.util.Scanner;

public class Exercicio4 {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        float num1 = input.nextInt();
        
        System.out.print("Digite o segundo número: ");
        float num2 = input.nextInt();

        System.out.println("Soma dos números: " + (num1 + num2));
        System.out.println("Subtração dos números: " + (num1 - num2));
        System.out.println("Multiplicação dos números: " + (num1 * num2));
        System.out.println("Divisão dos números: " + (num1 / num2));

        input.close();

    }
}