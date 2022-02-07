package com.example.bdbproject.services;


import com.example.bdbproject.entities.Person;
import com.example.bdbproject.repositories.PersonRepository;

import java.util.List;

public interface IPersonService {

    List<PersonRepository.PeopleModel> getPeople();

    List<PersonRepository.PeopleModel> getChildren();

    boolean adopt(int idChild);

    boolean existPerson(Person person);

    boolean existFather();

    boolean existMother();

    void addFather(Person person);

    void addChild(Person person);

    void addMother(Person person);

    void delPerson(int id);

}
