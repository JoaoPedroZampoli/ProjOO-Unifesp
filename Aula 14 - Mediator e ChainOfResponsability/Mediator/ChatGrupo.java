import java.util.ArrayList;
import java.util.List;

public class ChatGrupo implements Mediator {
    private List<Usuario> usuarios;
    private String nomeGrupo;
    private String descricao;

    public ChatGrupo(String nomeGrupo, String descricao) {
        this.nomeGrupo = nomeGrupo;
        this.descricao = descricao;
        this.usuarios = new ArrayList<>();
    }

    @Override
    public void enviarMensagem(String mensagem, Usuario usuario){
        // System.out.println("\n[" + nomeGrupo + "] " + usuario.getNome() + ": " + mensagem);
        for (Usuario user : usuarios){
            user.receberMensagem(mensagem, usuario);
        }
    }
    
    @Override
    public void adicionarUsuario(Usuario usuario){
        usuarios.add(usuario);
        // System.out.println(usuario.getNome() + " entrou no grupo " + nomeGrupo);

        for (Usuario user : usuarios){
            user.receberNotificacao(usuario.getNome() + " entrou no grupo " + nomeGrupo);
        }
    }

    @Override
    public void removerUsuario(Usuario usuario){
        usuarios.remove(usuario);
        // System.out.println(usuario.getNome() + " saiu do grupo " + nomeGrupo);

        for (Usuario user : usuarios){
            user.receberNotificacao(usuario.getNome() + " saiu do grupo " + nomeGrupo);
        }
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public String getDescricao() {
        return descricao;
    }
}
