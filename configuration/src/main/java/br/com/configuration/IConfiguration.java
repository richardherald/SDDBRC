package br.com.configuration;

import br.com.commons.model.Configuration;
import java.util.List;

public interface IConfiguration {
     public Configuration getByDatabaseId(int databaseId) throws Exception;
}
