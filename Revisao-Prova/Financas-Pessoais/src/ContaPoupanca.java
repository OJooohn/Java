public class ContaPoupanca extends Conta{

    private final float taxaRendimento;
    private final String dataAniversario;

    public ContaPoupanca(int ID, String titular, float saldo, float taxaRendimento, String dataAniversario) {
        super(ID, titular, saldo);
        this.taxaRendimento = taxaRendimento;
        this.dataAniversario = dataAniversario;
    }

    public float getTaxaRendimento() {
        return taxaRendimento;
    }

    public String getDataAniversario() {
        return dataAniversario;
    }

}
