package controle;

import modelo.Peca;
import modelo.Tabuleiro;
import visao.JTabuleiro;

import javax.swing.*;
import java.lang.Runnable;
public class ControlaTempo implements Runnable {

    private JTabuleiro jTabuleiro;

    private int tempoGasto = 0;

    public ControlaTempo() {
        super();
    }

    public void setJTabuleiro(JTabuleiro jTabuleiro) {
        this.jTabuleiro = jTabuleiro;
    }

    public void zeraCronometro() {
        this.tempoGasto = 0;
    }

    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep(1000);
                tempoGasto += 1000;
                if (tempoGasto >= Tabuleiro.TEMPO_JOGADA) {
                    JOptionPane.showMessageDialog(null, "O jogador " + jTabuleiro.getTabuleiro().getVez() + " perdeu a vez");
                    jTabuleiro.getTabuleiro().inverteVez();
                    if (jTabuleiro.getTabuleiro().getPecaSelecionada() != null) {
                        jTabuleiro.getTabuleiro().getPecaSelecionada().setSelecionada(false);
                        jTabuleiro.getTabuleiro().setPecaSelecionada(null);

                    }
                    jTabuleiro.getTabuleiro().inverteVez();
                    jTabuleiro.desenhaTabuleiro();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
