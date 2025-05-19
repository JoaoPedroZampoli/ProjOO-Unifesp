package Aula11;

public class TransportFactory {
    public TransportMode create(String type){
        if (type == null){
            System.out.println("Tipo de transporte inválido - não pode ser nulo.");
            return null;
        }

        switch (type.toLowerCase()) {
            case "bike":
            case "bicicleta":
                return new Bike();
                
            case "car":
            case "carro":
                return new Car();

            // A partir daqui são possíveis casos futuros (em caso de ampliação do sistema)
                
            // case "bus":
            // case "onibus":
            // case "ônibus":
            //     return new Bus();
                
            // case "subway":
            // case "metro":
            // case "metrô":
            //     return new Subway();
                
            // case "caminhar":
            // case "andando":
            // case "a pé":
            //     return new Walk();
                
            default:
                throw new IllegalArgumentException("Tipo de transporte não reconhecido: " + type);
        }
    }
}
