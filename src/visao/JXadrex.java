package visao;

import modelo.Tabuleiro;

import javax.swing.*;

public class JXadrex extends JFrame {

    public JXadrex() {
        setTitle("Jogo de Xadrez");
        this.add(new JTabuleiro(new Tabuleiro()));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack();
        this.setVisible(true);
    }

}
