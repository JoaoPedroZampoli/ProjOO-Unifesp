package Projeto;

public class Individuo implements Participante {
    private String nome;
    private String categoria;
    private int assento;
    private static int proximoAssento = 1;

    public Individuo(String nome, String categoria){
        this.nome = nome;
        this.categoria = categoria;
        this.assento = proximoAssento++;
    }

    @Override
    public int getAssento(){
        return this.assento;
    }

    @Override
    public void exibirInformacoes(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Categoria: " + this.categoria);
        System.out.println("Assento: " + this.assento);
    }

    @Override
    public int getTotalInscritos(){
        System.out.println("Você está inscrito!  Só é possível verificar sua inscrição desta maneira.");
        return 1; // Cada indivíduo conta como um inscrito
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }
}
