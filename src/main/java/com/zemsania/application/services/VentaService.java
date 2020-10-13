package com.zemsania.application.services;

import com.zemsania.application.entities.Venta;


public interface VentaService {

    public Iterable<Venta> getAllVentas();

    public Venta createVenta(Venta venta);

    public Venta readVenta(int id);
}
