import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex3 {

  static double TotalSalario(float salario, float vendas){

    return ((vendas * 0.15) + salario);

  }
  
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    float salario, vendas;
    String nome;

    System.out.print("Digite seu nome: ");
    nome = input.nextLine();

    System.out.print("Digite seu salário: ");
    salario = Float.parseFloat(input.nextLine());

    System.out.print("Digite o total de vendas em dinheiro: ");
    vendas = Float.parseFloat(input.nextLine());

    System.out.println("Salario total = R$ " + TotalSalario(salario, vendas));

  }

}
