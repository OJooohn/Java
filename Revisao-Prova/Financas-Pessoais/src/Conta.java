public abstract class Conta implements  OperacoesConta{

    private final int ID;
    private final String titular;
    private final float saldo;

    public Conta(int ID, String titular, float saldo) {
        this.ID = ID;
        this.titular = titular;
        this.saldo = saldo;
    }

    public int getID(){
        return this.ID;
    }

    public String getTitular(){
        return this.titular;
    }

    public float getSaldo() {
        return this.saldo;
    }

    @Override
    public void depositar() {

    }

    @Override
    public void sacar() {

    }

    @Override
    public void consultar() {

    }
}
