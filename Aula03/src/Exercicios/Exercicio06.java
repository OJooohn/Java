package Exercicios;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio06 {

  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    DecimalFormat deci = new DecimalFormat("0.00");

    float[] notas = new float[3];
    int[] pesos = new int[3];
    int i = 0;
    
    for(i = 0; i < 3; i++){
      System.out.println("Digite a nota" + (i + 1) + ": ");
      notas[i] = input.nextFloat();
    }

    for(i = 0; i < 3; i++){
      System.out.print("Digite o peso" + (i + 1) + ": ");
      pesos[i] = input.nextInt();
    }

    float media = ((notas[0] * pesos[0]) + (notas[1] * pesos[1]) + (notas[2] * pesos[2])) / (pesos[0] + pesos[1] + pesos[2]);

    System.out.println("Média ponderada final do aluno: " + deci.format(media));

  }
  
}
