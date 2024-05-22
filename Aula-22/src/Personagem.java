public class Personagem {

    private int posX;
    private int posY;
    private String desenho;

    Personagem(int posX, int posY, String desenho) {
        this.posX = posX;
        this.posY = posY;
        this.desenho = desenho;
    }

    public void mover(int dir) {

        switch (dir) {
            case 1:
                this.posY -= 1;
                break;

            case 2:
                this.posY += 1;
                break;

            case 3:
                this.posX -= 1;
                break;

            case 4:
                this.posX += 1;
                break;

            default:
                break;
        }

    }

    public void tentarMover(int dir, int lar, int alt) throws Exception {

        switch (dir) {
            case 1:
                if (this.posY - 1 < 0)
                    throw new Exception("LIMITE DE TABULEIRO - CIMA");
                else
                    this.posY -= 1;
                break;

            case 2:
                if (this.posY + 1 < 0)
                    throw new Exception("LIMITE DE TABULEIRO - BAIXO");
                else
                    this.posY += 1;
                break;

            case 3:
                if (this.posX - 1 < 0)
                    throw new Exception("LIMITE DE TABULEIRO - ESQ");
                else
                    this.posX -= 1;
                break;

            case 4:
                if (this.posX + 1 < 0)
                    throw new Exception("LIMITE DE TABULEIRO - DIR");
                else
                    this.posX += 1;
                break;

            default:
                break;
        }

    }

    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public String getDes() {
        return this.desenho;
    }

    public String desenhar() {
        return this.desenho;
    }

}
