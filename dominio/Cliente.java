/**
 *
 * Classe que modela o domínio do usuário final da aplicação
 *
 * @author Marcelo Henrique
 */
package dominio;

public class Cliente extends Usuario {

    private ContaPoupanca contaPoupanca = new ContaPoupanca();
    private ContaCorrente contaCorrente = new ContaCorrente();

    protected Cliente() {
        setPerfil("basico");
    }

    /**
     * Método que constrói o cliente
     *
     * @param login
     * @param senha
     * @param numContaCorrente
     * @param numContaPoupanca
     * @param saldoContaCorrente
     * @param saldoContaPoupanca
     */
    public Cliente(String login, String senha, String numContaCorrente, String numContaPoupanca, float saldoContaCorrente, float saldoContaPoupanca) {
        setPerfil("basico");
        setLogin(login);
        setSenha(senha);
        getContaCorrente().setConta(numContaCorrente);
        getContaPoupanca().setConta(numContaPoupanca);
        getContaCorrente().setSaldo(saldoContaCorrente);
        getContaPoupanca().setSaldo(saldoContaPoupanca);
    }

    /**
     * Método que retorna a conta poupança do Cliente
     *
     * @return Conta - contaPoupanca
     */
    public Conta getContaPoupanca() {
        return contaPoupanca;
    }

    /**
     * Método que retorna a conta corrente do Cliente
     *
     * @return Conta - contaCorrente
     */
    public Conta getContaCorrente() {
        return contaCorrente;
    }
}
