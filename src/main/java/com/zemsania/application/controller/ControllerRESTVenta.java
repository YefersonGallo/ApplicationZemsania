package com.zemsania.application.controller;

import com.zemsania.application.entities.Venta;
import com.zemsania.application.services.VentaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerRESTVenta {

    private static final Logger logger = LogManager.getLogger(ControllerRESTVenta.class);

    @Autowired
    VentaService ventaService;

    @GetMapping(value = "/ventas")
    public Iterable<Venta> getVentas(){
        return ventaService.getAllVentas();
    }

    @GetMapping(value = "/venta/{id}")
    public ResponseEntity<?> getVenta(@PathVariable int id) {
        Venta venta = null;
        try {
            venta = ventaService.readVenta(id);
        } catch (Exception e) {
            logger.error(e);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(venta);
    }

}
