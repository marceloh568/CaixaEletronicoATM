/**
 * Classe com funções rotineiras utilizadas no decorrer do fluxo da aplicação
 * 
 * @author Marcelo Henrique
 */
package util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utilitario {

    static final String COR_MENSSAGEM = "\u001B[";

    /**
     * Método que altera a cor da fonte do console para vermelho,
     * visando ser utilizado associado à uma mensagem de erro
     */
    public final static void prepararCorErro() {
        System.out.print(COR_MENSSAGEM + "31" + "m");
    }

    /**
     * Método que altera a cor da fonte do console para verde,
     * visando ser utilizado associado à uma mensagem de sucesso
     */
    public final static void prepararCorSucesso() {
        System.out.print(COR_MENSSAGEM + "32" + "m");
    }

    /**
     * Método que altera a cor da fonte para preto (estado normal),
     * visando ser utilizado após ter sido exibida alguma mensagem
     * de erro ou sucesso (e consequentemente, cor de fonte tiver sido alterada)
     */
    public final static void prepararCorNormal() {
        System.out.print(COR_MENSSAGEM + "39" + "m");
    }

    /**
     * Método que limpa o console da aplicaçao para que a tela comporte os menus
     * de forma clara. O sistema identificará qual sistema está em execução na máquina
     * e a depender dela serão executados comandos específicos (ou para o CMD - Windows
     * ou para o terminal shell - Linux). Caso a aplicação esteja rodando via IDE,
     * o método entrará em seu fluxo de exceção e serão executadas várias quebras de linhas
     * sucessivas dando a mesma impressão de console limpo.
     */
    public final static void limparConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) { //CASO SEJA CONSOLE DE IDE, OCORRE A EXCEÇÃO

            for (int clear = 0; clear < 1000; clear++) {
                System.out.println("\n");
            }
        }
    }

    /**
     * Método utilizado para formatar valor com a máscara do dinheiro utilizado no Brasil
     * @param valor
     * @return String - formatoDois.format(valor)
     */
    public final static String formatarDinheiro(Float valor) {

        DecimalFormat formatoDois = new DecimalFormat("##,###,###,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
        formatoDois.setMinimumFractionDigits(2);
        formatoDois.setParseBigDecimal(true);

        return formatoDois.format(valor);
    }

    /**
     * Método que formata uma data com a máscara do padrão utilizado no Brasil
     * @param data
     * @return String - dataPadraoBrasileiro
     */
    public final static String formatarDataParaPadraoBrasileiro(Date data) {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dataPadraoBrasileiro = fmt.format(data);
        return dataPadraoBrasileiro;
    }
    
}
