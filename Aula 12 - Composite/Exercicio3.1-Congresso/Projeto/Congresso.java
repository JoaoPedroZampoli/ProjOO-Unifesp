package Projeto;

import java.util.List;
import java.util.ArrayList;

public class Congresso {
    private String nome;
    private int capacidadeMaxima;
    private List<Instituicao> instituicoes;
    private List<Individuo> individuos;

    public Congresso(String nome, int capacidadeMaxima) {
        this.nome = nome;
        this.capacidadeMaxima = capacidadeMaxima;
        this.instituicoes = new ArrayList<>();
        this.individuos = new ArrayList<>();
    }

    public void adicionarInstituicao(Instituicao instituicao){
        instituicoes.add(instituicao);
    }

    public void inscreverIndividuo(Individuo membro){
        if (getTotalInscritos() < capacidadeMaxima){
            individuos.add(membro);
        }
        else{
            System.out.println("Capacidade máxima atingida. Não é possível adicionar mais membros.");
        }
    }

    public int getTotalInscritos(){
        int total = individuos.size();
        return total;
    }

    public int getTotalInstituicoes() {
        return instituicoes.size();
    }

    public void exibirInformacoes(){
        System.out.println("Congresso: " + nome);
        System.out.println("Capacidade Máxima: " + capacidadeMaxima);
        System.out.println("Instituições Participantes:");
        for (Instituicao instituicao : instituicoes) {
            System.out.println("- " + instituicao.getNome());
        }
        System.out.println("Total de Inscritos: " + getTotalInscritos());
        System.out.println("Membros Individuais:");
        for (Individuo individuo : individuos) {
            individuo.exibirInformacoes();
        }
    }

    public String getNome() {
        return nome;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }
}
