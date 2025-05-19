package Aula11;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Recebendo a origem e o destino do usuário
        System.out.print("Digite a origem: ");
        String origem = scanner.nextLine();
        
        System.out.print("Digite o destino: ");
        String destino = scanner.nextLine();
        
        System.out.print("Escolha o tipo de transporte (carro, bicicleta): ");
        String tipoTransporte = scanner.nextLine();
        
        System.out.print("Escolha o tipo de rota (mais curta, mais rápida, mais econômica ou mais ecológica): ");
        String tipoRota = scanner.nextLine();

        SettingsManager settingsManager = SettingsManager.getInstance();

        settingsManager.setSetting("estrategia_preferida", mapRouteTypeToStrategy(tipoRota));

        MapService mapService = new ExternalMapAdapter(new MapProvider());

        RouteService routeService = new CachedRouteProxy(new BaseRouteService(mapService));

        RoutePlanner planner = new RoutePlanner();

        AppFacade facade = new AppFacade(planner, routeService, settingsManager);

        facade.showRouteWithEnhancements(origem, destino, tipoTransporte);
        
        scanner.close();
    }

    private static String mapRouteTypeToStrategy(String tipoRota) {
        switch(tipoRota.toLowerCase()) {
            case "mais rápida":
                return "rapida";
            case "mais curta":
                return "curta";
            case "mais econômica":
                return "economica";
            case "mais ecológica":
                return "eco";
            default:
                System.out.println("Tipo de rota não reconhecido. Usando rota mais rápida por padrão.");
                return "rapida";
        }
    }
        // Selecionando a estratégia baseada na escolha do usuário
        // RouteStrategy strategy;
        // switch(tipoRota.toLowerCase()) {
        //     case "mais rápida":
        //         strategy = new FastestRoute();
        //         break;
        //     case "mais curta":
        //         strategy = new ShortestRoute();
        //         break;
        //     case "mais econômica":
        //         strategy = new EconomicRoute();
        //         break;
        //     case "mais ecológica":
        //         strategy = new EcoFriendlyRoute();
        //         break;
        //     default:
        //         System.out.println("Tipo de rota não reconhecido. Usando rota mais rápida por padrão.");
        //         strategy = new FastestRoute();
        // }
        
        // // Configurando a estratégia e calculando a rota
        // planner.setStrategy(strategy);
        // Route rota = planner.planRoute(origem, destino);
        
        // // Exibindo o resultado
        // System.out.println("\nRota calculada de " + origem + " para " + destino + ":");
        // System.out.println("Distância: " + String.format("%.2f", rota.distancia) + " km");
        // System.out.println("Tempo estimado: " + String.format("%.2f", rota.tempoEstimado) + " minutos");
        // System.out.println("Custo: R$ " + String.format("%.2f", rota.custoEstimado));
        // System.out.println("Emissão de CO2: " + String.format("%.2f", rota.emissaoEstimada) + " kg");
}