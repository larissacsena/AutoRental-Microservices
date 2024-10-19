package com.rentalcompany.vehicleservice.service;

import com.rentalcompany.vehicleservice.model.ManufacturerModel;
import com.rentalcompany.vehicleservice.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerService(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }
    public List<ManufacturerModel> listAll() {
        return manufacturerRepository.findAll();
    }

    public Optional<ManufacturerModel> findById(UUID id) {
        return manufacturerRepository.findById(id);
    }

    public ManufacturerModel save(ManufacturerModel manufacturerModel) {
        return manufacturerRepository.save(manufacturerModel);
    }

    public void delete(UUID id) {
        manufacturerRepository.deleteById(id);
    }

    public ManufacturerModel update(UUID id, ManufacturerModel updatedManufacturerModel) {
        Optional<ManufacturerModel> existingManufacturer = manufacturerRepository.findById(id);

        if (existingManufacturer.isPresent()) {
            ManufacturerModel manufacturerModel = existingManufacturer.get();
            manufacturerModel.setName(updatedManufacturerModel.getName());

            return manufacturerRepository.save(manufacturerModel);
        } else {
            throw new RuntimeException("Fabricante não encontrado!");
        }
    }
}
