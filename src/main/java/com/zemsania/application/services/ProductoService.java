package com.zemsania.application.services;

import com.zemsania.application.entities.Producto;

import java.util.List;

public interface ProductoService {

    public List<Producto> getAllProductos();

    public Producto createProducto(Producto producto) throws Exception;

    public Producto readProducto(int id) throws Exception;

    public Producto updateProducto(int id, Producto producto) throws Exception;

    public void deleteProducto(int id) throws Exception;

}
