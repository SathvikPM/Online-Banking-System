
package com.tap.daoImp;

import com.tap.dao.TransactionDAO;
import com.tap.model.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TransactionDaoImpl implements TransactionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void saveTransaction(Transaction transaction) {
        Session session = sessionFactory.getCurrentSession();
        session.save(transaction);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Transaction> getTransactionsByAccountId(int accountId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Transaction> query = session.createQuery("FROM Transaction WHERE account.accountId = :accountId", Transaction.class);
        query.setParameter("accountId", accountId);
        return query.list();
    }
}
