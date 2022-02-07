package com.example.bdbproject.controllers;

import com.example.bdbproject.repositories.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonControllerTest {

    PersonRepository personRepositoryMock = Mockito.mock(PersonRepository.class);

    @BeforeEach
    void setUp(){

        List<PersonRepository.PeopleModel> mockListModel = new ArrayList<>();
        List<PersonRepository.PeopleModel> mockListChildren = new ArrayList<>();

        PersonRepository.PeopleModel mockModel = new PersonRepository.PeopleModel() {
            @Override
            public Long getIdPerson() {
                return 1l;
            }

            @Override
            public String getFullName() {
                return "Leonardo Lara";
            }

            @Override
            public Date getBirth() {
                return new Date();
            }

            @Override
            public String getType() {
                return "Father";
            }
        };

        mockListModel.add(mockModel);
        Mockito.when(personRepositoryMock.getPeople()).thenReturn(mockListModel);

        PersonRepository.PeopleModel mockChild = new PersonRepository.PeopleModel() {
            @Override
            public Long getIdPerson() {
                return 2l;
            }

            @Override
            public String getFullName() {
                return "David Lara";
            }

            @Override
            public Date getBirth() {
                return new Date();
            }

            @Override
            public String getType() {
                return "Child";
            }
        };

        mockListChildren.add(mockChild);
        Mockito.when(personRepositoryMock.getChildren()).thenReturn(mockListChildren);

    }

    @Test
    void getPeople() {
        Assertions.assertEquals("Father", personRepositoryMock.getPeople().get(0).getType());
    }

    @Test
    void getChildren() {
        Assertions.assertEquals("Child", personRepositoryMock.getChildren().get(0).getType());
    }

}
