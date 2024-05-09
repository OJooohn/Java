import java.text.DecimalFormat;

public class Calculadora {

  float resultado;
  DecimalFormat deci = new DecimalFormat("0.00");
  
  Calculadora(float num1, float num2, String operacao){

    switch(operacao){
      case "+": resultado = num1 + num2;
      break;
  
      case "-": resultado = num1 - num2;
      break;
  
      case "*": resultado = num1 * num2;
      break;
  
      case "/": resultado = num1 / num2;
      break;
  
    }

    
    
  }

  void imprimirResultado(float num1, float num2, String operacao){
    System.out.println("\n");
    System.out.println("" + num1 + " " + operacao + " " + num2 + " = " + deci.format(resultado));
  }
  
}
