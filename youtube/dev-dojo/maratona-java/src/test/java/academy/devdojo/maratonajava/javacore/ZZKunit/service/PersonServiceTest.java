package academy.devdojo.maratonajava.javacore.ZZKunit.service;

import academy.devdojo.maratonajava.javacore.ZZKunit.dominio.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {

    @Test
    @DisplayName("A person should be not adult when age is lower than 18")
    void isAdult_returnFalse_WhenAgeIsLowerThan18() {
        Person person = new Person(15);
        PersonService personService = new PersonService();
        Assertions.assertFalse(personService.isAdult(person));
//        assertFalse(personService.isAdult(person));
    }
}