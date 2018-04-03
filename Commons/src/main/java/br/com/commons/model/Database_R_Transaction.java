
package br.com.configuration.model;

import java.sql.Timestamp;

public class Banco_R_Transacao {
    private Integer banco_R_Transacao_Id;
    private Integer transacao_Id;
    private Integer banco_Id;
    private Integer sincronizacao_Id;
    private Timestamp banco_R_Transacao_DataSincronizacao;

    public Banco_R_Transacao() {
    }

    public Banco_R_Transacao(Integer banco_R_Transacao_Id, Integer transacao_Id, Integer banco_Id, Integer sincronizacao_Id, Timestamp banco_R_Transacao_DataSincronizacao) {
        this.banco_R_Transacao_Id = banco_R_Transacao_Id;
        this.transacao_Id = transacao_Id;
        this.banco_Id = banco_Id;
        this.sincronizacao_Id = sincronizacao_Id;
        this.banco_R_Transacao_DataSincronizacao = banco_R_Transacao_DataSincronizacao;
    }

    public Integer getBanco_R_Transacao_Id() {
        return banco_R_Transacao_Id;
    }

    public void setBanco_R_Transacao_Id(Integer banco_R_Transacao_Id) {
        this.banco_R_Transacao_Id = banco_R_Transacao_Id;
    }

    public Integer getTransacao_Id() {
        return transacao_Id;
    }

    public void setTransacao_Id(Integer transacao_Id) {
        this.transacao_Id = transacao_Id;
    }

    public Integer getBanco_Id() {
        return banco_Id;
    }

    public void setBanco_Id(Integer banco_Id) {
        this.banco_Id = banco_Id;
    }

    public Integer getSincronizacao_Id() {
        return sincronizacao_Id;
    }

    public void setSincronizacao_Id(Integer sincronizacao_Id) {
        this.sincronizacao_Id = sincronizacao_Id;
    }

    public Timestamp getBanco_R_Transacao_DataSincronizacao() {
        return banco_R_Transacao_DataSincronizacao;
    }

    public void setBanco_R_Transacao_DataSincronizacao(Timestamp banco_R_Transacao_DataSincronizacao) {
        this.banco_R_Transacao_DataSincronizacao = banco_R_Transacao_DataSincronizacao;
    }
    
}
