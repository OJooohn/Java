import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Metodo2 {
    public static void main(String[] args) {
        
        String path = "C:\\Users\\John\\Documents\\GitHub\\Java\\Aula-23\\src\\texto.txt";
        File arquivo = new File(path);

        try(BufferedReader br = new BufferedReader(new FileReader(arquivo))) {

            String linha;
            while((linha = br.readLine()) != null){
                System.out.println(linha);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
