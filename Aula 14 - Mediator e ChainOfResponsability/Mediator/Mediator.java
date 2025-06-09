public interface Mediator {
    void enviarMensagem(String mensagem, Usuario usuario);
    void adicionarUsuario(Usuario usuario);
    void removerUsuario(Usuario usuario);
    String getNomeGrupo();
    String getDescricao();
}
