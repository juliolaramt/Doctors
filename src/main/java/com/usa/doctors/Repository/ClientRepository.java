package com.usa.doctors.Repository;

import com.usa.doctors.Repository.CruRepository.ClientCrudRepository;
import com.usa.doctors.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll() {
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getById(Integer idClient) {
        return clientCrudRepository.findById(idClient);
    }

    public Client save(Client client) {
        return clientCrudRepository.save(client);
    }

    public boolean delete(Client client) {
        clientCrudRepository.delete(client);
        return true;
    }
}

