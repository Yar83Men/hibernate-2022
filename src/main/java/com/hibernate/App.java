package com.hibernate;

import com.hibernate.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

//            Person person = new Person("Arny", 73);
//            Person person1 = new Person("Sarah", 65);
//            Person person2 = new Person("Victor", 39);
//
//            session.save(person);
//            session.save(person1);
//            session.save(person2);
//            Person person = session.get(Person.class, 1);
//            System.out.println(person);

//            Person personUpdate = session.get(Person.class, 7);
//            personUpdate.setAge(25);

//            Person deletePerson = session.get(Person.class, 8);
//            session.delete(deletePerson);

            String allPeople = "FROM Person";
            String ageGreaterThen40 = "FROM Person WHERE age>40";
            String nameStartsOnLetterA = "FROM Person WHERE name LIKE 'A%'";
            String updatePersonWhereAgeGreater40 = "UPDATE Person SET name='Old' WHERE age>40";
            String deletePersonWhereNameEqualsOld = "DELETE Person WHERE name='Old'";
;

            // Update
            session.createQuery(updatePersonWhereAgeGreater40).executeUpdate();

            // Delete
            session.createQuery(deletePersonWhereNameEqualsOld).executeUpdate();

            List<Person> people = session.createQuery(allPeople).getResultList();

            System.out.println(people);
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}