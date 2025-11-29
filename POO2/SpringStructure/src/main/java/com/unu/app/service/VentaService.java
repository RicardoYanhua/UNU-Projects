package com.unu.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.unu.app.entity.Venta;

public interface VentaService {
	
	public abstract List<Venta> Listar();
	public abstract Venta Insertar(Venta venta);
	public abstract void Eliminar(Integer id);
	public abstract void Actualizar(Venta venta);
	public abstract Venta Obtener(Integer id);
	
	public List<Venta> BuscarByAll(String busqueda);
	public Integer ObtenerLastId();
	
	public boolean isExistByIdVenta(Integer idVenta);
   

	
}
