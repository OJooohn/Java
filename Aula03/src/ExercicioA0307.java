import java.util.Scanner;

public class ExercicioA0307 {
 
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    int[] vetor1 = new int[5];
    int[] vetor2 = new int[5];
    int i, count = 0;

    System.out.println("Preencha o primeiro vetor");
    for(i = 0; i < 5; i++){
      System.out.print("Digite o valor do indíce [" + i + "]: ");
      vetor1[i] = input.nextInt();
    }

    System.out.println("Preencha o segundo vetor");
    for(i = 0; i < 5; i++){
      System.out.print("Digite o valor do indíce [" + i + "]: ");
      vetor2[i] = input.nextInt();
    }

    for(i = 0; i < 5; i++){
      if(vetor1[i] == vetor2[i]){
        count++;
      }
    }

    if(count != 5){
      System.out.println("Os vetores não são iguais!");
    } else {
      System.out.println("Os vetores são iguais!");
    }

  }

}
