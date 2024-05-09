public class VeiculoAereo extends Veiculo{

    private int numeroMotores;

    VeiculoAereo(int ano, String cor, String modelo, boolean ligado, int numeroMotores) {
        super(ano, cor, modelo, ligado);
        this.numeroMotores = numeroMotores;
    }

    public int getNumeroMotores() {
        return numeroMotores;
    }


}
