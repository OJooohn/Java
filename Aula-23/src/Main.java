import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    
    public static void main(String[] args) {

        Personagem a = new Personagem("Rogerio", 100, 35, 69);
        Personagem b = new Personagem("Adalberta", 85, 31, 6);

        System.out.println(a);
        System.out.println(b);

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("jogo.save"));
            os.writeObject(a);
            os.writeObject(b);
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        

    }

}
