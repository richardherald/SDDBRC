
package br.com.sddbrc.commons.model;

import java.sql.Timestamp;

public class Databases_R_Transactions {
    private Integer database_R_Transaction_Id;
    private Integer transaction_Id;
    private Integer database_Id;
    private Integer sincronization_Id;
    private Timestamp database_R_Transaction_DateSincronization;
    private Transaction transaction;

    public Databases_R_Transactions() {
        transaction = new Transaction();
    }

    public Databases_R_Transactions(Integer database_R_Transaction_Id, Integer transaction_Id, Integer database_Id, Integer sincronization_Id, Timestamp database_R_Transaction_DateSincronization, Transaction transaction) {
        this.database_R_Transaction_Id = database_R_Transaction_Id;
        this.transaction_Id = transaction_Id;
        this.database_Id = database_Id;
        this.sincronization_Id = sincronization_Id;
        this.database_R_Transaction_DateSincronization = database_R_Transaction_DateSincronization;
        this.transaction = transaction;
    }

    /**
     * @return the database_R_Transaction_Id
     */
    public Integer getDatabase_R_Transaction_Id() {
        return database_R_Transaction_Id;
    }

    /**
     * @param database_R_Transaction_Id the database_R_Transaction_Id to set
     */
    public void setDatabase_R_Transaction_Id(Integer database_R_Transaction_Id) {
        this.database_R_Transaction_Id = database_R_Transaction_Id;
    }

    /**
     * @return the transaction_Id
     */
    public Integer getTransaction_Id() {
        return transaction_Id;
    }

    /**
     * @param transaction_Id the transaction_Id to set
     */
    public void setTransaction_Id(Integer transaction_Id) {
        this.transaction_Id = transaction_Id;
    }

    /**
     * @return the database_Id
     */
    public Integer getDatabase_Id() {
        return database_Id;
    }

    /**
     * @param database_Id the database_Id to set
     */
    public void setDatabase_Id(Integer database_Id) {
        this.database_Id = database_Id;
    }

    /**
     * @return the sincronization_Id
     */
    public Integer getSincronization_Id() {
        return sincronization_Id;
    }

    /**
     * @param sincronization_Id the sincronization_Id to set
     */
    public void setSincronization_Id(Integer sincronization_Id) {
        this.sincronization_Id = sincronization_Id;
    }

    /**
     * @return the database_R_Transaction_DateSincronization
     */
    public Timestamp getDatabase_R_Transaction_DateSincronization() {
        return database_R_Transaction_DateSincronization;
    }

    /**
     * @param database_R_Transaction_DateSincronization the database_R_Transaction_DateSincronization to set
     */
    public void setDatabase_R_Transaction_DateSincronization(Timestamp database_R_Transaction_DateSincronization) {
        this.database_R_Transaction_DateSincronization = database_R_Transaction_DateSincronization;
    }

    /**
     * @return the transaction
     */
    public Transaction getTransaction() {
        return transaction;
    }

    /**
     * @param transaction the transaction to set
     */
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
