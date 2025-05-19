package Aula11;

public class AppFacade{
    private final RoutePlanner planner;
    private final RouteService routeService;
    private final SettingsManager settingsManager;
    private final TransportFactory transportFactory;

    public AppFacade(RoutePlanner planner, RouteService routeService, SettingsManager settingsManager) {
        this.planner = planner;
        this.routeService = routeService;
        this.settingsManager = settingsManager;
        this.transportFactory = new TransportFactory();
        System.out.println("Sistema de recomendação de rotas inicializado.");
    }

    public void showRouteWithEnhancements(String origem, String destino, String tipoTransporte) {
        TransportMode transport = transportFactory.create(tipoTransporte);
        
        String estrategiaPreferida = settingsManager.getSetting("estrategia_preferida");
        RouteStrategy strategy;
        
        switch (estrategiaPreferida == null ? "rapida" : estrategiaPreferida.toLowerCase()) {
            case "eco":
            case "ecologica":
                strategy = new EcoFriendlyRoute();
                break;
            case "economica":
                strategy = new EconomicRoute();
                break;
            case "curta":
                strategy = new ShortestRoute();
                break;
            case "rapida":
            default:
                strategy = new FastestRoute();
        }
        
        planner.setStrategy(strategy);
        
        Route route = routeService.getRoute(origem, destino, transport);
        
        Route decoratedRoute = route;
        
        if (Boolean.parseBoolean(settingsManager.getSetting("mostrar_informacoes_turisticas", "true"))) {
            decoratedRoute = new TouristInfoDecorator(decoratedRoute);
        }
        
        System.out.println("Rota Recomendada:");
        System.out.println("De: " + origem);
        System.out.println("Para: " + destino);
        System.out.println("Meio de transporte: " + tipoTransporte);
        System.out.println("Estratégia: " + strategy.getClass().getSimpleName());
        
        decoratedRoute.display();
        
        System.out.println("\nRota adicionada ao histórico de buscas recentes.");
        
        System.out.println("\n");
    }
}