package com.vti;

import com.vti.entity.Product;
import org.hibernate.Session;

public class ProductRepository {
   public static Product findById(Integer id){
        Session session = HibernateUtils.getSessionFactory()
                .openSession();


       return session.find(Product.class, id);
    }
    public static  ()

}
