package Aula09;

class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getTipo() {
        return pizza.getTipo();
    }

    @Override
    public double getPreco() {
        return pizza.getPreco();
    }

    @Override
    public String getAdicionais() {
        return pizza.getAdicionais();
    }
}