package Veiculos.VeiculosAereos;
import Veiculos.VeiculoAereo;

public class Helicoptero extends VeiculoAereo {
    private int numeroHelices;
    private double capacidadeCarga;

    public Helicoptero(String modelo, int ano, String cor, int numeroMotores, int numeroHelices, double capacidadeCarga) {
        super(modelo, ano, cor, numeroMotores);
        this.numeroHelices = numeroHelices;
        this.capacidadeCarga = capacidadeCarga;
    }

    // Métodos específicos do Helicoptero
    public void pairar() {
        System.out.println("Helicóptero pairando no ar...");
    }

    public void resgatarPessoas() {
        System.out.println("Helicóptero realizando resgate de pessoas...");
    }
}