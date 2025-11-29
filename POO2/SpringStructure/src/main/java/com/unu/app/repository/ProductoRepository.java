package com.unu.app.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.unu.app.entity.Producto;

@Repository("productoRepository")
public interface ProductoRepository extends JpaRepository<Producto, Serializable>{
	
	@Query("SELECT obj FROM Producto obj WHERE "
	        + "obj.nombre LIKE CONCAT( :busqueda, '%')")
	
	public List<Producto> BuscarByAll(@Param("busqueda") String busqueda);
	

}




