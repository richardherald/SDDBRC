 
package br.com.commons.model;
 
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private Integer transaction_Id;
    private String transaction_Script;
private List<Database_R_Transaction> listDatabaseRTransaction = new ArrayList<>();
    public Transaction() {
    }

    public Transaction(Integer transaction_Id, String transaction_Script,List<Database_R_Transaction> listDatabaseRTransaction) {
        this.transaction_Id = transaction_Id;
        this.transaction_Script = transaction_Script;
       this.listDatabaseRTransaction = listDatabaseRTransaction;
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

    public List<Database_R_Transaction> getListDatabaseRTransaction() {
        return listDatabaseRTransaction;
    }

    public void setListDatabaseRTransaction(List<Database_R_Transaction> listDatabaseRTransaction) {
        this.listDatabaseRTransaction = listDatabaseRTransaction;
    }

    
}
