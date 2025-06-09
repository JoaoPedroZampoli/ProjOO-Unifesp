public class ProcessadorLetraA implements Processador{
    private Processador proximo;

    @Override
    public Object processarTexto(String texto){
        if (texto == null){
            return null;
        }
        int letrasA = contarLetraA(texto);

        if(proximo != null) {
            return proximo.processarTexto(texto);
        }
        
        return letrasA;
    }

    private int contarLetraA(String texto) {
        int letrasA = 0;
        for (int i = 0; i < texto.length(); i++) {
            if(texto.charAt(i) == 'A' || texto.charAt(i) == 'a'){
                letrasA++;
            }
        }
        return letrasA;
    }

    @Override
    public void setProximo(Processador proximo) {
        this.proximo = proximo;
    }
}
