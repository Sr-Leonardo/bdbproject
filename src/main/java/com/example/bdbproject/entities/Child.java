package com.example.bdbproject.entities;

import javax.persistence.*;

@Entity
@Table(name = "child")
public class Child {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_child;

    @JoinColumn(name = "id_person", referencedColumnName = "id_person")
    @ManyToOne
    private Person id_person;

    @JoinColumn(name = "id_father", referencedColumnName = "id_father")
    @ManyToOne
    private Father id_father;

    @JoinColumn(name = "id_mother", referencedColumnName = "id_mother")
    @ManyToOne
    private Mother id_mother;

    public int getId_child() {
        return id_child;
    }

    public void setId_child(int id_child) {
        this.id_child = id_child;
    }

    public Person getId_person() {
        return id_person;
    }

    public void setId_person(Person id_person) {
        this.id_person = id_person;
    }

    public Father getId_father() {
        return id_father;
    }

    public void setId_father(Father id_father) {
        this.id_father = id_father;
    }

    public Mother getId_mother() {
        return id_mother;
    }

    public void setId_mother(Mother id_mother) {
        this.id_mother = id_mother;
    }
}
