public class ProcessadorEspacos implements Processador{
    private Processador proximo;

    @Override
    public Object processarTexto(String texto){
        if (texto == null){
            return null;
        }
        int espacos = contarEspacos(texto);

        if(proximo != null) {
            return proximo.processarTexto(texto);
        }
        
        return espacos;
    }

    private int contarEspacos(String texto) {
        int espacos = 0;
        for (int i = 0; i < texto.length(); i++) {
            if(texto.charAt(i) == ' '){
                espacos++;
            }
        }
        return espacos;
    }

    @Override
    public void setProximo(Processador proximo) {
        this.proximo = proximo;
    }
}
