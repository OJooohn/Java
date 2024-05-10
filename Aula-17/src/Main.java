import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        // Instrumento i = new Instrumento("C", 40);
        Violao v = new Violao("E", 100, 6);
        Flauta f = new Flauta("F", 10);

        List<Instrumento> instrumento = new ArrayList<>();
        instrumento.add(new Violao("D", 100, 6));

        Instrumento i = instrumento.get(0);
        i.tocar();

        v.tocar();
        f.tocar();

    }

}