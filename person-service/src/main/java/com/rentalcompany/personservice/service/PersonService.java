package com.rentalcompany.personservice.service;

import com.rentalcompany.personservice.model.Person;
import com.rentalcompany.personservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAllPersons();
    }

    public List<Person> getAllEmployees() {
        return personRepository.findAllEmployees();
    }

    public Person getPersonById(UUID id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro não encontrado"));
    }

    public Person savePerson(Person person) {

            if (personRepository.findByCPF(person.getCPF()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um registro com esse CPF");
        }
        return personRepository.save(person);
    }

    public Person updatePerson(UUID id, Person updatedPerson) {
        return personRepository.findById(id)
                .map(person -> {
                    person.setName(updatedPerson.getName());
                    person.setBirthDate(updatedPerson.getBirthDate());
                    person.setCPF(updatedPerson.getCPF());
                    person.setGender(updatedPerson.getGender());
                    person.setEmail(updatedPerson.getEmail());
                    person.setTipoPessoa(updatedPerson.getTipoPessoa());
                    return personRepository.save(person);
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro não encontrado"));
    }

    public String deletePerson(UUID id) {
        if (!personRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro não encontrado");
        }
        personRepository.deleteById(id);
        return "Registro deletado com sucesso!";
    }
}