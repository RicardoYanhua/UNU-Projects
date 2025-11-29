package com.unu.app.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.unu.app.entity.DetalleVenta;
import com.unu.app.entity.Venta;

@Repository("detalleVentaRepository")
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Serializable>{
	
	@Query("SELECT obj FROM DetalleVenta obj WHERE (obj.venta = :id)")
	public List<DetalleVenta> ListarDetalleBy_IdVenta(@Param("id") int id);
	
	@Query("SELECT obj FROM DetalleVenta obj WHERE obj.venta = :obj")
	public List<DetalleVenta> ListarDetalleBy_ObjVenta(@Param("obj") Venta venta);
	
	@Query("SELECT SUM(obj.total) FROM DetalleVenta obj WHERE obj.venta = :idVenta")
    public Double obtenerTotalByIdVenta(@Param("idVenta") Integer id);
	
}




