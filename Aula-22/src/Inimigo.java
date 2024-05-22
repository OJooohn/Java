public class Inimigo extends Personagem{

    Inimigo(int posX, int posY, String desenho) {
        super(posX, posY, desenho);
    }

    @Override
    public String desenhar() {
        return "\u001B[31m" + this.getDes() + "\u001B[0m";
    }

}
