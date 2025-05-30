package Aula11;

public class BaseRouteService implements RouteService{
    private final MapService mapService;

    public BaseRouteService(MapService mapService) {
        this.mapService = mapService;
    }

    @Override
    public Route getRoute(String origem, String destino, TransportMode transportMode) {
        System.out.println("Calculando rota de " + origem + " para " + destino + " usando " + transportMode.getType());
        
        // Delegando a obtenção da rota para o serviço de mapas
        Route route = mapService.getRoute(origem, destino, transportMode);
        
        // Aplicando modificadores adicionais se necessário
        System.out.println("Ajustando parâmetros da rota conforme necessário");
        
        return route;
    }
}
