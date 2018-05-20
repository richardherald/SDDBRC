package br.com.sddbrc.replicationImpl;

import br.com.sddbrc.commons.model.CommandJDBC;
import br.com.sddbrc.commons.model.Databases;
import br.com.sddbrc.commons.model.Databases_R_Transactions;
import br.com.sddbrc.persistence_impl.PersistenceImpl;
import br.com.sddbrc.replication.IReplication;
import java.util.List;

public class ReplicationPrimaryCopyAsynchronousImpl extends IReplication {

    private final PersistenceImpl persistence;
    private final br.com.sddbrc.core.Runtime runtime = new br.com.sddbrc.core.Runtime();

    public ReplicationPrimaryCopyAsynchronousImpl() {
        persistence = new PersistenceImpl();
    }

    @Override
    public void algorithm(List<Databases> datasources, List<Databases_R_Transactions> transactions) throws Exception {
        try {
            int databaseId = 0;
            CommandJDBC command = new CommandJDBC();
            for (int i = 0; i < transactions.size(); i++) {
                long ti = System.currentTimeMillis();
//                if (databaseId != transactions.get(i).getDatabase_Id()) {
                databaseId = transactions.get(i).getDatabase_Id();
                command.setCon(persistence.getConnection(datasources, databaseId));
//                }
                command.setQuery(transactions.get(i).getTransaction().getTransaction_Script());
                command.setGeneratedKeys(false);
                persistence.executeUpdate(command);
                runtime.atualizarTransacao(transactions.get(i));
                long tf = System.currentTimeMillis();
                long tempo = tf - ti;
                System.out.println(tempo);
            }
            System.out.println("Finalizando integração");
        } catch (Exception e) {
            throw e;
        }
    }
}
