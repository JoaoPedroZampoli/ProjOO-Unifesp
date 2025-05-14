//Exemplo de Fábrica

interface EntregaPizza { // Declaração de uma interface de uso comum
    void entregarPizza(String endereco);
}

class EntregaPizzaNormal implements EntregaPizza {
    public void entregarPizza(String endereco){
        System.out.println("Entregando pizza com prioridade normal para: " + endereco);
    }
}

class EntregaPizzaExpress implements EntregaPizza {
    public void entregarPizza(String endereco){
        System.out.println("Entregando pizza com alta prioridade para: " + endereco);
    }
}

class EntregaPizzaAgendada implements EntregaPizza {
    private String dataHoraAgendada;

    public void agendarEntrega(String dataHora) {
        this.dataHoraAgendada = dataHora;
    }

    @Override
    public void entregarPizza(String endereco) {
        System.out.println("Entregando pizza agendada para: " + endereco + " na data e hora: " + dataHoraAgendada);
    }
}

class EntregaPizzaFabrica {
    public static EntregaPizza criarEntrega(String tipo){
        switch (tipo) {
            case "Normal":
                return new EntregaPizzaNormal();    // Retorna uma instância de EntregaPizzaNormal
            case "Expressa":
                return new EntregaPizzaExpress();   // Retorna uma instância de EntregaPizzaExpress
            case "Agendada":
                return new EntregaPizzaAgendada();  // Retorna uma instância de EntregaPizzaAgendada
            default:
                throw new IllegalArgumentException("Tipo de entrega não aceito: " + tipo);
        }
    }
}

public class ExemploDeFabrica {
    public static void main(String[] args) {
        EntregaPizza pedido01 = EntregaPizzaFabrica.criarEntrega("Normal");
        pedido01.entregarPizza("Avenida das Letras, 485 - Jacareí - SP");

        EntregaPizza pedido02 = EntregaPizzaFabrica.criarEntrega("Expressa");
        pedido02.entregarPizza("Avenida Vital Brasil, 1177 - Poá - SP");

        EntregaPizza pedido03 = EntregaPizzaFabrica.criarEntrega("Agendada");
        if (pedido03 instanceof EntregaPizzaAgendada) {
            EntregaPizzaAgendada agendada = (EntregaPizzaAgendada) pedido03;
            agendada.agendarEntrega("2025-05-01 21:00");
            agendada.entregarPizza("Avenida Cesare Mansueto Giulio Lattes, 1201 - São José dos Campos - SP");
        }
    }
}
