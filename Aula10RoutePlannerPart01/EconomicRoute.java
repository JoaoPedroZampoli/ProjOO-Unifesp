package Aula10RoutePlannerPart01;
import java.util.Random;

public class EconomicRoute implements RouteStrategy {
    private Random random = new Random();

    @Override
    public Route calcularRota(String origem, String destino){
        double distancia = 10 + random.nextDouble() * 70;
        double tempo = 1 + random.nextDouble() * 20;
        double custo = 5 + random.nextDouble() * 30;
        double emissao = 0.1 + random.nextDouble() * 10;
        Route rota = new Route(origem, destino, distancia, tempo, custo, emissao);

        return rota;
    }
}
