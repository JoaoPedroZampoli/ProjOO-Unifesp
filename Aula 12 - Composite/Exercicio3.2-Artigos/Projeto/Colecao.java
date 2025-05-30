import java.util.List;
import java.util.ArrayList;

public class Colecao implements Publicacao {
    private String nome;
    private List<Publicacao> publicacoes;

    public Colecao(String nome) {
        this.nome = nome;
        this.publicacoes = new ArrayList<>();
    }

    public void adicionarPublicacao(Publicacao publicacao){
        if(publicacao != null){
            publicacoes.add(publicacao);
        }
        else{
            System.out.println("Publicação Inválida!");
        }
    }    

    public void removerPublicacao(Publicacao publicacao){
        if (publicacao != null && publicacoes.contains(publicacao)){
            publicacoes.remove(publicacao);
        } else {
            System.out.println("Publicação não encontrada na coleção.");
        }
    }

    public List<Publicacao> getPublicacoes() {
        return publicacoes;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Coleção: ").append(nome).append("\n");
        sb.append("Publicações:\n");
        if(publicacoes.isEmpty()){
            sb.append("Nenhuma publicação na coleção até o momento.\n");
        }
        else{
            for (Publicacao pub : publicacoes){
                sb.append("- ").append(pub.toString()).append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public int contarTotalPublicacoes(){
        int contador = 0;
        for (Publicacao pub: publicacoes){
            contador += pub.contarTotalPublicacoes();
        }
        return contador;
    }

    @Override
    public int contarArtigos() {
        int contador = 0;
        for (Publicacao pub : publicacoes) {
            contador += pub.contarArtigos();
        }
        return contador;
    }
    
}
