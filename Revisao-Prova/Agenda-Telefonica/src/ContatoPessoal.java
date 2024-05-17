public class ContatoPessoal extends Contato{

    private String dataNascimento;

    ContatoPessoal(String nome, String numero, String dataNascimento) {
        super(nome, numero);
        this.dataNascimento = dataNascimento;
    }

    public String getDataNascimento(){
        return this.dataNascimento;
    }

    @Override
    public String toString() {
        return
        "\nContato Pessoal" +
        "\nNome: " + this.getNome() +
        "\nNúmero: " + this.getNumero() +
        "\nData Nascimento: " + this.getDataNascimento() + "\n";
    }
    
}
