/**
 * Classe que serve de base para reaproveitamento de código nas classes relativas aos relatórios
 *
 * @author Marcelo Henrique
 */
package relatorios;

public abstract class RelatorioModelo {

    protected final static String LINHA_TABULACAO = "............................................................................................\n";
    protected final static int NAO_HOUVE_OPERACAO = 0;
    protected float mediaSaque = 0, mediaDeposito = 0;
    protected int totalSaqueCaixa = 0, totalDepositoCaixa = 0;
    protected int numeroDeSaques = 0, numeroDeDepositos;

    protected String descritivoCaixaEletronico = "";
    protected String cabecalhoOperacoesRealizadas = LINHA_TABULACAO + "Operacão       Valor             Data     -    Hora\n" + LINHA_TABULACAO;
    protected float maiorValorDeposito = 0, menorValorDeposito = 0;
    protected float maiorValorSaque = 0, menorValorSaque = 0;

    protected String gerarHistoricoDoCaixa() {
        return LINHA_TABULACAO
                + "Total Depositado No Caixa: R$ " + totalDepositoCaixa + "   |   Total Sacado Do Caixa: R$ " + totalSaqueCaixa + "\n"
                + LINHA_TABULACAO
                + "Maior Depósito Realizado: R$ " + maiorValorDeposito + "  |  Menor Depósito Realizado: R$ " + menorValorDeposito + "\n"
                + LINHA_TABULACAO
                + "Maior Saque Realizado: R$ " + maiorValorSaque + "     |  Menor Saque Realizado: R$ " + menorValorSaque + "\n"
                + LINHA_TABULACAO
                + "Media dos Depósitos: R$ " + mediaDeposito + "\nMédia dos Saques: R$ " + mediaSaque + "\n"
                + LINHA_TABULACAO + "\n";
    }

    protected void calcularMediasSaqueDeposito() {

        if (totalSaqueCaixa != NAO_HOUVE_OPERACAO) {
            mediaSaque = (totalSaqueCaixa / numeroDeSaques);
        }
        if (totalDepositoCaixa != NAO_HOUVE_OPERACAO) {
            mediaDeposito = (totalDepositoCaixa / numeroDeDepositos);
        }

    }

    protected void exibirConsulta() {
        descritivoCaixaEletronico = (descritivoCaixaEletronico + gerarHistoricoDoCaixa());
        System.out.println(descritivoCaixaEletronico + cabecalhoOperacoesRealizadas);
    }

}
