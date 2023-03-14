package ru.netology.hibernate.repository;

import ru.netology.hibernate.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {

    @PersistenceContext
    private EntityManager entityManager;
    @SuppressWarnings("unchecked")
    public List<Person> getPersonsByCity(String city){
        return entityManager.createQuery("SELECT p FROM Person p WHERE p.cityOfLiving = :city")
                .setParameter("city", city)
                .getResultList();
    }
}
