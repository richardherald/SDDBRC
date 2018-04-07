package br.com.replicacao;

import br.com.commons.model.Databases;
import br.com.commons.model.Databases_R_Transactions;
import java.util.List;

public abstract class IReplication {
    public abstract void algorithmReplication(List<Databases> databases, List<Databases_R_Transactions> transactions) throws Exception;
}
