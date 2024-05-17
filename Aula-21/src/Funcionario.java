public abstract class Funcionario {
    
    private String nome;
    private int matricula;
    private float salario;

    Funcionario(String nome, int matricula, float salario){
        this.nome = nome;
        this.matricula = matricula;
        this.salario = salario;
    }

    public String getNome(){
        return this.nome;
    }

    public int getMatricula(){
        return this.matricula;
    }

    public float getSalario(){
        return this.salario;
    }

    public abstract float calcularSalario();

    @Override
    public String toString() {
        return super.toString();
    }

}
