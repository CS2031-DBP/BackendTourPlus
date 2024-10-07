package com.dbp.backendtourplus.person.domain;

import com.dbp.backendtourplus.exceptions.ResourceNotFoundException;
import com.dbp.backendtourplus.person.infrastructure.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Long id, String firstname, String lastname) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + id));
        person.setFirstname(firstname);
        person.setLastname(lastname);
        return personRepository.save(person);
    }

    public void deleteById(Long id) {
        if (!personRepository.existsById(id)) {
            throw new ResourceNotFoundException("Person not found with id " + id);
        }
        personRepository.deleteById(id);
    }
}
