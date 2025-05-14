interface OperacaoBancaria {
    void executarOperacao();
}

class OperacaoBancariaReal implements OperacaoBancaria {
    public void executarOperacao() {
        System.out.println("Executando operação bancária real...");
        System.out.println("Operação concluída com sucesso!");
    }
}

class OperacaoBancariaProxy implements OperacaoBancaria {
    private OperacaoBancariaReal operacaoReal;
    private String usuarioAutenticado;

    public OperacaoBancariaProxy(String usuario) {
        this.usuarioAutenticado = usuario;              // Armazenando o usuário autenticado
        this.operacaoReal = new OperacaoBancariaReal(); // Criando a operação real
    }

    public void executarOperacao() {
        if("admin".equalsIgnoreCase(usuarioAutenticado)) {
            operacaoReal.executarOperacao();
        }
        else {
            System.out.println("Acesso negado!");
        }
    }
}

public class ExemploDeProxy {
    public static void main(String[] args) {
        OperacaoBancaria operacao = new OperacaoBancariaProxy("admin");
        operacao.executarOperacao(); // Acesso permitido, operação executada

        operacao = new OperacaoBancariaProxy("usuario");
        operacao.executarOperacao(); // Acesso negado
    }
}
