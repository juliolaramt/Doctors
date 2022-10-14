package com.usa.doctors.Repository;


import com.usa.doctors.Repository.CruRepository.MessageCrudRepository;
import com.usa.doctors.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> getAll() {
        return (List<Message>) messageCrudRepository.findAll();
    }

    public Optional<Message> getById(Integer idMessage) {
        return messageCrudRepository.findById(idMessage);
    }

    public Message save(Message message ){
        return messageCrudRepository.save(message);
    }
    public boolean delete(Message message){
        messageCrudRepository.delete(message);
        return true;
    }
}
