import java.util.Scanner;

public class Exercicio12 {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int mes = 0;
        boolean condicao = false;

        while(condicao == false) {
            
            System.out.print("Informe o número de um mês: ");
            mes = input.nextInt();

            if(mes < 0 || mes > 12){
                System.out.println("Número de mês inválido!");
                System.out.println("Digite novamente...");
            } else {
                condicao = true;
            }

        }

        switch(mes) {
            case 1: System.out.println("Janeiro");
            break;
            case 2: System.out.println("Feveiro");
            break;
            case 3: System.out.println("Março");
            break;
            case 4: System.out.println("Abril");
            break;
            case 5: System.out.println("Maio");
            break;
            case 6: System.out.println("Junho");
            break;
            case 7: System.out.println("Julho");
            break;
            case 8: System.out.println("Agosto");
            break;
            case 9: System.out.println("Setembro");
            break;
            case 10: System.out.println("Outubro");
            break;
            case 11: System.out.println("Novembro");
            break;
            case 12: System.out.println("Dezembro");
            break;
        }



    }

}
