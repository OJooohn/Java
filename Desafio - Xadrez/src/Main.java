import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // IntelliJ colors
    // Console Background: 9E9E9E
    // Error: FF0018
    // Standart output: 000000
    // System output: 000000
    // User input: 00FF24

    // Green: FFFFFF both
    // Black: 000000 both

    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\u001B[93m";  // YELLOW
    public static final String BLUE = "\u001B[94m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[48m";  // WHITE

    public static void printBackground(int i, int j){
        if(i % 2 == 0){
            if(j % 2 == 0)
                System.out.print(GREEN_BACKGROUND);
            else
                System.out.print(BLACK_BACKGROUND);
        } else {
            if(j % 2 == 0)
                System.out.print(BLACK_BACKGROUND);
            else
                System.out.print(GREEN_BACKGROUND);
        }
    }

    public static void imprimirTabuleiro(List<Personagem> personagens, List<Inimigo> inimigos){

        System.out.println("--------------------------------------------------------------");
        System.out.println("-                          TABULEIRO                         -");
        System.out.println("--------------------------------------------------------------");

        char letra = 'A';
        int i;
        System.out.print("     \t");
        for(i = 0; i < 8; i++){
            System.out.print("[ " + (i + 1) + RESET + " ]");
        }
        System.out.println();
        System.out.println();

        for (int j = 0; j < 8; j++, letra++) {
            System.out.print("[ " + letra + RESET + " ]\t");
            for (i = 0; i < 8; i++) {
                printBackground(i, j);
                boolean encontrado = false;
                for (Personagem p : personagens) {
                    
                    if (p.getposX() == j && p.getposY() == i) {
                        System.out.print("[ " + p.getIcone() +  " ]" + RESET);
                        //printBackground(i, j);
                        //System.out.print("[ " + RESET + p.getIcone());
                        //printBackground(i, j);
                        //System.out.print( " ]" + RESET);
                        encontrado = true;
                        break;
                    }
                }
                for (Inimigo I : inimigos) {
                    if (I.getposX() == j && I.getposY() == i) {
                        System.out.print("[ " + I.getIcone() +  " ]" + RESET);
                        //printBackground(i, j);
                        //System.out.print("[ " + RESET + I.getIcone());
                        //printBackground(i, j);
                        //System.out.print( " ]" + RESET);
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado){
                    //System.out.print("[");
                    //printBackground(i, j);
                    //System.out.print("   "  + RESET);
                    //System.out.print("]");
                    System.out.print("[   ]" + RESET);
                }
                if(i == 7)
                    System.out.printf("\t");
            }
            System.out.print("[ " + BLUE_BOLD + letra + RESET + " ]");
            System.out.println();
            if(j == 7)
                System.out.println();
        }
        System.out.print("     \t");
        for(i = 0; i < 8; i++){
            System.out.print("[ " + (i + 1) + RESET + " ]");
        }
        System.out.println();

        System.out.println();
        System.out.println("--------------------------------------------------------------");
    }

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        Tabuleiro tabuleiro = new Tabuleiro(8, 8);  
        List<Personagem> personagens = new ArrayList<>();
        List<Inimigo> inimigos = new ArrayList<>();

        int i, j, rodada = 0;

        // Peças Brancas

        // Peões
        for(i = 0; i < 8; i++){
            //personagens.add(new Personagem("♙" , 6, i));
            personagens.add(new Personagem("♙" , 6, i));
        }

        // Torres
        personagens.add(new Personagem("♖", 7, 0));
        personagens.add(new Personagem("♖", 7, 7));

        // Cavalos
        personagens.add(new Personagem("♘", 7, 1));
        personagens.add(new Personagem("♘", 7, 6));

        // Bispos
        personagens.add(new Personagem("♗", 7, 2));
        personagens.add(new Personagem("♗", 7, 5));

        // Rainha
        personagens.add(new Personagem("♕", 7, 3));
        
        // Rei
        personagens.add(new Personagem("♔", 7, 4));
        
        // Peças Pretas

        // Peões
        for(i = 0; i < 8; i++){
            inimigos.add(new Inimigo("♟", 1, i));
        }

        // Torres
        inimigos.add(new Inimigo("♜", 0, 0));
        inimigos.add(new Inimigo("♜", 0, 7));

        // Cavalos
        inimigos.add(new Inimigo("♞", 0, 1));
        inimigos.add(new Inimigo("♞", 0, 6));

        // Bispos
        inimigos.add(new Inimigo("♝", 0, 2));
        inimigos.add(new Inimigo("♝", 0, 5));

        // Rainha
        inimigos.add(new Inimigo("♛", 0, 3));
        
        // Rei
        inimigos.add(new Inimigo("♚", 0, 4));

        boolean menu = true;

        // Letras = j | Numeros = i

        while(menu){

            int pecas = rodada % 2;
            int linha, coluna;
            char caracterLinha, caracterColuna;
            String pecaSelecionada = "", proximaPosicao = "";
            String[] cortado;

            imprimirTabuleiro(personagens, inimigos);
            switch(pecas){
                case 0:
                    System.out.println("- RODADA DAS PEÇAS BRANCAS                                   -");
                    System.out.println("--------------------------------------------------------------");
                    System.out.print("- SELECIONE A PEÇA (A1 - H8): ");
                    pecaSelecionada = input.nextLine();
                    
                    // Se o tamanho da string for diferente de 2
                    // !Character.isLetter(pecaSelecionada.charAt(0)) --> Se o primeiro caracter não é uma letra entra pro input inválido
                    // !Character.isDigit(pecaSelecionada.charAt(1)) --> Se o segundo caracter não é um número entra pro input inválido
                    if (pecaSelecionada.length() != 2 || !Character.isLetter(pecaSelecionada.charAt(0)) || !Character.isDigit(pecaSelecionada.charAt(1))) {
                        System.out.println("- Input inválido. Insira um input válido entre 'A1' e 'H8'.");
                    } else {
                        cortado = pecaSelecionada.split("(?=\\d)");
                        caracterLinha = cortado[0].charAt(0);
                        linha = caracterLinha - 65;
                        
                        if(linha < 0 || linha > 7){
                            System.out.println("- Input inválido. Insira um input válido entre 'A1' e 'H8'.");
                            break;
                        }
                        
                        caracterColuna = cortado[1].charAt(0);
                        coluna = caracterColuna - 49;
                        
                        if(coluna < 0 || coluna > 7){
                            System.out.println("- Input inválido. Insira um input válido entre 'A1' e 'H8'.");
                            break;
                        }
                        // A1 = linha[0] coluna[0]
                        
                        boolean branca = false;
                        for(i = 0; i < personagens.size(); i++){
                            Personagem p = personagens.get(i);
                            if(p.getposX() == linha && p.getposY() == coluna){
                                branca = true;
                                break;
                            }
                        }
                        if(!branca){
                            System.out.println("- Você selecionou uma peça preta! Selecione uma peça BRANCA!");
                            break;
                        } else {
                            
                            System.out.println("--------------------------------------------------------------");
                            System.out.print("- SELECIONE A PROXIMA POSIÇÃO DA PEÇA (A1 - H8): ");
                            proximaPosicao = input.nextLine();

                            if (pecaSelecionada.length() != 2 || !Character.isLetter(pecaSelecionada.charAt(0)) || !Character.isDigit(pecaSelecionada.charAt(1))) {
                                System.out.println("- Input inválido. Insira um input válido entre 'A1' e 'H8'.");
                            } else {

                                cortado = proximaPosicao.split("(?=\\d)");
                                caracterLinha = cortado[0].charAt(0);
                                linha = caracterLinha - 65;

                                if(linha < 0 || linha > 7){
                                    System.out.println("- Input inválido. Insira um input válido entre 'A1' e 'H8'.");
                                    break;
                                }
                                
                                caracterColuna = cortado[1].charAt(0);
                                coluna = caracterColuna - 49;
                                
                                if(coluna < 0 || coluna > 7){
                                    System.out.println("- Input inválido. Insira um input válido entre 'A1' e 'H8'.");
                                    break;
                                }
                                
                                personagens.get(i).setposX(linha);
                                personagens.get(i).setposY(coluna);
                                rodada++;

                            }
                            
                        }
                    }
                break;

                case 1:
                    System.out.println("- RODADA DAS PEÇAS PRETAS                                   -");
                    System.out.println("--------------------------------------------------------------");
                    System.out.print("- SELECIONE A PEÇA (A1 - H8): ");
                    pecaSelecionada = input.nextLine();
                    
                    // Se o tamanho da string for diferente de 2
                    // !Character.isLetter(pecaSelecionada.charAt(0)) --> Se o primeiro caracter não é uma letra entra pro input inválido
                    // !Character.isDigit(pecaSelecionada.charAt(1)) --> Se o segundo caracter não é um número entra pro input inválido
                    if (pecaSelecionada.length() != 2 || !Character.isLetter(pecaSelecionada.charAt(0)) || !Character.isDigit(pecaSelecionada.charAt(1))) {
                        System.out.println("- Input inválido. Insira um input válido entre 'A1' e 'H8'.");
                    } else {
                        cortado = pecaSelecionada.split("(?=\\d)");
                        caracterLinha = cortado[0].charAt(0);
                        linha = caracterLinha - 65;
                        
                        if(linha < 0 || linha > 7){
                            System.out.println("- Input inválido. Insira um input válido entre 'A1' e 'H8'.");
                            break;
                        }
                        
                        caracterColuna = cortado[1].charAt(0);
                        coluna = caracterColuna - 49;
                        
                        if(coluna < 0 || coluna > 7){
                            System.out.println("- Input inválido. Insira um input válido entre 'A1' e 'H8'.");
                            break;
                        }
                        // A1 = linha[0] coluna[0]
                        
                        boolean preta = false;
                        for(i = 0; i < inimigos.size(); i++){
                            Inimigo I = inimigos.get(i);
                            if(I.getposX() == linha && I.getposY() == coluna){
                                preta = true;
                                break;
                            }
                        }
                        if(!preta){
                            System.out.println("- Você selecionou uma peça branca! Selecione uma peça PRETA!");
                            break;
                        } else {
                            
                            System.out.println("--------------------------------------------------------------");
                            System.out.print("- SELECIONE A PROXIMA POSIÇÃO DA PEÇA (A1 - H8): ");
                            proximaPosicao = input.nextLine();

                            if (pecaSelecionada.length() != 2 || !Character.isLetter(pecaSelecionada.charAt(0)) || !Character.isDigit(pecaSelecionada.charAt(1))) {
                                System.out.println("- Input inválido. Insira um input válido entre 'A1' e 'H8'.");
                            } else {

                                cortado = proximaPosicao.split("(?=\\d)");
                                caracterLinha = cortado[0].charAt(0);
                                linha = caracterLinha - 65;

                                if(linha < 0 || linha > 7){
                                    System.out.println("- Input inválido. Insira um input válido entre 'A1' e 'H8'.");
                                    break;
                                }
                                
                                caracterColuna = cortado[1].charAt(0);
                                coluna = caracterColuna - 49;
                                
                                if(coluna < 0 || coluna > 7){
                                    System.out.println("- Input inválido. Insira um input válido entre 'A1' e 'H8'.");
                                    break;
                                }
                                
                                inimigos.get(i).setposX(linha);
                                inimigos.get(i).setposY(coluna);
                                rodada++;

                            }
                            
                        }
                    }
                break;
            }
        }

        input.close();
    }
}
