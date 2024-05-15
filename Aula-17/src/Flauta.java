public class Flauta extends InstrumentoDeSopro {

    Flauta(String tom, float tamanho, String tipoDeConstrucao) {
        super(tom, tamanho, tipoDeConstrucao);
    }

    public void tocarMelodia(){
        System.out.println("Tocando melodia...");
    }

    @Override
    public void tocar() {
        System.out.println("Tocando flauta...");
    }

    @Override
    public void tocarNotasEspeciais(String nota) {
        System.out.println("Tocando nota especial [" + nota +"] na flauta...");
    }

}
