package br.com.configuration;

import br.com.commons.model.Configurations;

public interface IConfiguration {
     public Configurations getByDatabaseId(int databaseId) throws Exception;
}
