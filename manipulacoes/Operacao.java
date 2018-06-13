/**
 * Classe que refente as operações presentes no sistema
 *
 * @author Marcelo Henrique
 */
package manipulacoes;

import java.util.Date;
import util.Utilitario;

public class Operacao {

    private float valor;
    private TipoDeOperacao operacao;
    private TipoDeConta tipoConta;
    private Date dataDaOperacao;
    private String margemDeEspaco = "      ";

    /**
     * Método que constrói a operaçao
     *
     * @param valor
     * @param operacao
     * @param data
     * @param tipoConta
     */
    public Operacao(float valor, TipoDeOperacao operacao, Date data, TipoDeConta tipoConta) {
        this.valor = valor;
        this.operacao = operacao;
        this.dataDaOperacao = data;
        this.tipoConta = tipoConta;
    }

    /**
     * Especificação dos possíveis tipos de operações a serem realizadas no
     * sistema
     */
    public enum TipoDeOperacao {

        SAQUE {
            @Override
            public String toString() {
                return "Saque";
            }

        },
        DEPOSITO {
            @Override
            public String toString() {
                return "Depósito";
            }

        };
    }

    /**
     * Especificação dos possíveis tipos de contas cujas quais possam ser
     * realizadas operações no sistema
     */
    public enum TipoDeConta {
        CORRENTE,
        POUPANCA
    }

    /**
     * Método que retorna o tipo de operação efetuada
     *
     * @return TipoDeOperacao - operacao
     */
    public TipoDeOperacao getTipoOperacao() {
        return this.operacao;
    }

    /**
     * Método que retorna o tipo de conta atrelada a operação realizada
     *
     * @return TipoDeConta - tipoConta
     */
    public TipoDeConta getTipoConta() {
        return tipoConta;
    }

    /**
     * Método que retorna o valor da operação efetuada
     *
     * @return float - valor
     */
    public float getValor() {
        return this.valor;
    }

    /**
     * Sobreescrita de método para representar o objeto em texto quando a
     * operacao for instanciada
     *
     * @return
     */
    @Override
    public String toString() {
        configurarMargemDeEspacoParaSaque();
        return operacao.toString() + margemDeEspaco
                + Utilitario.formatarDinheiro(this.valor)
                + "             "
                + Utilitario.formatarDataParaPadraoBrasileiro(this.dataDaOperacao);
    }

    private void configurarMargemDeEspacoParaSaque() {
        if (this.operacao == Operacao.TipoDeOperacao.SAQUE) {
            margemDeEspaco = "         ";
        }
    }

}
