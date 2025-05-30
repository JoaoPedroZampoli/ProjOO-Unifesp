package Projeto;

import java.util.ArrayList;
import java.util.List;

public class Instituicao implements Participante{
    public String nome;
    public String sigla;
    private List<Individuo> membros;

    public Instituicao(String nome, String sigla){
        this.nome = nome;
        this.sigla = sigla;
        this.membros = new ArrayList<>();
    }

    public void adicionarMembro(Individuo membro){
        if (membro != null){
            membros.add(membro);
        } else {
            System.out.println("Membro inválido.");
        }
    }

    public List<Individuo> getMembros() {
        return membros;
    }

    @Override
    public int getAssento(){
        System.out.println("Instituição não possui assento individual.");
        return -1;
    }

    @Override
    public void exibirInformacoes(){
        System.out.println("Instituição: " + this.nome);
        System.out.println("Sigla: " + this.sigla);
        System.out.println("Membros:");
        for (Individuo membro : membros) {
            membro.exibirInformacoes();
        }
    }

    @Override
    public int getTotalInscritos() {
        return membros.size(); // Retorna o total de membros inscritos na instituição
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }
}
