public class Aviao extends VeiculoAereo{

    private float envergaduraAsa;
    private String tipoCombustivel;

    Aviao(int ano, String cor, String modelo, boolean ligado, int numeroMotores, float envergaduraAsa, String tipoCombustivel) {
        super(ano, cor, modelo, ligado, numeroMotores);
        this.envergaduraAsa = envergaduraAsa;
        this.tipoCombustivel = tipoCombustivel;
    }

    public float getEnvergaduraAsa() {
        return envergaduraAsa;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void decolar () {
        System.out.println("O aviao esta decolando!");
    }

    public void pousar () {
        System.out.println("O aviao esta pousando!");
    }
    
}
