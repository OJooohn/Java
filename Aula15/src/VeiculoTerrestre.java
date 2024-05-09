public class VeiculoTerrestre extends Veiculo {

    private int numeroRodas;

    VeiculoTerrestre(int ano, String cor, String modelo, boolean ligado, int numeroRodas) {
        super(ano, cor, modelo, ligado);
        this.numeroRodas = numeroRodas;
    }

    public int getNumeroRodas () {
        return this.numeroRodas;
    }

}
