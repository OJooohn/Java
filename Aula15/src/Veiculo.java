public class Veiculo {
    
    private String modelo;
    private int ano;
    private String cor;
    private boolean ligado;

    Veiculo (String modelo, int ano, String cor, boolean ligado) {
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.ligado = ligado;
    }

    public String getModelo () {
        return this.modelo;
    }

    public int getAno () {
        return this.ano;
    }

    public String getCor () {
        return this.cor;
    }

    public boolean getLigado () {
        return this.ligado;
    }

    public void setModelo (String modelo) {
        this.modelo = modelo;
    }

    public void setAno (int ano) {
        this.ano = ano;
    }

    public void setCor (String cor) {
        this.cor = cor;
    }

    public void setLigado (boolean ligado) {
        this.ligado = ligado;
    }

    public void ligar () {
        this.ligado = true;
    }

    public void desligar () {
        this.ligado = false;
    }

    public void acelerar () {
        System.out.println("Veículo acelerando...\n");
    }

    public void frear () {
        System.out.println("Veículo freiando...\n");
    }

    public void virar () {
        System.out.println("Veículo virando...\n");
    }

}
