import java.util.List;
import java.util.ArrayList;

public class MalhaAerea implements ElementoDaRota {
    private List<ElementoDaRota> elementos;

    public MalhaAerea() {
        this.elementos = new ArrayList<>();
    }

    public void adicionarElemento(ElementoDaRota elemento) {
        if(elemento != null){
            elementos.add(elemento);
        }
    }

    public void removerElemento(ElementoDaRota elemento){
        if (elemento != null && elementos.contains(elemento)) {
            elementos.remove(elemento);
        } else {
            System.out.println("Elemento não encontrado na malha aérea.");
        }
    }

    @Override
    public String getOrigem() {
        if (elementos.isEmpty()) {
            return null;
        }
        return elementos.get(0).getOrigem();
    }

    @Override
    public String getDestinoFinal() {
        if (elementos.isEmpty()) {
            return null;
        }
        return elementos.get(elementos.size() - 1).getDestinoFinal();
    }

    @Override
    public double getPrecoFinal() {
        double total = 0.0;
        for (ElementoDaRota elemento : elementos) {
            total += elemento.getPrecoFinal();
        }
        return total;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Malha Aérea:");
        for (ElementoDaRota elemento : elementos) {
            elemento.exibirDetalhes();
        }
    }

    @Override
    public List<TrechoDeVoo> getTrechosDeVoo() {
        List<TrechoDeVoo> trechos = new ArrayList<>();
        for (ElementoDaRota elemento : elementos) {
            trechos.addAll(elemento.getTrechosDeVoo());
        }
        return trechos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Malha Aérea:\n");
        for (ElementoDaRota elemento : elementos) {
            sb.append(elemento.toString()).append("\n");
        }
        return sb.toString();
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    public int getNumeroTrechos() {
        return getTrechosDeVoo().size();
    }
}
