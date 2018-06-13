/**
 *  Classe responsável de interação com o usuário
 *
 * @author Marcelo Henrique
 */
package view;

import dominio.Usuario;
import dominio.ContaCorrente;
import dominio.Cliente;
import dominio.Conta;
import DAO.BaseDeDados;
import relatorios.RelatorioDasContasPoupancas;
import relatorios.IRelatorio;
import relatorios.RelatorioDasContasCorrentes;
import java.util.Date;
import java.util.Scanner;
import manipulacoes.Operacao;
import manipulacoes.HistoricoOperacoes;
import util.Utilitario;

public class TerminalATM {

    static Usuario usuarioSessao;
    static BaseDeDados baseDeDadosEstatica;
    static HistoricoOperacoes gerenciadorOperacoes = new HistoricoOperacoes();

    private static void menuPrincipal() {
        Scanner entradaMenuPrincipal = new Scanner(System.in);

        String alternativa = "0";
        while (!alternativa.equals("2")) {
            System.out.println("Escolha uma das alternativas: \n 1 - Logar no sistema \n 2 - Sair do sistema");
            alternativa = entradaMenuPrincipal.nextLine();
            Utilitario.limparConsole();

            if (alternativa == null) {
                alternativa = "2";
            }

            switch (alternativa) {
                case "1":
                    System.out.println("DIGITE SEU LOGIN: ");
                    String login = entradaMenuPrincipal.nextLine();

                    System.out.println("DIGITE SUA SENHA: ");
                    String senha = entradaMenuPrincipal.nextLine();
                    Utilitario.limparConsole();

                    usuarioSessao = baseDeDadosEstatica.autenticarUsuario(login, senha);

                    if (usuarioSessao != null) {
                        switch (usuarioSessao.getPerfil()) {
                            case "basico":
                                menuEscolhaDeTipoDeConta();
                                break;
                            case "administrativo":
                                menuAdministrativo();
                                break;
                        }
                    } else {
                        Utilitario.prepararCorErro();
                        System.out.println("ERRO! Credenciais inválidas, tente novamente!");
                        Utilitario.prepararCorNormal();
                    }

                    break;
                case "2":
                    System.out.println("ENCERRANDO CAIXA ELETRÔNICO...");
                    break;
                default:
                    Utilitario.prepararCorErro();
                    System.out.println("Escolha uma alternativa válida dentre as permitidas");
                    Utilitario.prepararCorNormal();
            }
        }
    }

    private static void menuEscolhaDeTipoDeConta() {
        Scanner entradaMenuEscolhaDeTipoDeConta = new Scanner(System.in);
        String alternativaDeTipoDeConta = "0";
        while (!alternativaDeTipoDeConta.equals("3")) {
            System.out.println("Escolha uma das opções: \n 1 - Acessar Conta Corrente \n 2 - Acessar Conta Poupança \n 3 - Deslogar");
            alternativaDeTipoDeConta = entradaMenuEscolhaDeTipoDeConta.nextLine();
            Utilitario.limparConsole();

            if (alternativaDeTipoDeConta == null) {
                alternativaDeTipoDeConta = "3";
            }
            switch (alternativaDeTipoDeConta) {
                case "1":
                    menuSelecaoDeConta(((Cliente) usuarioSessao).getContaCorrente());
                    break;
                case "2":
                    menuSelecaoDeConta(((Cliente) usuarioSessao).getContaPoupanca());
                    break;
            }
        }
    }

    private static void menuSelecaoDeConta(Conta conta) {
        Scanner entradaMenuSelecaoDeConta = new Scanner(System.in);
        String optOperacao = "0";
        while (!optOperacao.equals("4")) {

            System.out.println("\n\n"
                    + "Selecione o que deseja fazer:\n\n"
                    + "1 - Verificar Saldo.\n2 - Saque\n3 - Deposito.\n4 - Sair.");
            optOperacao = entradaMenuSelecaoDeConta.nextLine();
            Utilitario.limparConsole();

            if (optOperacao == null) {
                optOperacao = "4";
            }
            switch (optOperacao) {
                case "1":
                    System.out.println("SALDO R$: " + Utilitario.formatarDinheiro(conta.getSaldo()));
                    break;
                case "2":
                    System.out.println("Quanto deseja sacar?");
                    int valorSaque = Integer.parseInt(entradaMenuSelecaoDeConta.nextLine());
                    Utilitario.limparConsole();

                    if (conta.realizarSaque(valorSaque)) {
                        if (conta instanceof ContaCorrente) {
                            gerenciadorOperacoes.inserirOperacaoNoHistorico(new Operacao(valorSaque, Operacao.TipoDeOperacao.SAQUE, new Date(), Operacao.TipoDeConta.CORRENTE));
                        } else {
                            gerenciadorOperacoes.inserirOperacaoNoHistorico(new Operacao(valorSaque, Operacao.TipoDeOperacao.SAQUE, new Date(), Operacao.TipoDeConta.POUPANCA));
                        }
                        Utilitario.prepararCorSucesso();
                        System.out.println("SAQUE REALIZADO!");
                        Utilitario.prepararCorNormal();
                    } else {
                        Utilitario.prepararCorErro();
                        System.out.println("SALDO INSUFICIENTE PARA A REALIZAÇÃO DESTE SAQUE!");
                        Utilitario.prepararCorNormal();
                    }
                    break;
                case "3":
                    System.out.println("Quanto deseja depositar?");
                    int valorDeposito = Integer.parseInt(entradaMenuSelecaoDeConta.nextLine());
                    Utilitario.limparConsole();

                    conta.realizarDeposito(valorDeposito);
                    if (conta instanceof ContaCorrente) {
                        gerenciadorOperacoes.inserirOperacaoNoHistorico(new Operacao(valorDeposito, Operacao.TipoDeOperacao.DEPOSITO, new Date(), Operacao.TipoDeConta.CORRENTE));
                    } else {
                        gerenciadorOperacoes.inserirOperacaoNoHistorico(new Operacao(valorDeposito, Operacao.TipoDeOperacao.DEPOSITO, new Date(), Operacao.TipoDeConta.POUPANCA));
                    }
                    Utilitario.prepararCorSucesso();
                    System.out.println("DEPÓSITO REALIZADO!");
                    Utilitario.prepararCorNormal();

                    break;
                case "4":
                    break;
            }

        }
    }

    private static void menuAdministrativo() {
        Scanner entradaMenuAdministrativo = new Scanner(System.in);
        Utilitario.limparConsole();

        String alternativaTipoConta = "0";
        while (!alternativaTipoConta.equals("3")) {
            System.out.println("*** RELATÓRIOS *** \n1 - Contas Correntes \n2 - Contas poupanças \n3 - Sair");
            alternativaTipoConta = entradaMenuAdministrativo.nextLine();
            Utilitario.limparConsole();

            if (alternativaTipoConta == null) {
                alternativaTipoConta = "3";
            }
            switch (alternativaTipoConta) {
                case "1":
                    imprimirRelatorio(new RelatorioDasContasCorrentes());
                    break;
                case "2":
                    imprimirRelatorio(new RelatorioDasContasPoupancas());
                    break;
            }
        }

    }

    private static void imprimirRelatorio(IRelatorio geradorRelatorio) {
        geradorRelatorio.plotarRelatorio(gerenciadorOperacoes);
    }

    /**
     * Método que serve para iniciar o caixa eletrônico e todo o sistema em uma
     * classe principal (main)
     */
    public static void iniciarCaixaEletronico() {
        baseDeDadosEstatica = new BaseDeDados();
        baseDeDadosEstatica.carregarUsuarios();
        System.out.println("*** ATM - Sistema de Caixa Eletrônico ***");

        menuPrincipal();
    }
}
