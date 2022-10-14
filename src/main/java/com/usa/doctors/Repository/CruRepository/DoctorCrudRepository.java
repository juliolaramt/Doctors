package com.usa.doctors.Repository.CruRepository;

import com.usa.doctors.model.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorCrudRepository extends CrudRepository<Doctor, Integer> {
}
