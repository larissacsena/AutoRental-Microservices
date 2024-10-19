package com.rentalcompany.personservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rentalcompany.personservice.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "persons")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_pessoa", discriminatorType = DiscriminatorType.STRING)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    protected UUID id;

    @NotBlank(message = "O preenchimento campo nome é obrigatório")
    @Column(name = "nome", nullable = false, length = 50)
    protected String name;

    @Past(message = "Data de aniversário incorreta")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "data_nascimento", nullable = false)
    protected LocalDate birthDate;

    @JsonProperty("CPF")
    @NotBlank(message = "Número do CPF não informado")
    @Pattern(regexp = "\\d{11}", message = "CPF inválido")
    @Column(nullable = false, unique = true, length = 11)
    protected String CPF;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo", nullable = false)
    protected Gender gender;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Informe o endereço de e-mail")
    @Column(name = "email", nullable = false, unique = true, length = 30)
    protected String email;

    @Column(name = "tipo_pessoa", nullable = false, insertable = false, updatable = false)
    protected String tipoPessoa = "Person";
}
