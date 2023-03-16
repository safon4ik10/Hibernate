package ru.netology.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Objects;

@IdClass(PersonKey.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonKey implements Serializable {
    private String name;
    private String surname;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonKey personKey = (PersonKey) o;
        return age == personKey.age && name.equals(personKey.name) && surname.equals(personKey.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }
}
