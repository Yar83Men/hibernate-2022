package com.hibernate.model;

import javax.persistence.*;


@Entity
@Table(name = "passport")
public class Passport {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person_with_Passport person;

    @Column(name = "passport_number")
    private int passportNumber;

    public Passport() {}

    public Passport(Person_with_Passport person, int passportNumber){
        this.person = person;
        this.passportNumber = passportNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person_with_Passport getPerson() {
        return person;
    }

    public void setPerson(Person_with_Passport person) {
        this.person = person;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", person=" + person +
                ", passportNumber=" + passportNumber +
                '}';
    }
}
