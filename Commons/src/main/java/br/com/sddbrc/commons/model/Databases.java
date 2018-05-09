package br.com.sddbrc.commons.model;

import java.util.ArrayList;
import java.util.List;

public class Databases extends Datasource {

    private Integer database_Id;
    private String database_Name;
    private Boolean database_Active;
    private Boolean database_Principal;
    private String database_Driver;
    private String database_ClassDatasource;
    private Integer database_Priority;
    private Configurations configuration = new Configurations();
    private List<Identifier> identifiers = new ArrayList<>();
    private List<Databases_R_Transactions> databaseRTransactions = new ArrayList<>();

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
     * @return the database_Name
     */
    public String getDatabase_Name() {
        return database_Name;
    }

    /**
     * @param database_Name the database_Name to set
     */
    public void setDatabase_Name(String database_Name) {
        this.database_Name = database_Name;
    }

    /**
     * @return the database_Active
     */
    public Boolean getDatabase_Active() {
        return database_Active;
    }

    /**
     * @param database_Active the database_Active to set
     */
    public void setDatabase_Active(Boolean database_Active) {
        this.database_Active = database_Active;
    }

    /**
     * @return the database_Principal
     */
    public Boolean getDatabase_Principal() {
        return database_Principal;
    }

    /**
     * @param database_Principal the database_Principal to set
     */
    public void setDatabase_Principal(Boolean database_Principal) {
        this.database_Principal = database_Principal;
    }

    /**
     * @return the database_Driver
     */
    public String getDatabase_Driver() {
        return database_Driver;
    }

    /**
     * @param database_Driver the database_Driver to set
     */
    public void setDatabase_Driver(String database_Driver) {
        this.database_Driver = database_Driver;
    }

    /**
     * @return the database_classDatasource
     */
    public String getDatabase_ClassDatasource() {
        return database_ClassDatasource;
    }

    /**
     * @param database_classDatasource the database_classDatasource to set
     */
    public void setDatabase_ClassDatasource(String database_classDatasource) {
        this.database_ClassDatasource = database_classDatasource;
    }

    /**
     * @return the database_Priority
     */
    public Integer getDatabase_Priority() {
        return database_Priority;
    }

    /**
     * @param database_Priority the database_Priority to set
     */
    public void setDatabase_Priority(Integer database_Priority) {
        this.database_Priority = database_Priority;
    }

    /**
     * @return the configuration
     */
    public Configurations getConfiguration() {
        return configuration;
    }

    /**
     * @param configuration the configuration to set
     */
    public void setConfiguration(Configurations configuration) {
        this.configuration = configuration;
    }

    /**
     * @return the identifiers
     */
    public List<Identifier> getIdentifiers() {
        return identifiers;
    }

    /**
     * @param identifiers the identifiers to set
     */
    public void setIdentifiers(List<Identifier> identifiers) {
        this.identifiers = identifiers;
    }

    /**
     * @return the databaseRTransactions
     */
    public List<Databases_R_Transactions> getDatabaseRTransactions() {
        return databaseRTransactions;
    }

    /**
     * @param databaseRTransactions the databaseRTransactions to set
     */
    public void setDatabaseRTransactions(List<Databases_R_Transactions> databaseRTransactions) {
        this.databaseRTransactions = databaseRTransactions;
    }

   

}
