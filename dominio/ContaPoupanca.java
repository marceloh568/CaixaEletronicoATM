/**
 * Classe que modela o domínio de uma conta poupança
 *
 * @author Marcelo Henrique
 */
package dominio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContaPoupanca extends Conta {

    private Date dataDeCriacao;

    /**
     * Método de utilização em sistemas de terceiros: (por isso da visibilidade
     * pública) Serve para aplicar juros na poupança de acordo com um
     * determinado percentual
     *
     * @param percentualDoJuros
     */
    public void aplicarJuros(float percentualDoJuros) {
        float juros = getSaldo() * percentualDoJuros;
        setSaldo(getSaldo() - juros);
    }

    /**
     * Método de utilização em sistemas de terceiros: (por isso da visibilidade
     * pública) Serve para retornar o dia do mês em que a conta poupança faz
     * aniversário
     *
     * @return int - diaDoAniversario
     * @throws ParseException
     */
    public int retornaDiaDoAniversarioDaConta() throws ParseException {

        String dataAniversario = String.valueOf(this.dataDeCriacao);
        SimpleDateFormat resgatarDia = new SimpleDateFormat("dd");

        Date diaDeAniversarioAux = resgatarDia.parse(dataAniversario);
        int diaDoAniversario = Integer.parseInt(String.valueOf(diaDeAniversarioAux));

        return diaDoAniversario;
    }

    /**
     * Sobreescrita de método para representar o objeto em texto quando a conta
     * poupança for instanciada
     *
     * @return String - "Conta Poupança"
     */
    @Override
    public String toString() {
        return "Conta Poupança";
    }

}
