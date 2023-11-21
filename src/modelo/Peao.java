package modelo;

public class Peao extends Peca {

    private boolean primeiroMovimento = true;

    public Peao(EnumCor cor, int linha, int coluna, String imagem) {
        super(cor, linha, coluna, imagem);
    }

    @Override
    public boolean validaMovimento(int linhaDestino, int colunaDestino) {
        return true;
    }
}
