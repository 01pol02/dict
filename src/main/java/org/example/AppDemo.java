package org.example;

import org.example.entity.Entity1;
import org.example.entity.Entity2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Entity1.class)
                .addAnnotatedClass(Entity2.class)
                .buildSessionFactory();

        Entity1 entity1_1 = new Entity1("en1_1");
        entity1_1.getMap1().put("key1", 0.11f);
        entity1_1.getMap1().put("key2", 0.11f);
        entity1_1.getMap1().put("key3", 0.11f);

        Entity1 entity1_2 = new Entity1("en1_2");
        entity1_2.getMap1().put("key1", 0.12f);
        entity1_2.getMap1().put("key2", 0.12f);
        entity1_2.getMap1().put("key3", 0.12f);

        Entity1 entity1_3 = new Entity1("en1_3");
        entity1_3.getMap1().put("key1", 0.13f);
        entity1_3.getMap1().put("key2", 0.13f);
        entity1_3.getMap1().put("key3", 0.13f);


        Entity2 entity2_1 = new Entity2("en2_1");
        entity2_1.getMap2().put("key1", 0.21f);
        entity2_1.getMap2().put("key2", 0.21f);
        entity2_1.getMap2().put("key3", 0.21f);

        Entity2 entity2_2 = new Entity2("en2_2");
        entity2_2.getMap2().put("key1", 0.22f);
        entity2_2.getMap2().put("key2", 0.22f);
        entity2_2.getMap2().put("key3", 0.22f);

        Entity2 entity2_3 = new Entity2("en2_3");
        entity2_3.getMap2().put("key1", 0.23f);
        entity2_3.getMap2().put("key2", 0.23f);
        entity2_3.getMap2().put("key3", 0.23f);

        entity1_1.getEntity2s().add(entity2_1);
        entity1_1.getEntity2s().add(entity2_2);
        entity2_2.getEntity1s().add(entity1_2);
        entity2_3.getEntity1s().add(entity1_2);
        entity2_3.getEntity1s().add(entity1_3);

        System.out.println("Save entity1 to db: ");
        System.out.println("----------------------------------------");

        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();
            session.save(entity1_1);
            session.save(entity2_2);
            session.save(entity2_3);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
