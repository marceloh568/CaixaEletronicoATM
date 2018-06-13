/**
 * Classe que serve para manter o histórico de tudo que é feito no caixa
 *
 * @author Marcelo Henrique
 */
package manipulacoes;

import java.util.ArrayList;
import java.util.List;

public class HistoricoOperacoes {

    private List<Operacao> historicoOperacao = new ArrayList<>();

    /**
     * Método que retorna o histórico de operações realizadas no caixa
     * eletrônico (ATM)
     *
     * @return List<Operacao> - historicoOperacao
     */
    public List<Operacao> retornaHistoricoOperacao() {
        return historicoOperacao;
    }

    /**
     * Método que insere a operação no histórico de operações realizadas no
     * caixa eletrônico (ATM)
     *
     * @param operacao
     */
    public void inserirOperacaoNoHistorico(Operacao operacao) {
        this.historicoOperacao.add(operacao);
    }
}
