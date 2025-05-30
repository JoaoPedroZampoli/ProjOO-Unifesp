package Aula10RoutePlannerPart01;

public class RoutePlanner {
    private RouteStrategy strategy;

    public void setStrategy(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    public Route planRoute(String origem, String destino) {
        if (strategy == null) {
            throw new IllegalStateException("Nenhuma estratégia definida!");
        }
        return strategy.calcularRota(origem, destino);
    }
}

