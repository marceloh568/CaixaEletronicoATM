/**
 * Interface utilizada para fazer contrato com relatórios
 *
 * @author Marcelo Henrique
 */
package relatorios;

import manipulacoes.HistoricoOperacoes;

public interface IRelatorio {

    /**
     * Método utilizado para prover contrato com as classes que implementarem
     * esta interface, obrigando-as a implementarem o método que plota o
     * relatório na tela da aplicação
     *
     * @param historicoOperacoes
     */
    public void plotarRelatorio(HistoricoOperacoes historicoOperacoes);

}
