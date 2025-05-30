public class Artigo implements Publicacao{
    private String nome;
    private String[] autores;

    public Artigo(String nome, String[] autores) {
        this.nome = nome;
        this.autores = autores;
    }

    @Override
    public String getNome(){
        return nome;
    }

    @Override
    public String toString(){
        return "Artigo: " + nome + ", Autores: " + String.join(", ", autores);
    }

    @Override
    public int contarTotalPublicacoes() {
        return 1;
    }

    @Override
    public int contarArtigos(){
        return 1;
    }
}
