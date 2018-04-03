package br.com.configuration.model;

public class Banco {

    private Integer banco_Id;
    private String banco_Nome;
    private Boolean banco_Ativo;
    private Boolean banco_Principal;
    private Boolean banco_Driver;
    private Integer banco_Prioridade;

    public Banco() {
    }

    public Banco(Integer banco_Id, String banco_Nome, Boolean banco_Ativo, Boolean banco_Principal, Boolean banco_Driver, Integer banco_Prioridade) {
        this.banco_Id = banco_Id;
        this.banco_Nome = banco_Nome;
        this.banco_Ativo = banco_Ativo;
        this.banco_Principal = banco_Principal;
        this.banco_Driver = banco_Driver;
        this.banco_Prioridade = banco_Prioridade;
    }

    public Integer getBanco_Id() {
        return banco_Id;
    }

    public void setBanco_Id(Integer banco_Id) {
        this.banco_Id = banco_Id;
    }

    public String getBanco_Nome() {
        return banco_Nome;
    }

    public void setBanco_Nome(String banco_Nome) {
        this.banco_Nome = banco_Nome;
    }

    public Boolean getBanco_Ativo() {
        return banco_Ativo;
    }

    public void setBanco_Ativo(Boolean banco_Ativo) {
        this.banco_Ativo = banco_Ativo;
    }

    public Boolean getBanco_Principal() {
        return banco_Principal;
    }

    public void setBanco_Principal(Boolean banco_Principal) {
        this.banco_Principal = banco_Principal;
    }

    public Boolean getBanco_Driver() {
        return banco_Driver;
    }

    public void setBanco_Driver(Boolean banco_Driver) {
        this.banco_Driver = banco_Driver;
    }

    public Integer getBanco_Prioridade() {
        return banco_Prioridade;
    }

    public void setBanco_Prioridade(Integer banco_Prioridade) {
        this.banco_Prioridade = banco_Prioridade;
    }
    

}
