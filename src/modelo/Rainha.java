package modelo;

public class Rainha extends Peca {

    public Rainha(EnumCor cor, int linha, int coluna) {
        super(cor, linha, coluna, "figs/RAINHA" + cor + ".gif");
    }

    public Rainha(EnumCor cor, int linha, int coluna, String imagem) {
        super(cor, linha, coluna, imagem);
    }

    @Override
    public boolean validaMovimento(int linhaDestino, int colunaDestino) {
        return true;
    }
}
