package com.hibernate.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "film")
public class Film {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "year_of_production")
    private int yearOfProduction;

    @ManyToMany(mappedBy = "films")
    private List<Actor> actors;

    public Film() {
    }

    public Film(String name, int yearOfProduction) {
        this.name = name;
        this.yearOfProduction = yearOfProduction;
    }

    public Film(String name, int yearOfProduction, List<Actor> actors) {
        this.name = name;
        this.yearOfProduction = yearOfProduction;
        this.actors = actors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id == film.id &&
                yearOfProduction == film.yearOfProduction &&
                Objects.equals(name, film.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, yearOfProduction);
    }
}
