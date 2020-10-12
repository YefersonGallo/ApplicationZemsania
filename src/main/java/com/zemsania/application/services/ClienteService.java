package com.zemsania.application.services;

import com.zemsania.application.entities.Cliente;

import java.util.List;

public interface ClienteService {

    public List<Cliente> getAllClientes();

    public Cliente createCliente(Cliente cliente) throws Exception;
}
