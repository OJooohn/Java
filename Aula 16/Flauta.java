public class Flauta extends Instrumento {

    Flauta(String tom, float tamanho) {
        super(tom, tamanho);
    }

    @Override
    public void tocar() {
        System.out.println("Tocando flauta...");
    }

}
