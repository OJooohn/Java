public class ContaCorrente extends Conta{

    private final float taxaJuros;
    private final float limiteCheque;

    ContaCorrente(int ID, String titular, float saldo, float taxaJuros, float limiteCheque){
        super(ID, titular, saldo);
        this.taxaJuros = taxaJuros;
        this.limiteCheque = limiteCheque;
    }

    public float getTaxaJuros() {
        return taxaJuros;
    }

    public float getLimiteCheque() {
        return limiteCheque;
    }
}
