import java.util.ArrayList;
import java.util.List;

public class Aluno {

    String matricula;
    String nome;

    List<Float> notas = new ArrayList<Float>();

    float media;
    boolean aprovado;

    Aluno(){
        System.out.println("~ criando aluno vazio ~");
    }

    void mostrar(){
        System.out.println("\n\n");
        System.out.println("~ Informações do Aluno(a): " + nome);
        System.out.println("-- Matricula: " + matricula);
        calcularMedia(true);

        if (media > 6)
            System.out.println("-- Status: (X) Aprovado ( ) Reprovado");
        else 
            System.out.println("-- Status: ( ) Aprovado (X) Reprovado");
    }

    void calcularMedia(boolean mostrar){
        
        // Somar todas as notas da lista
        float soma = 0;
        for (int i = 0; i < notas.size(); i++) {
            soma += notas.get(i);
        }
        
        media = soma / notas.size();

        if(mostrar){
            System.out.println("-- Notas: ");
            for (int i = 0; i < notas.size(); i++) {
                System.out.println("--- Nota (" + i + "): " + notas.get(i));
            }
            System.out.println("--- Média: " + media);
        }
    }

}

