import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class ServicoRota {
    private List<TrechoDeVoo> voosDisponiveis;

    public ServicoRota(List<TrechoDeVoo> voosDisponiveis) {
        this.voosDisponiveis = voosDisponiveis;
    }

    private List<TrechoDeVoo> getVoosSaindoDe(String cidadeOrigem){
        return voosDisponiveis.stream()
                .filter(voo -> voo.getOrigem().equalsIgnoreCase(cidadeOrigem))
                .toList();
    }

    public List<MalhaAerea> encontrarTodasRotas(String origem, String destino){
        List<MalhaAerea> todasRotas = new ArrayList<>();
        List<TrechoDeVoo> rotaAtual = new ArrayList<>();
        Set<String> visitados = new HashSet<>();
        
        dfs(origem, destino, rotaAtual, visitados, todasRotas);
        return todasRotas;
    }

    private void dfs(String origemAtual, String destinoFinal, List<TrechoDeVoo> rotaAtual, Set<String> visitados, List<MalhaAerea> todasRotas){
        if(origemAtual.equalsIgnoreCase(destinoFinal)){
            if(!rotaAtual.isEmpty()){
                MalhaAerea rotaCompleta = new MalhaAerea();
                for(TrechoDeVoo trecho : rotaAtual) {
                    rotaCompleta.adicionarElemento(trecho);
                }
                todasRotas.add(rotaCompleta);
            }
            return;
        }
        
        visitados.add(origemAtual);
        
        List<TrechoDeVoo> voosSaindo = getVoosSaindoDe(origemAtual);
        
        for(TrechoDeVoo voo : voosSaindo) {
            String proximaCidade = voo.getDestino();
            
            if(!visitados.contains(proximaCidade)) {
                rotaAtual.add(voo);
                
                dfs(proximaCidade, destinoFinal, rotaAtual, visitados, todasRotas);
                
                rotaAtual.remove(rotaAtual.size() - 1);
            }
        }
        
        visitados.remove(origemAtual);
    }

    public MalhaAerea encontrarRotaMaisBarata(String origem, String destino) {
        List<MalhaAerea> rotas = encontrarTodasRotas(origem, destino);
        if (rotas.isEmpty()) {
            return null;
        }
        return rotas.stream()
                .min((r1, r2) -> Double.compare(r1.getPrecoFinal(), r2.getPrecoFinal()))
                .orElse(null);
    }
}