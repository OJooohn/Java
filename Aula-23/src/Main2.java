import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {

        List<Personagem> list = new ArrayList<>();
        
        try {



            
            ObjectInputStream os = new ObjectInputStream(new FileInputStream("jogo.save"));
            
            Personagem personagem;
            String EOF;

            while(os.available() > 0){
                list.add((Personagem) os.readObject());
            }

            System.out.println(list.indexOf(0));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
