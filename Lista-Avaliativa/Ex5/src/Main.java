import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  static void acelerar(List<Carro> carros, Scanner input){
    
    int i = 0;
    boolean verificado = false;
    
    while(verificado == false){
      System.out.print(">> Informe a placa do veiculo para acelerar: ");
      String placa = input.nextLine();

      for(i = 0; i < carros.size(); i++){
        if(placa.equals(carros.get(i).getPlaca())){
          verificado = true;
          break;
        } else {
          verificado = false;
        }
      }

      if(verificado == false){
        System.err.println(">> Carro com placa nao cadastrada! Digite novamente...\n\n");
      }

    }

    carros.get(i).acelerar();

  }

  static void frear(List<Carro> carros, Scanner input){
    int i = 0;
    boolean verificado = false;
    
    while(verificado == false){
      System.out.print(">> Informe a placa do veiculo para acelerar: ");
      String placa = input.nextLine();

      for(i = 0; i < carros.size(); i++){
        if(placa.equals(carros.get(i).getPlaca())){
          verificado = true;
          break;
        } else {
          verificado = false;
        }
      }

      if(verificado == false){
        System.err.println(">> Carro com placa nao cadastrada! Digite novamente...\n\n");
      }

    }

    carros.get(i).frear();
  }

  static String verificarPlaca(List<Carro> carros, Scanner input){

    boolean verificado = false;
    int i;
    String placa = "";

    while(verificado == false){
      System.out.print(">> Informe a placa do carro: ");
      placa = input.nextLine();

      if(carros.size() != 0){
        for(i = 0; i < carros.size(); i++){
          if(placa.equals(carros.get(i).getPlaca())){
            System.out.println(">> Placa já cadastrada! Digite novamente...");
            break;
          } else {
            verificado = true;
          }
        }
      } else {
        verificado = true;
      }
    }

    return placa;

  }

  static void cadastrar(List<Carro> carros, Scanner input){
    System.out.println("\nCadastrar Carro\n");

    String placa = verificarPlaca(carros, input);

    System.out.print(">> Informe a marca do carro: ");
    String marca = input.nextLine();

    System.out.print(">> Informe o modelo do carro: ");
    String modelo = input.nextLine();

    System.out.print(">> Informe o ano do carro: ");
    int ano = Integer.parseInt(input.nextLine());

    carros.add(new Carro(marca, modelo, ano, placa));
  }

  static void listar(List<Carro> carros, Scanner input){
    
    String placa;
    int i = 0;
    boolean verificado = false;
    
    while(verificado == false){
      System.out.print(">> Informe a placa do carro: ");
      placa = input.nextLine();

      for(i = 0; i < carros.size(); i++){
        if(placa.equals(carros.get(i).getPlaca())){
          verificado = true;
          break;
        } else {
          System.out.println(">> Carro nao cadastrado! Digite novamente...\n\n");
          verificado = false;
        }
      }
    }

    carros.get(i).listar();

    
  }
  
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    List<Carro> carros = new ArrayList<Carro>();
    boolean menu = true;
    String opcao = "-1";

    while(menu){
      System.out.println("[0] Finalizar programa");
      System.out.println("[1] Cadastrar novo carro");
      System.out.println("[2] Listar carros");
      System.out.println("[3] Acelerar");
      System.out.println("[4] Frear");
      System.out.print(">> Opcao: ");
      opcao = input.nextLine();

      switch(opcao){
        case "0": menu = false;
        break;

        case "1": cadastrar(carros, input);
        break;

        case "2": listar(carros, input);
        break;

        case "3": acelerar(carros, input);
        break;

        case "4": frear(carros, input);
        break;
      }
    }

  }

}
