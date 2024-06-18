import java.io.Serializable;

public class Personagem implements Serializable{

    private String nome;
    private int vida;
    // transient private int vida;
    private int posX;
    private int posY;

    public Personagem(String nome, int vida, int posX, int posY) {
        this.nome = nome;
        this.vida = vida;
        this.posX = posX;
        this.posY = posY;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " - Vida: " + vida + " - Pos: (" + posX + ", " + posY + ")\n";
    }

}
