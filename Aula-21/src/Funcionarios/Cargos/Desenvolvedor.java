package Funcionarios.Cargos;
import java.util.ArrayList;
import java.util.List;

import Funcionarios.Funcionario;
import Interfaces.Trabalhavel;

public class Desenvolvedor extends Funcionario implements Trabalhavel{

    private List<String> tecnologias;

    public Desenvolvedor(String nome, int matricula, float salario) {
        super(nome, matricula, salario);
        this.tecnologias = new ArrayList<String>();
    }

    public void adicionarTecnologia(String tecnologia){
        this.tecnologias.add(tecnologia);
    }

    public void listarTecnologias(){
        System.out.println("Tecnologias dominantes:");
        System.out.println(tecnologias);
    }

    @Override
    public float calcularSalario() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularSalario'");
    }

    @Override
    public void trabalhar() {
        System.out.println("Desenvolvedor trabalhando...");

    }

    @Override
    public void relatarProgresso() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'relatarProgresso'");
    }

    @Override
    public String toString() {
        return 
        "Desenvolvedor" +
        "\nNome: " + this.getNome() +
        "\nMatricula: " + this.getMatricula() +
        "\nSalário: " + this.getSalario();
    }
    
}
