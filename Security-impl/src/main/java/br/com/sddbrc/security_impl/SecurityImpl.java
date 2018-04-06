package br.com.sddbrc.security_impl;

import br.com.sddbrc.security.ISecurity;
import br.com.sddbrc.core.Runtime;

public class SecurityImpl implements ISecurity {
    
    Runtime runtime = Runtime.getInstance();

    @Override
    public Object basicSecurity(String username, String password, String command) throws Exception{
        try {
            return 1 == 1 ? runtime.execute(command) : new Exception("");
        } catch (Exception e) {
            throw e;
        }
    }
    
}
