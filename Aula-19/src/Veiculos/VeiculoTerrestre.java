package Veiculos;

public class VeiculoTerrestre extends Veiculo {
    
    private int numeroRodas;

    public VeiculoTerrestre(String modelo, int ano, String cor, int numeroRodas) {
        super(modelo, ano, cor);
        this.numeroRodas = numeroRodas;
    }
    
    @Override
    public void ligar() {
        this.ligado = true;
        System.out.println("O veículo terrestre está ligado.");
    }
}
