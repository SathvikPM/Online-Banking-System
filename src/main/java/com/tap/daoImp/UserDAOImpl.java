package com.tap.daoImp;

import com.tap.dao.UserDAO;
import com.tap.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByEmailAndPassword(String email, String password) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("FROM User WHERE email = :email AND password = :password", User.class);
        query.setParameter("email", email);
        query.setParameter("password", password);
        return query.uniqueResult();
    }
    
    @Override
    @Transactional(readOnly = true)
    public boolean emailExists(String email) {
    	 String hql = "SELECT count(*) FROM User WHERE email = :email";
    	 Query query = sessionFactory.getCurrentSession().createQuery(hql);
    	 query.setParameter("email", email);
    	 Long count = (Long) query.uniqueResult();
    	 return count > 0;
    	

    }
}
