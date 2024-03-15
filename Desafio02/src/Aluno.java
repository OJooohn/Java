public class Aluno {
  
  private String matricula;
  private String nome;
  public float nota1, nota2, nota3, nota4, nota5;
  private float notaFinal;

  public void setNota1(float n1){
    nota1 = n1;
  }

  public float getNota1(){
    return nota1;
  }

  Aluno(String mat, String nm, float n1, float n2, float n3, float n4, float n5){
    matricula = mat;
    nome = nm;
    nota1 = n1;
    nota2 = n2;
    nota3 = n3;
    nota4 = n4;
    nota5 = n5;
  }
  
  void Imprimir(){
    
    notaFinal = (nota1 + nota2 + nota3 + nota4 + nota5) / 5;

    if(notaFinal >= 6){
      System.out.println("Matrícula: " + matricula);
      System.out.println("Nome: " + nome);
      System.out.println("Aprovado: ( x ) Sim ( ) Não");
      System.out.println("Nota1: " + nota1);
      System.out.println("Nota2: " + nota2);
      System.out.println("Nota3: " + nota3);
      System.out.println("Nota4: " + nota4);
      System.out.println("Nota5: " + nota5);
      System.out.println("Média: " + notaFinal);
      System.out.println();
    } else {
      System.out.println("Matrícula: " + matricula);
      System.out.println("Nome: " + nome);
      System.out.println("Aprovado: ( ) Sim ( x ) Não");
      System.out.println("Nota1: " + nota1);
      System.out.println("Nota2: " + nota2);
      System.out.println("Nota3: " + nota3);
      System.out.println("Nota4: " + nota4);
      System.out.println("Nota5: " + nota5);
      System.out.println("Média: " + notaFinal);
      System.out.println();
    }

  }

}
