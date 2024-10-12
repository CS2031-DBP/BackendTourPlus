package com.dbp.backendtourplus.person.infrastructure;

import com.dbp.backendtourplus.AbstractContainerBaseTest;
import com.dbp.backendtourplus.person.domain.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonRepositoryTest extends AbstractContainerBaseTest {

    @Autowired
    private PersonRepository personRepository;

    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person();
        person.setFirstname("John");
        person.setLastname("Doe");
    }

    @Test
    void testSaveAndFindPerson() {
        Person savedPerson = personRepository.save(person);

        Person foundPerson = personRepository.findById(savedPerson.getId()).orElse(null);
        assertThat(foundPerson).isNotNull();
        assertThat(foundPerson.getFirstname()).isEqualTo("John");
        assertThat(foundPerson.getLastname()).isEqualTo("Doe");
    }
}
