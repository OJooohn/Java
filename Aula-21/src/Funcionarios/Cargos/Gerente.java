package Funcionarios.Cargos;
import Funcionarios.Funcionario;
import Interfaces.Trabalhavel;

public class Gerente extends Funcionario implements Trabalhavel{

    private float bonusAnual;
    private String equipe;

    public Gerente(String nome, int matricula, float salario, float bonusAnual, String equipe) {
        super(nome, matricula, salario);
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

    public void calcularOutroSalario(){

    }

    @Override
    public void trabalhar() {
        System.out.println("Gerente trabalhando...");
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
        "\nMatricula: " + this.getMatricula() +
        "\nSalário: " + this.getSalario();
    }
    
}
