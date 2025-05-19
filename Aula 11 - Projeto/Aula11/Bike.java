package Aula11;

public class Bike implements TransportMode{
    @Override
    public double getSpeed() {
        return 15.0;
    }    

    @Override
    public double getCost() {
        return 0.1;
    }

    @Override
    public String getType() {
        return "Bicicleta";
    }
}
