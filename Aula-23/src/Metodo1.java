import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Metodo1 {
    
    public static void main(String[] args){
        
        String path = "C:\\Users\\John\\Documents\\GitHub\\Java\\Aula-23\\src\\texto.txt";
        File arquivo = new File(path);
        
        try {
            Scanner leitor = new Scanner(arquivo);
            
            while(leitor.hasNextLine()){
                System.out.println(leitor.nextLine());
            }

            leitor.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
