package com.example.bdbproject.services.impl;

import com.example.bdbproject.entities.*;
import com.example.bdbproject.repositories.ChildRepository;
import com.example.bdbproject.repositories.FatherRepository;
import com.example.bdbproject.repositories.MotherRepository;
import com.example.bdbproject.repositories.PersonRepository;
import com.example.bdbproject.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ChildRepository childRepository;

    @Autowired
    FatherRepository fatherRepository;

    @Autowired
    MotherRepository motherRepository;

    @Override
    public List<PersonRepository.PeopleModel> getPeople() {
        return personRepository.getPeople();
    }

    @Override
    public List<PersonRepository.PeopleModel> getChildren() {
        return personRepository.getChildren();
    }

    @Override
    public boolean adopt(int idChild) {
        if (!existFather() && !existMother()) {
            int idFather = personRepository.getIdFather();
            int idMother = personRepository.getIdMother();
            personRepository.adoptChild(idFather, idMother, idChild);
        } else
            return false;

        return true;
    }

    @Override
    public boolean existFather() {
        if (personRepository.existFather() > 0)
            return false;
        else
            return true;
    }

    @Override
    public boolean existPerson(Person person) {

        if (personRepository.existPerson(person.getFull_name()) > 0)
            return false;
        else
            return true;

    }

    @Override
    public boolean existMother() {
        if (personRepository.existMother() > 0)
            return false;
        else
            return true;
    }

    @Override
    public void addFather(Person person) {
        personRepository.save(person);
        Father father = new Father();
        father.setId_person(person);
        fatherRepository.save(father);
    }

    @Override
    public void addChild(Person person) {
        personRepository.save(person);
        Child child = new Child();
        child.setId_person(person);
        childRepository.save(child);
    }

    @Override
    public void addMother(Person person) {
        personRepository.save(person);
        Mother mother = new Mother();
        mother.setId_person(person);
        motherRepository.save(mother);
    }

    @Override
    public void delPerson(int id) {
        personRepository.delPerson(id);
    }
}
