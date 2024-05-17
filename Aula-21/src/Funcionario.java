public abstract class Funcionario {
    
    private String nome;
    private int matricula;

    Funcionario(String nome, int matricula){
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome(){
        return this.nome;
    }

    public int getMatricula(){
        return this.matricula;
    }

    public abstract float calcularSalario();

    @Override
    public String toString() {
        return super.toString();
    }

}
