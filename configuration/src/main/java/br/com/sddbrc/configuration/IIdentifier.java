package br.com.sddbrc.configuration;
 
import br.com.sddbrc.commons.model.Identifier;

public interface IIdentifier {
    public int insert(Identifier identifier) throws Exception;
    public Identifier getByTable(String table) throws Exception;
    public int update(Identifier identifier) throws Exception;
}
