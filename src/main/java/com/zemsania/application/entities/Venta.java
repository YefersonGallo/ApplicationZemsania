package com.zemsania.application.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Venta implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native",strategy="native")
    private int idVenta;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cliente cliente;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="DetalleVenta",
            joinColumns=@JoinColumn(name="idVenta"),
            inverseJoinColumns=@JoinColumn(name="idProducto"))
    private List<Producto> productos;

    public Venta() {
        productos = new ArrayList<>();
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProdctos(List<Producto> prodctos) {
        this.productos = prodctos;
    }

    public void addProducto(Producto producto){
        this.productos.add(producto);
    }

    public void removeProducto(Producto producto){
        this.productos.remove(producto);
    }

    @Override
    public String toString() {
        return "Venta{" +
                "idVenta=" + idVenta +
                ", idCliente=" + cliente.getIdCliente() +
                ", fecha=" + fecha +
                ", productos=" + productos.toString() +
                '}';
    }
}
