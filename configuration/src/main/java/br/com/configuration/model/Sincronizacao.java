package br.com.configuration.model;

public class Sincronizacao {

    private Integer sincronizacao_Id;
    private String sincronizacao_nome;

    public Sincronizacao() {
    }

    public Sincronizacao(Integer sincronizacao_Id, String sincronizacao_nome) {
        this.sincronizacao_Id = sincronizacao_Id;
        this.sincronizacao_nome = sincronizacao_nome;
    }

    public Integer getSincronizacao_Id() {
        return sincronizacao_Id;
    }

    public void setSincronizacao_Id(Integer sincronizacao_Id) {
        this.sincronizacao_Id = sincronizacao_Id;
    }

    public String getSincronizacao_nome() {
        return sincronizacao_nome;
    }

    public void setSincronizacao_nome(String sincronizacao_nome) {
        this.sincronizacao_nome = sincronizacao_nome;
    }

}
