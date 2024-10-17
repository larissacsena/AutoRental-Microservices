package com.rentalcompany.vehicleservice.record;

import java.util.UUID;

public record VehicleType(
        UUID id,
        String name,
        String description
) {
   //Outros métodos podem ser adicionados
}