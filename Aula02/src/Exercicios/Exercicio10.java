package Exercicios;
import java.util.Scanner;

public class Exercicio10 {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        boolean condicao = false;
        int num = 0;

        while(condicao == false) {
            System.out.print("Digite um número de 1 a 5: ");
            num = input.nextInt();
            
            if(num > 0 && num < 6) {
                condicao = true;
            }
        }
        
        switch(num) {
            case 1: System.out.println("Um");
            break;
            case 2: System.out.println("Dois");
            break;
            case 3: System.out.println("Três");
            break;
            case 4: System.out.println("Quatro");
            break;
            case 5: System.out.println("Cinco");
            break;
        }


    }

}
