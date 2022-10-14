package com.usa.doctors.Repository;

import com.usa.doctors.Repository.CruRepository.DoctorCrudRepository;
import com.usa.doctors.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Repository
public class DoctorRepository {
    @Autowired
    private DoctorCrudRepository doctorCrudRepository;

    public List<Doctor> getAll() {
        return (List<Doctor>) doctorCrudRepository.findAll();
    }

    public Optional<Doctor> getById(Integer idDoctor) {
        return doctorCrudRepository.findById(idDoctor);
    }

    public Doctor save(Doctor doctor ){
        return doctorCrudRepository.save(doctor);
    }
    public boolean delete(Doctor doctor){
        doctorCrudRepository.delete(doctor);
        return true;
    }

}
