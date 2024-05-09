public class Veiculo {
    
    private int ano;
    private String cor;
    private String modelo;
    private boolean ligado;

    Veiculo (int ano, String cor, String modelo, boolean ligado) {
        this.ano = ano;
        this.cor = cor;
        this.modelo = modelo;
        this.ligado = ligado;
    }

    public int getAno () {
        return this.ano;
    }

    public String getCor () {
        return this.cor;
    }

    public String getModelo () {
        return this.modelo;
    }

    public boolean getLigado () {
        return this.ligado;
    }

    public void ligar () {
        this.ligado = true;
    }
    
    public void desligar () {
        this.ligado = false;
    }

}
