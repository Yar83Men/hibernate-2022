package com.hibernate.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App_Actor_Film_ManyToMany {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Film.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Film film = new Film("Terminator 2", 1993);
//            Actor actor1 = new Actor("Arnold Shwartzenegger", 1945);
//            Actor actor2 = new Actor("Linda Humilton", 1956);
//            film.setActors(new ArrayList<>(List.of(actor1, actor2)));
//            actor1.setFilms(new ArrayList<>(List.of(film)));
//            actor2.setFilms(new ArrayList<>(List.of(film)));
//
//            session.save(actor1);
//            session.save(actor2);
//            session.save(film);
            Film film = new Film("Predator", 1984);
            Actor actor = session.get(Actor.class, 1);

            session.save(film);
            actor.getFilms().add(film);


            session.getTransaction().commit();
        }
    }
}
