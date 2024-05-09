package Exercicios;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio14 {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    DecimalFormat deci = new DecimalFormat("0.00");

    int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
    // Raiz quadrada de 100 Math.sqrt(100)
    // Potencia 2 elevado 4 Math.pow(2, 4)
    
    System.out.print("Digite o valor de x1: ");
    x1 = input.nextInt();
    System.out.print("Digite o valor de y1: ");
    y1 = input.nextInt();
    System.out.print("Digite o valor de x2: ");
    x2 = input.nextInt();
    System.out.print("Digite o valor de y2: ");
    y2 = input.nextInt();
    double total = Math.sqrt(((Math.pow((x2 - x1), 2)) + Math.pow((y2 - y1), 2)));
    
    System.out.println("Raiz quadrada de 100 = " + deci.format(total));
    
  }
  
}
