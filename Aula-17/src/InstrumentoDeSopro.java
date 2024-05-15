public abstract class InstrumentoDeSopro extends Instrumento{

    private String tipoDeConstrucao;

    InstrumentoDeSopro(String tom, float tamanho, String tipoDeConstrucao) {
        super(tom, tamanho);
        this.tipoDeConstrucao = tipoDeConstrucao;
    }

    public String getTipoDeConstrucao(){
        return this.tipoDeConstrucao;
    }

    public void limpar(){
        System.out.println("Limpando instrumento de Sopro...");
    }

    public abstract void tocarNotasEspeciais(String nota);

    @Override
    public abstract void tocar();
    
}
