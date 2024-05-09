public class Aluno {

    public String matricula;
    public String nome;
    private float nota1;
    private float nota2;
    private float media;
    boolean aprovado;

    public void setNota1(float n1){
        nota1 = n1;
    }

    public float getNota1(){
        return nota1;
    }

    Aluno(){
        System.out.println("~ criando aluno vazio ~");
    }

    Aluno(String mat, String nm){
        System.out.println("~ criando novo aluno (sem nota) - " + nm + " ~");
        matricula = mat;
        nome = nm;
    }

    Aluno(String mat, String nm, float n1, float n2){
        System.out.println("~ criando novo aluno (completo) - " + nm + " ~");
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

