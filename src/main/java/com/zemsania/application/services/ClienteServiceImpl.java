package com.zemsania.application.services;

import com.zemsania.application.entities.Cliente;
import com.zemsania.application.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository repository;

    @Override
    public Iterable<Cliente> getAllClientes() {
        return repository.findAll();
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        cliente = repository.save(cliente);
        return cliente;
    }
}
