/**
 *
 * Classe que serve de modelo para as possíveis contas existentes na aplicação
 *
 * @author Marcelo Henrique
 */
package dominio;

public abstract class Conta {

    private String conta;
    private float saldo;

    protected String getConta() {
        return conta;
    }

    protected void setConta(String conta) {
        this.conta = conta;
    }

    /**
     * Método que retorna o saldo da conta
     *
     * @return float - saldo
     */
    public float getSaldo() {
        return saldo;
    }

    protected void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    protected boolean verificarSaldo(float saque) {
        return saldo >= saque;
    }

    /**
     * Médoto utilizado na reazalição de depósito na conta
     *
     * @param deposito
     */
    public void realizarDeposito(float deposito) {
        if (deposito > 0) {
            saldo = saldo + deposito;
        }
    }

    /**
     * Método utilizado na realização de saque na conta
     *
     * @param sacar
     * @return boolean
     */
    public boolean realizarSaque(float sacar) {
        if (verificarSaldo(sacar)) {
            saldo = saldo - sacar;
            return true;
        }
        return false;
    }

}
