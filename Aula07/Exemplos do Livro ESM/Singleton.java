class Logger {
    private Logger() {
    } // proíbe clientes de chamar new Logger()

    private static Logger instance; // instância única da classe

    public static Logger getInstance() {
        if (instance == null) // primeira vez que chama-se getInstance
            instance = new Logger();
        return instance;
    }

    public void println(String msg) {
        System.out.println(msg); // registra msg na console; mas poderia ser em arquivo também
    }

}

public class Singleton {
    void f() {
        Logger log = Logger.getInstance();
        System.out.print("Log ID" + log.hashCode());
        log.println(" Executando f");
    }

    void g() {
        Logger log = Logger.getInstance();
        System.out.print("Log ID" + log.hashCode());
        log.println(" Executando g");

    }

    void h() {
        Logger log = Logger.getInstance();
        System.out.print("Log ID" + log.hashCode());
        log.println(" Executando h");
    }

    public static void main(String[] args) {
        Singleton m = new Singleton();
        System.out.println("Veja que todos as msg de log serão enviadas o singleton (hashcode são iguais)");
        m.f();
        m.g();
        m.h();
    }

}