package com.tap.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//the explicit configuration statement like Configuration configuration = new Configuration().configure(); 
//88is not needed because Spring handles it implicitly when it processes your AppConfig class

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.tap")
public class AppConfig {

    

    //The DataSource is used by Hibernate to connect to the database.
    @Bean
    public DataSource dataSource() {
       
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/onlinebanking");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

  //The LocalSessionFactoryBean is a Spring-provided factory bean that creates a Hibernate SessionFactory.
  //sessionFactory.setPackagesToScan("com.tap.model");, Spring will automatically scan the specified package (in this case, com.tap.model) for all annotated entity classes.
   //This means you do not need to individually add each annotated class using methods like cfg.addAnnotatedClass(Customer.class);.
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean(); 
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.tap.model"); 
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    //This method creates a Properties object and sets Hibernate properties
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "update");
        return properties;
    }

    //This bean is crucial for managing transactions in your Hibernate-based application
    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
       
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }
}
