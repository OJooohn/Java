import java.util.Scanner;

public class Aula_02 {

    public static void main(String[] args) throws Exception {
        /* Faça um Programa que verifique se uma 
            letra digitada é "F" ou "M". 
            Conforme a letra escrever: 
            F - Feminino, M - Masculino, Sexo Inválido.

            Voce escolheu M - Masculino 
            Voce escolheu F - Feminino
            Sexo Inválido
        */

        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite F ou M: ");
        String sexo = leitor.nextLine();

        /*
        if(sexo.equals("M")){
            System.out.println("Voce escolheu M - Masculino");
        } else if (sexo == "F"){
            System.out.println("Voce escolheu F - Feminino");
        } else {
            System.out.println("Sexo Inválido");
        } */

        switch (sexo) {
            case "F": System.out.println("Você é do sexo Feminino!");
            break;
            
            case "M": System.out.println("Você é do sexo Masculino!");
            break;
        
            default: System.out.println("Sexo Inválido");
            break;
        }

        leitor.close();
    }
}
