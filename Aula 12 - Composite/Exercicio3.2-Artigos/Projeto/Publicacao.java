public interface Publicacao {
    String getNome();
    @Override
    String toString();
    int contarTotalPublicacoes();
    int contarArtigos();
}
