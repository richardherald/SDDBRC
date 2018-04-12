package br.com.sddbrc.configuration;

import br.com.sddbrc.commons.model.Databases;
import java.util.List;

public interface IDatabase {

    public List<Databases> getAll() throws Exception;
}
