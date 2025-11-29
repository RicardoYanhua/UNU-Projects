package com.unu.app.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "dni", nullable = false, length = 8, unique = true)
	private String dni;

	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;

	@Column(name = "apellido", nullable = false, length = 100)
	private String apellido;

	@Column(name = "correo", nullable = false, length = 100)
	private String correo;

	@Column(name = "telefono", nullable = false, length = 9)
	private String telefono;

	@Column(name = "edad", nullable = false)
	private Integer edad;

	@Column(name = "genero", nullable = false, length = 1)
	private String genero;

	@Column(name = "salario", nullable = false)
	private Double salario;

	@Column(name = "fecha_nacimiento", nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaNacimiento;

	public enum EstadoCivil {
		SOLTERO, CASADO, DIVORCIADO, VIUDO
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "estado_civil", nullable = false)
	private EstadoCivil estadoCivil;

	@Column(name = "activo", nullable = false)
	private Boolean activo = true;

	@Column(name = "fecha_registro", nullable = false, updatable = false)
	private LocalDate fechaRegistro;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Venta> ventas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public String getGeneroText() {
	    switch (genero.charAt(0)) {
	        case 'F':
	            return "Femenino";
	        case 'M':
	            return "Masculino";
	        default:
	            return apellido;
	    }
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	
	public String getEstadoCivilText() {
	    return estadoCivil.toString().toUpperCase();
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Boolean getActivo() {
		return activo;
	}
	
	public String getActivoText() {
		if(activo) {
			return "on";
		}
		return "";
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

}
