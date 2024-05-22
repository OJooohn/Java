package Veiculos.VeiculosTerrestres;
import Veiculos.Veiculo;

public class Bicicleta extends Veiculo {
    private int numeroMarchas;
    private String tipoFreio;
    private String estiloQuadro;
    
    // Métodos getters e setters para os atributos
    
    public Bicicleta(String modelo, int ano, String cor, int numeroMarchas, String tipoFreio, String estiloQuadro) {
        super(modelo, ano, cor);
        this.numeroMarchas = numeroMarchas;
        this.tipoFreio = tipoFreio;
        this.estiloQuadro = estiloQuadro;
    }

    public void pedalar() {
        // Implementação específica para dobrar a bicicleta (se for uma bicicleta dobrável)
    }
    
    public void parar() {
        // Implementação específica para ajustar a altura do selim da bicicleta
    }





    public int getNumeroMarchas() {
        return numeroMarchas;
    }

    public void setNumeroMarchas(int numeroMarchas) {
        this.numeroMarchas = numeroMarchas;
    }

    public String getTipoFreio() {
        return tipoFreio;
    }

    public void setTipoFreio(String tipoFreio) {
        this.tipoFreio = tipoFreio;
    }

    public String getEstiloQuadro() {
        return estiloQuadro;
    }

    public void setEstiloQuadro(String estiloQuadro) {
        this.estiloQuadro = estiloQuadro;
    }
}