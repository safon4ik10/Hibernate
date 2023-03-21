package ru.netology.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.repository.Repository;

import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    private final Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    @GetMapping("/persons/by-city")
    public String getPersonsByCity(String city) {
        return repository.findByCityOfLiving(city).toString();
    }

    @GetMapping("/persons/by-age")
    public String getPersonsByAge(int age) {
        return repository.findByIdAgeLessThanOrderByIdAge(age).toString();
    }

    @GetMapping("/persons/by-name-surname")
    public String getPersonsByNameSurname(String name, String surname) {
        Optional<Person> person = repository.findByIdNameAndIdSurname(name, surname);
        return person.map(Person::toString).orElse("Not found");
    }
}
