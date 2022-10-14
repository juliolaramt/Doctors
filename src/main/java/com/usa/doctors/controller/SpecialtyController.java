package com.usa.doctors.controller;

import com.usa.doctors.model.Specialty;
import com.usa.doctors.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Specialty")
@CrossOrigin(origins = "*", methods ={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class SpecialtyController {
    @Autowired
    private SpecialtyService specialtyService;
    @GetMapping("/all")
    public List<Specialty> getSpecialtys(){
        return specialtyService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Specialty> getSpecialtyOptional(@PathVariable ("id") Integer id){
        return specialtyService.getById(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Specialty saveSpecialty(@RequestBody Specialty specialty){
        return  specialtyService.save(specialty);
    }

    @DeleteMapping("/{idClient}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable ("idClient") Integer id){
        return specialtyService.delete(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Specialty update(@RequestBody Specialty specialty){
        return specialtyService.update(specialty);
    }

}
