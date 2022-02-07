package com.example.bdbproject.controllers;

import com.example.bdbproject.entities.Person;
import com.example.bdbproject.repositories.PersonRepository;
import com.example.bdbproject.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping({"/person"})
public class PersonController {

    @Autowired
    IPersonService personService;

    @GetMapping()
    public List<PersonRepository.PeopleModel> getPeople() {
        return personService.getPeople();
    }

    @PostMapping()
    public boolean adopt(@RequestBody int idChild) {
        return personService.adopt(idChild);
    }

    @PostMapping("/validatePerson")
    public boolean existPerson(@RequestBody Person person){
        return personService.existPerson(person);
    }

    @PostMapping("/addChild")
    public void addChild(@RequestBody Person person){
        personService.addChild(person);
    }

    @DeleteMapping("/delete")
    public void delPerson(@RequestParam int id){
        personService.delPerson(id);
    }

    @GetMapping("/getChildren")
    public List<PersonRepository.PeopleModel> getChildren(){
        return personService.getChildren();
    }

    @PostMapping("/addFather")
    public void addFather(@RequestBody Person person) {
        personService.addFather(person);
    }

    @PostMapping("/addMother")
    public void addMother(@RequestBody Person person) {
        personService.addMother(person);
    }

    @GetMapping("/getFather")
    public boolean existFather() {
        return personService.existFather();
    }

    @GetMapping("/getMother")
    public boolean existMother() {
        return personService.existMother();
    }

}
