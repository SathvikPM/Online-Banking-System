package com.tap.daoImp;

import com.tap.dao.AccountDAO;
import com.tap.model.Account;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public AccountDAOImpl() {
        LOGGER.info("AccountDAOImpl created");
    }

    @Override
    @Transactional
    public void saveAccount(Account account) {
        LOGGER.info("Saving account: {}", account);
        sessionFactory.getCurrentSession().save(account);
    }

    @Override
    @Transactional(readOnly = true)
    public Account getAccountById(int accountId) {
        LOGGER.info("Getting account by ID: {}", accountId);
        return sessionFactory.getCurrentSession().get(Account.class, accountId);
    }

    @Override
    @Transactional(readOnly = true)
    public Account getAccountByNumber(String accountNumber) {
        LOGGER.info("Getting account by number: {}", accountNumber);
        return sessionFactory.getCurrentSession().createQuery("FROM Account WHERE accountNumber = :accountNumber", Account.class)
            .setParameter("accountNumber", accountNumber).uniqueResult();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Account> getAccountsByUserId(int userId) {
        LOGGER.info("Getting accounts by user ID: {}", userId);
        List<Account> accounts = sessionFactory.getCurrentSession().createQuery("FROM Account WHERE userId = :userId", Account.class)
            .setParameter("userId", userId).list();
        LOGGER.info("Accounts retrieved from database: {}", accounts);
        return accounts;
    }
}
