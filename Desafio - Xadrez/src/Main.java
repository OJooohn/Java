import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // IntelliJ Terminal colors
    // Console Background: 9E9E9E
    // Error: FF0018
    // Standart output: 000000
    // System output: 000000
    // User input: 00FF24

    // Green: FFFFFF both
    // Black: 656565 FFFFFF

    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK// RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN

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
        for(int j = 0; j < personagens.size(); j++){
            Personagem p = personagens.get(j);
            if(p.getposX() == linha && p.getposY() == coluna){
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

    public static void main(String[] args) {

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
                            // Limitar movimentos das peças e verificar colisões ao movimentar !! PARTE MAIS DIFÍCIL DO DESAFIO !!
                            // String iconePeca = personagens.get(i).getIcone();
                            
                            while(!verificado){
                                System.out.println("--------------------------------------------------------------");
                                System.out.print("- SELECIONE A PROXIMA POSIÇÃO DA PEÇA (A1 - H8): ");
                                proximaPosicao = input.nextLine();

                                if (!Character.isLetter(pecaSelecionada.charAt(0)) || !Character.isDigit(pecaSelecionada.charAt(1))) {
                                    System.out.println("- Input inválido. Insira um input válido entre 'A1' e 'H8'.");
                                }
                                
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
                                            if(I.getposX() + 1 == p.getposX() && I.getposY() - 1 == p.getposY()){
                                                diagonal = true;
                                                break;
                                            }
                                        }
                                        if(diagonal){
                                            System.out.println("teste");
                                        }

                                        if(p.getposX() == 6){
                                            if(p.getposX() - linha > 2){
                                                if(p.getposY() == coluna){
                                                    verificado = true;
                                                }
                                                break;
                                            } else {
                                                verificado = true;
                                            }
                                        } else {
                                            if(p.getposX() < linha || (p.getposX() - linha) <= 0 || (p.getposX() - linha) > 1 || (p.getposY() != coluna && !diagonal)){
                                                break;
                                            } else {
                                                verificado = true;
                                            }
                                        }
                                        colisao = verificarPosicao(personagens, linha, coluna);
                                    break;
            
                                    case '♖':
                                        //colisao = verificarPosicao(personagens, linha, coluna);
                                    break;

                                    case '♘':
                                        //colisao = verificarPosicao(personagens, linha, coluna);
                                    break;
            
                                    case '♗':
                                        //colisao = verificarPosicao(personagens, linha, coluna);
                                    break;
            
                                    case '♕':
                                        //colisao = verificarPosicao(personagens, linha, coluna);
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

                            if (!Character.isLetter(pecaSelecionada.charAt(0)) || !Character.isDigit(pecaSelecionada.charAt(1))) {
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
                break;
            }
        }

        input.close();
    }
}
