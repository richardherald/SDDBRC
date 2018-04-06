package br.com.sddbrc.security;

/**
 *
 * @author islanm
 */
public interface ISecurity {
    public Object basicSecurity(String username, String password, String command) throws Exception;
}
