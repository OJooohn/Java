import Veiculos.*;
import Veiculos.VeiculosTerrestres.*;

public class Main {
 
    public static void main(String[] args) {
        
        Veiculo v = new Veiculo("V32", 1990, "azul");
        VeiculoTerrestre vt = new VeiculoTerrestre("VT1", 1990, "null", 4);
        Carro c = new Carro("CA4", 2000, "branco", 4, 4, "", 40);
        Onibus o = new Onibus("O9", 2024, "Ver", 6, 300,"5", "-");
        
        v.ligar();
        v.acelerar();
        v.frear();
        v.virar();
        v.desligar();
        //v.abrirTetoSolar();
        //v.ligarFarolNeblina();
        //v.abrirPortaDianteira();
        //v.anunciarParadaProxima();

        System.out.println();
        c.ligar();
        c.acelerar();
        c.frear();
        c.virar();
        c.desligar();
        c.abrirTetoSolar();
        c.ligarFarolNeblina();
        //c.abrirPortaDianteira();
        //c.anunciarParadaProxima();

        System.out.println();
        o.ligar();
        o.acelerar();
        o.frear();
        o.virar();
        o.desligar();
        o.abrirPortaDianteira();
        o.anunciarParadaProxima();
        //o.abrirTetoSolar();
        //o.ligarFarolNeblina();

    }

}
