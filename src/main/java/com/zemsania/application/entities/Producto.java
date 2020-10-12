package com.zemsania.application.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native",strategy="native")
    private int idProducto;

    @Column
    private String nombre;

    @Column
    private Long precio;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="DetalleVenta",
            joinColumns=@JoinColumn(name="idProducto"),
            inverseJoinColumns=@JoinColumn(name="idVenta"))
    private List<Venta> ventas;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
