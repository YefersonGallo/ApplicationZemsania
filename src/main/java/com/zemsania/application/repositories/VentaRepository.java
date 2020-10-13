package com.zemsania.application.repositories;

import com.zemsania.application.entities.Venta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository extends CrudRepository<Venta, Integer> {

    @Query(value ="SELECT * FROM detalle_venta d WHERE d.id_venta like ?1", nativeQuery = true)
    public List<Venta> findByIdCliente(int id);
}
