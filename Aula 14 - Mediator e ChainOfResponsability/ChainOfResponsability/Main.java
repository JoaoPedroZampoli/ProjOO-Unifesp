public class Main {
    public static void main(String[] args){
        Processador processadorLetraA = new ProcessadorLetraA();
        Processador processadorPontos = new ProcessadorPontos();
        Processador processadorEspacos = new ProcessadorEspacos();

        String texto = "Aula 14 - Mediator e Chain of Responsibility. Aula 14 - Mediator e Chain of Responsibility.";

        Object resultado = processadorLetraA.processarTexto(texto);
        System.out.println("Número de As: " + resultado);
        processadorLetraA.setProximo(processadorPontos);
        
        resultado = processadorLetraA.processarTexto(texto);
        System.out.println("Número de Pontos: " + resultado);

        processadorPontos.setProximo(processadorEspacos);

        resultado = processadorLetraA.processarTexto(texto);
        System.out.println("Número de Espaços: " + resultado);
    }    
}
