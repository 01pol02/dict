package org.example;

import org.example.entity.Entity1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Entity1.class)
                .buildSessionFactory();


        Entity1 entity1 = new Entity1("en1_name");
        entity1.getMap1().put("key1", 0.1f);
        entity1.getMap1().put("key2", 0.2f);
        entity1.getMap1().put("key3", 0.3f);

        System.out.println("Save entity1 to db: ");
        System.out.println("----------------------------------------");

        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();
            session.save(entity1);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
