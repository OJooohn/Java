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
    // Cyan: B16E41 both
    // Green: FFFFFF both
    // White (gray): FFD599 both
    // Bright Red: FFD599 both

    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String WHITE = "\033[0;37m";   // WHITE
    public static final String RED = "\033[0;31m";     // RED --> errors
    public static final String BLUE = "\033[0;34m";    // BLUE --> press to continue

    public static final String GREEN = "\033[0;32m";   // GREEN --> WHITE CHARACTER IN INTELLIJ

    public static final String RED_BRIGHT = "\033[0;91m";    // RED --> para caracteres brancos
    public static final String CYAN = "\033[0;36m";   // CYAN --> para caracteres pretos

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

    public static void pressToContinue(Scanner input){
        System.out.println(GREEN + "--------------------------------------------------------------");
        System.out.println(GREEN + "- " + BLUE + "Pressione qualquer tecla para continuar..." + RESET + "                 -");
        System.out.println(GREEN + "--------------------------------------------------------------");
        input.nextLine();
    }

    public static void printBackground(int i, int j){
        if(i % 2 == 0){
            if(j % 2 == 0)
                System.out.print(WHITE_BACKGROUND);
            else
                System.out.print(BLACK_BACKGROUND);
        } else {
            if(j % 2 == 0)
                System.out.print(BLACK_BACKGROUND);
            else
                System.out.print(WHITE_BACKGROUND);
        }
    }

    public static void imprimirTabuleiro(List<Personagem> personagens, List<Inimigo> inimigos){
        // BRANCAS: ♔ ♙ ♖ ♘ ♗ ♕
        // PRETAS: ♚ ♟ ♜ ♞ ♝ ♛
        int i;
        for(i = 0; i < 15; i++){
            System.out.println();
        }
        System.out.println(GREEN + "--------------------------------------------------------------");
        System.out.println(GREEN + "-                          TABULEIRO                         -");
        System.out.println(GREEN + "--------------------------------------------------------------");
        System.out.println(GREEN + "- LEGENDA:                                                   -");
        System.out.println(GREEN + "- PEÇAS BRANCAS (VAZIO POR DENTRO): " + RESET + WHITE_BACKGROUND + " ♔ " + BLACK_BACKGROUND + " ♙ " + WHITE_BACKGROUND + " ♖ " + BLACK_BACKGROUND + " ♘ " + WHITE_BACKGROUND + " ♗ " + BLACK_BACKGROUND + " ♕ " + GREEN + "   -");
        System.out.println(GREEN + "- PEÇAS PRETAS  (PREENCHIDAS):      " + RESET + BLACK_BACKGROUND + " ♚ " + WHITE_BACKGROUND + " ♟ " + BLACK_BACKGROUND + " ♜ " + WHITE_BACKGROUND + " ♞ " + BLACK_BACKGROUND + " ♝ " + WHITE_BACKGROUND + " ♛ " + GREEN + "   -");
        System.out.println(GREEN + "--------------------------------------------------------------");

        char letra = 'A';
        System.out.print("     \t");
        for(i = 0; i < 8; i++){
            System.out.print(GREEN + "[ " + (i + 1) + " ]" + RESET);
        }
        System.out.println();
        System.out.println();

        for (int j = 0; j < 8; j++, letra++) {
            System.out.print(GREEN + "[ " + letra + " ]\t" + RESET);
            for (i = 0; i < 8; i++) {
                printBackground(i, j);
                boolean encontrado = false;
                for (Personagem p : personagens) {
                    
                    if (p.getposX() == j && p.getposY() == i) {
                        System.out.print("[ " + p.getIcone() +  " ]" + RESET);
                        encontrado = true;
                        break;
                    }
                }
                for (Inimigo I : inimigos) {
                    if (I.getposX() == j && I.getposY() == i) {
                        System.out.print("[ " + I.getIcone() +  " ]" + RESET);
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado)
                    System.out.print("[   ]" + RESET);

                if(i == 7)
                    System.out.print("\t");
            }
            System.out.print(GREEN + "[ " + letra + " ]\t" + RESET);
            System.out.println();
            if(j == 7)
                System.out.println();
        }
        System.out.print("     \t");
        for(i = 0; i < 8; i++){
            System.out.print(GREEN + "[ " + (i + 1) + " ]" + RESET);
        }
        System.out.println();

        System.out.println();
        System.out.println(GREEN + "--------------------------------------------------------------");
    }

    public static boolean verificarPosicao(List<Personagem> personagens, int linha, int coluna){
        boolean verificado = false;
        for(Personagem p : personagens){
            if(p.getposX() == linha && p.getposY() == coluna){
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

    public static boolean verificarRei(List<Personagem> personagens, List<Inimigo> inimigos, int pecas, int i, int linha, int coluna, Peca p){
        boolean verificado = false;

        if((p.getposX() - linha) > 1 || (p.getposX() - linha) < -1 || (p.getposY() - coluna) > 1 || (p.getposY() - coluna) < -1){
            verificado = false;
        } else {
            verificado = true;
        }

        return verificado;
    }

    public static boolean verificarTorre(List<Personagem> personagens, List<Inimigo> inimigos, int pecas, int i, int linha, int coluna, Peca p){
        int j;

        boolean verificado = false;
        boolean colPers = false, colIni = false;

        if(p.getposX() == linha || p.getposY() == coluna){
            if(p.getposX() == linha){
                // Direita
                if(p.getposY() - coluna < 0){
                    for(j = p.getposY() + 1; j < coluna; j++){
                        for(Personagem P : personagens){
                            if(P.getposY() == j && P.getposX() == p.getposX()){
                                colPers = true;
                                break;
                            }
                        }
                        if(verificado){
                            for(Inimigo I : inimigos){
                                if(I.getposY() == j && I.getposX() == p.getposX()){
                                    colIni = true;
                                    break;
                                }
                            }
                        }
                    }
                    
                } else { 
                    // Esquerda
                    for(j = p.getposY() - 1; j > coluna; j--){
                        for(Personagem P : personagens){
                            if(P.getposY() == j && P.getposX() == p.getposX()){
                                colPers = true;
                                break;
                            }
                        }
                        if(verificado){
                            for(Inimigo I : inimigos){
                                if(I.getposY() == j && I.getposX() == p.getposX()){
                                    colIni = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            } else {
                if(p.getposY() == coluna){
                    // Baixo
                    if(p.getposX() - linha < 0){
                        for(j = p.getposX() + 1; j < linha; j++){
                            for(Personagem P : personagens){
                                if(P.getposX() == j && P.getposY() == p.getposY()){
                                    colPers = true;
                                    break;
                                }
                            }
                            if(verificado){
                                for(Inimigo I : inimigos){
                                    if(I.getposY() == j && I.getposX() == p.getposX()){
                                        colIni = true;
                                        break;
                                    }
                                }
                            }
                        }
                    } else {
                        // Acima
                        for(j = p.getposX() - 1; j > linha; j--){
                            for(Personagem P : personagens){
                                if(P.getposX() == j && P.getposY() == p.getposY()){
                                    //System.out.println("Peca " + P.getIcone() + " | X = " + P.getposX() + " | Y = " + P.getposY());
                                    colPers = true;
                                    break;
                                }
                            }
                            if(verificado){
                                for(Inimigo I : inimigos){
                                    //System.out.println("Ini " + I.getIcone() + " | X = " + I.getposX() + " | Y = " + I.getposY());
                                    if(I.getposX() == j && I.getposY() == p.getposY()){
                                        colIni = true;
                                        break;
                                    }
                                }
                            }
                            
                        }
                    }
                } else {
                    verificado = false;
                }
            }
        } else {
            verificado = false;
        }
        
        if(!colPers && !colIni){
            verificado = true;
        }

        return verificado;
    }
    
    public static boolean verificarCavalo(List<Personagem> personagens, List<Inimigo> inimigos, int pecas, int i, int linha, int coluna, Peca p){

        boolean verificado = false;

        if(p.getposX() - linha == -2 || p.getposX() - linha == 2){
            if(p.getposY() - coluna == 1 || p.getposY() - coluna == -1){
                verificado = true;
            } else {
                verificado = false;
            }
        } else {
            if(p.getposY() - coluna == -2 || p.getposY() - coluna == 2){
                if(p.getposX() - linha == 1 || p.getposX() - linha == -1){
                    verificado = true;
                } else {
                    verificado = false;
                }
            } else {
                verificado = false;
            }

        }

        return verificado;
    }

    public static boolean verificarBispo(List<Personagem> personagens, List<Inimigo> inimigos, int pecas, int i, int linha, int coluna, Peca p){

        boolean verificado = false;
        int deltaX, deltaY;

        boolean Xnegativo = false, Ynegativo = false;

        int j, aux = 0;

        deltaX = p.getposX() - linha;
        deltaY = p.getposY() - coluna;

        if(deltaX < 0){
            deltaX *= -1;
            Xnegativo = true;
        }
        if(deltaY < 0){
            deltaY *= -1;
            Ynegativo = true;
        }
        
        if(deltaX == deltaY){
            // aux = X e j = Y
            if(!Xnegativo && !Ynegativo){
                for(aux = p.getposX() - 1; aux >= linha; aux--){
                    for(j = p.getposY() - 1; j >= coluna; j--){
                        if(pecas == 0){
                            for(Personagem P : personagens){
                                if(P.getposX() == aux && P.getposY() == j){
                                    verificado = false;
                                    return verificado;
                                } else {
                                    verificado = true;
                                }
                            }
                            if(verificado){
                                for(Inimigo I : inimigos){
                                    if(I.getposX() == aux && I.getposY() == j){
                                        if(aux != linha && j != coluna){
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
                            for(Inimigo I : inimigos){
                                if(I.getposX() == aux && I.getposY() == j){
                                    verificado = false;
                                    return verificado;
                                } else {
                                    verificado = true;
                                }
                            }
                            if(verificado){
                                for(Personagem P : personagens){
                                    if(P.getposX() == aux && P.getposY() == j){
                                        if(aux != linha && j != coluna){
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
            if(Xnegativo && Ynegativo){
                for(aux = p.getposX() + 1; aux <= linha; aux++){
                    for(j = p.getposY() + 1; j <= coluna; j++){
                        if(pecas == 0){
                            for(Personagem P : personagens){
                                if(P.getposX() == aux && P.getposY() == j){
                                    verificado = false;
                                    return verificado;
                                } else {
                                    verificado = true;
                                }
                            }
                            if(verificado){
                                for(Inimigo I : inimigos){
                                    if(I.getposX() == aux && I.getposY() == j){
                                        if(aux != linha && j != coluna){
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
                            for(Inimigo I : inimigos){
                                if(I.getposX() == aux && I.getposY() == j){
                                    verificado = false;
                                    return verificado;
                                } else {
                                    verificado = true;
                                }
                            }
                            if(verificado){
                                for(Personagem P : personagens){
                                    if(P.getposX() == aux && P.getposY() == j){
                                        if(aux != linha && j != coluna){
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
                if(Xnegativo && !Ynegativo){
                    for(aux = p.getposX() + 1; aux <= linha; aux++){
                        for(j = p.getposY() - 1; j >= coluna; j--) {
                            if(pecas == 0){
                                for(Personagem P : personagens){
                                    if(P.getposX() == aux && P.getposY() == j){
                                        verificado = false;
                                        return verificado;
                                    } else {
                                        verificado = true;
                                    }
                                }
                                if(verificado){
                                    for(Inimigo I : inimigos){
                                        if(I.getposX() == aux && I.getposY() == j){
                                            if(aux != linha && j != coluna){
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
                                for(Inimigo I : inimigos){
                                    if(I.getposX() == aux && I.getposY() == j){
                                        verificado = false;
                                        return verificado;
                                    } else {
                                        verificado = true;
                                    }
                                }
                                if(verificado){
                                    for(Personagem P : personagens){
                                        if(P.getposX() == aux && P.getposY() == j){
                                            if(aux != linha && j != coluna){
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
                if(!Xnegativo && Ynegativo){
                    for(aux = p.getposX() - 1; aux >= linha; aux--){
                        for(j = p.getposY() + 1; j <= coluna; j++){
                            if(pecas == 0){
                                for(Personagem P : personagens){
                                    if(P.getposX() == aux && P.getposY() == j){
                                        verificado = false;
                                        return verificado;
                                    } else {
                                        verificado = true;
                                    }
                                }
                                if(verificado){
                                    for(Inimigo I : inimigos){
                                        if(I.getposX() == aux && I.getposY() == j){
                                            if(aux != linha && j != coluna){
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
                                for(Inimigo I : inimigos){
                                    if(I.getposX() == aux && I.getposY() == j){
                                        verificado = false;
                                        return verificado;
                                    } else {
                                        verificado = true;
                                    }
                                }
                                if(verificado){
                                    for(Personagem P : personagens){
                                        if(P.getposX() == aux && P.getposY() == j){
                                            if(aux != linha && j != coluna){
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
        } else {
            verificado = false;
        }

        return verificado;
    }

    public static boolean verificarRainha(List<Personagem> personagens, List<Inimigo> inimigos, int pecas, int i, int linha, int coluna, Peca p){
        
        boolean verificado = false;

        if(p.getposX() == linha || p.getposY() == coluna){
            verificado = verificarTorre(personagens, inimigos, pecas, i, linha, coluna, p);
        } else {
            verificado = verificarBispo(personagens, inimigos, pecas, i, linha, coluna, p);
        }

        return verificado;
    }

    public static void sleep(int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            // Handle the exception 
        }
    }

    public static void main(String[] args){

        try (Scanner input = new Scanner(System.in)) {
            Tabuleiro tabuleiro = new Tabuleiro(8, 8);  
            List<Personagem> personagens = new ArrayList<>();
            List<Inimigo> inimigos = new ArrayList<>();

            int i, j, rodada = 0;

            
            // Peças Brancas
            // Rei --> Rei como posição 0 para verificar o ganhador do jogo
            personagens.add(new Personagem("♔", 7, 4));

            // Peões
            for(i = 0; i < tabuleiro.getColunas(); i++){
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
            
            // Peças Pretas
            // Rei --> Rei como posição 0 para verificar o ganhador do jogo
            inimigos.add(new Inimigo("♚", 0, 4));

            // Peões
            for(i = 0; i < tabuleiro.getColunas(); i++){
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

            boolean menu = true;

            // Letras = j | Numeros = i

            while(menu){

                int pecas = rodada % 2;
                int linha, coluna;
                char caracterLinha, caracterColuna, icone;
                String pecaSelecionada, proximaPosicao;
                String[] cortado;
                boolean verificado = false, colisao = false;

                imprimirTabuleiro(personagens, inimigos);
                if(!personagens.get(0).getIcone().equals("♔")){
                    System.out.println(GREEN + "- PEÇAS PRETAS VENCERAM!                                     -");
                    System.out.println(GREEN + "--------------------------------------------------------------");
                    break;
                }
                if(!inimigos.get(0).getIcone().equals("♚")){
                    System.out.println(GREEN + "- PEÇAS PRETAS VENCERAM!                                     -");
                    System.out.println(GREEN + "--------------------------------------------------------------");
                    break;
                }
                // RETIRAR PARA FUNCIONAR NORMALMENTE
                // pecas = 0;

                switch(pecas){
                    case 0:
                        System.out.println(GREEN + "- RODADA DAS PEÇAS " + RED_BRIGHT + "BRANCAS" + GREEN + "                                   -");
                        System.out.println(GREEN + "--------------------------------------------------------------");
                        System.out.println(GREEN + "- DIGITE 'SAIR' PARA FINALIZAR O JOGO                        -");
                        System.out.print(GREEN + "- SELECIONE A PEÇA (A1 - H8): ");
                        pecaSelecionada = input.nextLine();

                        if(pecaSelecionada.equalsIgnoreCase("SAIR")){
                            System.out.println(GREEN + "--------------------------------------------------------------");
                            System.out.println(GREEN + "- JOGO FINALIZADO SEM VENCEDORES                             -");
                            System.out.println(GREEN + "--------------------------------------------------------------");
                            menu = false;
                            break;
                        }
                        
                        // Se o tamanho da string for diferente de 2
                        // !Character.isLetter(pecaSelecionada.charAt(0)) --> Se o primeiro caracter não é uma letra entra pro input Ginválido
                        // !Character.isDigit(pecaSelecionada.charAt(1)) --> Se o segundo caracter não é um número entra pro input inválido
                        if (pecaSelecionada.length() != 2 || !Character.isLetter(pecaSelecionada.charAt(0)) || !Character.isDigit(pecaSelecionada.charAt(1)) || pecaSelecionada.length() == 1) {
                            System.out.println(GREEN + "- " + RED + "Input inválido. Insira um input válido entre 'A1' e 'H8'." + GREEN);
                            pressToContinue(input);
                        } else {
                            cortado = pecaSelecionada.split("(?=\\d)");
                            caracterLinha = cortado[0].toUpperCase().charAt(0);
                            linha = caracterLinha - 65;
                            
                            if(linha < 0 || linha > 7){
                                System.out.println(GREEN + "- " + RED + "Input inválido. Insira um input válido entre 'A1' e 'H8'." + GREEN);
                                pressToContinue(input);
                                break;
                            }
                            
                            caracterColuna = cortado[1].charAt(0);
                            coluna = caracterColuna - 49;
                            
                            if(coluna < 0 || coluna > 7){
                                System.out.println(GREEN + "- " + RED + "Input inválido. Insira um input válido entre 'A1' e 'H8'." + GREEN);
                                pressToContinue(input);
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
                                System.out.println(GREEN + "- " + RED + "Você selecionou uma peça preta! Selecione uma peça BRANCA!" + GREEN + " -");
                                pressToContinue(input);
                                break;
                            } else {
                                // Limitar movimentos das peças e verificar colisões ao movimentar !! PARTE MAIS DIFÍCIL DO DESAFIO !!
                                // String iconePeca = personagens.get(i).getIcone();
                                
                                while(!verificado){
                                    System.out.println(GREEN + "--------------------------------------------------------------");
                                    System.out.println(GREEN + "- DIGITE 'VOLTAR' PARA SELECIONAR OUTRA PEÇA:                -");
                                    System.out.print(GREEN + "- SELECIONE A PROXIMA POSIÇÃO DA PEÇA (A1 - H8): ");
                                    proximaPosicao = input.nextLine();

                                    if(proximaPosicao.equalsIgnoreCase("VOLTAR")){
                                        break;
                                    } else {

                                        if (!Character.isLetter(proximaPosicao.charAt(0)) || !Character.isDigit(proximaPosicao.charAt(1)) || proximaPosicao.length() == 1) {
                                            System.out.println(GREEN + "- " + RED + "Input inválido. Insira um input válido entre 'A1' e 'H8'." + GREEN);
                                            pressToContinue(input);
                                            break;
                                        }
                                        
                                        cortado = proximaPosicao.split("(?=\\d)");
                                        caracterLinha = cortado[0].toUpperCase().charAt(0);
                                        linha = caracterLinha - 65;
   
                                        if(linha < 0 || linha > 7){
                                            System.out.println(GREEN + "- " + RED + "Input inválido. Insira um input válido entre 'A1' e 'H8'." + GREEN);
                                            pressToContinue(input);
                                            break;
                                        }
                                        
                                        caracterColuna = cortado[1].charAt(0);
                                        coluna = caracterColuna - 49;
                                        
                                        if(coluna < 0 || coluna > 7){
                                            System.out.println(GREEN + "- " + RED + "Input inválido. Insira um input válido entre 'A1' e 'H8'." + GREEN);
                                            pressToContinue(input);
                                            break;
                                        }
   
                                        icone = personagens.get(i).getIcone().charAt(0);
                                                
                                        // BRANCAS: ♔ ♙ ♖ ♘ ♗ ♕
                                        // PRETAS: ♚ ♟ ♜ ♞ ♝ ♛
                                        
                                        // O movimento do REI é igual para os dois tipos
                                        // A peça peão pode colocar em uma função, indicando com a variável peça (identificador das cores das peças)
                                        // O movimento da TORRE é igual para os dois tipos
                                        // O movimento do CAVALO é igual para os dois tipos
                                        // O movimento do BISPO é igual para os dois tipos
                                        // O movimento da RAINHA ´igual para os dois tipos

                                        Personagem p = personagens.get(i);
                                        switch(icone){
                                            case '♔':
                                                verificado = verificarRei(personagens, inimigos, pecas, i, linha, coluna, p);
                                                colisao = verificarPosicao(personagens, linha, coluna);
                                            break;
                    
                                            case '♙':
                                                boolean diagonal = false;
   
                                                for(j = 0; j < inimigos.size(); j++){
                                                    Inimigo I = inimigos.get(j);
                                                    if(I.getposX() + 1 == p.getposX() && I.getposY() - 1 == p.getposY()){
                                                        diagonal = true;
                                                        break;
                                                    }
                                                    if(I.getposX() + 1 == p.getposX() && I.getposY() + 1 == p.getposY()){
                                                        diagonal = true;
                                                        break;
                                                    }
                                                }
   
                                                boolean inimigoFrente = false;
   
                                                for(j = 0; j < inimigos.size(); j++){
                                                    Inimigo I = inimigos.get(j);
                                                    if(I.getposY() == p.getposY() && I.getposX() == linha){
                                                        inimigoFrente = true;
                                                        break;
                                                    }
                                                }

                                                if(p.getposX() - linha <= -1){
                                                    verificado = false;
                                                    break;
                                                }
   
                                                if(p.getposX() == 6){
                                                    if(p.getposX() - linha <= 2 && p.getposY() == coluna){

                                                        verificado = true;

                                                    } else {
                                                        if(p.getposY() == coluna && p.getposX() - linha == 1)
                                                            verificado = true;
                                                    }
                                                } else {
                                                    if(p.getposX() < linha || (p.getposX() - linha) <= 0 || (p.getposX() - linha) > 1 || (p.getposY() != coluna && !diagonal)){
                                                        break;
                                                    } else {
                                                        colisao = verificarPosicao(personagens, linha, coluna);
                                                        verificado = true;
                                                    }
                                                }
                                                
                                                if(inimigoFrente){
                                                    if(p.getposY() == coluna && p.getposX() - 1 == linha){
                                                        verificado = false;
                                                        break;
                                                    }
                                                } else {
                                                    if(verificado && !inimigoFrente){
                                                        colisao = verificarPosicao(personagens, linha, coluna);
                                                    } else {
                                                        break;
                                                    }
                                                }
                                            break;
                    
                                            case '♖':
                                                verificado = verificarTorre(personagens, inimigos, pecas, i, linha, coluna, p);
                                                colisao = verificarPosicao(personagens, linha, coluna);
                                            break;
                                                
                                            case '♘':
                                                verificado = verificarCavalo(personagens, inimigos, pecas, i, linha, coluna, p);
                                                colisao = verificarPosicao(personagens, linha, coluna);
                                            break;
                                                
                                            case '♗':
                                                verificado = verificarBispo(personagens, inimigos, pecas, i, linha, coluna, p);
                                                colisao = verificarPosicao(personagens, linha, coluna);
                                            break;
                                                
                                            case '♕':
                                                verificado = verificarRainha(personagens, inimigos, pecas, i, linha, coluna, p);
                                                colisao = verificarPosicao(personagens, linha, coluna);
                                            break;
                                        }

                                        if(!verificado){
                                            System.out.println(GREEN + "--------------------------------------------------------------");
                                            System.out.println(GREEN + "- " + RED + "MOVIMENTO DE PEÇA INVÁLIDO!" + GREEN + "                                -");
                                            pressToContinue(input);
                                            break;
                                        }

                                        if(verificado && !colisao){
                                            pressToContinue(input);
                                            break;
                                        }

                                        if(verificado && colisao){
                                            for(j = 0; j < inimigos.size(); j++){
                                                Inimigo I = inimigos.get(j);
                                                if(I.getposX() == linha && I.getposY() == coluna){
                                                    inimigos.remove(j);
                                                    break;
                                                }
                                            }
                                            
                                            personagens.get(i).setposX(linha);
                                            personagens.get(i).setposY(coluna);
                                            rodada++;

                                            // Fazer os peões virarem ume peça aleatória ou somente a rainha quando chegar no final do tabuleiro
                                            // if(p.getposX() )
                                            break;
                                            
                                        }
                                    }
                                }
                            }
                        }
                    break;

                    case 1:
                        System.out.println(GREEN + "- RODADA DAS PEÇAS " + CYAN + "PRETAS" + GREEN + "                                   -");
                        System.out.println(GREEN + "--------------------------------------------------------------");
                        System.out.println(GREEN + "- DIGITE 'SAIR' PARA FINALIZAR O JOGO                        -");
                        System.out.print(GREEN + "- SELECIONE A PEÇA (A1 - H8): ");
                        pecaSelecionada = input.nextLine();

                        if(pecaSelecionada.equalsIgnoreCase("SAIR")){
                            System.out.println(GREEN + "--------------------------------------------------------------");
                            System.out.println(GREEN + "- JOGO FINALIZADO SEM VENCEDORES                             -");
                            System.out.println(GREEN + "--------------------------------------------------------------");
                            menu = false;
                            break;
                        }
                        
                        // Se o tamanho da string for diferente de 2
                        // !Character.isLetter(pecaSelecionada.charAt(0)) --> Se o primeiro caracter não é uma letra entra pro input inválido
                        // !Character.isDigit(pecaSelecionada.charAt(1)) --> Se o segundo caracter não é um número entra pro input inválido
                        if (pecaSelecionada.length() != 2 || !Character.isLetter(pecaSelecionada.charAt(0)) || !Character.isDigit(pecaSelecionada.charAt(1)) || pecaSelecionada.length() == 1) {
                            System.out.println(GREEN + "- " + RED + "Input inválido. Insira um input válido entre 'A1' e 'H8'." + GREEN);
                            pressToContinue(input);
                        } else {
                            cortado = pecaSelecionada.split("(?=\\d)");
                            caracterLinha = cortado[0].toUpperCase().charAt(0);
                            linha = caracterLinha - 65;
                            
                            if(linha < 0 || linha > 7){
                                System.out.println(GREEN + "- " + RED + "Input inválido. Insira um input válido entre 'A1' e 'H8'." + GREEN);
                                pressToContinue(input);
                                break;
                            }
                            
                            caracterColuna = cortado[1].charAt(0);
                            coluna = caracterColuna - 49;
                            
                            if(coluna < 0 || coluna > 7){
                                System.out.println(GREEN + "- " + RED + "Input inválido. Insira um input válido entre 'A1' e 'H8'." + GREEN);
                                pressToContinue(input);
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
                                System.out.println(GREEN + "- " + RED + "Você selecionou uma peça branca! Selecione uma peça PRETA!" + GREEN + " -");
                                pressToContinue(input);
                                break;
                            } else {

                                while(!verificado){
                                    System.out.println(GREEN + "--------------------------------------------------------------");
                                    System.out.println(GREEN + "- DIGITE 'VOLTAR' PARA SELECIONAR OUTRA PEÇA:                -");
                                    System.out.print(GREEN + "- SELECIONE A PROXIMA POSIÇÃO DA PEÇA (A1 - H8): ");
                                    proximaPosicao = input.nextLine();

                                    if(proximaPosicao.equalsIgnoreCase("VOLTAR")){
                                        break;
                                    } else {

                                        if (proximaPosicao.length() != 2 || !Character.isLetter(proximaPosicao.charAt(0)) || !Character.isDigit(proximaPosicao.charAt(1)) || proximaPosicao.length() == 1){
                                            System.out.println(GREEN + "- " + RED + "Input inválido. Insira um input válido entre 'A1' e 'H8'." + GREEN);
                                            pressToContinue(input);
                                            break;
                                        }
   
                                        cortado = proximaPosicao.split("(?=\\d)");
                                        caracterLinha = cortado[0].toUpperCase().charAt(0);
                                        linha = caracterLinha - 65;
   
                                        if(linha < 0 || linha > 7){
                                            System.out.println(GREEN + "- " + RED + "Input inválido. Insira um input válido entre 'A1' e 'H8'." + GREEN);
                                            pressToContinue(input);
                                            break;
                                        }
                                        
                                        caracterColuna = cortado[1].charAt(0);
                                        coluna = caracterColuna - 49;
                                        
                                        if(coluna < 0 || coluna > 7){
                                            System.out.println(GREEN + "- " + RED + "Input inválido. Insira um input válido entre 'A1' e 'H8'." + GREEN);
                                            pressToContinue(input);
                                            break;
                                        }

                                        icone = inimigos.get(i).getIcone().charAt(0);

                                        // BRANCAS: ♔ ♙ ♖ ♘ ♗ ♕
                                        // PRETAS: ♚ ♟ ♜ ♞ ♝ ♛

                                        Inimigo in = inimigos.get(i);
                                        switch(icone){
                                            case '♚':
                                                verificado = verificarRei(personagens, inimigos, pecas, i, linha, coluna, in);
                                                colisao = verificarInimigo(inimigos, linha, coluna);
                                            break;

                                            case '♟':
                                                boolean diagonal = false;

                                                for(j = 0; j < personagens.size(); j++){
                                                    Personagem p = personagens.get(j);
                                                    if(p.getposX() - 1 == in.getposX() && p.getposY() + 1 == in.getposY()){
                                                        diagonal = true;
                                                        break;
                                                    }
                                                    if(p.getposX() - 1 == in.getposX() && p.getposY() - 1 == in.getposY()){
                                                        diagonal = true;
                                                        break;
                                                    }
                                                }

                                                boolean inimigoFrente = false;

                                                for(j = 0; j < personagens.size(); j++){
                                                    Personagem p = personagens.get(j);
                                                    if(p.getposY() == in.getposY() && p.getposX() == linha){
                                                        inimigoFrente = true;
                                                        break;
                                                    }
                                                }

                                                if(in.getposX() - linha >= 1){
                                                    verificado = false;
                                                    break;
                                                }

                                                if(in.getposX() == 1){
                                                    if(in.getposX() - linha >= -2 && in.getposY() == coluna){
                                                        verificado = true;

                                                    } else {
                                                        if(in.getposY() == coluna && in.getposX() - linha == -1)
                                                            verificado = true;
                                                    }
                                                } else {
                                                    if(in.getposX() > linha || (in.getposX() - linha) >= 0 || (in.getposX() - linha) < -1 || (in.getposY() != coluna && !diagonal)){
                                                        break;
                                                    } else {
                                                        colisao = verificarInimigo(inimigos, linha, coluna);
                                                        verificado = true;
                                                    }
                                                }

                                                if(inimigoFrente){
                                                    if(in.getposY() == coluna && in.getposX() + 1 == linha){
                                                        verificado = false;
                                                        break;
                                                    }
                                                } else {
                                                    if(verificado && !inimigoFrente){
                                                        colisao = verificarInimigo(inimigos, linha, coluna);
                                                    } else {
                                                        break;
                                                    }
                                                }
                                            break;

                                            case '♜':
                                                verificado = verificarTorre(personagens, inimigos, pecas, i, linha, coluna, in);
                                                colisao = verificarInimigo(inimigos, linha, coluna);
                                            break;
                                                
                                            case '♞':
                                                verificado = verificarCavalo(personagens, inimigos, pecas, i, linha, coluna, in);
                                                colisao = verificarInimigo(inimigos, linha, coluna);
                                            break;
                                                
                                            case '♝':
                                                verificado = verificarBispo(personagens, inimigos, pecas, i, linha, coluna, in);
                                                colisao = verificarInimigo(inimigos, linha, coluna);
                                            break;

                                            case '♛':
                                                verificado = verificarRainha(personagens, inimigos, pecas, i, linha, coluna, in);
                                                colisao = verificarInimigo(inimigos, linha, coluna);
                                            break;
                                        }

                                        if(!verificado){
                                            System.out.println(GREEN + "--------------------------------------------------------------");
                                            System.out.println(GREEN + "- " + RED + "MOVIMENTO DE PEÇA INVÁLIDO!" + GREEN + "                                -");
                                            pressToContinue(input);
                                            break;
                                        }
    
                                        if(verificado && !colisao){
                                            pressToContinue(input);
                                            break;
                                        }

                                        if(verificado && colisao){
                                            for(j = 0; j < personagens.size(); j++){
                                                Personagem p = personagens.get(j);
                                                if(p.getposX() == linha && p.getposY() == coluna){
                                                    personagens.remove(j);
                                                    break;
                                                }
                                            }
                                            
                                            inimigos.get(i).setposX(linha);
                                            inimigos.get(i).setposY(coluna);
                                            rodada++;
                                            break;
                                            
                                        }
                                    }
                                }
                            }
                        }
                    break;
                }
            }
        }
    }
}
