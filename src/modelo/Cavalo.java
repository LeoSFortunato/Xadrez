package modelo;

public class Cavalo extends Peca {

    public Cavalo(EnumCor cor, int linha, int coluna) {
        super(cor, linha, coluna, "figs/CAVALO" + cor + ".gif");
    }

    public Cavalo(EnumCor cor, int linha, int coluna, String imagem) {
        super(cor, linha, coluna, imagem);
    }

    @Override
    public boolean validaMovimento(int linhaDestino, int colunaDestino) {
        return true;
    }
}
