import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A03Exemplo {
 
  public static void main(String[] args) {
    
    Object[] array = new Object[5];
    array[0] = 4;
    array[1] = "Texto";
    array[2] = true;
    array[3] = 4.52f;

    System.out.println(Arrays.toString(array));

    List<Integer> lista = new ArrayList<Integer>();
    System.out.println(lista.toString());
    lista.add(10);
    lista.add(100);
    lista.add(27);
    lista.add(130);
    System.out.println(lista.toString());
    
    lista.remove(2);

    System.out.println(lista.toString());

  }

}
