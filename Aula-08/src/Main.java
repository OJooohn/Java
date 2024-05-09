public class Main {
    public static void main(String[] args) throws Exception {
        Televisao tv = new Televisao(false, 57, 90);

        tv.setLigado(true);
        tv.setCanal(89);
        tv.setCanal(44);
        tv.setCanal(32);

        tv.setVolume(90);
        tv.aumentarVolume();
        tv.aumentarVolume();
        tv.aumentarVolume();

        System.out.println("-------");
        System.out.println("Canal: " + tv.getCanal());
        System.out.println("Volume: " + tv.getVolume());
        System.out.println("Ligado: " + tv.getLigado());

    }

}
