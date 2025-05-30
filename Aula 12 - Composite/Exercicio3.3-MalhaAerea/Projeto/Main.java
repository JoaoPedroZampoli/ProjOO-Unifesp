// Exercício 3.3 de Padrões de Projeto proposto em Sala durante a Disciplina de Projeto Orientado a Objetos

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TrechoDeVoo trecho1 = new TrechoDeVoo("São Paulo", "Rio de Janeiro", 350.0);
        TrechoDeVoo trecho2 = new TrechoDeVoo("Rio de Janeiro", "Belo Horizonte", 200.0);
        TrechoDeVoo trecho3 = new TrechoDeVoo("Belo Horizonte", "Brasília", 300.0);
        TrechoDeVoo trecho4 = new TrechoDeVoo("Brasília", "São Paulo", 400.0);
        TrechoDeVoo trecho5 = new TrechoDeVoo("São Paulo", "Curitiba", 250.0);
        TrechoDeVoo trecho6 = new TrechoDeVoo("Curitiba", "Florianópolis", 150.0);
        TrechoDeVoo trecho7 = new TrechoDeVoo("Florianópolis", "Porto Alegre", 200.0);
        TrechoDeVoo trecho8 = new TrechoDeVoo("Brasília", "Salvador", 300.0);
        TrechoDeVoo trecho9 = new TrechoDeVoo("Rio de Janeiro", "Salvador", 450.0);
        TrechoDeVoo trecho10 = new TrechoDeVoo("São Paulo", "Brasília", 300.0);

        MalhaAerea malhaAerea = new MalhaAerea();
        System.out.println("Trechos de voo individuais:");
        trecho1.exibirDetalhes();
        trecho2.exibirDetalhes();
        trecho3.exibirDetalhes();

        malhaAerea.adicionarElemento(trecho1);
        malhaAerea.adicionarElemento(trecho2);
        malhaAerea.adicionarElemento(trecho3);
        malhaAerea.adicionarElemento(trecho4);
        malhaAerea.adicionarElemento(trecho5);

        System.out.println("\nMalha Aérea após adicionar trechos:");
        malhaAerea.getTrechosDeVoo();
        System.out.println("Total de trechos: " + malhaAerea.getNumeroTrechos());

        List<TrechoDeVoo> todosVoos = new ArrayList<>();
        todosVoos.add(trecho1);
        todosVoos.add(trecho2);
        todosVoos.add(trecho3);
        todosVoos.add(trecho4);
        todosVoos.add(trecho5);
        todosVoos.add(trecho6);
        todosVoos.add(trecho7);
        todosVoos.add(trecho8);
        todosVoos.add(trecho9);
        todosVoos.add(trecho10);

        ServicoRota servicoRotas = new ServicoRota(todosVoos);

        List<MalhaAerea> rotasParaSalvador = servicoRotas.encontrarTodasRotas("São Paulo", "Salvador");
        System.out.println("\nRotas encontradas de São Paulo a Salvador:");
        System.out.println("Total de rotas encontradas: " + rotasParaSalvador.size());

        for (int i = 0; i < rotasParaSalvador.size(); i++) {
            System.out.println("\n--- ROTA " + (i + 1) + " ---");
            rotasParaSalvador.get(i).exibirDetalhes();
            System.out.printf("Preço: R$ %.2f%n", rotasParaSalvador.get(i).getPrecoFinal());
            System.out.println("Número de escalas: " + (rotasParaSalvador.get(i).getNumeroTrechos() - 1));
        }

        MalhaAerea rotaMaisBarata = servicoRotas.encontrarRotaMaisBarata("São Paulo", "Salvador");
        System.out.println("\nRota mais barata de São Paulo a Salvador:");
        if (rotaMaisBarata != null) {
            rotaMaisBarata.exibirDetalhes();
            System.out.printf("Preço: R$ %.2f%n", rotaMaisBarata.getPrecoFinal());
            System.out.println("Número de escalas: " + (rotaMaisBarata.getNumeroTrechos() - 1));
        } else {
            System.out.println("Nenhuma rota encontrada.");
        }
    }
}
