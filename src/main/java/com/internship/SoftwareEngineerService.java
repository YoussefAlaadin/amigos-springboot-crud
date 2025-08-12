package com.internship;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {
    private final SoftwareEngineerRepo softwareEngineerRepo;

    public SoftwareEngineerService(SoftwareEngineerRepo softwareEngineerRepo) {
        this.softwareEngineerRepo = softwareEngineerRepo;
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer){
       softwareEngineerRepo.save(softwareEngineer);
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepo.findAll();
    }
    public SoftwareEngineer getSoftwareEngineerById(Integer id){
        return softwareEngineerRepo.findById(id).orElse(null);
    }

    public SoftwareEngineer deleteSoftwareEngineer(Integer id) {
        // Check if the Software Engineer exists before attempting to delete
        // If it does not exist, throw an exception or return null
        // This prevents the deletion of a non-existent Software Engineer
        return softwareEngineerRepo.findById(id).map(softwareEngineer -> {
            softwareEngineerRepo.delete(softwareEngineer);
            return softwareEngineer;
        }).orElseThrow(() -> new RuntimeException("Software Engineer not found with id: " + id));
    }

    public SoftwareEngineer updateSoftwareEngineer(Integer id, SoftwareEngineer softwareEngineer) {
       return softwareEngineerRepo.findById(id).map(existingsoftwareEngineer -> {
            existingsoftwareEngineer.setName(softwareEngineer.getName());
            existingsoftwareEngineer.setTechStack(softwareEngineer.getTechStack());
            return softwareEngineerRepo.save(existingsoftwareEngineer);
        }).orElseThrow(() -> new RuntimeException("Software Engineer not found with id: " + id));
    }
}
