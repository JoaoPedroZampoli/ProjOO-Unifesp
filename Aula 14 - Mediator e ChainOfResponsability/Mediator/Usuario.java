public abstract class Usuario {
    protected String nome;
    protected Mediator ChatGrupo;

    public Usuario(String nome, Mediator ChatGrupo){
        this.nome = nome;
        this.ChatGrupo = ChatGrupo;
    }

    public abstract void enviarMensagem(String mensagem);
    public abstract void receberMensagem(String mensagem, Usuario usuario);
    public abstract void receberNotificacao(String notificacao);

    public String getNome() {
        return nome;
    }
}
