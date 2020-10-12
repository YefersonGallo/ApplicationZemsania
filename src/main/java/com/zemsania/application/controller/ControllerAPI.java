package com.zemsania.application.controller;

import com.zemsania.application.entities.Cliente;
import com.zemsania.application.entities.Producto;
import com.zemsania.application.entities.Venta;
import com.zemsania.application.services.ClienteService;
import com.zemsania.application.services.ProductoService;
import com.zemsania.application.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerAPI {

    @Autowired
    VentaService ventaService;

    @Autowired
    ProductoService productoService;

    @Autowired
    ClienteService clienteService;

    @GetMapping(value = "/clientes")
    public List<Cliente> getClientes(){
        return clienteService.getAllClientes();
    }

    @PostMapping(value = "/cliente")
    public String createCliente(@RequestBody Cliente cliente){
        try {
            clienteService.createCliente(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Creado";
    }

    @GetMapping(value = "/productos")
    public List<Producto> getProductos(){
        return productoService.getAllProductos();
    }

    @PostMapping(value = "/producto")
    public String createProducto(@RequestBody Producto producto){
        try {
            productoService.createProducto(producto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Creado";
    }

    @GetMapping(value = "/producto/{id}")
    public Producto getProducto(@PathVariable int id){
        Producto producto = null;
        try {
            producto = productoService.readProducto(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return producto;
    }

    @PutMapping(value = "/producto/{id}")
    public String updateProducto(@PathVariable int id, @RequestBody Producto producto){
        try {
            productoService.updateProducto(id, producto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Editado";
    }

    @DeleteMapping(value = "/producto/{id}")
    public String deleteProducto(@PathVariable int id){
        try {
            productoService.deleteProducto(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Borrado";
    }

    @PostMapping(value = "/venta")
    public String createVenta(@RequestBody Venta venta){
        try {
            ventaService.createVenta(venta);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Creado";
    }

    @GetMapping(value = "/ventas")
    public List<Venta> getVentas(){
        return ventaService.getAllVentas();
    }

    @GetMapping(value = "/venta/{id}")
    public Venta getVenta(@PathVariable int id){
        Venta venta = null;
        try {
            venta = ventaService.readVenta(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return venta;
    }
    
}
