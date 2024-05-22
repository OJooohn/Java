package Veiculos.VeiculosAquaticos;
import Veiculos.VeiculoAquatico;

public class Submarino extends VeiculoAquatico {
    
    private boolean periscopioLevantado;
    private int profundidadeMaxima;
    
    public Submarino(String modelo, int ano, String cor, float comprimento) {
        super(modelo, ano, cor, comprimento);
        
        this.periscopioLevantado = periscopioLevantado;
        this.profundidadeMaxima = profundidadeMaxima;
    }

    // Métodos específicos do Submarino
    public void mergulhar() {
        System.out.println("Submarino mergulhando...");
    }

    public void emergir() {
        System.out.println("Submarino emergindo...");
    }
}