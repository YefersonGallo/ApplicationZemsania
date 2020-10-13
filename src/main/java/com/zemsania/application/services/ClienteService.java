package com.zemsania.application.services;

import com.zemsania.application.entities.Cliente;

import java.util.List;

public interface ClienteService {

    public Iterable<Cliente> getAllClientes();

    public Cliente createCliente(Cliente cliente);
}
