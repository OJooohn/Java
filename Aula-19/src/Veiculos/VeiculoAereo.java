package Veiculos;
public class VeiculoAereo extends Veiculo {
    
    private int numeroMotores;

    public VeiculoAereo(String modelo, int ano, String cor, int numeroMotores) {
        super(modelo, ano, cor);
        this.numeroMotores = numeroMotores;
    }
    
    @Override
    public void ligar() {
        this.ligado = true;
        System.out.println("O veículo aéreo está ligado.");
    }

}
