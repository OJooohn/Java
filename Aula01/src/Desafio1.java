import java.util.Scanner;

public class Desafio1 {

    public static void main(String[] args){

        Scanner leitor = new Scanner(System.in);

        System.out.println("Em que dia você nasceu? ");
        int dia = leitor.nextInt();

        leitor.nextLine();
        System.out.println("Em que mês você nasceu? ");
        String mes = leitor.nextLine();

        System.out.println("Em que ano você nasceu? ");
        int ano = leitor.nextInt();

        System.out.println("Você nasceu no dia " + dia + " de " + mes + " de " + ano + ", correto? ");

    }
    
}