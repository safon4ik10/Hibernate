package ru.netology.hibernate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONS")
@Data
@NoArgsConstructor
@IdClass(PersonKey.class)
public class Person {
    @Id
    private String name;
    @Id
    private String surname;
    @Id
    private int age;
    private String phoneNumber;
    private String cityOfLiving;

    public PersonKey getId() {
        return new PersonKey(name, surname, age);
    }

    public void setId(PersonKey personKey){
        this.name = personKey.getName();
        this.surname = personKey.getSurname();
        this.age = personKey.getAge();
    }
}
