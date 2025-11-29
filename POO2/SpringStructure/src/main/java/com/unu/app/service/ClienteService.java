package com.unu.app.service;

import java.util.List;
import com.unu.app.entity.Cliente;

public interface ClienteService {
	
	public abstract List<Cliente> Listar();
	public abstract Cliente Insertar(Cliente cliente);
	public abstract void Eliminar(Integer id);
	public abstract void Actualizar(Cliente cliente);
	public abstract Cliente Obtener(int id);
	public abstract boolean isExistByDni(String dni);
	
	public List<Cliente> BuscarByAll(String busqueda);
    public List<Cliente> BuscarByDni(String busqueda);
    public List<Cliente> BuscarByNombre(String busqueda);
    public List<Cliente> BuscarByApellido(String busqueda);

	
}
