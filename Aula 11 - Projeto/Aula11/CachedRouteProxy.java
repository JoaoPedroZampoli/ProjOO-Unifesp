package Aula11;

import java.util.LinkedHashMap;
import java.util.Map;

public class CachedRouteProxy implements RouteService {
    private final RouteService routeService;
    private final Map<String, Route> cache;
    private final int cacheLimit;

    public CachedRouteProxy(RouteService routeService) {
        this.routeService = routeService;

        SettingsManager settingsManager = SettingsManager.getInstance();
        this.cacheLimit = Integer.parseInt(settingsManager.getSetting("limite_cache", "100"));
        
        this.cache = new LinkedHashMap<String, Route>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Route> eldest) {
                return size() > cacheLimit;
            }
        };
    }

    @Override
    public Route getRoute(String origem, String destino, TransportMode transportMode) {
        String cacheKey = origem + "|" + destino + "|" + transportMode.getClass().getSimpleName();
        if (cache.containsKey(cacheKey)) {
            System.out.println("Rota encontrada em cache!");
            return cache.get(cacheKey);
        }
        Route route = routeService.getRoute(origem, destino, transportMode);

        cache.put(cacheKey, route);
        System.out.println("Nova rota adicionada ao cache.");
        
        return route;
    }

    public void clearCache() {
        cache.clear();
        System.out.println("Cache de rotas limpo.");
    }

    public boolean hasRouteInCache(String origem, String destino, TransportMode transportMode) {
        String cacheKey = origem + "|" + destino + "|" + transportMode.getClass().getSimpleName();
        return cache.containsKey(cacheKey);
    }

    public int getCacheSize() {
        return cache.size();
    }        
}
