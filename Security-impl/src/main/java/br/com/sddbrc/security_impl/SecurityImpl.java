package br.com.sddbrc.security_impl;

import br.com.sddbrc.commons.model.CommandJDBC;
import br.com.sddbrc.security.ISecurity;

public class SecurityImpl implements ISecurity {

    br.com.sddbrc.core.Runtime runtime = new br.com.sddbrc.core.Runtime();

    @Override
    public Object basicSecurity(String username, String password, CommandJDBC commandJDBC) throws Exception {
        Object retorno = null;
        try {
            if (username.equals("teste") && password.equals("teste")) {
                retorno = runtime.execute(commandJDBC);
            }
        } catch (Exception e) {
            throw e;
        }
        return retorno;
    }

}
