package br.com.configuration.model;

public class Identificador {
    private Integer identificador_Id;
    private String identificador_Tabela;
    private Integer identificador_Valor;
    private Integer banco_Id;

    public Identificador() {
    }

    public Identificador(Integer identificador_Id, String identificador_Tabela, Integer banco_Id) {
        this.identificador_Id = identificador_Id;
        this.identificador_Tabela = identificador_Tabela;
        this.banco_Id = banco_Id;
    }

    
    public Integer getIdentificador_Id() {
        return identificador_Id;
    }

    public void setIdentificador_Id(Integer identificador_Id) {
        this.identificador_Id = identificador_Id;
    }

    public String getIdentificador_Tabela() {
        return identificador_Tabela;
    }

    public void setIdentificador_Tabela(String identificador_Tabela) {
        this.identificador_Tabela = identificador_Tabela;
    }

    public Integer getIdentificador_Valor() {
        return identificador_Valor;
    }

    public void setIdentificador_Valor(Integer identificador_Valor) {
        this.identificador_Valor = identificador_Valor;
    }

    public Integer getBanco_Id() {
        return banco_Id;
    }

    public void setBanco_Id(Integer banco_Id) {
        this.banco_Id = banco_Id;
    }
}
