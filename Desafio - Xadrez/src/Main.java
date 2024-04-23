import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // CONFIGURAR ANTES DE INICIAR O PROGRAMA!

    // IntelliJ Terminal colors
    // Theme: Dark Theme Default
    // Console Background: 1A1A1A
    // Error: FF0018
    // Standart output: FFFFFF
    // System output: FFFFFF
    // User input: 00FF24

    // White (gray): Foreground: FFFFFF
    // Black: 656565 FFFFFF

    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

    public static void printBackground(int i, int j){
        if(i % 2 == 0){
            if(j % 2 == 0)
                System.out.print(BLACK + WHITE_BACKGROUND);
            else
                System.out.print(BLACK_BACKGROUND);
        } else {
            if(j % 2 == 0)
                System.out.print(BLACK_BACKGROUND);
            else
                System.out.print(BLACK + WHITE_BACKGROUND);
        }
    }

    public static void imprimirTabuleiro(List<Personagem> personagens, List<Inimigo> inimigos){
        // BRANCAS: ♔ ♙ ♖ ♘ ♗ ♕
        // PRETAS: ♚ ♟ ♜ ♞ ♝ ♛
        System.out.println("--------------------------------------------------------------");
        System.out.println("-                          TABULEIRO                         -");
        System.out.println("--------------------------------------------------------------");
        System.out.println("- LEGENDA:                                                   -");
        System.out.println("- PEÇAS BRANCAS (VAZIO POR DENTRO): ♔ ♙ ♖ ♘ ♗ ♕          -");
        System.out.println("- PEÇAS PRETAS  (PREENCHIDAS):      ♚ ♟ ♜ ♞ ♝ ♛          -");
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
            System.out.print("[ " + letra + RESET + " ]");
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
            System.out.println("--------------------------------------------------------------");
            System.out.println("- DUAS PEÇAS NÃO PODEM FICAR NA MESMA POSIÇÃO!               -");
            System.out.println("--------------------------------------------------------------");
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
            System.out.println("--------------------------------------------------------------");
            System.out.println("- DUAS PEÇAS NÃO PODEM FICAR NA MESMA POSIÇÃO!               -");
            System.out.println("--------------------------------------------------------------");
        }

        return verificado;
    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

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
                System.out.println("- PEÇAS PRETAS VENCERAM!                                     -");
                System.out.println("--------------------------------------------------------------");
                break;
            }
            if(!inimigos.get(0).getIcone().equals("♚")){
                System.out.println("- PEÇAS PRETAS VENCERAM!                                     -");
                System.out.println("--------------------------------------------------------------");
                break;
            }
            // RETIRAR PARA FUNCIONAR NORMALMENTE
            // pecas = 1;
            int deltaX, deltaY;
            boolean Xnegativo, Ynegativo;
            boolean colPers = false, colIni = false;
            switch(pecas){
                case 0:
                    System.out.println("- RODADA DAS PEÇAS BRANCAS                                   -");
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("- DIGITE 'SAIR' PARA FINALIZAR O JOGO                        -");
                    System.out.print("- SELECIONE A PEÇA (A1 - H8): ");
                    pecaSelecionada = input.nextLine();

                    if(pecaSelecionada.equalsIgnoreCase("SAIR")){
                        System.out.println("--------------------------------------------------------------");
                        System.out.println("- JOGO FINALIZADO SEM VENCEDORES                             -");
                        System.out.println("--------------------------------------------------------------");
                        menu = false;
                        break;
                    }
                    
                    // Se o tamanho da string for diferente de 2
                    // !Character.isLetter(pecaSelecionada.charAt(0)) --> Se o primeiro caracter não é uma letra entra pro input Ginválido
                    // !Character.isDigit(pecaSelecionada.charAt(1)) --> Se o segundo caracter não é um número entra pro input inválido
                    if (pecaSelecionada.length() != 2 || !Character.isLetter(pecaSelecionada.charAt(0)) || !Character.isDigit(pecaSelecionada.charAt(1))) {
                        System.out.println("- Input inválido. Insira um input válido entre 'A1' e 'H8'.");
                    } else {
                        cortado = pecaSelecionada.split("(?=\\d)");
                        caracterLinha = cortado[0].toUpperCase().charAt(0);
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
                            // Limitar movimentos das peças e verificar colisões ao movimentar !! PARTE MAIS DIFÍCIL DO DESAFIO !!
                            // String iconePeca = personagens.get(i).getIcone();
                            
                            while(!verificado){
                                System.out.println("--------------------------------------------------------------");
                                System.out.println("- DIGITE 'VOLTAR' PARA SELECIONAR OUTRA PEÇA:                -");
                                System.out.print("- SELECIONE A PROXIMA POSIÇÃO DA PEÇA (A1 - H8): ");
                                proximaPosicao = input.nextLine();

                                if(proximaPosicao.equalsIgnoreCase("VOLTAR")){
                                    break;
                                } else {

                                    if (!Character.isLetter(pecaSelecionada.charAt(0)) || !Character.isDigit(pecaSelecionada.charAt(1))) {
                                        System.out.println("- Input inválido. Insira um input válido entre 'A1' e 'H8'.");
                                    }
                                    
                                    cortado = proximaPosicao.split("(?=\\d)");
                                    caracterLinha = cortado[0].toUpperCase().charAt(0);
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
    
                                    icone = personagens.get(i).getIcone().charAt(0);
                                            
                                    // BRANCAS: ♔ ♙ ♖ ♘ ♗ ♕
                                    // PRETAS: ♚ ♟ ♜ ♞ ♝ ♛
                                    
                                    Personagem p = personagens.get(i);
                                    switch(icone){
                                        case '♔':
                                        if((p.getposX() - linha) > 1 || (p.getposX() - linha) < -1 || (p.getposY() - coluna) > 1 || (p.getposY() - coluna) < -1){
                                            break;
                                        } else {
                                            verificado = true;
                                            colisao = verificarPosicao(personagens, linha, coluna);
                                        }
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
    
                                            if(p.getposX() == 6){
                                                if(p.getposX() - linha > 2 && p.getposY() == coluna){

                                                    verificado = true;

                                                } else {
                                                    if(p.getposY() == coluna)
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
                                        if(p.getposX() == linha || p.getposY() == coluna){
                                            if(p.getposX() == linha){
                                                // Direita
                                                if(p.getposY() - coluna < 0){
                                                    for(j = p.getposY(); j < coluna; j++){
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
                                                    for(j = p.getposY(); j > coluna; j--){
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
                                                        for(j = p.getposX(); j < linha; j++){
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
                                                        for(j = p.getposX(); j > linha; j--){
                                                            for(Personagem P : personagens){
                                                                if(P.getposX() == j && P.getposY() == p.getposY()){
                                                                    colPers = true;
                                                                    break;
                                                                }
                                                            }
                                                            
                                                            for(Inimigo I : inimigos){
                                                                if(I.getposX() == j && I.getposY() == p.getposY()){
                                                                    colIni = true;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    verificado = false;
                                                    break;
                                                }
                                            }
                                        } else {
                                            verificado = false;
                                            break;
                                        }
                                        
                                        if(!colPers && !colIni){
                                            verificado = true;
                                            colisao = verificarPosicao(personagens, linha, coluna);
                                        }
                                        break;
    
                                        case '♘':
                                            if(p.getposX() - linha == -2 || p.getposX() - linha == 2){
                                                if(p.getposY() - coluna == 1 || p.getposY() - coluna == -1){
                                                    verificado = true;
                                                } else {
                                                    verificado = false;
                                                    break;
                                                }
                                            } else {
                                                if(p.getposY() - coluna == -2 || p.getposY() - coluna == 2){
                                                    if(p.getposX() - linha == 1 || p.getposX() - linha == -1){
                                                        verificado = true;
                                                    } else {
                                                        verificado = false;
                                                        break;
                                                    }
                                                } else {
                                                    verificado = false;
                                                    break;
                                                }
    
                                            }
                                            colisao = verificarPosicao(personagens, linha, coluna);
                                        break;
                
                                        case '♗':
                                            deltaX = p.getposX() - linha;
                                            deltaY = p.getposY() - coluna;
                                            Xnegativo = false;
                                            Ynegativo = false;
    
                                            if(deltaX < 0){
                                                deltaX *= -1;
                                                Xnegativo = true;
                                            }
                                            if(deltaY < 0){
                                                deltaY *= -1;
                                                Ynegativo = true;
                                            }
                                            // Verificar possiveis colisões ao mexer o Bispo e NÃO ESQUECER DE ATUALIZAR NAS PEÇAS PRETAS E NAS RAINHAS -> TERMINOU ISSO? CODIGO FINALIZADO!!!
                                            if(deltaX == deltaY){
                                                int aux; // aux = X e j = Y
                                                if(!Xnegativo && !Ynegativo){
                                                    for(aux = p.getposX() - 1; aux > linha; aux--){
                                                        for(j = p.getposY() - 1; j > coluna; j--){
                                                            for(Personagem P : personagens){
                                                                if(P.getposX() == aux && P.getposY() == j){
                                                                    verificado = false;
                                                                    break;
                                                                } else {
                                                                    verificado = true;
                                                                }
                                                            }
                                                            if(verificado){
                                                                for(Inimigo I : inimigos){
                                                                    if(I.getposX() == aux && I.getposY() == j){
                                                                        verificado = false;
                                                                        break;
                                                                    } else {
                                                                        verificado = true;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if(Xnegativo && Ynegativo){
                                                    for(aux = p.getposX() + 1; aux < linha; aux++){
                                                        for(j = p.getposY() + 1; j < coluna; j++){
                                                            for(Personagem P : personagens){
                                                                if(P.getposX() == aux && P.getposY() == j){
                                                                    verificado = false;
                                                                    break;
                                                                } else {
                                                                    verificado = true;
                                                                }
                                                            }
                                                            if(verificado){
                                                                for(Inimigo I : inimigos){
                                                                    if(I.getposX() == aux && I.getposY() == j){
                                                                        verificado = false;
                                                                        break;
                                                                    } else {
                                                                        verificado = true;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    if(Xnegativo && !Ynegativo){
                                                        for(aux = p.getposX() + 1; aux < linha; aux++){
                                                            for(j = p.getposY() - 1; j > coluna; j--) {
                                                                for(Personagem P : personagens){
                                                                    if(P.getposX() == aux && P.getposY() == j){
                                                                        verificado = false;
                                                                        break;
                                                                    } else {
                                                                        verificado = true;
                                                                    }
                                                                }
                                                                if(verificado){
                                                                    for(Inimigo I : inimigos){
                                                                        if(I.getposX() == aux && I.getposY() == j){
                                                                            verificado = false;
                                                                            break;
                                                                        } else {
                                                                            verificado = true;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if(!Xnegativo && Ynegativo){
                                                        for(aux = p.getposX() - 1; aux > linha; aux--){
                                                            for(j = p.getposY() + 1; j < coluna; j++){
                                                                for(Personagem P : personagens){
                                                                    if(P.getposX() == aux && P.getposY() == j){
                                                                        verificado = false;
                                                                        break;
                                                                    } else {
                                                                        verificado = true;
                                                                    }
                                                                }
                                                                if(verificado){
                                                                    for(Inimigo I : inimigos){
                                                                        if(I.getposX() == aux && I.getposY() == j){
                                                                            verificado = false;
                                                                            break;
                                                                        } else {
                                                                            verificado = true;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else
                                                verificado = false;
                                            
                                            colisao = verificarPosicao(personagens, linha, coluna);
                                        break;
                
                                        case '♕':
                                        if(p.getposX() == linha || p.getposY() == coluna){
                                            if(p.getposX() == linha){
                                                // Direita
                                                if(p.getposY() - coluna < 0){
                                                    for(j = p.getposY(); j < coluna; j++){
                                                        for(Personagem P : personagens){
                                                            if(P.getposY() == j && P.getposX() == p.getposX()){
                                                                colPers = true;
                                                                break;
                                                            }
                                                        }
                                                        for(Inimigo I : inimigos){
                                                            if(I.getposX() == j && I.getposY() == p.getposY()){
                                                                colIni = true;
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    
                                                } else { 
                                                    // Esquerda
                                                    for(j = p.getposY(); j > coluna; j--){
                                                        for(Personagem P : personagens){
                                                            if(P.getposY() == j && P.getposX() == p.getposX()){
                                                                colPers = true;
                                                                break;
                                                            }
                                                        }
                                                        for(Inimigo I : inimigos){
                                                            if(I.getposX() == j && I.getposY() == p.getposY()){
                                                                colIni = true;
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                if(p.getposY() == coluna){
                                                    // Baixo
                                                    if(p.getposX() - linha < 0){
                                                        for(j = p.getposX(); j < linha; j++){
                                                            for(Personagem P : personagens){
                                                                if(P.getposX() == j && P.getposY() == p.getposY()){
                                                                    colPers = true;
                                                                    break;
                                                                }
                                                            }
                                                            for(Inimigo I : inimigos){
                                                                if(I.getposX() == j && I.getposY() == p.getposY()){
                                                                    colIni = true;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        // Acima
                                                        for(j = p.getposX(); j > linha; j--){
                                                            for(Personagem P : personagens){
                                                                if(P.getposX() == j && P.getposY() == p.getposY()){
                                                                    colPers = true;
                                                                    break;
                                                                }
                                                            }
                                                            
                                                            for(Inimigo I : inimigos){
                                                                if(I.getposX() == j && I.getposY() == p.getposY()){
                                                                    colIni = true;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    verificado = false;
                                                    break;
                                                }
                                            }

                                            if(!colIni && !colPers){
                                                verificado = true;
                                            }
                                        } else {
                                            deltaX = p.getposX() - linha;
                                            deltaY = p.getposY() - coluna;
                                            Xnegativo = false;
                                            Ynegativo = false;
    
                                            if(deltaX < 0){
                                                deltaX *= -1;
                                                Xnegativo = true;
                                            }
                                            if(deltaY < 0){
                                                deltaY *= -1;
                                                Ynegativo = true;
                                            }
                                            // Verificar possiveis colisões ao mexer o Bispo e NÃO ESQUECER DE ATUALIZAR NAS PEÇAS PRETAS E NAS RAINHAS -> TERMINOU ISSO? CODIGO FINALIZADO!!!
                                            if(deltaX == deltaY){
                                                int aux; // aux = X e j = Y
                                                if(!Xnegativo && !Ynegativo){
                                                    for(aux = p.getposX() - 1; aux > linha; aux--){
                                                        for(j = p.getposY() - 1; j > coluna; j--){
                                                            for(Personagem P : personagens){
                                                                if(P.getposX() == aux && P.getposY() == j){
                                                                    verificado = false;
                                                                    break;
                                                                } else {
                                                                    verificado = true;
                                                                }
                                                            }
                                                            if(verificado){
                                                                for(Inimigo I : inimigos){
                                                                    if(I.getposX() == aux && I.getposY() == j){
                                                                        verificado = false;
                                                                        break;
                                                                    } else {
                                                                        verificado = true;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if(Xnegativo && Ynegativo){
                                                    for(aux = p.getposX() + 1; aux < linha; aux++){
                                                        for(j = p.getposY() + 1; j < coluna; j++){
                                                            for(Personagem P : personagens){
                                                                if(P.getposX() == aux && P.getposY() == j){
                                                                    verificado = false;
                                                                    break;
                                                                } else {
                                                                    verificado = true;
                                                                }
                                                            }
                                                            if(verificado){
                                                                for(Inimigo I : inimigos){
                                                                    if(I.getposX() == aux && I.getposY() == j){
                                                                        verificado = false;
                                                                        break;
                                                                    } else {
                                                                        verificado = true;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    if(Xnegativo && !Ynegativo){
                                                        for(aux = p.getposX() + 1; aux < linha; aux++){
                                                            for(j = p.getposY() - 1; j > coluna; j--) {
                                                                for(Personagem P : personagens){
                                                                    if(P.getposX() == aux && P.getposY() == j){
                                                                        verificado = false;
                                                                        break;
                                                                    } else {
                                                                        verificado = true;
                                                                    }
                                                                }
                                                                if(verificado){
                                                                    for(Inimigo I : inimigos){
                                                                        if(I.getposX() == aux && I.getposY() == j){
                                                                            verificado = false;
                                                                            break;
                                                                        } else {
                                                                            verificado = true;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if(!Xnegativo && Ynegativo){
                                                        for(aux = p.getposX() - 1; aux > linha; aux--){
                                                            for(j = p.getposY() + 1; j < coluna; j++){
                                                                for(Personagem P : personagens){
                                                                    if(P.getposX() == aux && P.getposY() == j){
                                                                        verificado = false;
                                                                        break;
                                                                    } else {
                                                                        verificado = true;
                                                                    }
                                                                }
                                                                if(verificado){
                                                                    for(Inimigo I : inimigos){
                                                                        if(I.getposX() == aux && I.getposY() == j){
                                                                            verificado = false;
                                                                            break;
                                                                        } else {
                                                                            verificado = true;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else
                                                verificado = false;
                                            colisao = verificarPosicao(personagens, linha, coluna);
                                        }
                                        break;
                                    }
        
                                    if(!verificado){
                                        System.out.println("--------------------------------------------------------------");
                                        System.out.println("- MOVIMENTO DE PEÇA INVÁLIDO!                                -");
                                        System.out.println("--------------------------------------------------------------");
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
                                    }    
                                }
                            }
                        }
                    }
                break;

                case 1:
                    System.out.println("- RODADA DAS PEÇAS PRETAS                                   -");
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("- DIGITE 'SAIR' PARA FINALIZAR O JOGO                        -");
                    System.out.print("- SELECIONE A PEÇA (A1 - H8): ");
                    pecaSelecionada = input.nextLine();

                    if(pecaSelecionada.equalsIgnoreCase("SAIR")){
                        System.out.println("--------------------------------------------------------------");
                        System.out.println("- JOGO FINALIZADO SEM VENCEDORES                             -");
                        System.out.println("--------------------------------------------------------------");
                        menu = false;
                        break;
                    }
                    
                    // Se o tamanho da string for diferente de 2
                    // !Character.isLetter(pecaSelecionada.charAt(0)) --> Se o primeiro caracter não é uma letra entra pro input inválido
                    // !Character.isDigit(pecaSelecionada.charAt(1)) --> Se o segundo caracter não é um número entra pro input inválido
                    if (pecaSelecionada.length() != 2 || !Character.isLetter(pecaSelecionada.charAt(0)) || !Character.isDigit(pecaSelecionada.charAt(1))) {
                        System.out.println("- Input inválido. Insira um input válido entre 'A1' e 'H8'.");
                    } else {
                        cortado = pecaSelecionada.split("(?=\\d)");
                        caracterLinha = cortado[0].toUpperCase().charAt(0);
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

                            while(!verificado){
                                System.out.println("--------------------------------------------------------------");
                                System.out.println("- DIGITE 'VOLTAR' PARA SELECIONAR OUTRA PEÇA:                -");
                                System.out.print("- SELECIONE A PROXIMA POSIÇÃO DA PEÇA (A1 - H8): ");
                                proximaPosicao = input.nextLine();

                                if(proximaPosicao.equalsIgnoreCase("VOLTAR")){
                                    break;
                                } else {
    
                                    cortado = proximaPosicao.split("(?=\\d)");
                                    caracterLinha = cortado[0].toUpperCase().charAt(0);
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

                                    icone = inimigos.get(i).getIcone().charAt(0);

                                    // BRANCAS: ♔ ♙ ♖ ♘ ♗ ♕
                                    // PRETAS: ♚ ♟ ♜ ♞ ♝ ♛

                                    Inimigo in = inimigos.get(i);
                                    switch(icone){
                                        case '♚':
                                        if((in.getposX() - linha) > 1 || (in.getposX() - linha) < -1 || (in.getposY() - coluna) > 1 || (in.getposY() - coluna) < -1){
                                            break;
                                        } else {
                                            verificado = true;
                                            colisao = verificarInimigo(inimigos, linha, coluna);
                                        }
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

                                            if(in.getposX() == 1){
                                                if(in.getposX() - linha > -2 && in.getposY() == coluna){
                                                    verificado = true;

                                                } else {
                                                    if(in.getposY() == coluna)
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
                                        if(in.getposX() == linha || in.getposY() == coluna){
                                            if(in.getposX() == linha){
                                                // Direita
                                                if(in.getposY() - coluna < 0){
                                                    for(j = in.getposY(); j < coluna; j++){
                                                        for(Personagem P : personagens){
                                                            if(P.getposY() == j && P.getposX() == in.getposX()){
                                                                colPers = true;
                                                                break;
                                                            }
                                                        }
                                                        if(verificado){
                                                            for(Inimigo I : inimigos){
                                                                if(I.getposY() == j && I.getposX() == in.getposX()){
                                                                    colIni = true;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    
                                                } else { 
                                                    // Esquerda
                                                    for(j = in.getposY(); j > coluna; j--){
                                                        for(Personagem P : personagens){
                                                            if(P.getposY() == j && P.getposX() == in.getposX()){
                                                                colPers = true;
                                                                break;
                                                            }
                                                        }
                                                        if(verificado){
                                                            for(Inimigo I : inimigos){
                                                                if(I.getposY() == j && I.getposX() == in.getposX()){
                                                                    colIni = true;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                if(in.getposY() == coluna){
                                                    // Baixo
                                                    if(in.getposX() - linha < 0){
                                                        for(j = in.getposX(); j < linha; j++){
                                                            for(Personagem P : personagens){
                                                                if(P.getposX() == j && P.getposY() == in.getposY()){
                                                                    colPers = true;
                                                                    break;
                                                                }
                                                            }
                                                            if(verificado){
                                                                for(Inimigo I : inimigos){
                                                                    if(I.getposY() == j && I.getposX() == in.getposX()){
                                                                        colIni = true;
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        // Acima
                                                        for(j = in.getposX(); j > linha; j--){
                                                            for(Personagem P : personagens){
                                                                if(P.getposX() == j && P.getposY() == in.getposY()){
                                                                    colPers = true;
                                                                    break;
                                                                }
                                                            }
                                                            
                                                            for(Inimigo I : inimigos){
                                                                if(I.getposX() == j && I.getposY() == in.getposY()){
                                                                    colIni = true;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    verificado = false;
                                                    break;
                                                }
                                            }
                                        } else {
                                            verificado = false;
                                            break;
                                        }
                                        
                                        if(!colPers && !colIni){
                                            verificado = true;
                                            colisao = verificarPosicao(personagens, linha, coluna);
                                        }
                                        break;

                                        case '♞':
                                        if(in.getposX() - linha == -2 || in.getposX() - linha == 2){
                                            if(in.getposY() - coluna == 1 || in.getposY() - coluna == -1){
                                                verificado = true;
                                            } else {
                                                verificado = false;
                                                break;
                                            }
                                        } else {
                                            if(in.getposY() - coluna == -2 || in.getposY() - coluna == 2){
                                                if(in.getposX() - linha == 1 || in.getposX() - linha == -1){
                                                    verificado = true;
                                                } else {
                                                    verificado = false;
                                                    break;
                                                }
                                            } else {
                                                verificado = false;
                                                break;
                                            }

                                        }
                                        colisao = verificarInimigo(inimigos, linha, coluna);
                                        break;

                                        case '♝':
                                        deltaX = in.getposX() - linha;
                                        deltaY = in.getposY() - coluna;
                                        Xnegativo = false;
                                        Ynegativo = false;

                                        if(deltaX == deltaY){
                                            int aux; // aux = X e j = Y
                                            if(!Xnegativo && !Ynegativo){
                                                for(aux = in.getposX() - 1; aux > linha; aux--){
                                                    for(j = in.getposY() - 1; j > coluna; j--){
                                                        for(Personagem P : personagens){
                                                            if(P.getposX() == aux && P.getposY() == j){
                                                                System.out.println("Peca = " + P.getIcone() + " | X = " + P.getposX() + " | Y = " + P.getposY());
                                                                verificado = false;
                                                                break;
                                                            } else {
                                                                verificado = true;
                                                            }
                                                        }
                                                        if(verificado){
                                                            for(Inimigo I : inimigos){
                                                                if(I.getposX() == aux && I.getposY() == j){
                                                                    verificado = false;
                                                                    break;
                                                                } else {
                                                                    verificado = true;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            if(Xnegativo && Ynegativo){
                                                for(aux = in.getposX() + 1; aux < linha; aux++){
                                                    for(j = in.getposY() + 1; j < coluna; j++){
                                                        for(Personagem P : personagens){
                                                            if(P.getposX() == aux && P.getposY() == j){
                                                                verificado = false;
                                                                break;
                                                            } else {
                                                                verificado = true;
                                                            }
                                                        }
                                                        if(verificado){
                                                            for(Inimigo I : inimigos){
                                                                if(I.getposX() == aux && I.getposY() == j){
                                                                    verificado = false;
                                                                    break;
                                                                } else {
                                                                    verificado = true;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                if(Xnegativo && !Ynegativo){
                                                    for(aux = in.getposX() + 1; aux < linha; aux++){
                                                        for(j = in.getposY() - 1; j > coluna; j--) {
                                                            for(Personagem P : personagens){
                                                                if(P.getposX() == aux && P.getposY() == j){
                                                                    verificado = false;
                                                                    break;
                                                                } else {
                                                                    verificado = true;
                                                                }
                                                            }
                                                            if(verificado){
                                                                for(Inimigo I : inimigos){
                                                                    if(I.getposX() == aux && I.getposY() == j){
                                                                        verificado = false;
                                                                        break;
                                                                    } else {
                                                                        verificado = true;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if(!Xnegativo && Ynegativo){
                                                    for(aux = in.getposX() - 1; aux > linha; aux--){
                                                        for(j = in.getposY() + 1; j < coluna; j++){
                                                            for(Personagem P : personagens){
                                                                if(P.getposX() == aux && P.getposY() == j){
                                                                    verificado = false;
                                                                    break;
                                                                } else {
                                                                    verificado = true;
                                                                }
                                                            }
                                                            if(verificado){
                                                                for(Inimigo I : inimigos){
                                                                    if(I.getposX() == aux && I.getposY() == j){
                                                                        verificado = false;
                                                                        break;
                                                                    } else {
                                                                        verificado = true;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else
                                            verificado = false;
                                         
                                        colisao = verificarPosicao(personagens, linha, coluna);
                                        break;

                                        case '♛':
                                        if(in.getposX() == linha || in.getposY() == coluna){
                                            if(in.getposX() == linha){
                                                // Direita
                                                if(in.getposY() - coluna < 0){
                                                    for(j = in.getposY(); j < coluna; j++){
                                                        for(Personagem P : personagens){
                                                            if(P.getposY() == j && P.getposX() == in.getposX()){
                                                                colPers = true;
                                                                break;
                                                            }
                                                        }
                                                        for(Inimigo I : inimigos){
                                                            if(I.getposX() == j && I.getposY() == in.getposY()){
                                                                colIni = true;
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    
                                                } else { 
                                                    // Esquerda
                                                    for(j = in.getposY(); j > coluna; j--){
                                                        for(Personagem P : personagens){
                                                            if(P.getposY() == j && P.getposX() == in.getposX()){
                                                                colPers = true;
                                                                break;
                                                            }
                                                        }
                                                        for(Inimigo I : inimigos){
                                                            if(I.getposX() == j && I.getposY() == in.getposY()){
                                                                colIni = true;
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                if(in.getposY() == coluna){
                                                    // Baixo
                                                    if(in.getposX() - linha < 0){
                                                        for(j = in.getposX(); j < linha; j++){
                                                            for(Personagem P : personagens){
                                                                if(P.getposX() == j && P.getposY() == in.getposY()){
                                                                    colPers = true;
                                                                    break;
                                                                }
                                                            }
                                                            for(Inimigo I : inimigos){
                                                                if(I.getposX() == j && I.getposY() == in.getposY()){
                                                                    colIni = true;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        // Acima
                                                        for(j = in.getposX(); j > linha; j--){
                                                            for(Personagem P : personagens){
                                                                if(P.getposX() == j && P.getposY() == in.getposY()){
                                                                    colPers = true;
                                                                    break;
                                                                }
                                                            }
                                                            
                                                            for(Inimigo I : inimigos){
                                                                if(I.getposX() == j && I.getposY() == in.getposY()){
                                                                    colIni = true;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    verificado = false;
                                                    break;
                                                }
                                            }

                                            if(!colIni && !colPers){
                                                verificado = true;
                                            }
                                        } else {
                                            deltaX = in.getposX() - linha;
                                            deltaY = in.getposY() - coluna;
                                            Xnegativo = false;
                                            Ynegativo = false;
    
                                            if(deltaX < 0){
                                                deltaX *= -1;
                                                Xnegativo = true;
                                            }
                                            if(deltaY < 0){
                                                deltaY *= -1;
                                                Ynegativo = true;
                                            }
                                            // Verificar possiveis colisões ao mexer o Bispo e NÃO ESQUECER DE ATUALIZAR NAS PEÇAS PRETAS E NAS RAINHAS -> TERMINOU ISSO? CODIGO FINALIZADO!!!
                                            if(deltaX == deltaY){
                                                int aux; // aux = X e j = Y
                                                if(!Xnegativo && !Ynegativo){
                                                    for(aux = in.getposX() - 1; aux > linha; aux--){
                                                        for(j = in.getposY() - 1; j > coluna; j--){
                                                            for(Personagem P : personagens){
                                                                if(P.getposX() == aux && P.getposY() == j){
                                                                    verificado = false;
                                                                    break;
                                                                } else {
                                                                    verificado = true;
                                                                }
                                                            }
                                                            if(verificado){
                                                                for(Inimigo I : inimigos){
                                                                    if(I.getposX() == aux && I.getposY() == j){
                                                                        verificado = false;
                                                                        break;
                                                                    } else {
                                                                        verificado = true;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if(Xnegativo && Ynegativo){
                                                    for(aux = in.getposX() + 1; aux < linha; aux++){
                                                        for(j = in.getposY() + 1; j < coluna; j++){
                                                            for(Personagem P : personagens){
                                                                if(P.getposX() == aux && P.getposY() == j){
                                                                    verificado = false;
                                                                    break;
                                                                } else {
                                                                    verificado = true;
                                                                }
                                                            }
                                                            if(verificado){
                                                                for(Inimigo I : inimigos){
                                                                    if(I.getposX() == aux && I.getposY() == j){
                                                                        verificado = false;
                                                                        break;
                                                                    } else {
                                                                        verificado = true;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    if(Xnegativo && !Ynegativo){
                                                        for(aux = in.getposX() + 1; aux < linha; aux++){
                                                            for(j = in.getposY() - 1; j > coluna; j--) {
                                                                for(Personagem P : personagens){
                                                                    if(P.getposX() == aux && P.getposY() == j){
                                                                        verificado = false;
                                                                        break;
                                                                    } else {
                                                                        verificado = true;
                                                                    }
                                                                }
                                                                if(verificado){
                                                                    for(Inimigo I : inimigos){
                                                                        if(I.getposX() == aux && I.getposY() == j){
                                                                            verificado = false;
                                                                            break;
                                                                        } else {
                                                                            verificado = true;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if(!Xnegativo && Ynegativo){
                                                        for(aux = in.getposX() - 1; aux > linha; aux--){
                                                            for(j = in.getposY() + 1; j < coluna; j++){
                                                                for(Personagem P : personagens){
                                                                    if(P.getposX() == aux && P.getposY() == j){
                                                                        verificado = false;
                                                                        break;
                                                                    } else {
                                                                        verificado = true;
                                                                    }
                                                                }
                                                                if(verificado){
                                                                    for(Inimigo I : inimigos){
                                                                        if(I.getposX() == aux && I.getposY() == j){
                                                                            verificado = false;
                                                                            break;
                                                                        } else {
                                                                            verificado = true;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else
                                                verificado = false;
                                            colisao = verificarPosicao(personagens, linha, coluna);
                                        }
                                        break;
                                    }

                                    if(!verificado){
                                        System.out.println("--------------------------------------------------------------");
                                        System.out.println("- MOVIMENTO DE PEÇA INVÁLIDO!                                -");
                                        System.out.println("--------------------------------------------------------------");
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
                                    }
                                }
                            }
                        }
                    }
                break;
            }
        }

        input.close();
    }
}
