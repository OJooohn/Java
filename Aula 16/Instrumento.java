public abstract class Instrumento {
    // Instrumento é uma classe base, onde todos os instrumentos tem em comum, por exemplo, todos da para tocar
    
    protected String tom;
    protected float tamanho;

    Instrumento (String tom, float tamanho) {
        this.tom = tom;
        this.tamanho = tamanho;
    }

    public String getTom () {
        return this.tom;
    }

    public float getTamanho () {
        return this.tamanho;
    }

    public abstract void tocar ();

}
