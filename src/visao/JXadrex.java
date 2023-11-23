package visao;

import controle.ControlaTempo;
import modelo.EnumCor;
import modelo.Tabuleiro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JXadrex extends JFrame {

    private static JLabel lbVez;
    public Tabuleiro tabuleiro;
    private JButton btReiniciarJogo;
    private JButton btPassavez;
    private final ControlaTempo controleTempo;
    private final JTabuleiro jTabuleiro;
    public static final JPanel painelCemiterio = new JPanel();
    public JProgressBar pbTempo;

    public JXadrex() {
        setTitle("Jogo de Xadrez");
        this.setLayout(new BorderLayout());
        pbTempo = new JProgressBar();
        pbTempo.setMinimum(0);
        pbTempo.setMaximum(10000);
        this.controleTempo = new ControlaTempo(pbTempo);
        this.tabuleiro = new Tabuleiro(controleTempo);
        this.jTabuleiro = new JTabuleiro(tabuleiro);
        controleTempo.setJTabuleiro(jTabuleiro);
        this.add(jTabuleiro, BorderLayout.CENTER);

        JPanel pnTopo = new JPanel();
        lbVez = new JLabel("VEZ DE: BRANCO");
        pnTopo.add(lbVez);
        this.add(pnTopo, BorderLayout.NORTH);

        JPanel pnLateral = new JPanel();
        pnLateral.setLayout(new GridLayout(10, 1));
        btReiniciarJogo = new JButton("Reiniciar Jogo");

        btReiniciarJogo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                reiniciaJogo();
            }
        });

        //painelCemiterio.setLayout(new FlowLayout());
        this.add(painelCemiterio, BorderLayout.EAST);

        btPassavez = new JButton("Passar a Vez");
        pnLateral.add(btReiniciarJogo);
        pnLateral.add(btPassavez);

        this.add(pnLateral, BorderLayout.WEST);
        this.add(pbTempo, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Thread threadTempo = new Thread(controleTempo);
        threadTempo.start();

        this.pack();
        this.setVisible(true);
    }

    private void reiniciaJogo() {
        controleTempo.zeraCronometro();
        this.tabuleiro = new Tabuleiro(controleTempo);
        this.jTabuleiro.setTabuleiro(this.tabuleiro);
        this.jTabuleiro.desenhaTabuleiro();
        setVez(tabuleiro.getVez());
    }


    public static void setVez(EnumCor corVez) {
        lbVez.setText("VEZ DE: " + corVez);
    }

}
