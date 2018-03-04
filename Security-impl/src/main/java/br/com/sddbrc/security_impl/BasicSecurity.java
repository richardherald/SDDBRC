package br.com.sddbrc.security_impl;

import br.com.sddbrc.security.Security;

public class BasicSecurity implements Security{

    @Override
    public boolean basicSecurity(String username, String password) {
        return true;
    }
    
}
