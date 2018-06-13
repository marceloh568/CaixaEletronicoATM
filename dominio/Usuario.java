/**
 * Classe que serve de modelo para os possíveis usuários existentes na aplicação
 *
 * @author Marcelo Henrique
 */
package dominio;

public abstract class Usuario {

    private String perfil;
    private String login;
    private String senha;

    /**
     * Método que retorna o tipo de perfil do usuário
     *
     * @return String - perfil
     */
    public String getPerfil() {
        return perfil;
    }

    protected void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    /**
     * Método que retorna o login do usuário
     *
     * @return String - login
     */
    public String getLogin() {
        return login;
    }

    protected void setLogin(String login) {
        this.login = login;
    }

    /**
     * Método que retorna a senha do usuário
     *
     * @return String - senha
     */
    public String getSenha() {
        return senha;
    }

    protected void setSenha(String senha) {
        this.senha = senha;
    }

}
