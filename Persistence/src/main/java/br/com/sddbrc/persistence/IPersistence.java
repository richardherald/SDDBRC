package br.com.sddbrc.persistence;

import br.com.sddbrc.commons.model.CommandJDBC;
import br.com.sddbrc.commons.model.Configurations;
import br.com.sddbrc.commons.model.Databases;
import java.sql.ResultSet;
import java.util.List;
import javax.sql.DataSource;

public interface IPersistence {
    public void init(List<Databases> databases, String classPersistence) throws Exception;
    public DataSource createPool(Configurations config) throws Exception;
    public int executeUpdate(CommandJDBC command) throws Exception;
    public ResultSet executeQuery(CommandJDBC command) throws Exception;
    public boolean findScriptByName(String command, String Action) throws Exception;
}
