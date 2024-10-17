package com.rentalcompany.vehicleservice.service;

import com.rentalcompany.vehicleservice.model.VehicleTypeModel;
import com.rentalcompany.vehicleservice.repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VehicleTypeService {
    private final VehicleTypeRepository vehicleTypeRepository;

    @Autowired
    public VehicleTypeService(VehicleTypeRepository vehicleTypeRepository) {
        this.vehicleTypeRepository = vehicleTypeRepository;
    }

    public List<VehicleTypeModel> listAll() {
        return vehicleTypeRepository.findAll();
    }

    public Optional<VehicleTypeModel> findById(UUID id) {
        return vehicleTypeRepository.findById(id);
    }

    public VehicleTypeModel save(VehicleTypeModel vehicleTypeModel) {
        return vehicleTypeRepository.save(vehicleTypeModel);
    }

    public void delete(UUID id) {
        vehicleTypeRepository.deleteById(id);
    }

    public VehicleTypeModel update(UUID id, VehicleTypeModel updatedVehicleTypeModel) {
        Optional<VehicleTypeModel> existingVehicleType = vehicleTypeRepository.findById(id);

        if (existingVehicleType.isPresent()) {
            VehicleTypeModel vehicleTypeModel = existingVehicleType.get();
            vehicleTypeModel.setDescription(updatedVehicleTypeModel.getDescription());
            vehicleTypeModel.setCategory(updatedVehicleTypeModel.getCategory());
            vehicleTypeModel.setManufacturerModel(updatedVehicleTypeModel.getManufacturerModel());

            return vehicleTypeRepository.save(vehicleTypeModel);
        } else {
            throw new RuntimeException("Tipo de veículo não encontrado!");
        }
    }
}