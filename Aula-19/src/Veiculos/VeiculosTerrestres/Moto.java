package Veiculos.VeiculosTerrestres;
import Veiculos.Veiculo;

public class Moto extends Veiculo {
    private int cilindradas;
    private String tipoCombustivel;
    private String tipoFreio;
    
    public Moto(String modelo, int ano, String cor, int cilindradas, String tipoCombustivel, String tipoFreio) {
        super(modelo, ano, cor);
        this.cilindradas = cilindradas;
        this.tipoCombustivel = tipoCombustivel;
        this.tipoFreio = tipoFreio;
    }
    
    public void ativarModoEsportivo() {
        // Implementação específica para ativar o modo esportivo da moto
    }
    
    public void ligarPartidaEletrica() {
        // Implementação específica para ligar a partida elétrica da moto
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public String getTipoFreio() {
        return tipoFreio;
    }

    public void setTipoFreio(String tipoFreio) {
        this.tipoFreio = tipoFreio;
    }
}