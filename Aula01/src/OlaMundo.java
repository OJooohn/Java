import java.util.Scanner;

public class OlaMundo {

  public static void main(String[] args){ 

        /*int numero = 8;
        float numero_real = 10.3f;
        String frase = "legal";
        char caracter = 'c';
        boolean verdadeiro = false;

        float soma = numero + numero_real;

        System.out.println("Olá Mundo!" + numero);
        System.out.println("A soma de " + numero + " + " + numero_real + " é " + soma);*/
        
        Scanner leitor = new Scanner(System.in);

        System.out.print("Olá, qual é seu nome? ");
        String nome = leitor.nextLine();

        System.out.println("Legal, seja bem vindo " + nome + "!");

        /* Em que ano vc nasceu?
         * resposta
         * conta
         * Sera que vc tem X anos então?
         */

        System.out.print("Em que ano você nasceu? ");
        int ano = leitor.nextInt();

        int idade = 2024 - ano;

        System.out.println("Será que vc tem " + idade + " anos então?");
    }
  
}
