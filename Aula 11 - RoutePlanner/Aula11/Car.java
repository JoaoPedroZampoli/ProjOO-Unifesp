package Aula11;

public class Car implements TransportMode {
    @Override
    public double getSpeed() {
        return 60.0;
    }

    @Override
    public double getCost() {
        return 0.5;
    }

    @Override
    public String getType() {
        return "Carro";
    }
    
}
