package com.unu.app.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.unu.app.entity.Venta;

@Repository("ventaRepository")
public interface VentaRepository extends JpaRepository<Venta, Serializable>{
		
	@Query("SELECT obj FROM Venta obj WHERE obj.id = :id")
    public Optional<Venta> isExistByIdVenta(@Param("id") int idVenta);
	
	@Query(value = "SELECT MAX(id) FROM ventas", nativeQuery = true)
    public Integer getNewId();
}




