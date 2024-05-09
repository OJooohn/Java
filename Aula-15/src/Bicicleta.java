public class Bicicleta extends Veiculo {

    private int numeroMarchas;
    private String tipoFreio;
    private String estiloQuadro;

    Bicicleta(String modelo, int ano, String cor, boolean ligado, int numeroMarchas, String tipoFreio, String estiloQuadro) {
        super(modelo, ano, cor, ligado);
        this.numeroMarchas = numeroMarchas;
        this.tipoFreio = tipoFreio;
        this.estiloQuadro = estiloQuadro;
    }

    public int getNumeroMarchas () {
        return this.numeroMarchas;
    }

    public String getTipoFreio () {
        return this.tipoFreio;
    }

    public String getEstiloQuadro () {
        return this.estiloQuadro;
    }

    public void setNumeroMarchas (int numeroMarchas) {
         this.numeroMarchas = numeroMarchas;
    }

    public void setTipoFreio (String tipoFreio) {
        this.tipoFreio = tipoFreio;
    }

    public void setEstiloQuadro (String estiloQuadro) {
        this.estiloQuadro = estiloQuadro;
    }

    public void pedalar () {
        System.out.println("Bicicleta pedalando...\n");
    }

    public void parar () {
        System.out.println("Bicicleta parando...\n");
    }

    @Override
    public String toString() {
        return "Bicicleta" +
        "\nModelo: " + this.getModelo() +
        "\nAno: " + this.getAno() + 
        "\nCor: " + this.getCor() +
        "\nMarchas: " + this.getNumeroMarchas() +
        "\nFreio: " + this.getTipoFreio() +
        "\nQuadro estilo: " + this.getEstiloQuadro();
    }
    
}
