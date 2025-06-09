public interface Processador {
    public Object processarTexto(String texto);
    public void setProximo(Processador proximo);
}
