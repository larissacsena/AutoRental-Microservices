package com.rentalcompany.personservice.model;

import jakarta.persistence.Entity;
import lombok.Data;


@Entity
@Data
public class Employee extends Person {
    public Employee() {
        super(); // Chama o construtor padrão da superclasse Person
    }
}
