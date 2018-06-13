/**
 * Classe que contém o método principal da aplicação e que irá inicializar o sistema
 *
 * @author Marcelo Henrique
 */
package sistema;

import view.TerminalATM;

public class Sistema {

    public static void main(String[] args) {

        //Cliente 1: Login: "123"; Senha: "123" (Sem Aspas). Saldo inicial em Conta -> Corrente: R$:3.000,00 | Poupança: R$:5.000,00
        //Cliente 2: Login: "321"; Senha: "321" (Sem Aspas). Saldo inicial em Conta -> Corrente: R$:900,00   | Poupança R$:1.800,00
        //Administrador: Login: "999"; Senha: "999" (Sem Aspas). NÃO POSSUI CONTAS!
        TerminalATM.iniciarCaixaEletronico();
    }
}
