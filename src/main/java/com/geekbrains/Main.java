package com.geekbrains;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();

        Session session = null;
        try {
            session = sessionFactoryUtils.getSession();
            session.beginTransaction();
            Product product = session.get(Product.class, 1l);
            System.out.println(product);
            session.getTransaction().commit();
        } finally {
            sessionFactoryUtils.shutdown();
            if (session != null) {
                session.close();
            }
        }

    }
}
