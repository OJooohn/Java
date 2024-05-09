import java.util.Scanner;

public class Aula02 {

    public static void main(String[] args) {
    
        /* Faça um Programa que verifique se uma 
            letra digitada é "F" ou "M". 
            Conforme a letra escrever: 
            F - Feminino, M - Masculino, Sexo Inválido.

            Voce escolheu M - Masculino 
            Voce escolheu F - Feminino
            Sexo Inválido
        */

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o seu sexo: ");
        String sexo = sc.nextLine();

        switch (sexo) {
            case "F": System.out.println("Você é do sexo Feminino!");
            break;

            case "M": System.out.println("Você é do sexo Masculino!");
            break;

            default: System.out.println("Sexo inválido!");
            break;
        }

        sc.close();
        
    }

}