package com.rentalcompany.vehicleservice.record;

import java.util.UUID;
import java.math.BigDecimal;

public record Accessory(
        UUID id,
        String name,
        String description
) {
    //Outros métodos podem ser adicionados
}

