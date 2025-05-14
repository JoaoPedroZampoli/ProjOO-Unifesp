package Aula10;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int condicaoClimatica = random.nextInt(3); // 0: Sol, 1: Chuva, 2: Neve
        int trafego = random.nextInt(3); // 0: Leve, 1: Moderado, 2: Pesado
        
        RoutePlanner planner = new RoutePlanner();
        Scanner scanner = new Scanner(System.in);
        
        // Recebendo a origem e o destino do usuário
        System.out.print("Digite a origem: ");
        String origem = scanner.nextLine();
        
        System.out.print("Digite o destino: ");
        String destino = scanner.nextLine();
        
        System.out.print("Escolha o tipo de transporte (Carro, Táxi ou Moto): ");
        String tipoTransporte = scanner.nextLine();
        
        System.out.println("Tipo de Clima: " + 
                (condicaoClimatica == 0 ? "Sol" : condicaoClimatica == 1 ? "Chuva" : "Neve"));
                
        System.out.println("Tipo de Tráfego: " + 
                (trafego == 0 ? "Leve" : trafego == 1 ? "Moderado" : "Pesado"));
                
        System.out.print("Escolha o tipo de rota (mais curta, mais rápida, mais econômica ou mais ecológica): ");
        String tipoRota = scanner.nextLine();
        
        // Selecionando a estratégia baseada na escolha do usuário
        RouteStrategy strategy;
        switch(tipoRota.toLowerCase()) {
            case "mais rápida":
                strategy = new FastestRoute();
                break;
            case "mais curta":
                strategy = new ShortestRoute();
                break;
            case "mais econômica":
                strategy = new EconomicRoute();
                break;
            case "mais ecológica":
                strategy = new EcoFriendlyRoute();
                break;
            default:
                System.out.println("Tipo de rota não reconhecido. Usando rota mais rápida por padrão.");
                strategy = new FastestRoute();
        }
        
        // Configurando a estratégia e calculando a rota
        planner.setStrategy(strategy);
        Route rota = planner.planRoute(origem, destino);
        
        // Exibindo o resultado
        System.out.println("\nRota calculada de " + origem + " para " + destino + ":");
        System.out.println("Distância: " + String.format("%.2f", rota.distancia) + " km");
        System.out.println("Tempo estimado: " + String.format("%.2f", rota.tempoEstimado) + " minutos");
        System.out.println("Custo: R$ " + String.format("%.2f", rota.custoEstimado));
        System.out.println("Emissão de CO2: " + String.format("%.2f", rota.emissaoEstimada) + " kg");
        
        scanner.close();
    }
}