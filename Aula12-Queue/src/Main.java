import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        List<Musica> musicas = new ArrayList<>();

        musicas.add(new Musica("Faint", "Linkin PArk", 2003));
        musicas.add(new Musica("Viva la Vda", "Cold Play", 2008));
        musicas.add(new Musica("Ceu Azul", "Charlie Brown Jr.", 2010));
        musicas.add(new Musica("Free Bird", "LYNYRD SKYNYRD", 2012));
        musicas.add(new Musica("Luz Negra", "", 2005));

        // musicas.add("Faint");
        // musicas.add("Viva la Vida");
        // musicas.add("Ceu Azul");
        // musicas.add("Free Bird");
        // musicas.add("Luz Negra");
        
        System.out.println(musicas);

        // System.out.print("[");
        // for(int i = 0; i < musicas.size(); i++){
        //     System.out.print(musicas.get(i).getTitulo());
        //     System.out.print(", ");
        // }
        // System.out.print("]");
        // Collections.sort(musicas);
        // System.out.println(musicas);

        Collections.sort(musicas);
        System.out.println(musicas);
        
    }
}
