public class VeiculoAquatico extends Veiculo {

    private float comprimento;

    VeiculoAquatico(int ano, String cor, String modelo, boolean ligado, float comprimento) {
        super(ano, cor, modelo, ligado);
        this.comprimento = comprimento;
    }

    public float getComprimento() {
        return this.comprimento;
    }

}
