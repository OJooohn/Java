public class Gerente extends Funcionario implements Trabalhavel{

    private float bonusAnual;
    private String equipe;

    Gerente(String nome, int matricula, float bonusAnual, String equipe) {
        super(nome, matricula);
        this.bonusAnual = bonusAnual;
        this.equipe = equipe;
    }

    public float getBonusAnual(){
        return this.bonusAnual;
    }

    public String getEquipe(){
        return this.equipe;
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

    @Override
    public String toString() {
        return 
        "Gerente" +
        "\nNome: " + this.getNome() +
        "\nMatricula: " + this.getMatricula();
    }
    
}
