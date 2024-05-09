public class Main {
    
    public static void main(String[] args) {
        
        Carro c = new Carro("Fiesta", 2004, "Cinza Claro", false, 4, "Manual", 100);
        Onibus o = new Onibus("Volvo", 2008, "Laranja", false, 85, 3, 26);
        Moto m = new Moto("CBR 2000", 2017, "Azul", false, 600, "Podium", "Disco");
        Bicicleta b = new Bicicleta("BMX", 2001, "Branca", false, 1, "Convencional", "Diamante");

        System.out.println(c);
        o.ligar();
        c.abrirTetoSolar();
        c.acelerar();
        c.ligarFarolNeblina();
        o.desligar();

        System.out.println(o);
        o.ligar();
        o.abrirPortaDianteira();
        o.anunciarProximaParada();
        o.anunciarProximaParada();
        o.desligar();

        System.out.println(m);
        m.ligar();
        m.ativarModoEsportivo();
        m.acelerar();
        m.lugarPartidaEletrica();
        m.desligar();

        System.out.println(b);
        b.pedalar();
        b.frear();
        b.virar();
        b.acelerar();
        
    }

}
