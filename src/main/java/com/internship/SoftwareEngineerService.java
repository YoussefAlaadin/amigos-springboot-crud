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
}
