import java.util.Scanner;

public class Exercicio2 {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int num1 = input.nextInt();

        System.out.print("Digite o segundo número: ");
        int num2 = input.nextInt();

        if(num1 >= num2){
            System.out.println("O número " + num1 + " é maior do que o número " + num2 + "!");
        } else {
            System.out.println("O número " + num2 + " é maior do que o número " + num1 + "!");
        }

        System.err.println("E a soma dos dois números é igual a: " + (num1 + num2) + "!");

    }

}
