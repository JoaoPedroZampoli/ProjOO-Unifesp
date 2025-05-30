// Exercício 3.2 do Slide B de Padrões de Projeto da Disciplina de Projeto Orientado a Objetos
public class Main {
    public static void main(String[] args){
        Artigo artigo1 = new Artigo("Título do Artigo 1", new String[]{"Autor 1"});
        Artigo artigo2 = new Artigo("Título do Artigo 2", new String[]{"Autor 2", "Autor 3"});
        Artigo artigo3 = new Artigo("Título do Artigo 3", new String[]{"Autor 3", "Autor 4"});
        Artigo artigo4 = new Artigo("Título do Artigo 4", new String[]{"Autor 5"});
        Artigo artigo5 = new Artigo("Título do Artigo 5", new String[]{"Autor 6", "Autor 7"});

        Colecao jornal = new Colecao("Jornal de Tecnologia");
        Colecao caderno = new Colecao("Caderno de Pesquisa");
        Colecao revista = new Colecao("Revista Científica");

        revista.adicionarPublicacao(artigo1);
        jornal.adicionarPublicacao(artigo2);
        caderno.adicionarPublicacao(artigo3);
        revista.adicionarPublicacao(artigo4);
        caderno.adicionarPublicacao(artigo5);
        caderno.adicionarPublicacao(revista);

        System.out.println(jornal);
        System.out.println(caderno);
        System.out.println(revista);

        System.out.println("Total de publicações no jornal: " + jornal.contarTotalPublicacoes());
        System.out.println("Total de publicações no caderno: " + caderno.contarTotalPublicacoes());
        System.out.println("Total de publicações na revista: " + revista.contarTotalPublicacoes());

        revista.removerPublicacao(artigo4);

        System.out.println("Após remover o artigo 4 da revista:\n");
        System.out.println(revista);

        System.out.println("Artigos na revista: " + revista.contarArtigos());
        System.out.println("Artigos no caderno: " + caderno.contarArtigos());
        System.out.println("Artigos no jornal: " + jornal.contarArtigos());
    }
}
