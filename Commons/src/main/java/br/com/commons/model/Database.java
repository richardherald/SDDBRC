package br.com.commons.model;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private Integer database_Id;
    private String database_Name;
    private Boolean database_Active;
    private Boolean database_Principal;
    private String database_Driver;
    private Integer database_Priority;
    private List<Configuration> listConfiguration = new ArrayList<>();
    private List<Identifier> listIdentifier = new ArrayList<>();
    private List<Database_R_Transaction> listDatabaseRTransaction = new ArrayList<>();

    public Database() {
    }

    public Database(Integer database_Id, String database_Name, Boolean database_Active, Boolean database_Principal, String database_Driver, Integer database_Priority, List<Configuration> listConfiguration, List<Identifier> listIdentifier, List<Database_R_Transaction> listDatabaseRTransaction) {
        this.database_Id = database_Id;
        this.database_Name = database_Name;
        this.database_Active = database_Active;
        this.database_Principal = database_Principal;
        this.database_Driver = database_Driver;
        this.database_Priority = database_Priority;
        this.listConfiguration = listConfiguration;
        this.listIdentifier = listIdentifier;
        this.listDatabaseRTransaction = listDatabaseRTransaction;
    }

    public Integer getDatabase_Id() {
        return database_Id;
    }

    public void setDatabase_Id(Integer database_Id) {
        this.database_Id = database_Id;
    }

    public String getDatabase_Name() {
        return database_Name;
    }

    public void setDatabase_Name(String database_Name) {
        this.database_Name = database_Name;
    }

    public Boolean getDatabase_Active() {
        return database_Active;
    }

    public void setDatabase_Active(Boolean database_Active) {
        this.database_Active = database_Active;
    }

    public Boolean getDatabase_Principal() {
        return database_Principal;
    }

    public void setDatabase_Principal(Boolean database_Principal) {
        this.database_Principal = database_Principal;
    }

    public String getDatabase_Driver() {
        return database_Driver;
    }

    public void setDatabase_Driver(String database_Driver) {
        this.database_Driver = database_Driver;
    }

    public Integer getDatabase_Priority() {
        return database_Priority;
    }

    public void setDatabase_Priority(Integer database_Priority) {
        this.database_Priority = database_Priority;
    }

    public List<Configuration> getListConfiguration() {
        return listConfiguration;
    }

    public void setListConfiguration(List<Configuration> listConfiguration) {
        this.listConfiguration = listConfiguration;
    }

    public List<Identifier> getListIdentifier() {
        return listIdentifier;
    }

    public void setListIdentifier(List<Identifier> listIdentifier) {
        this.listIdentifier = listIdentifier;
    }

    public List<Database_R_Transaction> getListDatabaseRTransaction() {
        return listDatabaseRTransaction;
    }

    public void setListDatabaseRTransaction(List<Database_R_Transaction> listDatabaseRTransaction) {
        this.listDatabaseRTransaction = listDatabaseRTransaction;
    }

    

}
