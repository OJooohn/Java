public class Violao extends Instrumento{

    private int numeroDeCordas;

    Violao(String tom, float tamanho, int numeroDeCordas) {
        super(tom, tamanho);
        this.numeroDeCordas = numeroDeCordas;
    }

    public int getNumeroDeCordas () {
        return this.numeroDeCordas;
    }

    @Override
    public void tocar() {
        System.out.println("Tocando violao...");
    }
    
}
