package com.unu.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import com.unu.app.entity.Cliente;
import com.unu.app.entity.Cliente.EstadoCivil;
import com.unu.app.service.ClienteService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/Cliente")

public class ClienteController {

	@Autowired
	@Qualifier("clienteService")
	private ClienteService clienteService;

	public List<Cliente> getListByBusqueda(String filtro, String busqueda) {
		List<Cliente> lista = null;
		switch (filtro) {
		case "Todo": 
			lista =  clienteService.BuscarByAll(busqueda);break;
		case "Dni": 
			lista =  clienteService.BuscarByDni(busqueda);break;
		case "Nombre": 
			lista =  clienteService.BuscarByNombre(busqueda);break;
		case "Apellido": 
			lista =  clienteService.BuscarByApellido(busqueda);break;
		default:
			lista = clienteService.Listar();break;
		}
		return lista;
	}
	
	@GetMapping("/Listar")
	public ModelAndView ListaCliente(
			@RequestParam(name = "Filtro", required = false, defaultValue = "Todo") String filtro,
			@RequestParam(name = "Busqueda", required = false, defaultValue = "") String busqueda,
			@RequestParam(name = "sucessRegister", required = false) boolean sucessRegister,
			@RequestParam(name = "sucessDelete", required = false) boolean sucessDelete,
			@RequestParam(name = "sucessEdit", required = false) boolean sucessEdit) {
		ModelAndView modelAndView = new ModelAndView("Cliente/lista");
		
		modelAndView.addObject("registros", getListByBusqueda(filtro,busqueda));
		modelAndView.addObject("Filtro", filtro);
		modelAndView.addObject("Busqueda", busqueda);
		modelAndView.addObject("InsertarRegistroSuccess", sucessRegister);
		modelAndView.addObject("EliminarRegistroSuccess", sucessDelete);
		modelAndView.addObject("EditarRegistroSuccess", sucessEdit);
		return modelAndView;
	}

	@PostMapping("/Eliminar/{id}")
	public ModelAndView Eliminar(@PathVariable(name = "id") int id) {
		clienteService.Eliminar(id);
		return new ModelAndView("redirect:/Cliente/Listar?sucessDelete=true");
	}

	@GetMapping("/Actualizar/{id}")
	public ModelAndView Actualizar(@PathVariable(name = "id") int id) {
		ModelAndView modelAndView = new ModelAndView("Cliente/editar");
		Cliente Objeto = clienteService.Obtener(id);
		modelAndView.addObject("id", Objeto.getId());
		modelAndView.addObject("dni", Objeto.getDni());
		modelAndView.addObject("originalDni", Objeto.getDni());
		modelAndView.addObject("nombre", Objeto.getNombre());
		modelAndView.addObject("apellido", Objeto.getApellido());
		modelAndView.addObject("correo", Objeto.getCorreo());
		modelAndView.addObject("telefono", Objeto.getTelefono());
		modelAndView.addObject("edad", Objeto.getEdad());
		modelAndView.addObject("genero", Objeto.getGeneroText());
		modelAndView.addObject("salario", Objeto.getSalario());
		modelAndView.addObject("fecha_nacimiento", Objeto.getFechaNacimiento());
		modelAndView.addObject("estado_civil", Objeto.getEstadoCivilText());
		modelAndView.addObject("activo", Objeto.getActivoText());

		return modelAndView;
	}

	@PostMapping("/Actualizar/{id}")
	public ModelAndView Actualizar(@PathVariable(name = "id") int id,
			@RequestParam(name = "dni", required = false, defaultValue = "") String dni,
			@RequestParam(name = "originalDni", required = false, defaultValue = "") String originalDni,
			@RequestParam(name = "edad", required = false) Integer edad,
			@RequestParam(name = "nombre", required = false, defaultValue = "") String nombre,
			@RequestParam(name = "apellido", required = false, defaultValue = "") String apellido,
			@RequestParam(name = "correo", required = false, defaultValue = "") String correo,
			@RequestParam(name = "telefono", required = false, defaultValue = "") String telefono,
			@RequestParam(name = "genero", required = false, defaultValue = "") String genero,
			@RequestParam(name = "salario", required = false) Double salario,
			@RequestParam(name = "fecha_nacimiento", required = false, defaultValue = "") String fecha_nacimiento,
			@RequestParam(name = "estado_civil", required = false, defaultValue = "") String estado_civil,
			@RequestParam(name = "activo", required = false, defaultValue = "") String activo) {

		ModelAndView modelAndView = new ModelAndView("Cliente/editar");

		boolean SuccessEdit = true;

		if (!ValidarDato.validarDni(dni).equals("")) {
			modelAndView.addObject("ErrorDni", ValidarDato.validarDni(dni));
			SuccessEdit = false;
		}else if(clienteService.isExistByDni(dni) && !originalDni.equals(dni)){
			modelAndView.addObject("ErrorDni", "El DNI ya esta registrado.");
			SuccessEdit = false;
		}
		modelAndView.addObject("dni", dni);
		modelAndView.addObject("originalDni", originalDni);

		if (!ValidarDato.validarOnlyTexto(nombre).equals("")) {
			modelAndView.addObject("ErrorNombre", ValidarDato.validarOnlyTexto(nombre));
			SuccessEdit = false;
		}
		modelAndView.addObject("nombre", nombre);

		if (!ValidarDato.validarOnlyTexto(apellido).equals("")) {
			modelAndView.addObject("ErrorApellido", ValidarDato.validarOnlyTexto(apellido));
			SuccessEdit = false;
		}
		modelAndView.addObject("apellido", apellido);

		if (!ValidarDato.validarCorreo(correo).equals("")) {
			modelAndView.addObject("ErrorCorreo", ValidarDato.validarCorreo(correo));
			SuccessEdit = false;
		}
		modelAndView.addObject("correo", correo);

		if (!ValidarDato.validarTelefono(telefono).equals("")) {
			modelAndView.addObject("ErrorTelefono", ValidarDato.validarTelefono(telefono));
			SuccessEdit = false;
		}
		modelAndView.addObject("telefono", telefono);

		if (!ValidarDato.validarEdad(edad).equals("")) {
			modelAndView.addObject("ErrorEdad", ValidarDato.validarEdad(edad));
			SuccessEdit = false;
		}
		modelAndView.addObject("edad", edad);

		if (!ValidarDato.validarRadioButton(genero).equals("")) {
			modelAndView.addObject("ErrorGenero", ValidarDato.validarRadioButton(genero));
			SuccessEdit = false;
		}
		modelAndView.addObject("genero", genero);

		if (!ValidarDato.validarSalario(salario).equals("")) {
			modelAndView.addObject("ErrorSalario", ValidarDato.validarSalario(salario));
			SuccessEdit = false;
		}
		modelAndView.addObject("salario", salario);

		if (!ValidarDato.validarFecha(fecha_nacimiento).equals("")) {
			modelAndView.addObject("ErrorFecha", ValidarDato.validarFecha(fecha_nacimiento));
			SuccessEdit = false;
		}
		modelAndView.addObject("fecha_nacimiento", fecha_nacimiento);

		if (!ValidarDato.validarComboBox(estado_civil).equals("")) {
			modelAndView.addObject("ErrorEstadoCivil", ValidarDato.validarComboBox(estado_civil));
			SuccessEdit = false;
		}
		modelAndView.addObject("estado_civil", estado_civil);

		modelAndView.addObject("activo", activo);

		if (SuccessEdit) {
			Cliente ActualizarRegistro = new Cliente();
			ActualizarRegistro.setId(id);
			ActualizarRegistro.setDni(dni);
			ActualizarRegistro.setNombre(nombre);
			ActualizarRegistro.setApellido(apellido);
			ActualizarRegistro.setCorreo(correo);
			ActualizarRegistro.setTelefono(telefono);
			ActualizarRegistro.setEdad(edad);
			ActualizarRegistro.setGenero(String.valueOf(genero.charAt(0)));
			ActualizarRegistro.setSalario(salario);
			ActualizarRegistro.setFechaNacimiento(LocalDate.parse(fecha_nacimiento));
			ActualizarRegistro.setEstadoCivil(EstadoCivil.valueOf(estado_civil.toUpperCase()));
			ActualizarRegistro.setActivo(activo.equals("on"));
			ActualizarRegistro.setFechaRegistro(LocalDate.now());
			clienteService.Actualizar(ActualizarRegistro);
			return new ModelAndView("redirect:/Cliente/Listar?sucessEdit=true");
		}

		return modelAndView;

	}

	@GetMapping("/Registrar")
	public ModelAndView Registrar() {
		ModelAndView modelAndView = new ModelAndView("Cliente/registrar");
		return modelAndView;
	}

	@PostMapping("/Registrar")
	public ModelAndView Registrar(@RequestParam(name = "dni", required = false, defaultValue = "") String dni,
			@RequestParam(name = "edad", required = false) Integer edad,
			@RequestParam(name = "nombre", required = false, defaultValue = "") String nombre,
			@RequestParam(name = "apellido", required = false, defaultValue = "") String apellido,
			@RequestParam(name = "correo", required = false, defaultValue = "") String correo,
			@RequestParam(name = "telefono", required = false, defaultValue = "") String telefono,
			@RequestParam(name = "genero", required = false, defaultValue = "") String genero,
			@RequestParam(name = "salario", required = false) Double salario,
			@RequestParam(name = "fecha_nacimiento", required = false, defaultValue = "") String fecha_nacimiento,
			@RequestParam(name = "estado_civil", required = false, defaultValue = "") String estado_civil,
			@RequestParam(name = "activo", required = false, defaultValue = "") String activo

	) {
		ModelAndView modelAndView = new ModelAndView("Cliente/registrar");

		boolean SuccessRegister = true;

		if (!ValidarDato.validarDni(dni).equals("")) {
			modelAndView.addObject("ErrorDni", ValidarDato.validarDni(dni));
			SuccessRegister = false;
		}else if(clienteService.isExistByDni(dni)){
			modelAndView.addObject("ErrorDni", "El DNI ya esta registrado.");
			SuccessRegister = false;
		}
		modelAndView.addObject("dni", dni);

		if (!ValidarDato.validarOnlyTexto(nombre).equals("")) {
			modelAndView.addObject("ErrorNombre", ValidarDato.validarOnlyTexto(nombre));
			SuccessRegister = false;
		}
		modelAndView.addObject("nombre", nombre);

		if (!ValidarDato.validarOnlyTexto(apellido).equals("")) {
			modelAndView.addObject("ErrorApellido", ValidarDato.validarOnlyTexto(apellido));
			SuccessRegister = false;
		}
		modelAndView.addObject("apellido", apellido);

		if (!ValidarDato.validarCorreo(correo).equals("")) {
			modelAndView.addObject("ErrorCorreo", ValidarDato.validarCorreo(correo));
			SuccessRegister = false;
		}
		modelAndView.addObject("correo", correo);

		if (!ValidarDato.validarTelefono(telefono).equals("")) {
			modelAndView.addObject("ErrorTelefono", ValidarDato.validarTelefono(telefono));
			SuccessRegister = false;
		}
		modelAndView.addObject("telefono", telefono);

		if (!ValidarDato.validarEdad(edad).equals("")) {
			modelAndView.addObject("ErrorEdad", ValidarDato.validarEdad(edad));
			SuccessRegister = false;
		}
		modelAndView.addObject("edad", edad);

		if (!ValidarDato.validarRadioButton(genero).equals("")) {
			modelAndView.addObject("ErrorGenero", ValidarDato.validarRadioButton(genero));
			SuccessRegister = false;
		}
		modelAndView.addObject("genero", genero);

		if (!ValidarDato.validarSalario(salario).equals("")) {
			modelAndView.addObject("ErrorSalario", ValidarDato.validarSalario(salario));
			SuccessRegister = false;
		}
		modelAndView.addObject("salario", salario);

		if (!ValidarDato.validarFecha(fecha_nacimiento).equals("")) {
			modelAndView.addObject("ErrorFecha", ValidarDato.validarFecha(fecha_nacimiento));
			SuccessRegister = false;
		}
		modelAndView.addObject("fecha_nacimiento", fecha_nacimiento);

		if (!ValidarDato.validarComboBox(estado_civil).equals("")) {
			modelAndView.addObject("ErrorEstadoCivil", ValidarDato.validarComboBox(estado_civil));
			SuccessRegister = false;
		}
		modelAndView.addObject("estado_civil", estado_civil);

		modelAndView.addObject("activo", activo);

		if (SuccessRegister) {
			Cliente nuevoRegistro = new Cliente();
			nuevoRegistro.setDni(dni);
			nuevoRegistro.setNombre(nombre);
			nuevoRegistro.setApellido(apellido);
			nuevoRegistro.setCorreo(correo);
			nuevoRegistro.setTelefono(telefono);
			nuevoRegistro.setEdad(edad);
			nuevoRegistro.setGenero(String.valueOf(genero.charAt(0)));
			nuevoRegistro.setSalario(salario);
			nuevoRegistro.setFechaNacimiento(LocalDate.parse(fecha_nacimiento));
			nuevoRegistro.setEstadoCivil(EstadoCivil.valueOf(estado_civil.toUpperCase()));
			nuevoRegistro.setActivo(activo.equals("on"));
			nuevoRegistro.setFechaRegistro(LocalDate.now());
			clienteService.Insertar(nuevoRegistro);
			return new ModelAndView("redirect:/Cliente/Listar?sucessRegister=true");
		}

		return modelAndView;
	}

}
