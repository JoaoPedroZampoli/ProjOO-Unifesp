import java.util.List;
import java.util.Collections;

public class TrechoDeVoo implements ElementoDaRota {
    private String origem;
    private String destino;
    private double preco;

    public TrechoDeVoo(String origem, String destino, double preco){
        this.origem = origem;
        this.destino = destino;
        this.preco = preco;
    }

    @Override
    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String getDestinoFinal() {
        return destino;
    }

    @Override
    public double getPrecoFinal() {
        return preco;
    }

    @Override
    public void exibirDetalhes(){
        System.out.printf("Trecho de Voo: %s -> %s, Preço: R$ %.2f%n", origem, destino, preco);
    }

    @Override
    public List<TrechoDeVoo> getTrechosDeVoo(){
        return Collections.singletonList(this);
    }

    @Override
    public String toString(){
        return origem + " -> " + destino + " (R$ " + preco + ")";
    }
}