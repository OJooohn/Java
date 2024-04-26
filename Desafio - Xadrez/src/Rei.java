public class Rei extends Peca{

  public Rei(String icone, int posX, int posY, boolean isWhite, boolean isBlack) {
    super(icone, posX, posY, isWhite, isBlack);
  }

  @Override
  public boolean movimentarPeca() {

    boolean verificado = false;

    return super.movimentarPeca();
  }

  public static boolean verificarCastling(Peca p, int linha, int coluna, List<Personagem> personagens, List<Inimigo> inimigos, int pecas) {

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

    public static boolean verificarRei(int linha, int coluna, Peca p) {

      return (p.getposX() - linha) <= 1 && (p.getposX() - linha) >= -1 && (p.getposY() - coluna) <= 1
              && (p.getposY() - coluna) >= -1;
  }

}
