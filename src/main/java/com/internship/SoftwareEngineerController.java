package com.internship;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/software-engineer")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;
    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }
    @GetMapping
    public List<SoftwareEngineer> getAllSoftwareEngineers(){
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    @PostMapping
    public void addNewSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer){
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }

    @GetMapping( "{id}")
    public SoftwareEngineer getSoftwareEngineerById(@PathVariable Integer id){
        return softwareEngineerService.getSoftwareEngineerById(id);
    }

}
