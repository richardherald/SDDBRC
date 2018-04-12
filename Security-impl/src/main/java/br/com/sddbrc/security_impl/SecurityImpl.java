package br.com.sddbrc.security_impl;

import br.com.sddbrc.security.ISecurity;

public class SecurityImpl implements ISecurity {

    @Override
    public Object basicSecurity(String username, String password, String command) throws Exception{
        try {
            command = "SELECT TOP (10) * FROM [TESTE].[dbo].[Pessoa]";
            return 1 == 1 ? "" : new Exception("");
        } catch (Exception e) {
            throw e;
        }
    }
    
}
