package com.zemsania.application.services;

import com.zemsania.application.entities.Venta;
import com.zemsania.application.repositories.ClienteRepository;
import com.zemsania.application.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaServiceImpl implements VentaService{

    @Autowired
    VentaRepository repository;

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Iterable<Venta> getAllVentas() {
        return repository.findAll();
    }

    @Override
    public Venta createVenta(Venta venta) {
        venta = repository.save(venta);
        return venta;
    }

    @Override
    public Venta readVenta(int id){
        Venta venta = repository.findById(id).get();
        return venta;
    }

}
