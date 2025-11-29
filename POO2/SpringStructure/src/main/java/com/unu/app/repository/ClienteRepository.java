package com.unu.app.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.unu.app.entity.Cliente;

@Repository("clienteRepository")
public interface ClienteRepository extends JpaRepository<Cliente, Serializable>{
	
	@Query("SELECT obj FROM Cliente obj WHERE obj.dni = :dni")
    public Optional<Cliente> isExistByDni(@Param("dni") String dni);
	
	@Query("SELECT obj FROM Cliente obj WHERE "
	        + "(obj.dni LIKE CONCAT( :busqueda, '%') OR "
	        + "obj.nombre LIKE CONCAT( :busqueda, '%') OR "
	        + "obj.apellido LIKE CONCAT( :busqueda, '%'))")
	public List<Cliente> BuscarByAll(@Param("busqueda") String busqueda);
	
	@Query("SELECT obj FROM Cliente obj WHERE "
			+ "obj.dni LIKE CONCAT( :busqueda, '%')")
    public List<Cliente> BuscarByDni(@Param("busqueda") String busqueda);
	
	@Query("SELECT obj FROM Cliente obj WHERE "
			+ "obj.nombre LIKE CONCAT( :busqueda, '%')")
    public List<Cliente> BuscarByNombre(@Param("busqueda") String busqueda);
	
	@Query("SELECT obj FROM Cliente obj WHERE "
			+ "obj.apellido LIKE CONCAT( :busqueda, '%')")
    public List<Cliente> BuscarByApellido(@Param("busqueda") String busqueda);
}




