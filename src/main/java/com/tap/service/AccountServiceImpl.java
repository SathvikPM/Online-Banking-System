package com.tap.service;

import com.tap.dao.AccountDAO;
import com.tap.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDAO accountDAO;

    @Override
    @Transactional
    public void saveAccount(Account account) {
        accountDAO.saveAccount(account);
    }

    @Override
    @Transactional(readOnly = true)
    public Account getAccountById(int accountId) {
        return accountDAO.getAccountById(accountId);
    }

    @Override
    @Transactional(readOnly = true)
    public Account getAccountByNumber(String accountNumber) {
        return accountDAO.getAccountByNumber(accountNumber);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Account> getAccountsByUserId(int userId) {
        return accountDAO.getAccountsByUserId(userId);
    }
}
