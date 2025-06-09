public class Main {
    public static void main(String[] args){
        ChatGrupo Grupo = new ChatGrupo("Um Grupo Qualquer", "Grupo de Teste para o Mediator");
        System.out.println("Grupo criado: " + Grupo.getNomeGrupo());
        System.out.println("Descrição: " + Grupo.getDescricao());
        
        ConcreteUsuario joao = new ConcreteUsuario("João", Grupo);

        ConcreteUsuario.definirUsuarioAtivo(joao); // Definindo o usuário ativo para simular comportamento de um usuário que envia mensagens
        
        Usuario daniela = new ConcreteUsuario("Daniela", Grupo);
        Usuario patricia = new ConcreteUsuario("Patrícia", Grupo);
        Usuario helena = new ConcreteUsuario("Helena", Grupo);
        Usuario enzo = new ConcreteUsuario("Enzo", Grupo);

        Grupo.adicionarUsuario(joao);
        Grupo.adicionarUsuario(daniela);
        Grupo.adicionarUsuario(patricia);
        Grupo.adicionarUsuario(helena);
        Grupo.adicionarUsuario(enzo);

        enzo.enviarMensagem("Mensagem de Teste");
        joao.enviarMensagem("Olá a todos!");
        helena.enviarMensagem("Oi pessoal!  Tudo bem?");
        patricia.enviarMensagem("Se chegou até aqui é porque deu certo!");

        Grupo.removerUsuario(daniela);

        helena.enviarMensagem("O teste da Daniela deu certo.");
    }
}
