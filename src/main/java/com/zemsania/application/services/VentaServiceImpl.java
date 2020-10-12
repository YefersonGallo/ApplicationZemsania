package com.zemsania.application.services;

import com.zemsania.application.entities.Venta;
import com.zemsania.application.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServiceImpl implements VentaService{

    @Autowired
    VentaRepository repository;

    @Override
    public List<Venta> getAllVentas() {
        return repository.findAll();
    }

    @Override
    public Venta createVenta(Venta venta) throws Exception {
        venta = repository.save(venta);
        return venta;
    }

    @Override
    public Venta readVenta(int id) throws Exception {
        Venta venta = repository.findById(id).get();
        return venta;
    }
}
