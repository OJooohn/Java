public class Aluno {
    
    String matricula;
    String nome;
    float nota1;
    float nota2;
    float media;
    boolean aprovado;

    Aluno(String mat, String nm, float n1, float n2){
        matricula = mat;
        nome = nm;
        nota1 = n1;
        nota2 = n2;
    }

    void calcularMedia(boolean mostrar){
        media = (nota1 + nota2) / 2;

        if(mostrar){
            System.out.println("Média do Aluno: " + nome);
            System.out.println("-- Nota 1: " + nota1);
            System.out.println("-- Nota 2: " + nota2);
            System.out.println("-- Média Final: " + media);
        }
    }

}
