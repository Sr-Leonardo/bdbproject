package com.example.bdbproject.entities;

import javax.persistence.*;

@Entity
@Table(name = "father")
public class Father {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_father;

    @JoinColumn(name = "id_person", referencedColumnName = "id_person")
    @ManyToOne
    private Person id_person;

    public int getId_father() {
        return id_father;
    }

    public void setId_father(int id_father) {
        this.id_father = id_father;
    }

    public Person getId_person() {
        return id_person;
    }

    public void setId_person(Person id_person) {
        this.id_person = id_person;
    }
}
