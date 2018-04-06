package br.com.configuration;

import br.com.commons.model.Transaction;

public interface ITransaction {
    public int insert(Transaction obj) throws Exception;
}
