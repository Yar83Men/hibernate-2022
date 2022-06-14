package com.hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "school")
public class School {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "number")
    private int number;

    @OneToOne
    @JoinColumn(name = "director_id", referencedColumnName = "id")
    private SchoolDirector director;

    public School() {
    }

    public School(int number) {
        this.number = number;
    }

    public School(int number, SchoolDirector director) {
        this.number = number;
        this.director = director;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public SchoolDirector getDirector() {
        return director;
    }

    public void setDirector(SchoolDirector director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", number=" + number +
               '}';
    }
}
