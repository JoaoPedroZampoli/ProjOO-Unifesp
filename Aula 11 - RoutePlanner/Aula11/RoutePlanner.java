package Aula11;

public class RoutePlanner implements WeatherObserver{
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

    public void onWeatherUpdate(String newCondition) {
        System.out.println("Atualizando estratégia de rota devido ao clima: " + newCondition);
        
    }
}

