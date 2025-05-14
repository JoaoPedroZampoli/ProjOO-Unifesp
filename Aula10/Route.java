package Aula10;

public class Route {
    private String origem;
    private String destino;
    private String tipoRota;
    public double distancia;
    public double tempoEstimado;
    public double custoEstimado;
    public double emissaoEstimada;

    public Route(String origem, String destino, double distancia, double tempoEstimado, double custoEstimado, double emissaoEstimada){
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
        this.tempoEstimado = tempoEstimado;
        this.custoEstimado = custoEstimado;
        this.emissaoEstimada = emissaoEstimada;
    }

    public void setTipoRota(String tipoRota){
        this.tipoRota = tipoRota;
    }
    
    @Override
    public String toString() {
        return String.format(
            "Rota de %s para %s (%s):\n" +
            "  - Distância: %.2f km\n" +
            "  - Tempo estimado: %.2f min\n" +
            "  - Custo estimado: R$ %.2f\n" +
            "  - Emissão de CO2: %.2f kg",
            origem, destino, tipoRota, distancia, tempoEstimado, custoEstimado, emissaoEstimada
        );
    }
}
