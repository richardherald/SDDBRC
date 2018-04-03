
package br.com.configuration.model;

public class ConfigBanco {
    private Integer configBanco_Id;
    private String configBanco_Usuario;
    private String configBanco_Senha;

    public ConfigBanco() {
    }

    public ConfigBanco(Integer configBanco_Id, String configBanco_Usuario, String configBanco_Senha) {
        this.configBanco_Id = configBanco_Id;
        this.configBanco_Usuario = configBanco_Usuario;
        this.configBanco_Senha = configBanco_Senha;
    }

    public Integer getConfigBanco_Id() {
        return configBanco_Id;
    }

    public void setConfigBanco_Id(Integer configBanco_Id) {
        this.configBanco_Id = configBanco_Id;
    }

    public String getConfigBanco_Usuario() {
        return configBanco_Usuario;
    }

    public void setConfigBanco_Usuario(String configBanco_Usuario) {
        this.configBanco_Usuario = configBanco_Usuario;
    }

    public String getConfigBanco_Senha() {
        return configBanco_Senha;
    }

    public void setConfigBanco_Senha(String configBanco_Senha) {
        this.configBanco_Senha = configBanco_Senha;
    }
    
    
}
