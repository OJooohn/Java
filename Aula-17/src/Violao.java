public class Violao extends InstrumentoDeCorda implements Afinador{

    private int numeroDeCordas;

    Violao(String tom, float tamanho,  String tipoDeCorda, int numeroDeCordas) {
        super(tom, tamanho, tipoDeCorda);
        this.numeroDeCordas = numeroDeCordas;
    }

    public int getNumeroDeCordas () {
        return this.numeroDeCordas;
    }

    public void tocarAcordes(){
        System.out.println("Tocando acordes");
    }

    @Override
    public void tocar() {
        System.out.println("Tocando violao...");
    }

    @Override
    public void afinar() {
        System.out.println("Afinando Violao...");
    }

    @Override
    public void mudarTom(String tom) {
        this.tom = tom;
        System.out.println("Mudando tom do Violao para [" + this.tom + "]");
    }
    
}
