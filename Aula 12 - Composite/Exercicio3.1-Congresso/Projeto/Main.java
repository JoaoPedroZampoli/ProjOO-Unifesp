// Exercício 3.1 do Slide B de Padrões de Projeto da Disciplina de Projeto Orientado a Objetos
package Projeto;

public class Main{
    public static void main(String[] args) {
        Congresso congresso = new Congresso("SBSeg", 200);

        Individuo pessoa1 = new Individuo("João Victor", "Estudante");
        Individuo pessoa2 = new Individuo("Maria Clara", "Professora");
        Individuo pessoa3 = new Individuo("Pedro Henrique", "Palestrante");
        Individuo pessoa4 = new Individuo("Ana Beatriz", "Organizadora");
        Individuo pessoa5 = new Individuo("Lucas Silva", "Regular");
        Individuo pessoa6 = new Individuo("Fernanda Souza", "Regular");

        Instituicao instituicao1 = new Instituicao("Universidade Federal de São Paulo", "Unifesp");
        Instituicao instituicao2 = new Instituicao("Universidade de São Paulo", "USP");
        Instituicao instituicao3 = new Instituicao("Instituto Tecnológico de Aeronáutica", "ITA");

        Instituicao instituicao4 = new Instituicao("Empresa 1", "Empresa1");
        Instituicao instituicao5 = new Instituicao("Empresa 2", "Empresa2");

        instituicao1.adicionarMembro(pessoa1);
        instituicao1.adicionarMembro(pessoa2);
        instituicao2.adicionarMembro(pessoa3);
        instituicao3.adicionarMembro(pessoa4);
        instituicao4.adicionarMembro(pessoa5);
        instituicao5.adicionarMembro(pessoa6);

        congresso.inscreverIndividuo(pessoa1);
        congresso.inscreverIndividuo(pessoa2);
        congresso.inscreverIndividuo(pessoa3);
        congresso.inscreverIndividuo(pessoa4);
        congresso.inscreverIndividuo(pessoa5);
        congresso.inscreverIndividuo(pessoa6);
        congresso.adicionarInstituicao(instituicao1);
        congresso.adicionarInstituicao(instituicao2);
        congresso.adicionarInstituicao(instituicao3);
        congresso.adicionarInstituicao(instituicao4);
        congresso.adicionarInstituicao(instituicao5);
        
        congresso.exibirInformacoes();
        System.out.println("Total de inscritos: " + congresso.getTotalInscritos());
        System.out.println("Total de instituições: " + congresso.getTotalInstituicoes());
        System.out.println("Capacidade máxima do evento: " + congresso.getCapacidadeMaxima());
    }
}