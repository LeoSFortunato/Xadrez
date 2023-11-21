package visao;

import modelo.Peca;
import modelo.Tabuleiro;

import javax.swing.*;
import java.awt.*;

public class JTabuleiro extends JPanel {

    private Tabuleiro tabuleiro;

    public JTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public void desenhaTabuleiro() {
        this.removeAll();
        this.setLayout(new GridLayout(8, 8));
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                JCelula jCelula;
                Peca peca = this.tabuleiro.getPeca(i, j);
                if (peca == null) {
                    jCelula = new JCelula(i,j);
                } else {

                }
            }
        }
    }



}
