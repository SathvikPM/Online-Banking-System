package com.tap.service;

import com.tap.model.Account;
import java.util.List;

public interface AccountService {
    void saveAccount(Account account);
    Account getAccountById(int accountId);
    Account getAccountByNumber(String accountNumber);
    List<Account> getAccountsByUserId(int userId);
}

