package br.com.repositorios.config.db;

import java.util.List;
import javax.sql.DataSource;

public interface ConnectionFactory {

    public DataSource getDatasource(int banco) throws Exception;

    public DataSource config(int codigo) throws Exception;
}
