package com.example.bdbproject.entities;

import javax.persistence.*;

@Entity
@Table(name = "mother")
public class Mother {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_mother;

    @JoinColumn(name = "id_person", referencedColumnName = "id_person")
    @ManyToOne
    private Person id_person;

    public int getId_mother() {
        return id_mother;
    }

    public void setId_mother(int id_mother) {
        this.id_mother = id_mother;
    }

    public Person getId_person() {
        return id_person;
    }

    public void setId_person(Person id_person) {
        this.id_person = id_person;
    }
}
