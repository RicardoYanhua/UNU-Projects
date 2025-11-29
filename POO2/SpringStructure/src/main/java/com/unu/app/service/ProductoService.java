package com.unu.app.service;

import java.util.List;
import com.unu.app.entity.Producto;

public interface ProductoService {
	
	public abstract List<Producto> Listar();
	public abstract Producto Insertar(Producto producto);
	public abstract void Eliminar(Integer id);
	public abstract void Actualizar(Producto producto);
	public abstract Producto Obtener(int id);
	
	public List<Producto> BuscarByAll(String busqueda);
   

	
}
