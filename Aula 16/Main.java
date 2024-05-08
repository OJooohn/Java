public class Main {

    public static void main(String[] args) {
        
        // Instrumento i = new Instrumento("C", 40);
        Violao v = new Violao("E", 100, 6);
        Flauta f = new Flauta("F", 10);

        v.tocar();
        f.tocar();

    }

}