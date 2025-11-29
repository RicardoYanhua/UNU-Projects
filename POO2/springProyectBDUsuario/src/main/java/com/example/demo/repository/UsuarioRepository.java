package com.example.demo.repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.*;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;

/*
ES UNA CAPA PARA INTERACTUAR CON LA BASE DE DATOS.

ES UN REPOSITORIO QUE SE ENCARGA DE REALIZAR OPERACIONES CRUD (CREAR, LEER, ACTUALIZAR Y ELIMINAR) SOBRE LA ENTIDAD USUARIO.
*/

@Repository("usuariorepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable>{
	
	// Ejemplo de consulta personalizada con @Query
    @Query("SELECT t FROM TuEntidad t WHERE t.fecha BETWEEN :inicio AND :fin")
    List<Usuario> findByFechaRango(@Param("inicio") LocalDate inicio, @Param("fin") LocalDate fin);

    // Consulta nativa
    @Query(value = "SELECT * FROM tu_tabla WHERE columna = :valor", nativeQuery = true)
    List<Usuario> consultaNativa(@Param("valor") String valor);
    
    @Query(name = "TuEntidad.buscarPorNombre")
    List<TuEntidad> buscarPorNombre(@Param("nombre") String nombre);
    
}

@Entity
@NamedQuery(name = "TuEntidad.buscarPorNombre", query = "SELECT t FROM TuEntidad t WHERE t.nombre = :nombre")
 class TuEntidad {
    // atributos, getters, setters
}




