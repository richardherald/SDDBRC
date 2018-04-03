 
package br.com.persistence;
 
import br.com.commons.model.Configuration;
import java.util.List;

public interface IConfiguration {
    public List<Configuration> getByDatabaseId(int databaseId) throws Exception;
}
