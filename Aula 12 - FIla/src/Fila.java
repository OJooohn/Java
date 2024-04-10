import java.util.ArrayDeque;
import java.util.Deque;

public class Fila {

    public static void main(String[] args) throws Exception {

        Deque<Integer> fila = new ArrayDeque<>();
        fila.add(10);
        fila.add(5);
        fila.add(7);
        fila.add(44);
        fila.add(19);

        System.out.println(fila);

        // tirar da fila e mostrar
        int proximo = fila.pollFirst(); // primeiro número da fila (10)
        System.out.println(proximo);
        System.out.println(fila);

        // apenas mostrar quem está na fila
        System.out.println(fila.peekFirst()); // próximo da fila (5)
        System.out.println(fila);
        
        // apenas remove o primeiro
        fila.removeFirst();

    }
}
