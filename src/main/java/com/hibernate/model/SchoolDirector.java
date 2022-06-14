package com.hibernate.model;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "school_director")
public class SchoolDirector {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "director")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private School school;

    public SchoolDirector() {
    }

    public SchoolDirector(String name) {
        this.name = name;
    }

    public SchoolDirector(String name, School school) {
        this.name = name;
        this.school = school;
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

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "SchoolDirector{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
