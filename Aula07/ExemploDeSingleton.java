class BancoDeDados {
    private static BancoDeDados instancia;

    private BancoDeDados() {
        // Construtor privado para evitar instâncias externas
        System.out.println("Conectando ao banco de dados...");
    }

    public static BancoDeDados getInstancia() {
        if(instancia == null) {                 // Verifica se a instância já foi criada
            instancia = new BancoDeDados();
        }
        return instancia;                       // Retorna a instância única do banco de dados
    }
    
}

public class ExemploDeSingleton {
    public static void main(String[] args) {
        BancoDeDados bd1 = BancoDeDados.getInstancia();
        BancoDeDados bd2 = BancoDeDados.getInstancia();

        System.out.println(bd1 == bd2); // true, pois ambas as variáveis referenciam a mesma instância
    }
}
