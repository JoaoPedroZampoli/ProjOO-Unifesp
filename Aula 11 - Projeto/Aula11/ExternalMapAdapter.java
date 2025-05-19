package Aula11;

import java.util.Random;

class MapProvider {
    private Random random = new Random();

    public RouteData calculatePath(String origem, String destino){
        System.out.println("Calculando rota entre " + origem + " e " + destino);

        double distancia = 10 + random.nextDouble() * 70;
        double tempo = 1 + random.nextDouble() * 20;
        double custo = 5 + random.nextDouble() * 50;
        double emissao = 0.1 + random.nextDouble() * 5;

        return new RouteData(origem, destino, distancia, tempo, custo, emissao);
    }

    public class RouteData {
        private double distancia;
        private double tempo;
        private double custo;
        private double emissao;

        public RouteData(String origem, String destino, double distancia, double tempo, double custo, double emissao) {
            this.distancia = distancia;
            this.tempo = tempo;
            this.custo = custo;
            this.emissao = emissao;
        }

        public double getDistancia() {
            return distancia;
        }
        public double getTempo() {
            return tempo;
        }
        public double getCusto() {
            return custo;
        }
        public double getEmissao() {
            return emissao;
        }
        
    }
}

public class ExternalMapAdapter implements MapService{
    private MapProvider MapProvider;

    public ExternalMapAdapter(MapProvider mapProvider) {
        this.MapProvider = new MapProvider();
        System.out.println("Adaptando o serviço de mapas externo...");
    }

    @Override
    public Route getRoute(String origem, String destino, TransportMode transportMode) {
        System.out.println("Calculando rota entre " + origem + " e " + destino + " usando " + transportMode.getType());

        MapProvider.RouteData routeData = MapProvider.calculatePath(origem, destino);

        Route route = new Route(origem, destino, routeData.getDistancia(), routeData.getTempo(), routeData.getCusto() * transportMode.getCost(), routeData.getEmissao());
        route.tempoEstimado = route.tempoEstimado * (30.0 / transportMode.getSpeed());

        route.setTipoRota("Rota externa");
        System.out.println("Rota calculada com sucesso!");

        return route;
    }
}
