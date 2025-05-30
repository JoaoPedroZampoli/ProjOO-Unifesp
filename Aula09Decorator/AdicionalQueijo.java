package Aula09Decorator;

public class AdicionalQueijo extends PizzaDecorator {
    public AdicionalQueijo(Pizza pizza){
        super(pizza);
    }

    @Override
    public String getTipo() {
        return pizza.getTipo() + " com queijo extra adicionado";
    }

    @Override
    public double getPreco() {
        return pizza.getPreco() + 5.00;
    }

    @Override
    public String getAdicionais(){
        return pizza.getAdicionais() + "Queijo extra - R$ 5,00";
    }
}
