public class Main {
  
  public static void main(String[] args) {
    
    Animal animal = new Animal();
    Cachorro cachorro = new Cachorro();
    Gato gato = new Gato();
    Vaca vaca = new Vaca();

    animal.setNome("Bufallus Zebrus");
    animal.setSexo("M");
    animal.setIdade(10000);

    cachorro.setRaca("Golden Retriever");
    cachorro.setPorte("Médio");
    cachorro.setNome("Toto");
    cachorro.setSexo("M");
    cachorro.setIdade(7);

    gato.setNome("Eren");
    gato.setSexo("M");
    gato.setIdade(3);
    gato.setCor("Laranja | Preto | Branca");
    gato.setCacando(false);

    vaca.setNome("Mimosa");
    vaca.setSexo("F");
    vaca.setIdade(5);
    vaca.setDieta("Raçao");
    vaca.setManchas("Marrom");

    cachorro.buscarOsso();
    cachorro.buscarOsso();
    vaca.produzirLeite();
    vaca.pastar();
    cachorro.buscarOsso();
    cachorro.buscarOsso();
    gato.mudarCacando();

    System.out.println(animal);
    System.out.println(cachorro);
    System.out.println(gato);
    System.out.println(vaca);

  }

}
