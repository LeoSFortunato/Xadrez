package modelo;

public class Torre extends Peca {

    public Torre(EnumCor cor, int linha, int coluna) {
        super(cor, linha, coluna, "figs/TORRE" + cor + ".gif");
    }
    public Torre(EnumCor cor, int linha, int coluna, String imagem) {
        super(cor, linha, coluna, imagem);
    }

    @Override
    public boolean validaMovimento(int linhaDestino, int colunaDestino) {
        return true;
    }
}
