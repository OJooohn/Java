import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.println("-- INICO MAIN --");

        try {
            // System.out.print("Digite um número: ");
            // String str = scan.nextLine();
            // int str = scan.nextInt();
            // int num = Integer.parseInt(scan.nextLine());
            
            Tabuleiro.jogar();
            // NumberFormatException
            // java.lang.IndexOutOfBoundsException
        }catch(Exception e){
            // System.out.println(e);
            e.printStackTrace();
        }

        System.out.println("-- FIM MAIN --");

    }


}
