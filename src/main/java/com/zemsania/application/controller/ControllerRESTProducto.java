package com.zemsania.application.controller;

import com.zemsania.application.entities.Producto;
import com.zemsania.application.services.ProductoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerRESTProducto {

    private static final Logger logger = LogManager.getLogger(ControllerRESTProducto.class);

    @Autowired
    ProductoService productoService;

    @GetMapping(value = "/productos")
    public List<Producto> getProductos(){
        return productoService.getAllProductos();
    }

    @PostMapping(value = "/producto")
    public String createProducto(@RequestBody Producto producto) {
        try {
            productoService.createProducto(producto);
        } catch (Exception e) {
            logger.error(e);
        }
        return "Creado";
    }

    @GetMapping(value = "/producto/{id}")
    public Producto getProducto(@PathVariable int id){
        Producto producto = null;
        try {
            producto = productoService.readProducto(id);
        } catch (Exception e) {
            logger.error(e);
        }
        return producto;
    }

    @PutMapping(value = "/producto/{id}")
    public String updateProducto(@PathVariable int id, @RequestBody Producto producto) {
        try {
            productoService.updateProducto(id, producto);
        } catch (Exception e) {
            logger.error(e);
        }
        return "Editado";
    }

    @DeleteMapping(value = "/producto/{id}")
    public String deleteProducto(@PathVariable int id) {
        try {
            productoService.deleteProducto(id);
        } catch (Exception e) {
            logger.error(e);
        }
        return "Borrado";
    }

}
