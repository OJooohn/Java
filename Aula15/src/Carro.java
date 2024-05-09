public class Carro extends Veiculo{
    
    private int numeroPortas;
    private String tipoTransmissao;
    private float capacidadePortaMalas;

    Carro(String modelo, int ano, String cor, boolean ligado, int numPortas, String tipoTrans, float capPortaMalas) {
        super(modelo, ano, cor, ligado);
        this.numeroPortas = numPortas;
        this.tipoTransmissao = tipoTrans;
        this.capacidadePortaMalas = capPortaMalas;
    }

    public int getNumPortas () {
        return this.numeroPortas;
    }

    public String getTipoTransmissao () {
        return this.tipoTransmissao;
    }

    public float getCapacidadePortaMalas () {
        return this.capacidadePortaMalas;
    }

    public void setNumPortas (int numPortas) {
        this.numeroPortas = numPortas;
    }

    public void setTipoTransmissao (String tipoTrans) {
        this.tipoTransmissao = tipoTrans;
    }

    public void setCapacidadePortaMalas (float capPortaMalas) {
        this.capacidadePortaMalas = capPortaMalas;
    }

    public void ligarFarolNeblina () {
        System.out.println("Carro ligando farol de neblina...\n");
    }

    public void abrirTetoSolar () {
        System.out.println("Carro abrindo teto solar...\n");
    }

    @Override
    public String toString() {
        return "Carro" +
        "\nModelo: " + this.getModelo() +
        "\nAno: " + this.getAno() + 
        "\nCor: " + this.getCor() +
        "\nPortas: " + this.getNumPortas() +
        "\nTransmissão: " + this.getTipoTransmissao() +
        "\nPorta Malas: " + this.getCapacidadePortaMalas();
    }

}
