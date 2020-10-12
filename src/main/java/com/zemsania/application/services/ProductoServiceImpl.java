package com.zemsania.application.services;

import com.zemsania.application.entities.Producto;
import com.zemsania.application.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    ProductoRepository repository;

    @Override
    public Iterable<Producto> getAllProductos() {
        return repository.findAll();
    }
}
