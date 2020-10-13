package com.zemsania.application.services;

import com.zemsania.application.entities.Producto;
import com.zemsania.application.entities.Venta;

import java.util.List;

public interface VentaService {

    public Iterable<Venta> getAllVentas();

    public Venta createVenta(Venta venta) throws Exception;

    public Venta readVenta(int id) throws Exception;
}
