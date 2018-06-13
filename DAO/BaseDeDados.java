/**
 * Classe que representa a simulação com o banco de dados da aplicação
 *
 * @author Marcelo Henrique
 */
package DAO;

import dominio.Administrador;
import dominio.Usuario;
import dominio.Cliente;
import java.util.HashMap;
import java.util.Map;

public class BaseDeDados {

    private Map<String, Usuario> listaDeUsuarios = new HashMap<>();

    /**
     * Método que carrega os usuários presentes no sistema
     */
    public void carregarUsuarios() {
        carregarPrimeiroCliente();
        carregarSegundoCliente();
        carregarAdministrador();
    }

    /**
     * Método que autentica o usuário para acessar o sistema
     *
     * @param login
     * @param senha
     * @return Usuario
     */
    public Usuario autenticarUsuario(String login, String senha) {
        if (listaDeUsuarios.get(login).getSenha().equals(senha)
                && listaDeUsuarios.containsKey(login)) {
            return listaDeUsuarios.get(login);
        } else {
            return null;
        }
    }

    private void carregarPrimeiroCliente() {
        Cliente cliente1 = new Cliente("123", "123", "12345678", "12345678-4", 3000, 5000);
        this.listaDeUsuarios.put(cliente1.getLogin(), cliente1);
    }

    private void carregarSegundoCliente() {
        Cliente cliente2 = new Cliente("321", "321", "87654321", "87654321-4", 900, 1800);
        this.listaDeUsuarios.put(cliente2.getLogin(), cliente2);
    }

    private void carregarAdministrador() {
        Administrador adm = new Administrador("999", "999");
        this.listaDeUsuarios.put(adm.getLogin(), adm);
    }

}
