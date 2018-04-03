
package br.com.persistence;

import br.com.commons.model.Database;
import java.util.List;

public interface IDatabase {
    public Database getById(int id) throws Exception;
    public List<Database> getAll() throws Exception;
}
