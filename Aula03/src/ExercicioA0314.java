import java.util.Scanner;

public class ExercicioA0314 {
  
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    int[] vetor = new int[5];
    int i, maior, indice = 0;

    System.out.println("Preencha o vetor");
    for(i = 0; i < 5; i++){
      System.out.print("Digite o valor do indice [" + i + "]: ");
      vetor[i] = input.nextInt();
    }

    maior = vetor[0];
    for(i = 1; i < 5; i++){
      if(vetor[i] > maior){
        maior = vetor[i];
        indice = i;
      }
    }

    vetor[indice] = vetor[4];
    vetor[4] = maior;
    
    System.out.println("Vetor atualizado");
    for(i = 0; i < 5; i++){
      System.out.print("[" + vetor[i] + "] ");
    }

  }

}
