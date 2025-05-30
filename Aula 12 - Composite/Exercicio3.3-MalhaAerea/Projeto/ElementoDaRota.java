import java.util.List;

public interface ElementoDaRota {
    String getOrigem();
    String getDestinoFinal();
    double getPrecoFinal();
    void exibirDetalhes();
    List<TrechoDeVoo> getTrechosDeVoo();
}
