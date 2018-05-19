package br.com.sddbrc.security;

import br.com.sddbrc.commons.model.CommandJDBC;

public interface ISecurity {

    public Object basicSecurity(String username, String password, CommandJDBC commandJDBC) throws Exception;
}
