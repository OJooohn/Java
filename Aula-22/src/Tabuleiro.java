import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tabuleiro {
    

    public static void tabuleiro(int largura, int altura, List<Personagem> pers){

            for (int lin = 0; lin < altura; lin++) {
        
                for (int col = 0; col < largura; col++) {
    
                    boolean teveUmPersonagem = false;
                    // for (int i = 0; i < pers.size(); i++) {
                        // Personagem p = pers.get(i);
                    
                    // Para cada personagem na lista de variosPersonagens faça:
                    // for (Personagem personagem : variosPersonagens) {
                    for (Personagem p : pers) {
                            
                        if(p.getPosX() == col && p.getPosY() == lin){
                            System.out.print("[" + p.desenhar() + "]");
                            teveUmPersonagem = true;
                        } 

                    }

                    if(!teveUmPersonagem) {
                        System.out.print("[.]");
                    }
    
                }
                
                System.out.println();
            }

    }


    public static void jogar() throws Exception{

        System.out.println("-- INICO JOGAR --");
        
        List<Personagem> pers = new ArrayList<>();
        // pers.add(new Personagem(4, 1, "P"));
        // pers.add(new Personagem(2, 3, "P"));
        // pers.add(new Personagem(1, 5, "P"));
        
        pers.add(new Player(1, 2, "O"));
        pers.add(new Inimigo(2, 0, "X"));
        pers.add(new Inimigo(2, 1, "X"));

        Scanner leitor = new Scanner(System.in);

        while (true) {
            tabuleiro(6, 6, pers);
            System.out.println("--------------------\n");
            
            for (int i = 0; i < pers.size(); i++) {
                System.out.println("(" + (i+1) + ") - " + pers.get(i).desenhar());
            }
            System.out.println("--------------------\n");

            try{
                System.out.print("Personagem: ");
                int per = Integer.parseInt(leitor.nextLine()) - 1;
                
                System.out.print("Dir: ");
                int dir = Integer.parseInt(leitor.nextLine());
    
                // pers.get(per).mover(dir);
                pers.get(per).tentarMover(dir, 6, 6);
            }catch(IndexOutOfBoundsException io){
                System.out.println("ERRO! PERSONAGEM NÃO EXISTE!");
            }catch(NumberFormatException nf){
                System.out.println("ERRO! DIGITE UM NÚMERO!");
            }catch(Exception e){
                e.printStackTrace();
            }

            System.out.println("-- FIM JOGAR --");
        }

        // Tentar Andar
        // Tentar Herança

        // Depois
        // Tentar Xadrez


    }


}