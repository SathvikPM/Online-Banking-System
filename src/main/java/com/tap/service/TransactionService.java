package com.tap.service;

import com.tap.model.Transaction;
import java.util.List;

public interface TransactionService {
    void saveTransaction(Transaction transaction);
    List<Transaction> getTransactionsByAccountId(int accountId);
}
