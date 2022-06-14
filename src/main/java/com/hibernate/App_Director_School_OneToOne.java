package com.hibernate;

import com.hibernate.model.School;
import com.hibernate.model.SchoolDirector;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App_Director_School_OneToOne {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(School.class)
                .addAnnotatedClass(SchoolDirector.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();
//            Создайте нового директора и новую школу и свяжите эти сущности
//            School school = new School(2);
//            SchoolDirector director = new SchoolDirector("Ivan", school);
//            school.setDirector(director);
//            session.save(director);
//            Получите любую школу, а затем получите ее директора
//            School school = session.get(School.class, 1);
//            System.out.println(school.getDirector());
//            Смените директора у существующей школы

            School school = session.get(School.class, 1);
            // SchoolDirector director = new SchoolDirector("Alice");

            // session.save(director);
            SchoolDirector director = session.get(SchoolDirector.class, 2);

            school.setDirector(director);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
