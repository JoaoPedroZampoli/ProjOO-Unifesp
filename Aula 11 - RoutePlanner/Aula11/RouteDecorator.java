package Aula11;

public abstract class RouteDecorator extends Route {
    protected Route decoratedRoute;
    
    public RouteDecorator(Route decoratedRoute) {
        super(decoratedRoute.getOrigem(), decoratedRoute.getDestino(), 
              decoratedRoute.distancia, decoratedRoute.tempoEstimado, 
              decoratedRoute.custoEstimado, decoratedRoute.emissaoEstimada);
        this.decoratedRoute = decoratedRoute;
    }

    @Override
    public void display() {
        decoratedRoute.display();
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