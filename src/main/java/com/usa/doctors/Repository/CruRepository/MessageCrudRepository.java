package com.usa.doctors.Repository.CruRepository;

import com.usa.doctors.model.Doctor;
import com.usa.doctors.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
