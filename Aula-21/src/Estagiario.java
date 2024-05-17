public class Estagiario extends Funcionario{

    private int horasDeTrabalho;
    private String supervisor;

    Estagiario(String nome, int matricula, float salario, int horasDeTrabalho, String supervisor) {
        super(nome, matricula, salario);
        this.horasDeTrabalho = horasDeTrabalho;
        this.supervisor = supervisor;
    }

    public int getHorasDeTrabalho(){
        return this.horasDeTrabalho;
    }

    public String getSupervisor(){
        return this.supervisor;
    }

    public void pegarCafe(){
        System.out.println("Estagiario pegando café...");
    }

    @Override
    public float calcularSalario() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularSalario'");
    }
    
    @Override
    public String toString() {
        return 
        "Estagiário" +
        "\nNome: " + this.getNome() +
        "\nMatricula: " + this.getMatricula() +
        "\nSalário: " + this.getSalario();
    }
    
}
