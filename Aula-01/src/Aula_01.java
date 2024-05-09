import java.util.Scanner;

public class Aula_01 {
    public static void main(String[] args){

        /* int numero = 8;
        float numero_real = 10.3f;
        String frase = "legal";
        char caracter = 'c';
        boolean verdadeiro = false;

        float soma = numero + numero_real;
        System.out.println("A soma de " + numero + " + " + numero_real + " é " + soma);
        */

        /* DESAFIO 1 */
        Scanner leitor = new Scanner(System.in);

        System.out.print("Olá, qual é o seu nome? ");
        String nome = leitor.nextLine();

        System.out.println("Legal, sejam bem vindo(a) " + nome + "!");
        
        System.out.print("Em que ano vc nasceu? ");
        int ano = Integer.parseInt(leitor.nextLine());
        int idade = 2024 - ano;
        
        System.out.println("Sera que vc tem " +  idade + "anos entao?");
        
        /* DESAFIO 2 */
        
        /* Qual seu nome?
         * - resposta
         * 
         * Bem vindo __
         * Em que ano vc nasceu?
         * - resposta
         * conta
         * Que legal, então vc deve ter X anos... isso?
         */

         System.out.print("Bem vindo! Qual o seu nome? ");
         String name = leitor.nextLine();

         System.out.println("Legal, seja bem vindo(a) " + name + "!");

         System.out.print("Em que ano você nasceu? ");
         int year = Integer.parseInt(leitor.nextLine());
         
         System.out.println("Que legal, então você deve ter " + (2024 - year) + " anos então?");

         leitor.close();

    }
}