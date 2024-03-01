import java.util.Scanner;

public class Exercicio6 {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.print("Digite a temperatura em °C: ");
        int celsius = input.nextInt();

        int fahrenheit = (9 * celsius + 160) / 5;
        
        System.out.println("Temperatura em Fahrenheit: " + fahrenheit);

    }

}
