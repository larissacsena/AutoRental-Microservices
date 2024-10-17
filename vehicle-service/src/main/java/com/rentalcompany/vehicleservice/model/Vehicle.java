package com.rentalcompany.vehicleservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "carros")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_veiculo", discriminatorType = DiscriminatorType.STRING)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Placado carro é obrigatória!")
    @Column(name = "placa", nullable = false, unique = true, length = 7)
    private String licensePlate;

    @NotBlank(message = "Chassi é obrigatório!")
    @Column(name = "chassi", nullable = false, unique = true, length = 20)
    private String chassis;

    @NotBlank(message = "Cor do carro é obrigatória")
    @Column(name = "cor", nullable = false, length = 20)
    private String color;

    @Positive(message = "Valor da diária é obrigatório!")
    @Column(name = "valor_diaria", nullable = false)
    private BigDecimal dailyRate;

    @Column(name = "url_imagem")
    private String imageURL;

    @ManyToMany
    @JoinTable(
            name = "carro_acessorios",
            joinColumns = @JoinColumn(name = "carro_id"),
            inverseJoinColumns = @JoinColumn(name = "acessorio_id")
    )
    private List<AccessoryModel> accessories = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "modelo_id")
    @JsonBackReference("vehicleTypeReference")
    private VehicleTypeModel vehicleTypeModel;

    @ElementCollection
    @CollectionTable(name = "carro_datas_ocupadas", joinColumns = @JoinColumn(name = "carro_id"))
    @Column(name = "data_ocupada")
    private List<LocalDate> occupiedDates = new ArrayList<>();

    public boolean isAvailableForRent(LocalDate startingDate, LocalDate returnDate) {
        for (LocalDate data : occupiedDates) {
            if (!data.isBefore(startingDate) && !data.isAfter(returnDate)) {
                return false;
            }
        }
        return true;
    }

    public void blockDates(LocalDate startingDate, LocalDate returnDate) {
        LocalDate data = startingDate;
        while (!data.isAfter(returnDate)) {
            occupiedDates.add(data);
            data = data.plusDays(1);
        }
    }
}
