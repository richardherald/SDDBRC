package br.com.sddbrc.configuration;

import br.com.sddbrc.commons.model.Transaction;

public interface ITransaction {
    public int insert(Transaction obj) throws Exception;
}
