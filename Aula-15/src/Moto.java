public class Moto extends Veiculo {

    private int cilindradas;
    private String tipoCombustivel;
    private String tipoFreio;

    Moto(String modelo, int ano, String cor, boolean ligado, int cilindradas, String tipoCombustivel, String tipoFreio) {
        super(modelo, ano, cor, ligado);
        this.cilindradas = cilindradas;
        this.tipoCombustivel = tipoCombustivel;
        this.tipoFreio = tipoFreio;
    }

    public int getCilindradas () {
        return this.cilindradas;
    }

    public String getTipoCombustivel () {
        return this.tipoCombustivel;
    }

    public String getTipoFreio () {
        return this.tipoFreio;
    }

    public void setCilindradas (int cilindradas) {
        this.cilindradas = cilindradas;
    }

    public void setTipoCombustivel (String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public void setTipoFreio (String tipoFreio) {
        this.tipoFreio = tipoFreio;
    }

    public void ativarModoEsportivo () {
        System.out.println("Moto ativando o modo esportivo...\n");
    }

    public void lugarPartidaEletrica () {
        System.out.println("Moto ligando partida elétrica...\n");
    }

    @Override
    public String toString() {
        return "Moto" +
        "\nModelo: " + this.getModelo() +
        "\nAno: " + this.getAno() + 
        "\nCor: " + this.getCor() +
        "\nCilindradas: " + this.getCilindradas() +
        "\nCombustível: " + this.getTipoCombustivel() +
        "\nFreio: " + this.getTipoFreio();
    }
    
}
