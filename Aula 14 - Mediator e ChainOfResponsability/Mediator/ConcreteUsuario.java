public class ConcreteUsuario extends Usuario{
    private static ConcreteUsuario usuarioAtivo;

    public ConcreteUsuario(String nome, Mediator chatGrupo) {
        super(nome, chatGrupo);
    }

    public static void definirUsuarioAtivo(ConcreteUsuario usuario){
        usuarioAtivo = usuario;
    }

    @Override
    public void enviarMensagem(String mensagem){
        ChatGrupo.enviarMensagem(mensagem, this);
    }

    @Override
    public void receberMensagem(String mensagem, Usuario usuario){
        if (this == usuarioAtivo){
            System.out.println("[" + ChatGrupo.getNomeGrupo() + "] " + usuario.getNome() + ": " + mensagem);
        }    
    }

    @Override
    public void receberNotificacao(String notificacao) {
        if (this == usuarioAtivo){
            System.out.println("Notificação: " + notificacao);
        }
    }
}
