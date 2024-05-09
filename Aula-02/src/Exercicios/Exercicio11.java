package Exercicios;
import java.util.Scanner;

public class Exercicio11 {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        int a, b, c;
        System.out.print("Digite o valor da variável A: ");
        a = input.nextInt();
        System.out.print("Digite o valor da variável B: ");
        b = input.nextInt();
        System.out.print("Digite o valor da variável C: ");
        c = input.nextInt();

        int prim = a, seg = 0, ter = 0;
        if(b < prim){
            prim = b;
        } else if(c < prim){
            prim = c;
        }

        if(a > prim){
            seg = a;
        } else {
            seg = b;
            if(c < seg){
                seg = c;
            }
        }

        if(a > seg){
            ter = a;
        } else {
            if(b > seg){
                ter = b;
            } else {
                ter = c;
            }
        }

        System.out.println("Os números após a ordenação: " + prim + ", " + seg + ", " + ter);

        input.close();

    }

}
