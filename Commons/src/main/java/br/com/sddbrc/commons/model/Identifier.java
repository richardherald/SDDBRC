package br.com.sddbrc.commons.model;

public class Identifier {
    private Integer identifier_Id;
    private String identifier_Table;
    private Integer identifier_Value;
    private String identifier_NameTableId;

    public Identifier() {
    }

    public Identifier(Integer identifier_Id, String identifier_Table, Integer identifier_Value, String identifier_NameTableId) {
        this.identifier_Id = identifier_Id;
        this.identifier_Table = identifier_Table;
        this.identifier_Value = identifier_Value;
        this.identifier_NameTableId = identifier_NameTableId;
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

    public Integer getIdentifier_Value() {
        return identifier_Value;
    }

    public void setIdentifier_Value(Integer identifier_Value) {
        this.identifier_Value = identifier_Value;
    }

    public String getIdentifier_NameTableId() {
        return identifier_NameTableId;
    }

    public void setIdentifier_NameTableId(String identifier_NameTableId) {
        this.identifier_NameTableId = identifier_NameTableId;
    }

 
}
