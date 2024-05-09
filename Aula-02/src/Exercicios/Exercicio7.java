package Exercicios;
import java.util.Scanner;

public class Exercicio7 {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.print("Informe um número: ");
        int num = input.nextInt();

        if(num > 100 && num < 200){
            System.out.println("O número " + num + " está no intervalo entre 100 e 200!");
        } else {
            System.out.println("O número " + num + " não está no intervalo entre 100 e 200!");
        }

        input.close();
    }

}
