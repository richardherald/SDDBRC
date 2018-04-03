package br.com.configuration.db;


import br.com.commons.model.Configuration;
import javax.sql.DataSource;

public interface ConnectionFactory {

    DataSource config(Configuration config) throws Exception;

    DataSource config(String directory) throws Exception;

}
