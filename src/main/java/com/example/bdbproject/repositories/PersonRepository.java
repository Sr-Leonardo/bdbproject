package com.example.bdbproject.repositories;

import com.example.bdbproject.entities.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Query(value = "{Call GetPeople()}", nativeQuery = true)
    List<PeopleModel> getPeople();

    @Query(value = "{Call getChildren()}", nativeQuery = true)
    List<PeopleModel> getChildren();

    @Query(value = "SELECT Count(*) FROM person\n" +
            "WHERE full_Name = ?1 AND person.active = 1", nativeQuery = true)
    int existPerson(String name);

    @Query(value = "SELECT COUNT(*) FROM father \n" +
            "INNER JOIN person ON person.id_person = father.id_person\n" +
            "WHERE person.active = 1", nativeQuery = true)
    int existFather();

    @Query(value = "SELECT COUNT(*) FROM mother \n" +
            "INNER JOIN person ON person.id_person = mother.id_person\n" +
            "WHERE person.active = 1", nativeQuery = true)
    int existMother();

    @Query(value = "SELECT id_father FROM father\n" +
            "INNER JOIN person ON person.id_person = father.id_person\n" +
            "WHERE person.active = 1", nativeQuery = true)
    int getIdFather();

    @Query(value = "SELECT id_mother FROM mother\n" +
            "INNER JOIN person ON person.id_person = mother.id_person\n" +
            "WHERE person.active = 1", nativeQuery = true)
    int getIdMother();

    @Transactional
    @Modifying
    @Query(value = "UPDATE child\n" +
            "SET id_father = ?1 , id_mother = ?2\n" +
            "WHERE id_person = ?3", nativeQuery = true)
    void adoptChild(int idFather, int idMother, int idChild);

    @Transactional
    @Modifying
    @Query(value = "UPDATE person SET active = 0 WHERE id_Person = ?1", nativeQuery = true)
    void delPerson(int id);

    public static interface PeopleModel {

        Long getIdPerson();

        String getFullName();

        Date getBirth();

        String getType();
    }
}


