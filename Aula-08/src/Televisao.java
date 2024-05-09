public class Televisao {

    private int canal;
    private int volume;
    private boolean ligado;

    Televisao() {
        this.canal = 22;
        this.volume = 50;
        this.ligado = true;
    }

    Televisao(boolean ligado, int canal, int volume) {
        this.canal = canal;
        this.volume = volume;
        this.ligado = ligado;
    }

    void aumentarVolume() {
        if (this.getVolume() <= 95) {
            this.setVolume(this.getVolume() + 5);
        } else {
            System.out.println(">> Volume maximo atingido.");
        }
    }

    void setVolume(int volume) {
        this.volume = volume;
        System.out.println(">> Alterando Volume para: " + volume);
    }

    int getVolume() {
        return this.volume;
    }

    void setCanal(int canal) {
        this.canal = canal;
        System.out.println(">> ALterando Canal para: " + canal);
    }

    int getCanal() {
        return this.canal;
    }

    void setLigado(boolean ligado) {
        this.ligado = ligado;
        System.out.println(">> Alterando Ligado para: " + ligado);
    }

    boolean getLigado() {
        return this.ligado;
    }

}