package Aula11;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TouristInfoDecorator extends RouteDecorator{
    private Map<String, String[]> pointsOfInterest;
    private Random random = new Random();

    public TouristInfoDecorator(Route route){
        super(route);
        InitializePOIs();
        System.out.println("Adicionando informações turísticas à rota...");
    }

    private void InitializePOIs(){
        pointsOfInterest = new HashMap<>();

        // Usando São Paulo como exemplo
        pointsOfInterest.put("Centro", new String[] {
            "Catedral da Sé", "Mercado Municipal", "Pinacoteca", "Teatro Municipal"
        });
        
        pointsOfInterest.put("Avenida Paulista", new String[] {
            "MASP", "Japan House", "Casa das Rosas", "Instituto Moreira Salles"
        });
        
        pointsOfInterest.put("Parque Ibirapuera", new String[] {
            "MAM", "Museu Afro Brasil", "Planetário", "Bienal de Arte"
        });
        
        pointsOfInterest.put("Vila Madalena", new String[] {
            "Beco do Batman", "Benedito Calixto", "Teatro do Ator", "Bares e Restaurantes"
        });
    }

    private String[] getTouristAttractions(String location){
        for (String key : pointsOfInterest.keySet()) {
            if (location.toLowerCase().contains(key.toLowerCase())) {
                return pointsOfInterest.get(key);
            }
        }

        return new String[] {
            "Praça local", "Restaurantes próximos", "Centro cultural", "Comércio local"
        };
    }

    @Override
    public void display(){
        decoratedRoute.display();

        System.out.println("Pontos de interesse na rota:");
        String[] attractions = getTouristAttractions(decoratedRoute.getOrigem());
        System.out.println("Atrações turísticas em " + decoratedRoute.getOrigem() + ":");
        int originCount = Math.min(attractions.length, 3);
        for (int i = 0; i < originCount; i++) {
            System.out.println("- " + attractions[i]);
        }

        String[] attractionsDest = getTouristAttractions(decoratedRoute.getDestino());
        System.out.println("Atrações turísticas em " + decoratedRoute.getDestino() + ":");
        int destinationCount = Math.min(attractionsDest.length, 3);
        for (int i = 0; i < destinationCount; i++) {
            System.out.println("- " + attractionsDest[i]);
        }

        String[] tips = {
            "Experimente a comida local!",
            "Visite os museus e centros culturais.",
            "Aproveite os parques e áreas verdes.",
            "Use transporte público para evitar o trânsito.",
            "Cuidado com seus pertences em áreas movimentadas."
        };
        System.out.println("\nDica: " + tips[random.nextInt(tips.length)]);
    }
    
    @Override
    public String getOrigem() {
        return decoratedRoute.getOrigem();
    }
    
    @Override
    public String getDestino() {
        return decoratedRoute.getDestino();
    }
}
