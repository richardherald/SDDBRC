package br.com.sddbrc.commons.model;

public class CommandJDBC {

    private String query;
    private boolean generatedKeys;
    private String DML;

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

}
