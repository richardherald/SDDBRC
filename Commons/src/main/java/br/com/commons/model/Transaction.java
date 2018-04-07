package br.com.commons.model;

import java.util.ArrayList;
import java.util.List;

public class Transaction {

    private Integer transaction_Id;
    private String transaction_Script;

    public Transaction() {
    }

    public Transaction(Integer transaction_Id, String transaction_Script) {
        this.transaction_Id = transaction_Id;
        this.transaction_Script = transaction_Script;
    }

    public Integer getTransaction_Id() {
        return transaction_Id;
    }

    public void setTransaction_Id(Integer transaction_Id) {
        this.transaction_Id = transaction_Id;
    }

    public String getTransaction_Script() {
        return transaction_Script;
    }

    public void setTransaction_Script(String transaction_Script) {
        this.transaction_Script = transaction_Script;
    }
}
