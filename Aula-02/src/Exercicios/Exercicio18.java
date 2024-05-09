package Exercicios;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio18 {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    DecimalFormat deci = new DecimalFormat("0.00");
    
    System.out.print("Digite o raio do cilindro: ");
    float raio = input.nextFloat();

    System.out.print("Digite a altura do cilindro: ");
    float altura = input.nextFloat();

    System.out.println("O volume total do cilindro é: " + deci.format(3.14 * (Math.pow(raio, 2)) * altura));

    input.close();

  }
  
}
