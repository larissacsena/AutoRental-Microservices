package com.rentalcompany.vehicleservice.service;

import com.rentalcompany.vehicleservice.model.VehicleModel;
import com.rentalcompany.vehicleservice.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<VehicleModel> listAll() {
        return vehicleRepository.findAll();
    }

    public VehicleModel findById(UUID id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado: " + id));
    }

    public VehicleModel save(VehicleModel vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(UUID id) {
        if (!vehicleRepository.existsById(id)) {
            throw new RuntimeException("Veículo não encontrado: " + id);
        }
        vehicleRepository.deleteById(id);
    }

    public VehicleModel update(UUID id, VehicleModel updatedVehicle) {
        Optional<VehicleModel> existingVehicle = vehicleRepository.findById(id);

        if (existingVehicle.isPresent()) {
            VehicleModel vehicle = existingVehicle.get();

            vehicle.setLicensePlate(updatedVehicle.getLicensePlate());
            vehicle.setChassis(updatedVehicle.getChassis());
            vehicle.setColor(updatedVehicle.getColor());
            vehicle.setDailyRate(updatedVehicle.getDailyRate());
            vehicle.setImageURL(updatedVehicle.getImageURL());
            vehicle.setVehicleType(updatedVehicle.getVehicleType());
            vehicle.setAccessories(updatedVehicle.getAccessories());
            return vehicleRepository.save(vehicle);
        } else {
            throw new RuntimeException("Vehicle not found!");
        }
    }

    public void delete(UUID id) {
        Optional<VehicleModel> existingVehicle = vehicleRepository.findById(id);

        if (existingVehicle.isPresent()) {
            vehicleRepository.deleteById(id);
        } else {
            throw new RuntimeException("Vehicle not found!");
        }
    }

    public boolean checkAvailability(UUID id, LocalDate startDate, LocalDate endDate) {
        return vehicleRepository.findById(id)
                .map(vehicle -> vehicle.isAvailableForRent(startDate, endDate))
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado!"));
    }

}
