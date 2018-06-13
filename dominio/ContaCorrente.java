/**
 *
 * Classe que modela o domínio de uma conta corrente
 *
 * @author Marcelo Henrique
 */
package dominio;

public class ContaCorrente extends Conta {

    ContaCorrente() {

    }

    /**
     * Sobreescrita de método para representar o objeto em texto quando a conta
     * corrente for instanciada
     *
     * @return String - "Conta Corrente"
     */
    @Override
    public String toString() {
        return "Conta Corrente";
    }

}
