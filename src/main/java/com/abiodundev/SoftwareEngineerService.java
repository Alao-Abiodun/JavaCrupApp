package com.abiodundev;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineerById(
            Integer id
    ) {
        return softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                id + " not found "
        ));
    }

    public void deleteSoftwareEngineerById(
            Integer id
    ) {
        boolean isSoftwareEngineerExist = softwareEngineerRepository.existsById(id);
        if (!isSoftwareEngineerExist) {
            throw new IllegalStateException(
                    id + " not found"
            );
        }
        softwareEngineerRepository.deleteById(id);
    }

    public void updateSoftwareEngineerById(
            Integer id,
            SoftwareEngineer updatedSoftwareEngineer
    ) {
        SoftwareEngineer softwareEngineer = softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(id + " not found"));
        softwareEngineer.setName(updatedSoftwareEngineer.getName());
        softwareEngineer.setTechStack(updatedSoftwareEngineer.getTechStack());
        softwareEngineerRepository.save(softwareEngineer);
    }
}


