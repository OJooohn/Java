public class Main {
    
    public static void main(String[] args) {

        Veiculo v = new Veiculo(2004, "Cinza Claro", "Fiesta", false);
        Aviao a = new Aviao(2020, "Branco", "A330 NEO", false, 2, 67, "Avgas");

        a.decolar();
        v.ligar();

    }

}