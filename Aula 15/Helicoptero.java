public class Helicoptero extends VeiculoAereo{

    private int numeroHelices;
    private float capacidadeCarga;

    Helicoptero(int ano, String cor, String modelo, boolean ligado, int numeroMotores, int numeroHelices, float capacidadeCarga) {
        super(ano, cor, modelo, ligado, numeroMotores);
        this.numeroHelices = numeroHelices;
        this.capacidadeCarga = capacidadeCarga;
    }

    public int getNumeroHelices() {
        return this.numeroHelices;
    }

    public float getCapacidadeCarga() {
        return this.capacidadeCarga;
    }

    public void pairar () {
        System.out.println("O helicoptero está pairando!");
    }

    public void resgatarPessoas () {
        System.out.println("O helicoptero está resgatando pessoas!");
    }

}
