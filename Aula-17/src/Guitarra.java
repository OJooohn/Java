public class Guitarra extends InstrumentoDeCorda implements Afinador{
    
    private int numeroDeCaptadores;

    Guitarra(String tom, float tamanho, String tipoDeCorda, int numeroDeCaptadores) {
        super(tom, tamanho, tipoDeCorda);
        this.numeroDeCaptadores = numeroDeCaptadores;
        
    }

    public int getNumeroDeCaptadores(){
        return this.numeroDeCaptadores;
    }

    public void tocarSolo(){
        System.out.println("Tocando solo de guitarra");
    }

    @Override
    public void tocar() {
        System.out.println("Tocando guitarra...");
    }

    @Override
    public void afinar() {
        System.out.println("Afinando guitarra...");
    }

    @Override
    public void mudarTom(String tom) {
        this.tom = tom;
        System.out.println("Mudando o tom da guitarra para [" + this.tom + "]");
    }

}
