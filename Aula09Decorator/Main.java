package Aula09Decorator;

public class Main {
    public static void main(String[] args) {
        // Pizza básica
        Pizza marguerita = new Marguerita();
        System.out.println(marguerita.getTipo() + " - R$" + marguerita.getPreco());
        
        // Pizza com um adicional
        Pizza margueritaComQueijo = new AdicionalQueijo(marguerita);
        System.out.println(margueritaComQueijo.getTipo() + " - R$" + margueritaComQueijo.getPreco());
        
        // Pizza com múltiplos adicionais
        Pizza calabresa = new Calabresa();
        Pizza calabresaComQueijo = new AdicionalQueijo(calabresa);
        System.out.println(calabresaComQueijo.getTipo());
        System.out.println("Adicionais: " + calabresaComQueijo.getAdicionais());
        System.out.println("Preço total: R$" + calabresaComQueijo.getPreco());
    }
}
