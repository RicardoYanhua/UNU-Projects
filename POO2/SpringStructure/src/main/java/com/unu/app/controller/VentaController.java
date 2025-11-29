package com.unu.app.controller;


import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.unu.app.entity.Cliente;
import com.unu.app.entity.DetalleVenta;
import com.unu.app.entity.Producto;
import com.unu.app.entity.Venta;
import com.unu.app.entity.Cliente.EstadoCivil;
import com.unu.app.service.ClienteService;
import com.unu.app.service.DetalleService;
import com.unu.app.service.ProductoService;
import com.unu.app.service.VentaService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/Venta")

public class VentaController {

	@Autowired
	@Qualifier("ventaService")
	private VentaService ventaService;

	@Autowired
	@Qualifier("detalleVentaService")
	private DetalleService detalleService;

	@Autowired
	@Qualifier("clienteService")
	private ClienteService clienteService;

	@Autowired
	@Qualifier("productoService")
	private ProductoService productoService;

	@GetMapping("/Listar")
	public ModelAndView Listar(
			@RequestParam(name = "sucessDelete", required = false) boolean sucessDelete
			) {
		ModelAndView modelAndView = new ModelAndView("Venta/lista");
		modelAndView.addObject("registros", ventaService.Listar());
		modelAndView.addObject("EliminarRegistroSuccess", sucessDelete);
		return modelAndView;
	}

	@GetMapping("/FormularioVenta")
	public ModelAndView NuevaVenta() {

		ModelAndView modelAndView = new ModelAndView("Venta/nuevo");
		modelAndView.addObject("registros", clienteService.Listar());
		modelAndView.addObject("productos", productoService.Listar());
		return modelAndView;
	}

	@GetMapping("/NuevaVenta")
	public ModelAndView AgregarDetalle(
			@RequestParam(name = "codigo", required = false, defaultValue = "") String codigo,
			@RequestParam(name = "cliente", required = false, defaultValue = "") String cliente,
			@RequestParam(name = "producto", required = false, defaultValue = "") String producto,
			@RequestParam(name = "cantidad", required = false) Integer cantidad) {

		ModelAndView modelAndView = new ModelAndView("Venta/nuevo");

		boolean isValidateDetalle = true;
		System.err.println("Cliente : " + cliente);
		modelAndView.addObject("clientes", clienteService.Listar());
		modelAndView.addObject("registros", clienteService.Listar());
		if (cliente.isEmpty() || cliente.equals("")) {
			modelAndView.addObject("ErrorCliente", "Debe seleccionar a un cliente.");
			isValidateDetalle = false;
		} else {
			modelAndView.addObject("cliente", cliente);
			Cliente obj = clienteService.Obtener(Integer.parseInt(cliente));
			modelAndView.addObject("DatoCliente", obj.getNombre() + " " + obj.getApellido());
			modelAndView.addObject("isSelectedCliente", false);
		}

		modelAndView.addObject("productos", productoService.Listar());
		if (producto.isEmpty() || producto.equals("")) {
			modelAndView.addObject("ErrorProducto", "Debe seleccionar a un producto.");
			isValidateDetalle = false;
		} else {
			modelAndView.addObject("producto", producto);
		}

		if (!ValidarDato.validarCantidad(cantidad, 0, 100).equals("")) {
			modelAndView.addObject("ErrorCantidad", ValidarDato.validarCantidad(cantidad, 0, 100));
			isValidateDetalle = false;
		}
		

		if (isValidateDetalle == true) {
			modelAndView.addObject("producto", "");
			
			
			Venta venta = null;
			if (codigo.isEmpty() || codigo.equals("")) {
				venta= new Venta();
				venta.setCliente(clienteService.Obtener(Integer.parseInt(cliente)));
				venta.setFechaVenta(LocalDate.now());
				venta.setTotal(0.0);
				
				ventaService.Insertar(venta);
				modelAndView.addObject("codigo", ventaService.ObtenerLastId());
			} else {
				//venta.setCliente(clienteService.Obtener(Integer.parseInt(cliente)));
				//ventaService.Actualizar(venta);
				venta = ventaService.Obtener(Integer.parseInt(codigo));
				modelAndView.addObject("codigo", codigo);
				//venta.setTotal(detalleService.obtenerTotalByIdVenta(Integer.parseInt(codigo)));
				
				
			}
			
			
			
			DetalleVenta Nuevodetalle = new DetalleVenta();
			Nuevodetalle.setVenta(venta);
			Producto obtenerProducto = productoService.Obtener(Integer.parseInt(producto));
			Nuevodetalle.setProducto(obtenerProducto);
			Nuevodetalle.setCantidad(cantidad);
			Nuevodetalle.setTotal(obtenerProducto.getPrecio() * cantidad);
			detalleService.Insertar(Nuevodetalle);
			
			modelAndView.addObject("detalles", detalleService.ListarDetalleBy_ObjVenta(venta));
			
			
			
			return modelAndView;
		}else {
			
			Venta venta = null;
			if (!codigo.isEmpty() || !codigo.equals("")) {
				venta = ventaService.Obtener(Integer.parseInt(codigo));
				modelAndView.addObject("codigo", codigo);
				modelAndView.addObject("detalles", detalleService.ListarDetalleBy_ObjVenta(venta));
			}
			
			
			modelAndView.addObject("codigo", codigo);
			return modelAndView;
		}
		
		

		
	}
	
	@PostMapping("/EliminarDetalle")
	public String EliminarDetalle(
	        @RequestParam(name = "codigo", required = false, defaultValue = "") String codigo,
	        @RequestParam(name = "codigodetalle", required = false, defaultValue = "") Integer codigodetalle,
	        @RequestParam(name = "cliente", required = false, defaultValue = "") String cliente) {

	    // Eliminar el detalle
	    detalleService.Eliminar(codigodetalle);

	    // Redirigir al método POST AgregarDetalle
	    return "redirect:/Venta/NuevaVenta?codigo=" + codigo+"&cliente=" + cliente;
	}

	@PostMapping("/Eliminar/{id}")
	public ModelAndView Eliminar(@PathVariable(name = "id") int id) {
		ventaService.Eliminar(id);
		return new ModelAndView("redirect:/Venta/Listar?sucessDelete=true");
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
		} else if (clienteService.isExistByDni(dni)) {
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
