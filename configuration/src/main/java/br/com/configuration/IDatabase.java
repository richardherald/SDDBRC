package br.com.configuration;

import br.com.commons.model.Databases;
import java.util.List;

public interface IDatabase {

    public List<Databases> getAll() throws Exception;
}
