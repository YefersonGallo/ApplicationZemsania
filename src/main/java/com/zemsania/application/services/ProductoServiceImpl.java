package com.zemsania.application.services;

import com.zemsania.application.entities.Producto;
import com.zemsania.application.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    ProductoRepository repository;

    @Override
    public List<Producto> getAllProductos() {
        return repository.findAll();
    }

    @Override
    public Producto createProducto(Producto producto) throws Exception {
        producto = repository.save(producto);
        return producto;
    }

    @Override
    public Producto readProducto(int id) throws Exception {
        Producto producto = repository.findById(id).get();
        return producto;
    }

    @Override
    public Producto updateProducto(int id, Producto producto) throws Exception {
        Producto productoAux = repository.findById(id).get();
        productoAux.setNombre(producto.getNombre());
        productoAux.setPrecio(producto.getPrecio());
        return productoAux;
    }

    @Override
    public void deleteProducto(int id) throws Exception {
        Producto producto = repository.findById(id).get();
        repository.delete(producto);
    }

}
