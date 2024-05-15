public abstract class InstrumentoDeCorda extends Instrumento{

    private String tipoDeCorda;

    InstrumentoDeCorda(String tom, float tamanho, String tipoDeCorda) {
        super(tom, tamanho);
        this.tipoDeCorda = tipoDeCorda;
    }

    public String getTipoDeCorda(){
        return this.tipoDeCorda;
    }

    @Override
    public abstract void tocar();
    
}
