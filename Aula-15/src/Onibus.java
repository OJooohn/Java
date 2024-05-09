public class Onibus extends Veiculo {

    private int capacidadePassageiros;
    private int portasAcesso;
    private int numeroParadas;

    Onibus(String modelo, int ano, String cor, boolean ligado, int capPassageiros, int portasAcesso, int numParadas) {
        super(modelo, ano, cor, ligado);
        this.capacidadePassageiros = capPassageiros;
        this.portasAcesso = portasAcesso;
        this.numeroParadas = numParadas;
    }

    public int getCapacidadePassageiros () {
        return this.capacidadePassageiros;
    }

    public int getPortasAcesso () {
        return this.portasAcesso;
    }

    public int getNumeroParadas () {
        return this.numeroParadas;
    }

    public void setCapacidadePassageiros (int capPassageiros) {
        this.capacidadePassageiros = capPassageiros;
    }

    public void setPortasAcesso (int portasAcesso) {
        this.portasAcesso = portasAcesso;
    }

    public void setRotasItinerarios (int numeroParadas) {
        this.numeroParadas = numeroParadas;
    }

    public void abrirPortaDianteira () {
        System.out.println("Ônibus abrindo porta dianteira...\n");
    }

    public void anunciarProximaParada () {
        System.out.println("Ônibus anunciando a próxima parada...\n");
    }

    @Override
    public String toString() {
        return "Ônibus" +
        "\nModelo: " + this.getModelo() +
        "\nAno: " + this.getAno() + 
        "\nCor: " + this.getCor() +
        "\nCapacidade passageiros: " + this.getCapacidadePassageiros() +
        "\nPortas acesso: " + this.getPortasAcesso() +
        "\nLinha: " + this.getNumeroParadas() + " pontos";
    }
    
}
