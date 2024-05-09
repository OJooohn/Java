import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aula12 {

    public static void main(String[] args) {

        List<Musica> musicas = new ArrayList<>();

        musicas.add(new Musica("Faint", "Linkin Park", 2003));
        musicas.add(new Musica("Viva la Vida", "Cold Play", 2008));
        musicas.add(new Musica("Ceu Azul", "Charlie Brown Jr.", 2012));
        musicas.add(new Musica("Free Bird", "LYNYRD SKYNYRD", 1973));
        musicas.add(new Musica("Luz Negra", "Nelson Cavaquinho", 1979));
        musicas.add(new Musica("Caneta Azul", "Manuel Gomes", 2020));

        System.out.println(musicas);
        System.out.println(musicas.get(0));
        System.out.println(musicas.get(2));
        System.out.println(musicas.get(3));

        /*
         * System.out.print("[");
         * for (int i = 0; i < musicas.size(); i++) {
         * System.out.print(musicas.get(i).getTitulo() + ", ");
         * }
         * System.out.print("]");
         */

        System.out.println("----------");
        System.out.println(musicas);
        Collections.sort(musicas);
        System.out.println(musicas);

    }

}
