public class ProcessadorPontos implements Processador{
    private Processador proximo;

    @Override
    public Object processarTexto(String texto){
        if (texto == null){
            return null;
        }
        int Pontos = contarPontos(texto);

        if(proximo != null) {
            return proximo.processarTexto(texto);
        }
        
        return Pontos;
    }

    private int contarPontos(String texto) {
        int Pontos = 0;
        for (int i = 0; i < texto.length(); i++) {
            if(texto.charAt(i) == '.'){
                Pontos++;
            }
        }
        return Pontos;
    }

    @Override
    public void setProximo(Processador proximo) {
        this.proximo = proximo;
    }
}
