public class Contato {

    private String nome;
    private String numero;

    Contato(String nome, String numero){
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome(){
        return this.nome;
    }

    public String getNumero(){
        return this.numero;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}