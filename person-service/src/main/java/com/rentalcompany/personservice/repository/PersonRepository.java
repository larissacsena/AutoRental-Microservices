package com.rentalcompany.personservice.repository;

import com.rentalcompany.personservice.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {

    Optional<Person> findByCpf(String cpf);

    @Query("SELECT p FROM Person p WHERE TYPE(p) = Person")
    List<Person> findAllPersons();

    @Query("SELECT p FROM Person p WHERE TYPE(p) = Employee")
    List<Person> findAllEmployees();
}
