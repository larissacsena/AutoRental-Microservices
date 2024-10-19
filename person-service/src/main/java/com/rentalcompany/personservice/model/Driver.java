package com.rentalcompany.personservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "motoristas")
public class Driver{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", unique = true)
    private UUID id;

    @NotBlank(message = "CNH é obrigatória!")
    @Column(name = "CNH", nullable = false, unique = true, length = 11)
    private String driverLicenseNumber;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;
}
