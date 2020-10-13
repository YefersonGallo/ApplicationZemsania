package com.zemsania.application.controller;

import com.zemsania.application.entities.Cliente;
import com.zemsania.application.services.ClienteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerRESTCliente {

    private static final Logger logger = LogManager.getLogger(ControllerRESTCliente.class);

    @Autowired
    ClienteService clienteService;

    @GetMapping(value = "/clientes")
    public List<Cliente> getClientes(){
        return clienteService.getAllClientes();
    }

    @PostMapping(value = "/cliente")
    public String createCliente(@RequestBody Cliente cliente) {
        try {
            clienteService.createCliente(cliente);
        } catch (Exception e) {
            logger.error(e);
        }
        return "Creado";
    }
}
