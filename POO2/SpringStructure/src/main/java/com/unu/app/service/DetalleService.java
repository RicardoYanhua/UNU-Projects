package com.unu.app.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.unu.app.entity.DetalleVenta;
import com.unu.app.entity.Venta;

public interface DetalleService {
	
	public abstract List<DetalleVenta> Listar();
	public abstract DetalleVenta Insertar(DetalleVenta detalle);
	public abstract void Eliminar(Integer id);
	public abstract void Actualizar(DetalleVenta detalle);
	public abstract DetalleVenta Obtener(int id);
	
	public List<DetalleVenta> BuscarByAll(String busqueda);
	public List<DetalleVenta> ListarDetalleBy_IdVenta(int id);
	public List<DetalleVenta> ListarDetalleBy_ObjVenta(Venta venta);
	public Double obtenerTotalByIdVenta(Integer id);
	
}
