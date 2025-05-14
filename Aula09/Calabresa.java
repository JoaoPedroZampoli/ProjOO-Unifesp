package Aula09;

public class Calabresa implements Pizza {
    private String tipo;
    private double preco;

    public Calabresa(){
        this.tipo = "\nPizza de Calabresa";
        this.preco = 40.00;
    }
    public String getTipo() {
        return tipo;
    }
    public double getPreco() {
        return preco;
    }
    @Override
    public String getAdicionais() {
        return ""; 
    }
}
