import java.util.Scanner;

public class Exercicio5 {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o valor da variável A: ");
        int a = input.nextInt();
        
        System.out.print("Digite o valor da variável A: ");
        int b = input.nextInt();
        
        int aux = a;
        a = b;
        b = aux;

        System.out.println("Valores após a troca | A: " + a + " B: " + b);
        
    }

}
