package ru.netology.hibernate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.entity.PersonId;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends CrudRepository<Person, PersonId> {

    List<Person> findByCityOfLiving(@Param("cityOfLiving") String cityOfLiving);

    List<Person> findByIdAgeLessThanOrderByIdAge(@Param("age") int age);

    Optional<Person> findByIdNameAndIdSurname(@Param("name") String name, @Param("surname") String surname);
}
