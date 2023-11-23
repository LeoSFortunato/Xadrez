package modelo;

import controle.ControlaTempo;
import visao.JXadrex;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {

    private Peca[][] pecas;
    private Peca pecaSelecionada = null;
    private EnumCor vez = EnumCor.BRANCO;
    public static final int TEMPO_JOGADA = 10000;
    private ControlaTempo controleTempo;
    private List<Peca> pecasForaDeJogo;

    public Tabuleiro(ControlaTempo controleTempo) {
        this.controleTempo = controleTempo;
        this.pecas = new Peca[8][8];
        this.pecasForaDeJogo = new ArrayList<>();

        Torre torreBranca1 = new Torre(EnumCor.BRANCO, 0, 0);
        Torre torreBranca2 = new Torre(EnumCor.BRANCO, 0, 7);
        this.adicionarPeca(torreBranca1);
        this.adicionarPeca(torreBranca2);

        Torre torrePreta1 = new Torre(EnumCor.PRETO, 7, 0);
        Torre torrePreta2 = new Torre(EnumCor.PRETO, 7, 7);
        this.adicionarPeca(torrePreta1);
        this.adicionarPeca(torrePreta2);

        Cavalo cavaloBranco1 = new Cavalo(EnumCor.BRANCO, 0, 1);
        Cavalo cavaloBranco2 = new Cavalo(EnumCor.BRANCO, 0, 6);
        this.adicionarPeca(cavaloBranco1);
        this.adicionarPeca(cavaloBranco2);

        Cavalo cavaloPreto1 = new Cavalo(EnumCor.PRETO, 7, 1);
        Cavalo cavaloPreto2 = new Cavalo(EnumCor.PRETO, 7, 6);
        this.adicionarPeca(cavaloPreto1);
        this.adicionarPeca(cavaloPreto2);

        Bispo bispoBranco1 = new Bispo(EnumCor.BRANCO, 0, 2);
        Bispo bispoBranco2 = new Bispo(EnumCor.BRANCO, 0, 5);
        this.adicionarPeca(bispoBranco1);
        this.adicionarPeca(bispoBranco2);

        Bispo bispoPreto1 = new Bispo(EnumCor.PRETO, 7, 2);
        Bispo bispoPreto2 = new Bispo(EnumCor.PRETO, 7, 5);
        this.adicionarPeca(bispoPreto1);
        this.adicionarPeca(bispoPreto2);

        Rainha rainhaBranco = new Rainha(EnumCor.BRANCO, 0, 4);
        Rainha rainhaPreto = new Rainha(EnumCor.PRETO, 7, 3);
        this.adicionarPeca(rainhaBranco);
        this.adicionarPeca(rainhaPreto);

        Rei reiBranco = new Rei(EnumCor.BRANCO, 0, 3);
        Rei reiPreto = new Rei(EnumCor.PRETO, 7, 4);
        this.adicionarPeca(reiBranco);
        this.adicionarPeca(reiPreto);

        for (int i = 0; i < 8; i++) {
            Peao peaoBranco = new Peao(EnumCor.BRANCO, 1, i);
            this.adicionarPeca(peaoBranco);

            Peao peaoPreto = new Peao(EnumCor.PRETO, 6, i);
            this.adicionarPeca(peaoPreto);
        }

    }

    public List<Peca> getPecasForaDeJogo() {
        return pecasForaDeJogo;
    }

    public EnumCor getVez() {
        return this.vez;
    }

    public Peca getPecaSelecionada() {
        return this.pecaSelecionada;
    }

    public void setPecaSelecionada(Peca peca) {
        this.pecaSelecionada = peca;
    }

    public Peca getPeca(int linha, int coluna) {
        return this.pecas[linha][coluna];
    }

    public void setPeca(Peca peca) {
        this.pecas[peca.getLinha()][peca.getColuna()] = peca;
        peca.setTabuleiro(this);
    }

    public void adicionarPeca(Peca peca) {
        this.pecas[peca.getLinha()][peca.getColuna()] = peca;
        peca.setTabuleiro(this);
    }

    public void selecionaPeca(Peca peca) {
        if (peca.isSelecionada()) {
            peca.setSelecionada(false);
            this.pecaSelecionada = null;
        } else {
            peca.setSelecionada(true);
            this.pecaSelecionada = peca;
        }
    }
    
    public void movePeca(Peca peca, int novaLinha, int novaColuna) {
        if (peca.validaMovimento(novaLinha, novaColuna)) {
            this.pecas[peca.getLinha()][peca.getColuna()] = null;
            peca.setLinha(novaLinha);
            peca.setColuna(novaColuna);
            if (peca instanceof Peao) {
                Peao peao = (Peao) peca;
                peao.setPrimeiroMovimento(false);
            }
            this.setPeca(peca);
            this.selecionaPeca(peca);

            this.inverteVez();
        }
    }

    public void inverteVez() {
        if (this.vez.equals(EnumCor.BRANCO)) {
            this.vez = EnumCor.PRETO;
        } else {
            this.vez = EnumCor.BRANCO;
        }
        JXadrex.setVez(this.  vez);
        controleTempo.zeraCronometro();
    }

    public void realizaJogada(int linha, int coluna) {

        Peca peca = this.getPeca(linha, coluna);
        if (this.pecaSelecionada == null) {
            if (peca != null && peca.getCor().equals(this.vez)) {
                this.selecionaPeca(peca);
            }
        } else {
            if (pecaSelecionada == peca) {
                this.selecionaPeca(peca);
            } else {
                if (peca == null) { //mover pra uma célula vazia
                    this.movePeca(this.pecaSelecionada, linha, coluna);
                }
                if (peca != null && !peca.getCor().equals(this.pecaSelecionada.getCor())) { // capturar o adversário
                    peca.setEliminada(true);
                    this.pecasForaDeJogo.add(peca);
                    this.movePeca(this.pecaSelecionada, linha, coluna);
                }
            }
        }
    }

}
