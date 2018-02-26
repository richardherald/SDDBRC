package br.com.repositorios.model;

import java.util.Date;
import java.util.List;

public class Banco {

    private int banco_Id;
    private String banco_Nome;
    private boolean banco_Principal;
    private String banco_Driver;
    private Date banco_DataCriacao;
    private int banco_Prioridade;
    private List<ConfigBanco> configuracoes;

    /**
     * @return the banco_Id
     */
    public int getBanco_Id() {
        return banco_Id;
    }

    /**
     * @param banco_Id the banco_Id to set
     */
    public void setBanco_Id(int banco_Id) {
        this.banco_Id = banco_Id;
    }

    /**
     * @return the banco_Nome
     */
    public String getBanco_Nome() {
        return banco_Nome;
    }

    /**
     * @param banco_Nome the banco_Nome to set
     */
    public void setBanco_Nome(String banco_Nome) {
        this.banco_Nome = banco_Nome;
    }

    /**
     * @return the banco_Principal
     */
    public boolean isBanco_Principal() {
        return banco_Principal;
    }

    /**
     * @param banco_Principal the banco_Principal to set
     */
    public void setBanco_Principal(boolean banco_Principal) {
        this.banco_Principal = banco_Principal;
    }

    /**
     * @return the banco_Driver
     */
    public String getBanco_Driver() {
        return banco_Driver;
    }

    /**
     * @param banco_Driver the banco_Driver to set
     */
    public void setBanco_Driver(String banco_Driver) {
        this.banco_Driver = banco_Driver;
    }

    /**
     * @return the banco_DataCriacao
     */
    public Date getBanco_DataCriacao() {
        return banco_DataCriacao;
    }

    /**
     * @param banco_DataCriacao the banco_DataCriacao to set
     */
    public void setBanco_DataCriacao(Date banco_DataCriacao) {
        this.banco_DataCriacao = banco_DataCriacao;
    }

    /**
     * @return the banco_Prioridade
     */
    public int getBanco_Prioridade() {
        return banco_Prioridade;
    }

    /**
     * @param banco_Prioridade the banco_Prioridade to set
     */
    public void setBanco_Prioridade(int banco_Prioridade) {
        this.banco_Prioridade = banco_Prioridade;
    }

    /**
     * @return the configuracoes
     */
    public List<ConfigBanco> getConfiguracoes() {
        return configuracoes;
    }

    /**
     * @param configuracoes the configuracoes to set
     */
    public void setConfiguracoes(List<ConfigBanco> configuracoes) {
        this.configuracoes = configuracoes;
    }

}
