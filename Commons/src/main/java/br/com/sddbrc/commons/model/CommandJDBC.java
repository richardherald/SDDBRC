package br.com.sddbrc.commons.model;

import java.sql.Connection;

public class CommandJDBC {

    private String query;
    private boolean generatedKeys;
    private String DML;
    private Connection con;
    private boolean beginTransaction=false;

    public CommandJDBC() {
    }

    public CommandJDBC(String query, boolean generatedKeys, String DML) {
        this.query = query;
        this.generatedKeys = generatedKeys;
        this.DML = DML;
    }

    public boolean isGeneratedKeys() {
        return generatedKeys;
    }

    public void setGeneratedKeys(boolean generatedKeys) {
        this.generatedKeys = generatedKeys;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getDML() {
        return DML;
    }

    public void setDML(String DML) {
        this.DML = DML;
    }

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * @return the beginTransaction
     */
    public boolean isBeginTransaction() {
        return beginTransaction;
    }

    /**
     * @param beginTransaction the beginTransaction to set
     */
    public void setBeginTransaction(boolean beginTransaction) {
        this.beginTransaction = beginTransaction;
    }

}
