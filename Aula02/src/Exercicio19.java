import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio19 {

  public static void main(String[] agrs){

    Scanner input = new Scanner(System.in);
    DecimalFormat deci = new DecimalFormat("0.00");

    System.out.print("Digite o tempo total da viagem (hora): ");
    float t = input.nextFloat();

    System.out.print("Digite a velocidade média da viagem: ");
    int vm = input.nextInt();

    float distancia = vm * t;
    System.out.println("A quantidade de litros de combustível gasto na viagem é: " + deci.format(distancia / 12));

  }
  
}
