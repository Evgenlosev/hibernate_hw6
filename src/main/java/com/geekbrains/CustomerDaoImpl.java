package com.geekbrains;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDaoImpl implements CustomerDao {
    private SessionFactoryUtils sessionFactoryUtils;

    public CustomerDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Customer findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            session.getTransaction().commit();
            return customer;
        }
    }

    @Override
    public List<Customer> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
        session.beginTransaction();
        List<Customer> customers = session.createQuery("select c from Customer c").getResultList();
        session.getTransaction().commit();
        return customers;
        }
    }


    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.createQuery("delete from Customer c where c.id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Product> findProductsByCustomerId(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createNativeQuery("SELECT * FROM products p JOIN products_customers ON p.id = products_customers.product_id WHERE customer_id = :id", Product.class)
                    .setParameter("id", id)
                    .getResultList();
            session.getTransaction().commit();
            return products;
        }
    }
}
