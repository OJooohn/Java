public class Submarino extends VeiculoAquatico{

    private float profundidadeMaxima;

    Submarino(int ano, String cor, String modelo, boolean ligado, float comprimento, float profundidadeMaxima) {
        super(ano, cor, modelo, ligado, comprimento);
        this.profundidadeMaxima = profundidadeMaxima;
    }

    public float getProfundidadeMaxima() {
        return this.profundidadeMaxima;
    }

    public void mergulhar () {
        System.out.println("Submarino mergulhando");
    }

    public void emergir () {
        System.out.println("Submarino emergindo");
    }
    
}
