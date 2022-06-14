package com.hibernate;

import com.hibernate.model.Passport;
import com.hibernate.model.Person;
import com.hibernate.model.Person_with_Passport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App_OneToOne {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person_with_Passport.class)
                .addAnnotatedClass(Passport.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
//            Person_with_Passport person = new Person_with_Passport("Alex", 44);
//            Passport passport = new Passport(person, 123456);
//            person.setPassport(passport);
//
//            session.save(person);
//            Passport passport = session.get(Passport.class, 7);
//            System.out.println(passport.getPerson());
            Person_with_Passport person = session.get(Person_with_Passport.class, 7);
            System.out.println(person.getPassport());

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
