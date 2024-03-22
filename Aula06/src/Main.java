public class Main {
  
  public static void main(String[] args) {
    
    Televisao tv = new Televisao(false, 57, 90);

    tv.setCanal(17);
    tv.setLigado(true);

    tv.setVolume(90);
    tv.aumentarVolume();
    tv.aumentarVolume();
    tv.aumentarVolume();

    System.out.println("-------------------------------");
    System.out.println("~~ Canal: " + tv.getCanal());
    System.out.println("~~ Volume: " + tv.getVolume());
    System.out.println("~~ Ligado: " + tv.getLigado());

  }

}
