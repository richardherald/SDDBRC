package br.com.replicacao;

import java.util.Map;
import javax.sql.DataSource;

public abstract class IReplication {
    public abstract Object algorithmReplication(Map<Integer, DataSource> datasources, String command) throws Exception;
}
