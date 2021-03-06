package org.felix.persons.model;

import java.util.Objects;

public class Person {
    private final String firstName;
    private final String lastName;

    public Person(String[] s) {
        firstName = s[0];
        lastName = s[1];
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Person(firstName='" + this.firstName + "', lastName='" + this.lastName + "')";
    }
}

