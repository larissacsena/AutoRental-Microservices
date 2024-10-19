package com.rentalcompany.vehicleservice.service;

import com.rentalcompany.vehicleservice.model.AccessoryModel;
import com.rentalcompany.vehicleservice.repository.AccessoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccessoryService {

    private final AccessoryRepository accessoryRepository;

    @Autowired
    public AccessoryService(AccessoryRepository accessoryRepository) {
        this.accessoryRepository = accessoryRepository;
    }

    public List<AccessoryModel> listAll() {
        return accessoryRepository.findAll();
    }

    public AccessoryModel update(UUID id, AccessoryModel updatedAccessoryModel) {
        Optional<AccessoryModel> existingAccessory = accessoryRepository.findById(id);

        if (existingAccessory.isPresent()) {
            AccessoryModel accessoryModel = existingAccessory.get();
            accessoryModel.setName(updatedAccessoryModel.getName());
            accessoryModel.setDescription(updatedAccessoryModel.getDescription());


            return accessoryRepository.save(accessoryModel);
        } else {
            throw new RuntimeException("Accessory not found!");
        }
    }

    public Optional<AccessoryModel> findById(UUID id) {
        return accessoryRepository.findById(id);
    }

    public AccessoryModel save(AccessoryModel accessoryModel) {
        return accessoryRepository.save(accessoryModel);
    }

    public void delete(UUID id) {
        accessoryRepository.deleteById(id);
    }
}
