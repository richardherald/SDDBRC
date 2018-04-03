package br.com.commons.model;

public class Identifier {
    private Integer identifier_Id;
    private String identifier_Table;
    private Integer identifier_Valor;
    private Integer database_Id;

    public Identifier() {
    }

    public Identifier(Integer identifier_Id, String identifier_Table, Integer database_Id) {
        this.identifier_Id = identifier_Id;
        this.identifier_Table = identifier_Table;
        this.database_Id = database_Id;
    }

    public Integer getIdentifier_Id() {
        return identifier_Id;
    }

    public void setIdentifier_Id(Integer identifier_Id) {
        this.identifier_Id = identifier_Id;
    }

    public String getIdentifier_Table() {
        return identifier_Table;
    }

    public void setIdentifier_Table(String identifier_Table) {
        this.identifier_Table = identifier_Table;
    }

    public Integer getIdentifier_Valor() {
        return identifier_Valor;
    }

    public void setIdentifier_Valor(Integer identifier_Valor) {
        this.identifier_Valor = identifier_Valor;
    }

    public Integer getDatabase_Id() {
        return database_Id;
    }

    public void setDatabase_Id(Integer database_Id) {
        this.database_Id = database_Id;
    }

    
   
}
