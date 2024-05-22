package Veiculos.VeiculosAereos;
import Veiculos.VeiculoAereo;

public class Aviao extends VeiculoAereo {
    private double envergaduraAsa;
    private String tipoCombustivel;

    public Aviao(String modelo, int ano, String cor, int numeroMotores, double envergaduraAsa, String tipoCombustivel) {
        super(modelo, ano, cor, numeroMotores);
        this.envergaduraAsa = envergaduraAsa;
        this.tipoCombustivel = tipoCombustivel;
    }

    // Métodos específicos do Aviao
    public void decolar() {
        System.out.println("Avião decolando...");
    }

    public void pousar() {
        System.out.println("Avião pousando...");
    }
}