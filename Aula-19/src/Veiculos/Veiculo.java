package Veiculos;

public class Veiculo {

    private int ano;
    private String cor;
    protected String modelo;
    protected boolean ligado;

    public Veiculo(String modelo, int ano, String cor) {
        this.modelo = "M" + modelo;
        this.ano = ano;
        this.cor = cor;
        this.ligado = false;
    }

    public void ligar(){
        this.setLigado(true);
        System.out.println("Ligando Veiculo...");
    }

    public void desligar() {
        this.ligado = false;
        System.out.println("Desligando Veiculo...");
    }

    public void acelerar(){
        System.out.println("Acelerando Veiculo...");
    }

    public void frear(){
        System.out.println("Freando Veiculo");
    }

    public void virar(){
        System.out.println("Virando Veiculo");
    }

    // get - set

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean getLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }
    
}
