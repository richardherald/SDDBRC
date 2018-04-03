
package br.com.configuration.model;

public class Banco_R_ConfigBanco {
    private Integer banco_R_ConfigBanco_Id;
    private Integer banco_Id;
    private Integer configBanco_Id;

    public Banco_R_ConfigBanco() {
    }

    public Banco_R_ConfigBanco(Integer banco_R_ConfigBanco_Id, Integer banco_Id, Integer configBanco_Id) {
        this.banco_R_ConfigBanco_Id = banco_R_ConfigBanco_Id;
        this.banco_Id = banco_Id;
        this.configBanco_Id = configBanco_Id;
    }

    public Integer getBanco_R_ConfigBanco_Id() {
        return banco_R_ConfigBanco_Id;
    }

    public void setBanco_R_ConfigBanco_Id(Integer banco_R_ConfigBanco_Id) {
        this.banco_R_ConfigBanco_Id = banco_R_ConfigBanco_Id;
    }

    public Integer getBanco_Id() {
        return banco_Id;
    }

    public void setBanco_Id(Integer banco_Id) {
        this.banco_Id = banco_Id;
    }

    public Integer getConfigBanco_Id() {
        return configBanco_Id;
    }

    public void setConfigBanco_Id(Integer configBanco_Id) {
        this.configBanco_Id = configBanco_Id;
    }
    
}
