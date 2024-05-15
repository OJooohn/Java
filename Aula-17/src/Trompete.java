public class Trompete extends InstrumentoDeSopro{

    private int numeroDeValvulas;

    Trompete(String tom, float tamanho, String tipoDeConstrucao, int numeroDeValvulas) {
        super(tom, tamanho, tipoDeConstrucao);
        this.numeroDeValvulas = numeroDeValvulas;
    }

    public int getNumeroDeValvulas(){
        return this.numeroDeValvulas;
    }

    @Override
    public void tocarNotasEspeciais(String nota) {
        System.out.println("Tocando nota especial [" + nota +"] no trompete...");
    }

    @Override
    public void tocar() {
        System.out.println("Tocando trompete...");
    }
    
}
