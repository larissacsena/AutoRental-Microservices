package com.rentalcompany.vehicleservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.rentalcompany.vehicleservice.enums.Category;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "modelos_veiculo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleTypeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "descricao", length = 500, nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 25)
    private Category category;

    @OneToMany(mappedBy = "vehicleType", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("vehicleTypeReference")
    private List<VehicleModel> vehicles;

    @ManyToOne
    @JoinColumn(name = "fabricante_id", nullable = false)
    @JsonBackReference("manufacturerReference")
    private ManufacturerModel manufacturer;
}
