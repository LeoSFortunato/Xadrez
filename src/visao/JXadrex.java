package visao;

import modelo.EnumCor;
import modelo.Tabuleiro;

import javax.swing.*;
import java.awt.*;

public class JXadrex extends JFrame {

    private static JLabel lbVez;

    private Tabuleiro tabuleiro;
    private JButton btReiniciarJogo;
    private JButton btPassavez;

    public JXadrex() {
        setTitle("Jogo de Xadrez");
        this.setLayout(new BorderLayout());
        this.tabuleiro = new Tabuleiro();
        this.add(new JTabuleiro(tabuleiro), BorderLayout.CENTER);


        JPanel pnTopo = new JPanel();
        lbVez = new JLabel("VEZ DE: BRANCO");
        pnTopo.add(lbVez);
        this.add(pnTopo, BorderLayout.NORTH);

        JPanel pnLateral = new JPanel();
        pnLateral.setLayout(new GridLayout(10, 1));
        btReiniciarJogo = new JButton("Reiniciar Jogo");
        btPassavez = new JButton("Passar a Vez");
        pnLateral.add(btReiniciarJogo);
        pnLateral.add(btPassavez);

        this.add(pnLateral, BorderLayout.WEST);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack();
        this.setVisible(true);
    }

    public static void setVez(EnumCor corVez) {
        lbVez.setText("VEZ DE: " + corVez);
    }

}
