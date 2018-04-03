package br.com.repositorios.config.db;

import br.com.repositorios.model.ConfigBanco;
import javax.sql.DataSource;

public interface ConnectionFactory {

    DataSource config(ConfigBanco config) throws Exception;

    DataSource config(String directory) throws Exception;

}
