/**
 * Classe responsável pelos relatórios das contas correntes
 *
 * @author Marcelo Henrique
 */
package relatorios;

import manipulacoes.Operacao;
import manipulacoes.HistoricoOperacoes;

public class RelatorioDasContasCorrentes extends RelatorioModelo implements IRelatorio {

    /**
     * Implementação de método da interface IRelatorio que visa a plotagem do
     * relatório das contas correntes em tela
     *
     * @param historicoOperacao
     */
    @Override
    public void plotarRelatorio(HistoricoOperacoes historicoOperacao) {

        for (Operacao operacao : historicoOperacao.retornaHistoricoOperacao()) {
            if (operacao.getTipoConta() == Operacao.TipoDeConta.CORRENTE) {
                cabecalhoOperacoesRealizadas = cabecalhoOperacoesRealizadas + operacao.toString() + "\n\n";
                switch (operacao.getTipoOperacao()) {
                    case SAQUE:
                        totalSaqueCaixa += operacao.getValor();
                        numeroDeSaques++;
                        if (maiorValorSaque == NAO_HOUVE_OPERACAO
                                || maiorValorSaque < operacao.getValor()) {
                            maiorValorSaque = operacao.getValor();
                        }
                        if (menorValorSaque == NAO_HOUVE_OPERACAO
                                || menorValorSaque > operacao.getValor()) {
                            menorValorSaque = operacao.getValor();
                        }
                        break;
                    case DEPOSITO:
                        totalDepositoCaixa += operacao.getValor();
                        numeroDeDepositos++;
                        if (maiorValorDeposito == NAO_HOUVE_OPERACAO
                                || maiorValorDeposito < operacao.getValor()) {
                            maiorValorDeposito = operacao.getValor();
                        }
                        if (menorValorDeposito == NAO_HOUVE_OPERACAO
                                || menorValorDeposito > operacao.getValor()) {
                            menorValorDeposito = operacao.getValor();
                        }
                        break;

                }
            }
        }
        calcularMediasSaqueDeposito();
        exibirConsulta();
    }

}
