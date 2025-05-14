package Aula09;

public class Marguerita implements Pizza {
    private String tipo;
    private double preco;

    public Marguerita() {
        this.tipo = "Pizza de Marguerita";
        this.preco = 36.00;
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
