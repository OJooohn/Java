import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class CriarArquivo {
    public static void main(String[] args) {
        
        String path = "C:\\Users\\John\\Documents\\GitHub\\Java\\Aula-23\\src\\textoTeste.txt";
        File arquivo = new File(path);

        // Append: true -> nao vai remover os dados ja existentes!
        try(BufferedWriter br = new BufferedWriter(new FileWriter(arquivo, true))) {

            br.write("oi\n");
            br.write("teste\n");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
