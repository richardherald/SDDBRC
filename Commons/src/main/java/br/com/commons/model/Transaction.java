 
package br.com.configuration.model;
 
public class Transacao {
    private Integer transacao_Id;
    private String transacao_Script;

    public Transacao() {
    }

    public Transacao(Integer transacao_Id, String transacao_Script) {
        this.transacao_Id = transacao_Id;
        this.transacao_Script = transacao_Script;
    }

    public Integer getTransacao_Id() {
        return transacao_Id;
    }

    public void setTransacao_Id(Integer transacao_Id) {
        this.transacao_Id = transacao_Id;
    }

    public String getTransacao_Script() {
        return transacao_Script;
    }

    public void setTransacao_Script(String transacao_Script) {
        this.transacao_Script = transacao_Script;
    }
    
}
