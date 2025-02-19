package com.tap.daoImp;

import com.tap.dao.AccountDAO;
import com.tap.model.Account;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository //@Repository: Indicates that a class is a repository or DAO
public class AccountDAOImpl implements AccountDAO {

  
    @Autowired
    private SessionFactory sessionFactory;

    
    @Override
    @Transactional
    public void saveAccount(Account account) {
        
        sessionFactory.getCurrentSession().save(account);
    }

    @Override
    @Transactional(readOnly = true)
    public Account getAccountById(int accountId) {
      
        
        Account account= sessionFactory.getCurrentSession().get(Account.class, accountId);
        return account;
    }

    @Override
    @Transactional(readOnly = true)
    public Account getAccountByNumber(String accountNumber) {
        
    	Session session = sessionFactory.getCurrentSession();
    	Query<Account> query = session.createQuery("FROM Account WHERE accountNumber = :accountNumber", Account.class);
    	Account account = query.setParameter("accountNumber", accountNumber).uniqueResult();
    	return account;

    }

    @Override
    @Transactional(readOnly = true)
    public List<Account> getAccountsByUserId(int userId) {
      
       
        		Session session=sessionFactory.getCurrentSession();
        	     Query<Account>	quary=session.createQuery("FROM Account WHERE userId = :userId", Account.class);
                 List<Account> accounts  =quary.setParameter("userId", userId).list();
                return accounts;
    }
}

