package Veiculos;
public class VeiculoAquatico extends Veiculo {

    private float comprimento;

    public VeiculoAquatico(String modelo, int ano, String cor, float comprimento) {
        super(modelo, ano, cor);
        this.comprimento = comprimento;
    }
    
    
}
