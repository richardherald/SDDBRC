package br.com.sddbrc.configuration;

import br.com.sddbrc.commons.model.Configurations;

public interface IConfiguration {
     public Configurations getByDatabaseId(int databaseId) throws Exception;
}
