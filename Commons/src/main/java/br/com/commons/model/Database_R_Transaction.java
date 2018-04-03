
package br.com.commons.model;

import java.sql.Timestamp;

public class Database_R_Transaction {
    private Integer database_R_Transaction_Id;
    private Integer transaction_Id;
    private Integer database_Id;
    private Integer sincronization_Id;
    private Timestamp database_R_Transaction_DateSincronization;

    public Database_R_Transaction() {
    }

    public Database_R_Transaction(Integer database_R_Transaction_Id, Integer transaction_Id, Integer database_Id, Integer sincronization_Id, Timestamp database_R_Transaction_DateSincronization) {
        this.database_R_Transaction_Id = database_R_Transaction_Id;
        this.transaction_Id = transaction_Id;
        this.database_Id = database_Id;
        this.sincronization_Id = sincronization_Id;
        this.database_R_Transaction_DateSincronization = database_R_Transaction_DateSincronization;
    }

    public Integer getDatabase_R_Transaction_Id() {
        return database_R_Transaction_Id;
    }

    public void setDatabase_R_Transaction_Id(Integer database_R_Transaction_Id) {
        this.database_R_Transaction_Id = database_R_Transaction_Id;
    }

    public Integer getTransaction_Id() {
        return transaction_Id;
    }

    public void setTransaction_Id(Integer transaction_Id) {
        this.transaction_Id = transaction_Id;
    }

    public Integer getDatabase_Id() {
        return database_Id;
    }

    public void setDatabase_Id(Integer database_Id) {
        this.database_Id = database_Id;
    }

    public Integer getSincronization_Id() {
        return sincronization_Id;
    }

    public void setSincronization_Id(Integer sincronization_Id) {
        this.sincronization_Id = sincronization_Id;
    }

    public Timestamp getDatabase_R_Transaction_DateSincronization() {
        return database_R_Transaction_DateSincronization;
    }

    public void setDatabase_R_Transaction_DateSincronization(Timestamp database_R_Transaction_DateSincronization) {
        this.database_R_Transaction_DateSincronization = database_R_Transaction_DateSincronization;
    }


    
}
