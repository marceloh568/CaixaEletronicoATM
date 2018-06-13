/**
 * Classe que modela o domínio do administrador da aplicação
 *
 * @author Marcelo Henrique
 */
package dominio;

public class Administrador extends Usuario {

    protected Administrador() {
        setPerfil("administrativo");
    }

    /**
     * Construtor do Usuário Administrador com a possibilidade de setar Login e
     * Senha
     *
     * @param login
     * @param senha
     */
    public Administrador(String login, String senha) {
        setPerfil("administrativo");
        setLogin(login);
        setSenha(senha);
    }

}
