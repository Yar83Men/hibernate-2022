package com.hibernate;

import com.hibernate.model.Director;
import com.hibernate.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App_Director_Movie {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Director.class)
                .addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
//            С помощью Hibernate получите любого режиссера, а затем получите список
//            его фильмов
//            Director director = session.get(Director.class, 1);
//            List<Movie> movieList = director.getMovieList();
//            System.out.println(movieList);

//            Получите любой фильм, а затем получите его режиссера
//            Movie movie = session.get(Movie.class, 9);
//            Director director = movie.getDirector();
//            System.out.println(director);

//            Добавьте еще один фильм для любого режиссера
//            Director director = session.get(Director.class, 3);
//            Movie newMovie = new Movie("Карты деньги два ствола", director);
//            director.getMovieList().add(newMovie);
//            session.save(newMovie);

//            Создайте нового режиссера и новый фильм и свяжите эти сущности
//            Director director = new Director("Вуди Аллен");
//            Movie movie = new Movie("Молодой папа", director);
//
//            session.save(director);
//            session.save(movie);

//            Смените режиссера у существующего фильма
//            Movie movie = session.get(Movie.class, 1);
//            Director director = session.get(Director.class, 3);
//
//            movie.setDirector(director);

//            Удалите фильм у любого режиссера
            Movie movie = session.get(Movie.class, 5);

            session.remove(movie);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
