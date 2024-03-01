import java.util.Scanner;

public class Exercicio4 {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int num1 = input.nextInt();
        
        System.out.print("Digite o segundo número: ");
        int num2 = input.nextInt();

        int soma = num1 + num2;
        int sub = num1 - num2;
        int mult = num1 * num2;
        int div = num1 / num2;

        System.out.println("Soma dos números: " + soma);
        System.out.println("Subtração dos números: " + sub);
        System.out.println("Multiplicação dos números: " + mult);
        System.out.println("Divisão dos números: " + div);

    }

}
