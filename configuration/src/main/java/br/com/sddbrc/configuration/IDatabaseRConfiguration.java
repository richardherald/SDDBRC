package br.com.sddbrc.configuration;

import br.com.sddbrc.commons.model.Databases;
import java.util.List;

public interface IDatabaseRConfiguration {

    List<Databases> getDatabasesWithConfiguration() throws Exception;
}
