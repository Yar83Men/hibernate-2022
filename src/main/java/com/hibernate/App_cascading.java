package com.hibernate;

import com.hibernate.model.Item;
import com.hibernate.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;


public class App_cascading {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Person person = new Person("Andy", 34);
            Item item1 = new Item("Test Item1");
            Item item2 = new Item("Test Item2");
            Item item3 = new Item("Test Item3");
            //person.setItems(new ArrayList<>(Collections.singletonList(item)));
            person.addItem(item1);
            person.addItem(item2);
            person.addItem(item3);

//            session.persist(person);
            session.save(person);
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
