package br.com.sddbrc.commons.model;

import javax.sql.DataSource;

public class Datasource {

    private DataSource datasource = null;

    public DataSource getDatasource() {
        return datasource;
    }

    public void setDatasource(DataSource datasource) {
        this.datasource = datasource;
    }
}
