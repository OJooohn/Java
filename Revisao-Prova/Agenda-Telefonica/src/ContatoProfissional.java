public class ContatoProfissional extends Contato{

    private String email;

    ContatoProfissional(String nome, String numero, String email) {
        super(nome, numero);
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    @Override
    public String toString() {
        return
        "\nContato Profissional" +
        "\nNome: " + this.getNome() +
        "\nNúmero: " + this.getNumero() +
        "\nEmail: " + this.getEmail() + "\n";
    }
    
}
