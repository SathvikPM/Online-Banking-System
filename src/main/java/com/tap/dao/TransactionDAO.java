package com.tap.dao;

import com.tap.model.Transaction;
import java.util.List;

public interface TransactionDAO {
    void saveTransaction(Transaction transaction);
    List<Transaction> getTransactionsByAccountId(int accountId);
}
