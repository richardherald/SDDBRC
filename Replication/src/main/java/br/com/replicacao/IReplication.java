package br.com.replicacao;

import br.com.commons.model.Database;
import java.util.List;

public abstract class IReplication {
    public abstract Object algorithmReplication(List<Database> datasources, String command) throws Exception;
}
