package com.unu.app.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarDato {
	
	public static boolean isInteger(String textNumber) {
		try {
			Integer number = Integer.parseInt(textNumber);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isDouble(String textNumber) {
		try {
			Double number = Double.parseDouble(textNumber);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isTextEmpty(String text) {
		if (text.equals("") || text.isEmpty()) {
			return true;
		}
		return false;
	}

	public static String validarDni(String dni) {
		if (isTextEmpty(dni)) {
			return "Por favor, ingrese datos al campo DNI.";
		} else if (!isInteger(dni)) {
			return "El DNI es inválido.";
		} else if ((dni.length() < 8)) {
			return "Debe ingresar un valor de 8 cifras.";
		}
		return "";
	}

	public static String validarOnlyTexto(String texto) {
		if (isTextEmpty(texto)) {
			return "Este campo no puede estar vacio.";
		} else if (texto.matches(".*\\d.*")) {
			return "El campo no puede contener números.";
		}
		return "";
	}
	
	public static String validarFecha(String texto) {
		if (isTextEmpty(texto)) {
			return "Debe seleccionar una fecha.";
		}
		return "";
	}
	
	public static String validarRadioButton(String texto) {
		if (isTextEmpty(texto)) {
			return "Debe seleccionar una opcion.";
		}
		return "";
	}
	
	public static String validarComboBox(String texto) {
		if (isTextEmpty(texto)) {
			return "Debe seleccionar una opcion.";
		}
		return "";
	}
	
	public static String validarTelefono(String telefono) {
		if (isTextEmpty(telefono)) {
			return "Por favor, ingrese datos al campo Telefono.";
		} else if (!isInteger(telefono) || (telefono.length() < 9)) {
			return "Debe ingresar un valor de 9 cifras.";
		}
		return "";
	}

	public static String validarEdad(Integer edad) {
		if (isTextEmpty(String.valueOf(edad)) || edad == null) {
			return "Por favor, ingrese datos al campo Edad.";
		} else if (edad < 0 || edad > 100) {
			return "La edad debe estar entre 0 y 100.";
		}
		return "";
	}
	
	public static String validarCantidad(Integer cantidad, int min, int max) {
		if (isTextEmpty(String.valueOf(cantidad)) || cantidad == null) {
			return "Por favor, ingrese una Cantidad.";
		} else if (cantidad < min || cantidad > max) {
			return "La Catnidad debe estar entre " + min +" y " + max +".";
		}
		return "";
	}
	
	
	public static String validarSalario(Double salario) {
		if (isTextEmpty(String.valueOf(salario)) || salario == null) {
			return "Por favor, ingrese datos al campo Salario.";
		} else if (salario < 0) {
			return "El salario debe ser mayor de 0";
		}
		return "";
	}
	
	public static String validarNumberPositive(Double number) {
		if (isTextEmpty(String.valueOf(number)) || number == null) {
			return "Por favor, no deje el campo vacio.";
		} else if (number < 0) {
			return "El numero insertado no puede ser negativo.";
		}
		return "";
	}

	public static String validarCorreo(String correo) {
		if (isTextEmpty(correo)) {
			return "Por favor, ingrese datos al campo Correo.";
		}

		String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(correo);

		if (!matcher.matches()) {
			return "El correo es inválido.";
		}
		return "";

	}
}
