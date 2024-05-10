public class Garrafa {

    public static boolean aberto;
    
    public String material;
    public String formato;
    public String liquido;

    public float quantidade;
    public float capacidade;

    // static não pertence a nenhum objeto -> existe para todos os objetos criados
    public static float valor;

    public static void abrir () {
        aberto = true;
        System.out.println("Abrir garrafa");
    }
    
    Garrafa (String material, String formato, String liquido, float quantidade, float capacidade) {
        this.material = material;
        this.formato = formato;
        this.liquido = liquido;
        this.quantidade = quantidade;
        this.capacidade = capacidade;
    }
    
    Garrafa () {

    }

}
