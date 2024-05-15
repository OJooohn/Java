public class Estagiario extends Funcionario implements Trabalhavel{

    private int horasDeTrabalho;
    private String supervisor;

    Estagiario(String nome, int matricula, int horasDeTrabalho, String supervisor) {
        super(nome, matricula);
        this.horasDeTrabalho = horasDeTrabalho;
        this.supervisor = supervisor;
    }

    public int getHorasDeTrabalho(){
        return this.horasDeTrabalho;
    }

    public String getSupervisor(){
        return this.supervisor;
    }

    @Override
    public float calcularSalario() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularSalario'");
    }

    @Override
    public void trabalhar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'trabalhar'");
    }

    @Override
    public void relatarProgresso() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'relatarProgresso'");
    }
    
}
