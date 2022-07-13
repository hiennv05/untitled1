package com.vti;

import com.vti.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        testDelete();
    }

    static void testInsert() {
        Session session = HibernateUtils.getSessionFactory()
                .openSession();
        session.beginTransaction();

        Product product = new Product();
        product.setName("San pham 2");
        product.setPrice(100.9);
        product.setCreateDate(LocalDateTime.now());

        session.persist(product);
        session.getTransaction().commit();

    }

    static void testDelete() {
        Session session = HibernateUtils.getSessionFactory()
                .openSession();

        session.beginTransaction();
        Product product = session.find(Product.class, 3);
        if (product != null) {
          session.delete(product);
        }
        session.getTransaction().commit();

    }

    static void testSelect() {
        Session session = HibernateUtils.getSessionFactory()
                .openSession();

        session.beginTransaction();
        Product product = session.find(Product.class, 5);
        if (product != null) {
            product.setPrice(84.2);
            product.setName("new");
            session.update(product);
        }
        session.getTransaction().commit();
        System.out.println(product);
    }
}