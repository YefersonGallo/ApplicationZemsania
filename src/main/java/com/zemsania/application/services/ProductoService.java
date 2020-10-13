package com.zemsania.application.services;

import com.zemsania.application.entities.Producto;

import java.util.List;

public interface ProductoService {

    public List<Producto> getAllProductos();

    public Producto createProducto(Producto producto) ;

    public Producto readProducto(int id) ;

    public Producto updateProducto(int id, Producto producto);

    public void deleteProducto(int id);

}
