package com.rentalcompany.vehicleservice.record;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record Vehicle(
        UUID id,
        String licensePlate,
        String chassis,
        String color,
        BigDecimal dailyRate,
        String imageURL,
        List<String> accessories,
        String carModel,
        List<LocalDate> occupiedDates
) {

    public boolean isAvailableForRent(LocalDate startingDate, LocalDate returnDate) {
        if (occupiedDates == null || occupiedDates.isEmpty()) {
            return true; // Se não houver datas ocupadas, está disponível
        }
        for (LocalDate date : occupiedDates) {
            if (!date.isBefore(startingDate) && !date.isAfter(returnDate)) {
                return false; // Não disponível se alguma data ocupada se sobrepõe ao intervalo
            }
        }
        return true; // Está disponível
    }
}
