package com.rentalcompany.vehicleservice.record;

import java.util.UUID;

public record Manufacturer(
        UUID id,
        String name,
        String country
) {
    //Outros métodos podem ser adicionados
}
