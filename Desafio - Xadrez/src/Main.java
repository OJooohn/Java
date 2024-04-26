import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // CONFIGURAR ANTES DE INICIAR O PROGRAMA!

    // IntelliJ Terminal colors
    // Theme: Dark Theme Default
    // Console Background: 000000
    // Error: FF0019
    // Standart output: 000000
    // System output: FFFFFF
    // User input: 00FF24

    // Está em ordem nas configurações
    // Black: B16E41 both
    // Bright Red: FFD599 both
    // Cyan: B16E41 both
    // Green: FFFFFF both
    // White (gray): FFD599 both

    // Reset
    public static final String RESET = "\033[0m"; // Text Reset

    // Regular Colors
    public static final String RED = "\033[0;31m"; // RED --> errors
    public static final String BLUE = "\033[0;34m"; // BLUE --> press to continue

    public static final String GREEN = "\033[0;32m"; // GREEN --> WHITE CHARACTER IN INTELLIJ

    public static final String RED_BRIGHT = "\033[0;91m"; // RED --> para caracteres brancos
    public static final String CYAN = "\033[0;36m"; // CYAN --> para caracteres pretos

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m"; // BLACK
    public static final String WHITE_BACKGROUND = "\033[47m"; // WHITE

    public static void pressToContinue(Scanner input) {
        System.out.println(GREEN + "--------------------------------------------------------------");
        System.out.println(
                GREEN + "- " + BLUE + "Pressione qualquer tecla para continuar..." + RESET + "                 -");
        System.out.println(GREEN + "--------------------------------------------------------------");
        input.nextLine();
    }

    public static void printBackground(int i, int j) {
        if (i % 2 == 0) {
            if (j % 2 == 0)
                System.out.print(WHITE_BACKGROUND);
            else
                System.out.print(BLACK_BACKGROUND);
        } else {
            if (j % 2 == 0)
                System.out.print(BLACK_BACKGROUND);
            else
                System.out.print(WHITE_BACKGROUND);
        }
    }

    public static void imprimirTabuleiro(List<Peca> pecas) {
        // BRANCAS: ♔ ♙ ♖ ♘ ♗ ♕
        // PRETAS: ♚ ♟ ♜ ♞ ♝ ♛
        int i;
        for (i = 0; i < 15; i++) {
            System.out.println();
        }
        System.out.println(GREEN + "--------------------------------------------------------------");
        System.out.println(GREEN + "-                          TABULEIRO                         -");
        System.out.println(GREEN + "--------------------------------------------------------------");
        System.out.println(GREEN + "- LEGENDA:                                                   -");
        System.out.println(GREEN + "- PEÇAS BRANCAS (VAZIO POR DENTRO): " + RESET + WHITE_BACKGROUND + " ♔ "
                + BLACK_BACKGROUND + " ♙ " + WHITE_BACKGROUND + " ♖ " + BLACK_BACKGROUND + " ♘ " + WHITE_BACKGROUND
                + " ♗ " + BLACK_BACKGROUND + " ♕ " + GREEN + "   -");
        System.out.println(GREEN + "- PEÇAS PRETAS  (PREENCHIDAS):      " + RESET + BLACK_BACKGROUND + " ♚ "
                + WHITE_BACKGROUND + " ♟ " + BLACK_BACKGROUND + " ♜ " + WHITE_BACKGROUND + " ♞ " + BLACK_BACKGROUND
                + " ♝ " + WHITE_BACKGROUND + " ♛ " + GREEN + "   -");
        System.out.println(GREEN + "--------------------------------------------------------------");

        char letra = 'A';
        System.out.print("     \t");
        for (i = 0; i < 8; i++) {
            System.out.print(GREEN + "[ " + (i + 1) + " ]" + RESET);
        }
        System.out.println();
        System.out.println();

        for (int j = 0; j < 8; j++, letra++) {

            System.out.print(GREEN + "[ " + letra + " ]\t" + RESET);

            for (i = 0; i < 8; i++) {
                printBackground(i, j);
                boolean encontrado = false;

                for (Peca p : pecas) {

                    if (p.getposX() == j && p.getposY() == i) {
                        System.out.print("[ " + p.getIcone() + " ]" + RESET);
                        encontrado = true;
                        break;
                    }

                }

                if (!encontrado)
                    System.out.print("[   ]" + RESET);

                if (i == 7)
                    System.out.print("\t");
            }
            System.out.print(GREEN + "[ " + letra + " ]\t" + RESET);
            System.out.println();
            if (j == 7)
                System.out.println();
        }
        System.out.print("     \t");
        for (i = 0; i < 8; i++) {
            System.out.print(GREEN + "[ " + (i + 1) + " ]" + RESET);
        }
        System.out.println();

        System.out.println();
        System.out.println(GREEN + "--------------------------------------------------------------");
    }

    public static boolean verificarPosicao(List<Personagem> personagens, int linha, int coluna) {
        boolean verificado = false;
        for (Personagem p : personagens) {
            if (p.getposX() == linha && p.getposY() == coluna) {
                verificado = false;
                break;
            } else {
                verificado = true;
            }
        }

        if (!verificado) {
            System.out.println(GREEN + "--------------------------------------------------------------");
            System.out.println(
                    GREEN + "- " + RED + "DUAS PEÇAS NÃO PODEM FICAR NA MESMA POSIÇÃO!" + GREEN + "               -");
        }

        return verificado;
    }

    public static boolean verificarInimigo(List<Inimigo> inimigos, int linha, int coluna){
        boolean verificado = false;
        for(Inimigo i : inimigos){
            if(i.getposX() == linha && i.getposY() == coluna){
                // System.out.println("Peca = " + p.getIcone() + " | X = " + p.getposX() + " | Y = " + p.getposY());
                verificado = false;
                break;
            } else {
                verificado = true;
            }
        }

        if(!verificado){
            System.out.println(GREEN + "--------------------------------------------------------------");
            System.out.println(GREEN + "- " + RED + "DUAS PEÇAS NÃO PODEM FICAR NA MESMA POSIÇÃO!" + GREEN + "               -");
        }

        return verificado;
    }

    public static boolean verificarCastling(Peca p, int linha, int coluna, List<Personagem> personagens,
            List<Inimigo> inimigos, int pecas) {

        boolean torreDireita = false, torreEsquerda = false, castling;
        int indiceTorre;

        int Xd, Yd, Xe, Ye;

        if (pecas == 0) {
            Xd = 7;
            Yd = 7;
            Xe = 7;
            Ye = 0;
        } else {
            Xd = 0;
            Yd = 7;
            Xe = 0;
            Ye = 0;
        }

        if ((linha == Xe && coluna == Ye) || (linha == Xd && coluna == Yd)) {
            if (p.getMovimentos() == 0) {
                if (pecas == 0) {
                    for (indiceTorre = 0; indiceTorre < personagens.size(); indiceTorre++) {
                        Personagem pers = personagens.get(indiceTorre);

                        if (pers.getMovimentos() == 0 && pers.getIcone().equals("♖")) {
                            if ((pers.getposX() == linha && pers.getposY() == coluna)
                                    && (linha == Xd && coluna == Yd)) {
                                torreDireita = true;
                                break;
                            }
                            if ((pers.getposX() == linha && pers.getposY() == coluna)
                                    && (linha == Xe && coluna == Ye)) {
                                torreEsquerda = true;
                                break;
                            }
                        }
                    }
                } else {
                    for (indiceTorre = 0; indiceTorre < inimigos.size(); indiceTorre++) {
                        Inimigo ini = inimigos.get(indiceTorre);

                        if (ini.getMovimentos() == 0 && ini.getIcone().equals("♜")) {
                            if ((ini.getposX() == linha && ini.getposY() == coluna) && (linha == Xd && coluna == Yd)) {
                                torreDireita = true;
                                break;
                            }
                            if ((ini.getposX() == linha && ini.getposY() == coluna) && (linha == Xe && coluna == Ye)) {
                                torreEsquerda = true;
                                break;
                            }
                        }

                    }
                }

                if (!torreDireita && !torreEsquerda) {
                    return false;
                }

                int i;

                if (torreDireita) {
                    if (pecas == 0) {

                        for (i = p.getposY(); i < 7; i++) {
                            for (Personagem pers : personagens) {

                                if (pers.getposX() == 7 && pers.getposY() == i && !pers.getIcone().equals("♖")
                                        && !pers.getIcone().equals("♔")) {
                                    return false;
                                }

                            }
                        }

                        p.setposY(6);
                        personagens.get(indiceTorre).setposY(5);
                    } else {

                        for (i = p.getposY(); i < 7; i++) {
                            for (Inimigo pers : inimigos) {

                                if (pers.getposX() == 0 && pers.getposY() == i && !pers.getIcone().equals("♜")
                                        && !pers.getIcone().equals("♚")) {
                                    return false;
                                }

                            }
                        }

                        p.setposY(6);
                        inimigos.get(indiceTorre).setposY(5);

                        castling = true;
                        System.out.println("Castling: " + castling);
                    }
                    return true;
                }

                if (torreEsquerda) {
                    if (pecas == 0) {

                        for (i = p.getposY(); i > 0; i--) {
                            for (Personagem pers : personagens) {

                                if (pers.getposX() == 7 && pers.getposY() == i && !pers.getIcone().equals("♖")
                                        && !pers.getIcone().equals("♔")) {
                                    return false;
                                }

                            }
                        }

                        p.setposY(2);
                        personagens.get(indiceTorre).setposY(3);
                    } else {

                        for (i = p.getposY(); i > 0; i--) {
                            for (Inimigo pers : inimigos) {

                                if (pers.getposX() == 0 && pers.getposY() == i && !pers.getIcone().equals("♜")
                                        && !pers.getIcone().equals("♚")) {
                                    return false;
                                }

                            }
                        }

                        p.setposY(2);
                        inimigos.get(indiceTorre).setposY(3);
                    }
                    return true;
                }

            }
        }

        return false;
    }

    public static String promocaoPeao(Scanner input, int pecas) {

        String icone = " ";
        int opcao = 0;

        
        do {
            System.out.println(GREEN + "--------------------------------------------------------------");
            System.out.println(GREEN + "- [1] TORRE  ♖ | ♜                                         -");        
            System.out.println(GREEN + "- [2] CAVALO ♘ | ♞                                         -");        
            System.out.println(GREEN + "- [3] BISPO  ♗ | ♝                                         -");        
            System.out.println(GREEN + "- [4] RAINHA ♕ | ♛                                         -"); 
            System.out.print("- SELECIONE A PEÇA: ");
            opcao = Integer.parseInt(input.nextLine());
            
            switch (opcao) {
                case 1:
                    if(pecas == 0)
                        return "♖";
                    else
                        return "♜";
                
                case 2:
                    if(pecas == 0)
                        return "♘";
                    else
                        return "♞";
                
                case 3:
                    if(pecas == 0)
                        return "♗";
                    else
                        return "♝";
                
                case 4:
                    if(pecas == 0)
                        return "♕";
                    else
                        return "♛";
                
                default: 
                    System.out.println(GREEN + "--------------------------------------------------------------");
                    System.out.println(GREEN + "- " + RED + "PEÇA SELECIONA INVÁLIDA! " + BLUE + "DIGITE NOVEMENTE...               -");
                    pressToContinue(input);
                break;
            }   

        } while (opcao >= 0 && opcao <= 4);

        return icone;

    }

    public static boolean verificarRei(int linha, int coluna, Peca p) {

        return (p.getposX() - linha) <= 1 && (p.getposX() - linha) >= -1 && (p.getposY() - coluna) <= 1
                && (p.getposY() - coluna) >= -1;
    }

    public static boolean verificarTorre(List<Personagem> personagens, List<Inimigo> inimigos, int linha, int coluna,
            Peca p) {
        int j;

        boolean verificado = false;
        boolean colPers = false, colIni = false;

        if (p.getposX() == linha || p.getposY() == coluna) {
            if (p.getposX() == linha) {
                // Direita
                if (p.getposY() - coluna < 0) {
                    for (j = p.getposY() + 1; j < coluna; j++) {
                        for (Personagem P : personagens) {
                            if (P.getposY() == j && P.getposX() == p.getposX()) {
                                colPers = true;
                                break;
                            }
                        }
                        for (Inimigo I : inimigos) {
                            if (I.getposY() == j && I.getposX() == p.getposX()) {
                                colIni = true;
                                break;
                            }
                        }
                    }

                } else {
                    // Esquerda
                    for (j = p.getposY() - 1; j > coluna; j--) {
                        for (Personagem P : personagens) {
                            if (P.getposY() == j && P.getposX() == p.getposX()) {
                                colPers = true;
                                break;
                            }
                        }

                        for (Inimigo I : inimigos) {
                            if (I.getposY() == j && I.getposX() == p.getposX()) {
                                colIni = true;
                                break;
                            }
                        }
                    }
                }
            } else {
                if (p.getposY() == coluna) {
                    // Baixo
                    if (p.getposX() - linha < 0) {
                        for (j = p.getposX() + 1; j < linha; j++) {
                            for (Personagem P : personagens) {
                                if (P.getposX() == j && P.getposY() == p.getposY()) {
                                    colPers = true;
                                    break;
                                }
                            }
                            for (Inimigo I : inimigos) {
                                if (I.getposY() == j && I.getposX() == p.getposX()) {
                                    colIni = true;
                                    break;
                                }
                            }
                        }
                    } else {
                        // Acima
                        for (j = p.getposX() - 1; j > linha; j--) {
                            for (Personagem P : personagens) {
                                if (P.getposX() == j && P.getposY() == p.getposY()) {
                                    // System.out.println("Peca " + P.getIcone() + " | X = " + P.getposX() + " | Y =
                                    // " + P.getposY());
                                    colPers = true;
                                    break;
                                }
                            }
                            for (Inimigo I : inimigos) {
                                // System.out.println("Ini " + I.getIcone() + " | X = " + I.getposX() + " | Y =
                                // " + I.getposY());
                                if (I.getposX() == j && I.getposY() == p.getposY()) {
                                    colIni = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        if (!colPers && !colIni) {
            verificado = true;
        }

        return verificado;
    }

    public static boolean verificarCavalo(int linha, int coluna, Peca p) {

        boolean verificado;

        if (p.getposX() - linha == -2 || p.getposX() - linha == 2) {
            verificado = p.getposY() - coluna == 1 || p.getposY() - coluna == -1;
        } else {
            if (p.getposY() - coluna == -2 || p.getposY() - coluna == 2) {
                verificado = p.getposX() - linha == 1 || p.getposX() - linha == -1;
            } else {
                verificado = false;
            }

        }

        return verificado;
    }

    public static boolean verificarBispo(List<Personagem> personagens, List<Inimigo> inimigos, int pecas, int linha,
            int coluna, Peca p) {

        boolean verificado = false;
        int deltaX, deltaY;

        boolean Xnegativo = false, Ynegativo = false;

        int j, aux;

        deltaX = p.getposX() - linha;
        deltaY = p.getposY() - coluna;

        if (deltaX < 0) {
            deltaX *= -1;
            Xnegativo = true;
        }
        if (deltaY < 0) {
            deltaY *= -1;
            Ynegativo = true;
        }

        if (deltaX == deltaY) {
            // aux = X e j = Y
            if (!Xnegativo && !Ynegativo) {
                for (aux = p.getposX() - 1; aux >= linha; aux--) {
                    for (j = p.getposY() - 1; j >= coluna; j--) {
                        if (pecas == 0) {
                            for (Personagem P : personagens) {
                                if (P.getposX() == aux && P.getposY() == j) {
                                    verificado = false;
                                    return verificado;
                                } else {
                                    verificado = true;
                                }
                            }
                            if (verificado) {
                                for (Inimigo I : inimigos) {
                                    if (I.getposX() == aux && I.getposY() == j) {
                                        if (aux != linha && j != coluna) {
                                            verificado = false;
                                            return verificado;
                                        }
                                    } else {
                                        verificado = true;
                                    }
                                }
                            }
                            return verificado;
                        } else {
                            for (Inimigo I : inimigos) {
                                if (I.getposX() == aux && I.getposY() == j) {
                                    verificado = false;
                                    return verificado;
                                } else {
                                    verificado = true;
                                }
                            }
                            if (verificado) {
                                for (Personagem P : personagens) {
                                    if (P.getposX() == aux && P.getposY() == j) {
                                        if (aux != linha && j != coluna) {
                                            verificado = false;
                                            return verificado;
                                        }
                                    } else {
                                        verificado = true;
                                    }
                                }
                            }
                            return verificado;
                        }
                    }
                }
            }
            if (Xnegativo && Ynegativo) {
                for (aux = p.getposX() + 1; aux <= linha; aux++) {
                    for (j = p.getposY() + 1; j <= coluna; j++) {
                        if (pecas == 0) {
                            for (Personagem P : personagens) {
                                if (P.getposX() == aux && P.getposY() == j) {
                                    verificado = false;
                                    return verificado;
                                } else {
                                    verificado = true;
                                }
                            }
                            if (verificado) {
                                for (Inimigo I : inimigos) {
                                    if (I.getposX() == aux && I.getposY() == j) {
                                        if (aux != linha && j != coluna) {
                                            verificado = false;
                                            return verificado;
                                        }
                                    } else {
                                        verificado = true;
                                    }
                                }
                            }
                            return verificado;
                        } else {
                            for (Inimigo I : inimigos) {
                                if (I.getposX() == aux && I.getposY() == j) {
                                    verificado = false;
                                    return verificado;
                                } else {
                                    verificado = true;
                                }
                            }
                            if (verificado) {
                                for (Personagem P : personagens) {
                                    if (P.getposX() == aux && P.getposY() == j) {
                                        if (aux != linha && j != coluna) {
                                            verificado = false;
                                            return verificado;
                                        }
                                    } else {
                                        verificado = true;
                                    }
                                }
                            }
                            return verificado;
                        }
                    }
                }
            } else {
                if (Xnegativo && !Ynegativo) {
                    for (aux = p.getposX() + 1; aux <= linha; aux++) {
                        for (j = p.getposY() - 1; j >= coluna; j--) {
                            if (pecas == 0) {
                                for (Personagem P : personagens) {
                                    if (P.getposX() == aux && P.getposY() == j) {
                                        verificado = false;
                                        return verificado;
                                    } else {
                                        verificado = true;
                                    }
                                }
                                if (verificado) {
                                    for (Inimigo I : inimigos) {
                                        if (I.getposX() == aux && I.getposY() == j) {
                                            if (aux != linha && j != coluna) {
                                                verificado = false;
                                                return verificado;
                                            }
                                        } else {
                                            verificado = true;
                                        }
                                    }
                                }
                                return verificado;
                            } else {
                                for (Inimigo I : inimigos) {
                                    if (I.getposX() == aux && I.getposY() == j) {
                                        verificado = false;
                                        return verificado;
                                    } else {
                                        verificado = true;
                                    }
                                }
                                if (verificado) {
                                    for (Personagem P : personagens) {
                                        if (P.getposX() == aux && P.getposY() == j) {
                                            if (aux != linha && j != coluna) {
                                                verificado = false;
                                                return verificado;
                                            }
                                        } else {
                                            verificado = true;
                                        }
                                    }
                                }
                                return verificado;
                            }
                        }
                    }
                }
                if (!Xnegativo && Ynegativo) {
                    for (aux = p.getposX() - 1; aux >= linha; aux--) {
                        for (j = p.getposY() + 1; j <= coluna; j++) {
                            if (pecas == 0) {
                                for (Personagem P : personagens) {
                                    if (P.getposX() == aux && P.getposY() == j) {
                                        verificado = false;
                                        return verificado;
                                    } else {
                                        verificado = true;
                                    }
                                }
                                if (verificado) {
                                    for (Inimigo I : inimigos) {
                                        if (I.getposX() == aux && I.getposY() == j) {
                                            if (aux != linha && j != coluna) {
                                                verificado = false;
                                                return verificado;
                                            }
                                        } else {
                                            verificado = true;
                                        }
                                    }
                                }
                                return verificado;
                            } else {
                                for (Inimigo I : inimigos) {
                                    if (I.getposX() == aux && I.getposY() == j) {
                                        verificado = false;
                                        return verificado;
                                    } else {
                                        verificado = true;
                                    }
                                }
                                if (verificado) {
                                    for (Personagem P : personagens) {
                                        if (P.getposX() == aux && P.getposY() == j) {
                                            if (aux != linha && j != coluna) {
                                                verificado = false;
                                                return verificado;
                                            }
                                        } else {
                                            verificado = true;
                                        }
                                    }
                                }
                                return verificado;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    public static boolean verificarRainha(List<Personagem> personagens, List<Inimigo> inimigos, int pecas, int linha,
            int coluna, Peca p) {

        boolean verificado;

        if (p.getposX() == linha || p.getposY() == coluna) {
            verificado = verificarTorre(personagens, inimigos, linha, coluna, p);
        } else {
            verificado = verificarBispo(personagens, inimigos, pecas, linha, coluna, p);
        }

        return verificado;
    }

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            List<Peca> pecas = new ArrayList<Peca>();

            int i, j, rodada = 0;

            // Rei --> Rei como posição 0 para verificar o ganhador do jogo
            pecas.add(new Rei("♔", 7, 4, true, false));

            // Rei --> Rei como posição 0 para verificar o ganhador do jogo
            pecas.add(new Rei("♚", 0, 4, false, true));

            // Peças Brancas

            // Peões
            for (i = 0; i < 8; i++) {
                // personagens.add(new Personagem("♙" , 6, i));
                pecas.add(new Peao("♙", 6, i, true, false));
            }

            // Torres
            pecas.add(new Torre("♖", 7, 0, true, false));
            pecas.add(new Torre("♖", 7, 7, true, false));

            // Cavalos
            pecas.add(new Cavalo("♘", 7, 1, true, false));
            pecas.add(new Cavalo("♘", 7, 6, true, false));

            // Bispos
            pecas.add(new Bispo("♗", 7, 2, true, false));
            pecas.add(new Bispo("♗", 7, 5, true, false));
            // Rainha
            pecas.add(new Rainha("♕", 7, 3, true, false));

            // Peças Pretas

            // Peões
            for (i = 0; i < 8; i++) {
                pecas.add(new Peao("♟", 1, i, false, true));
            }

            // Torres
            pecas.add(new Torre("♜", 0, 0, false, true));
            pecas.add(new Torre("♜", 0, 7, false, true));

            // Cavalos
            pecas.add(new Cavalo("♞", 0, 1, false, true));
            pecas.add(new Cavalo("♞", 0, 6, false, true));

            // Bispos
            pecas.add(new Bispo("♝", 0, 2, false, true));
            pecas.add(new Bispo("♝", 0, 5, false, true));

            // Rainha
            pecas.add(new Rainha("♛", 0, 3, false, true));

            boolean menu = true;
            boolean castling = false;

            // Letras = j | Numeros = i

            while (menu) {

                int peca = rodada % 2;
                int linha, coluna;
                char caracterLinha, caracterColuna, icone;
                String pecaSelecionada, proximaPosicao;
                String[] cortado;
                boolean verificado = false, colisao;

                imprimirTabuleiro(pecas);
                if (!pecas.get(0).getIcone().equals("♔")) {
                    System.out.println(GREEN + "- PEÇAS PRETAS VENCERAM!                                     -");
                    System.out.println(GREEN + "--------------------------------------------------------------");
                    break;
                }
                if (!pecas.get(1).getIcone().equals("♚")) {
                    System.out.println(GREEN + "- PEÇAS PRETAS VENCERAM!                                     -");
                    System.out.println(GREEN + "--------------------------------------------------------------");
                    break;
                }
                // RETIRAR PARA FUNCIONAR NORMALMENTE
                // pecas = 0;

                switch (peca) {
                    case 0:
                        System.out.println(GREEN + "- RODADA DAS PEÇAS " + RED_BRIGHT + "BRANCAS" + GREEN
                                + "                                   -");
                        System.out.println(GREEN + "--------------------------------------------------------------");
                        System.out.println(GREEN + "- DIGITE 'SAIR' PARA FINALIZAR O JOGO                        -");
                        System.out.print(GREEN + "- SELECIONE A PEÇA (A1 - H8): ");
                        pecaSelecionada = input.nextLine();

                        if (pecaSelecionada.equalsIgnoreCase("SAIR")) {
                            System.out
                                    .println(GREEN + "--------------------------------------------------------------");
                            System.out
                                    .println(GREEN + "- JOGO FINALIZADO SEM VENCEDORES                             -");
                            System.out
                                    .println(GREEN + "--------------------------------------------------------------");
                            menu = false;
                            break;
                        }

                        // Se o tamanho da string for diferente de 2
                        // !Character.isLetter(pecaSelecionada.charAt(0)) --> Se o primeiro caracter não
                        // é uma letra entra pro input Ginválido
                        // !Character.isDigit(pecaSelecionada.charAt(1)) --> Se o segundo caracter não é
                        // um número entra pro input inválido
                        if (pecaSelecionada.length() != 2 || !Character.isLetter(pecaSelecionada.charAt(0))
                                || !Character.isDigit(pecaSelecionada.charAt(1))) {
                            System.out.println(GREEN + "- " + RED
                                    + "Input inválido. Insira um input válido entre 'A1' e 'H8'." + GREEN);
                            pressToContinue(input);
                        } else {
                            cortado = pecaSelecionada.split("");
                            caracterLinha = cortado[0].toUpperCase().charAt(0);
                            linha = caracterLinha - 65;

                            if (linha < 0 || linha > 7) {
                                System.out.println(GREEN + "- " + RED
                                        + "Input inválido. Insira um input válido entre 'A1' e 'H8'." + GREEN);
                                pressToContinue(input);
                                break;
                            }

                            caracterColuna = cortado[1].charAt(0);
                            coluna = caracterColuna - 49;

                            if (coluna < 0 || coluna > 7) {
                                System.out.println(GREEN + "- " + RED
                                        + "Input inválido. Insira um input válido entre 'A1' e 'H8'." + GREEN);
                                pressToContinue(input);
                                break;
                            }
                            // A1 = linha[0] coluna[0]

                            boolean branca = false;

                            for (i = 0; i < pecas.size(); i++) {
                                Peca p = pecas.get(i);
                                if (p.getposX() == linha && p.getposY() == coluna && p.getIsWhite()) {
                                    branca = true;
                                    break;
                                }
                            }
                            if (!branca) {
                                System.out.println(GREEN + "- " + RED
                                        + "Você selecionou uma peça preta! Selecione uma peça BRANCA!" + GREEN + " -");
                                pressToContinue(input);
                                break;
                            } else {
                                // Limitar movimentos das peças e verificar colisões ao movimentar !! PARTE MAIS
                                // DIFÍCIL DO DESAFIO !!
                                // String iconePeca = personagens.get(i).getIcone();

                                do {
                                    icone = pecas.get(i).getIcone().charAt(0);

                                    System.out.println(
                                            GREEN + "--------------------------------------------------------------");
                                    System.out.println(GREEN + "- PECA SELECIONADA: " + icone
                                            + "                                        -");

                                    System.out.println(
                                            GREEN + "--------------------------------------------------------------");
                                    System.out.println(
                                            GREEN + "- DIGITE 'VOLTAR' PARA SELECIONAR OUTRA PEÇA:                -");
                                    System.out.print(GREEN + "- SELECIONE A PROXIMA POSIÇÃO DA PEÇA (A1 - H8): ");
                                    proximaPosicao = input.nextLine();

                                    if (proximaPosicao.equalsIgnoreCase("VOLTAR")) {
                                        break;
                                    } else {

                                        if (!Character.isLetter(proximaPosicao.charAt(0))
                                                || !Character.isDigit(proximaPosicao.charAt(1))) {
                                            System.out.println(GREEN + "- " + RED
                                                    + "Input inválido. Insira um input válido entre 'A1' e 'H8'."
                                                    + GREEN);
                                            pressToContinue(input);
                                            break;
                                        }

                                        cortado = proximaPosicao.split("");
                                        caracterLinha = cortado[0].toUpperCase().charAt(0);
                                        linha = caracterLinha - 65;

                                        if (linha < 0 || linha > 7) {
                                            System.out.println(GREEN + "- " + RED
                                                    + "Input inválido. Insira um input válido entre 'A1' e 'H8'."
                                                    + GREEN);
                                            pressToContinue(input);
                                            break;
                                        }

                                        caracterColuna = cortado[1].charAt(0);
                                        coluna = caracterColuna - 49;

                                        if (coluna < 0 || coluna > 7) {
                                            System.out.println(GREEN + "- " + RED
                                                    + "Input inválido. Insira um input válido entre 'A1' e 'H8'."
                                                    + GREEN);
                                            pressToContinue(input);
                                            break;
                                        }

                                        for (Peca p : pecas) {
                                            if(p.getposX() == linha && p.getposY() == coluna) {
                                                p.movimentarPeca();
                                            }
                                        }


                                        if (!verificado) {
                                            System.out.println(GREEN
                                                    + "--------------------------------------------------------------");
                                            System.out.println(GREEN + "- " + RED + "MOVIMENTO DE PEÇA INVÁLIDO!"
                                                    + GREEN + "                                -");
                                            pressToContinue(input);
                                            break;
                                        }

                                        if (!colisao) {
                                            pressToContinue(input);
                                            break;
                                        } else {
                                            for (j = 0; j < inimigos.size(); j++) {
                                                Inimigo I = inimigos.get(j);
                                                if (I.getposX() == linha && I.getposY() == coluna) {
                                                    inimigos.remove(j);
                                                    break;
                                                }
                                            }

                                            if (!castling) {
                                                System.out.println("teste");
                                                personagens.get(i).setposX(linha);
                                                personagens.get(i).setposY(coluna);
                                            }
                                            personagens.get(i).aumentarMovimentos();
                                            rodada++;
                                        }

                                    }
                                } while (!verificado);
                            }
                        }
                        break;

                    case 1:
                        System.out.println(GREEN + "- RODADA DAS PEÇAS " + CYAN + "PRETAS" + GREEN
                                + "                                   -");
                        System.out.println(GREEN + "--------------------------------------------------------------");
                        System.out.println(GREEN + "- DIGITE 'SAIR' PARA FINALIZAR O JOGO                        -");
                        System.out.print(GREEN + "- SELECIONE A PEÇA (A1 - H8): ");
                        pecaSelecionada = input.nextLine();

                        if (pecaSelecionada.equalsIgnoreCase("SAIR")) {
                            System.out
                                    .println(GREEN + "--------------------------------------------------------------");
                            System.out
                                    .println(GREEN + "- JOGO FINALIZADO SEM VENCEDORES                             -");
                            System.out
                                    .println(GREEN + "--------------------------------------------------------------");
                            menu = false;
                            break;
                        }

                        // Se o tamanho da string for diferente de 2
                        // !Character.isLetter(pecaSelecionada.charAt(0)) --> Se o primeiro caracter não
                        // é uma letra entra pro input inválido
                        // !Character.isDigit(pecaSelecionada.charAt(1)) --> Se o segundo caracter não é
                        // um número entra pro input inválido
                        if (pecaSelecionada.length() != 2 || !Character.isLetter(pecaSelecionada.charAt(0))
                                || !Character.isDigit(pecaSelecionada.charAt(1))) {
                            System.out.println(GREEN + "- " + RED
                                    + "Input inválido. Insira um input válido entre 'A1' e 'H8'." + GREEN);
                            pressToContinue(input);
                        } else {
                            cortado = pecaSelecionada.split("");
                            caracterLinha = cortado[0].toUpperCase().charAt(0);
                            linha = caracterLinha - 65;

                            if (linha < 0 || linha > 7) {
                                System.out.println(GREEN + "- " + RED
                                        + "Input inválido. Insira um input válido entre 'A1' e 'H8'." + GREEN);
                                pressToContinue(input);
                                break;
                            }

                            caracterColuna = cortado[1].charAt(0);
                            coluna = caracterColuna - 49;

                            if (coluna < 0 || coluna > 7) {
                                System.out.println(GREEN + "- " + RED
                                        + "Input inválido. Insira um input válido entre 'A1' e 'H8'." + GREEN);
                                pressToContinue(input);
                                break;
                            }
                            // A1 = linha[0] coluna[0]

                            boolean preta = false;
                            for (i = 0; i < inimigos.size(); i++) {
                                Inimigo I = inimigos.get(i);
                                if (I.getposX() == linha && I.getposY() == coluna) {
                                    preta = true;
                                    break;
                                }
                            }
                            if (!preta) {
                                System.out.println(GREEN + "- " + RED
                                        + "Você selecionou uma peça branca! Selecione uma peça PRETA!" + GREEN + " -");
                                pressToContinue(input);
                                break;
                            } else {

                                do {
                                    icone = inimigos.get(i).getIcone().charAt(0);
                                    System.out.println(
                                            GREEN + "--------------------------------------------------------------");
                                    System.out.println(GREEN + "- PECA SELECIONADA: " + icone
                                            + "                                        -");

                                    System.out.println(
                                            GREEN + "--------------------------------------------------------------");
                                    System.out.println(
                                            GREEN + "- DIGITE 'VOLTAR' PARA SELECIONAR OUTRA PEÇA:                -");
                                    System.out.print(GREEN + "- SELECIONE A PROXIMA POSIÇÃO DA PEÇA (A1 - H8): ");
                                    proximaPosicao = input.nextLine();

                                    if (proximaPosicao.equalsIgnoreCase("VOLTAR")) {
                                        break;
                                    } else {

                                        if (proximaPosicao.length() != 2
                                                || !Character.isLetter(proximaPosicao.charAt(0))
                                                || !Character.isDigit(proximaPosicao.charAt(1))) {
                                            System.out.println(GREEN + "- " + RED
                                                    + "Input inválido. Insira um input válido entre 'A1' e 'H8'."
                                                    + GREEN);
                                            pressToContinue(input);
                                            break;
                                        }

                                        cortado = proximaPosicao.split("");
                                        caracterLinha = cortado[0].toUpperCase().charAt(0);
                                        linha = caracterLinha - 65;

                                        if (linha < 0 || linha > 7) {
                                            System.out.println(GREEN + "- " + RED
                                                    + "Input inválido. Insira um input válido entre 'A1' e 'H8'."
                                                    + GREEN);
                                            pressToContinue(input);
                                            break;
                                        }

                                        caracterColuna = cortado[1].charAt(0);
                                        coluna = caracterColuna - 49;

                                        if (coluna < 0 || coluna > 7) {
                                            System.out.println(GREEN + "- " + RED
                                                    + "Input inválido. Insira um input válido entre 'A1' e 'H8'."
                                                    + GREEN);
                                            pressToContinue(input);
                                            break;
                                        }

                                        Inimigo in = inimigos.get(i);
                                        switch (icone) {
                                            case '♚':
                                                castling = verificarCastling(in, linha, coluna, personagens, inimigos,
                                                        pecas);
                                                if (castling) {
                                                    verificado = true;
                                                    System.out.println(GREEN
                                                            + "--------------------------------------------------------------");
                                                    System.out.println(GREEN
                                                            + "- ROQUE REALIZADO COM SUCESSO!                               -");
                                                    System.out.println(GREEN
                                                            + "--------------------------------------------------------------");
                                                } else {
                                                    verificado = verificarRei(linha, coluna, in);
                                                }
                                                break;

                                            case '♟':
                                                boolean diagonal = false;

                                                for (j = 0; j < personagens.size(); j++) {
                                                    Personagem p = personagens.get(j);
                                                    if (p.getposX() - 1 == in.getposX()
                                                            && p.getposY() + 1 == in.getposY()) {
                                                        diagonal = true;
                                                        break;
                                                    }
                                                    if (p.getposX() - 1 == in.getposX()
                                                            && p.getposY() - 1 == in.getposY()) {
                                                        diagonal = true;
                                                        break;
                                                    }
                                                }

                                                boolean inimigoFrente = false;

                                                for (j = 0; j < personagens.size(); j++) {
                                                    Personagem p = personagens.get(j);
                                                    if (p.getposY() == in.getposY() && p.getposX() == linha) {
                                                        inimigoFrente = true;
                                                        break;
                                                    }
                                                }

                                                if (in.getposX() - linha >= 1) {
                                                    break;
                                                }

                                                if (in.getposX() == 1) {
                                                    if (in.getposX() - linha >= -2 && in.getposY() == coluna) {
                                                        verificado = true;

                                                    } else {
                                                        if (in.getposY() == coluna && in.getposX() - linha == -1)
                                                            verificado = true;
                                                    }
                                                } else {
                                                    if (in.getposX() > linha || (in.getposX() - linha) >= 0
                                                            || (in.getposX() - linha) < -1
                                                            || (in.getposY() != coluna && !diagonal)) {
                                                        break;
                                                    } else {
                                                        verificado = true;
                                                    }
                                                }

                                                if (inimigoFrente) {
                                                    if (in.getposY() == coluna && in.getposX() + 1 == linha) {
                                                        break;
                                                    }
                                                }

                                                if (verificado && linha == 7) {
                                                    in.setIcone(promocaoPeao(input, pecas));
                                                }
                                                break;

                                            case '♜':
                                                verificado = verificarTorre(personagens, inimigos, linha, coluna, in);
                                                break;

                                            case '♞':
                                                verificado = verificarCavalo(linha, coluna, in);
                                                break;

                                            case '♝':
                                                verificado = verificarBispo(personagens, inimigos, pecas, linha, coluna,
                                                        in);
                                                break;

                                            case '♛':
                                                verificado = verificarRainha(personagens, inimigos, pecas, linha,
                                                        coluna, in);
                                                break;
                                        }

                                        if (castling) {
                                            colisao = true;
                                        } else {
                                            colisao = verificarInimigo(inimigos, linha, coluna);
                                        }

                                        if (!verificado) {
                                            System.out.println(GREEN
                                                    + "--------------------------------------------------------------");
                                            System.out.println(GREEN + "- " + RED + "MOVIMENTO DE PEÇA INVÁLIDO!"
                                                    + GREEN + "                                -");
                                            pressToContinue(input);
                                            break;
                                        }

                                        if (!colisao) {
                                            pressToContinue(input);
                                            break;
                                        } else {
                                            for (j = 0; j < personagens.size(); j++) {
                                                Personagem p = personagens.get(j);
                                                if (p.getposX() == linha && p.getposY() == coluna) {
                                                    personagens.remove(j);
                                                    break;
                                                }
                                            }

                                            if (!castling) {
                                                inimigos.get(i).setposX(linha);
                                                inimigos.get(i).setposY(coluna);
                                            }

                                            inimigos.get(i).aumentarMovimentos();
                                            rodada++;
                                        }

                                    }
                                } while (!verificado);
                            }
                        }
                        break;
                }
            }
        }
    }
}
