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

    @DeleteMapping("{id}")
    public SoftwareEngineer deleteSoftwareEngineer(@PathVariable Integer id) {
      return   softwareEngineerService.deleteSoftwareEngineer(id);

    }

   /* @PutMapping("{id}")
    public SoftwareEngineer updateSoftwareEngineer(@PathVariable Integer id, @RequestBody SoftwareEngineer softwareEngineer) {
        SoftwareEngineer existingSoftwareEngineer = softwareEngineerService.getSoftwareEngineerById(id);
        if (existingSoftwareEngineer != null) {
            existingSoftwareEngineer.setName(softwareEngineer.getName());
            existingSoftwareEngineer.setTechStack(softwareEngineer.getTechStack());
            softwareEngineerService.insertSoftwareEngineer(existingSoftwareEngineer);
            return existingSoftwareEngineer;
        } else {
            throw new RuntimeException("Software Engineer not found with id: " + id);
        }*/

    @PutMapping("{id}")
    public SoftwareEngineer updateSoftwareEngineer(@PathVariable Integer id, @RequestBody SoftwareEngineer softwareEngineer) {
        return softwareEngineerService.updateSoftwareEngineer(id, softwareEngineer);
    }

}
