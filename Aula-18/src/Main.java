public class Main {
    public static void main(String[] args) throws Exception {

        Garrafa a = new Garrafa();
        // a.valor = 10;
        // a.abrir();
        Garrafa b = new Garrafa();
        // b.valor = 20;
        // b.abrir();

        Garrafa.valor = 30;
        Garrafa.abrir();

        Calculadora calc = new Calculadora();
        // Calculadora.somar(10, 20);
        calc.somar(10, 20);

        System.out.println();

    }

}
