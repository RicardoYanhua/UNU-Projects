package com.unu.poo2.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import com.unu.poo2.beans.*;
import com.unu.poo2.models.StructureModel;

@WebServlet("/StructureController")

public class StructureController extends HttpServlet {

	public StructureController() {
		super();
	}

	StructureModel structureModel = new StructureModel();

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
		try {

			String op = request.getParameter("op") == null ? "" : request.getParameter("op");

			switch (op) {

			case "listar":
				listar(request, response);
				break;
			case "nuevo":
				nuevo(request, response);
				break;
			case "obtener":
				obtener(request, response);
				break;
			case "modificar":
				modificar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;
			case "registrar":
				registrar(request, response);
				break;

			// MAIN CONTROLLER
			default:
				listar(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(
					"ERROR EN " + this.getClass().getName() + ".processRequest() \n" + e.getMessage().toString());
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("AtributoJavaJSP", structureModel.listar());
			request.getRequestDispatcher("/ruta/archivoListar.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR EN " + this.getClass().getName() + ".listar() \n" + e.getMessage().toString());
		}
	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/ruta/archivoNuevo.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR EN " + this.getClass().getName() + ".nuevo() \n" + e.getMessage().toString());
		}
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		try {

			int primaryKey = Integer.parseInt(request.getParameter("id"));

			if (structureModel.eliminar(primaryKey) > 0) {
				response.sendRedirect(request.getContextPath() + "/StructureController");
			} else {
				response.sendRedirect(request.getContextPath() + "/error404.jsp");
			}
		} catch (Exception e) {
			System.out.println("Error en " + this.getClass().getName() + " .eliminar() \n" + e.getMessage().toString());
			e.printStackTrace();
		}

	}

	private void obtener(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int primaryKey = Integer.parseInt(request.getParameter("id"));
			Entidad miEntidad = structureModel.obtener(primaryKey);

			if (miEntidad != null) {
				request.setAttribute("entidadAtributeJava", miEntidad);
				request.getRequestDispatcher("/ruta/archivo.jsp").forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/error404.jsp");
			}
		} catch (Exception e) {
			System.out.println(
					"Error en " + this.getClass().getName() + " .obtener() \n" + e.getMessage().toString());
			e.printStackTrace();
		}
	}

	private void modificar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			Entidad miEntidad = new Entidad();

			miEntidad.setVariablePrimaryKey(Integer.parseInt(request.getParameter("InputNameParameterJSP")));
			miEntidad.setVariableTipoInt(Integer.parseInt(request.getParameter("InputNameParameterJSP")));
			miEntidad.setVariableTipoString(request.getParameter("InputNameParameterJSP"));
			miEntidad.setVariableTipoDouble(Double.parseDouble(request.getParameter("InputNameParameterJSP")));
			miEntidad.setVariableTipoDate(LocalDate.parse(request.getParameter("InputNameParameterJSP")));

			if (structureModel.modificar(miEntidad) > 0) {
				response.sendRedirect(request.getContextPath() + "/StructureController");
			} else {
				response.sendRedirect(request.getContextPath() + "/error404.jsp");
			}

		} catch (Exception e) {
			System.out
					.println("Error en " + this.getClass().getName() + " .modificar() \n" + e.getMessage().toString());
			e.printStackTrace();
		}
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			Entidad miEntidad = new Entidad();
			miEntidad.setVariablePrimaryKey(Integer.parseInt(request.getParameter("InputNameParameterJSP")));
			miEntidad.setVariableTipoInt(Integer.parseInt(request.getParameter("InputNameParameterJSP")));
			miEntidad.setVariableTipoString(request.getParameter("InputNameParameterJSP"));
			miEntidad.setVariableTipoDouble(Double.parseDouble(request.getParameter("InputNameParameterJSP")));
			miEntidad.setVariableTipoDate(LocalDate.parse(request.getParameter("InputNameParameterJSP")));
			

			if (structureModel.insertar(miEntidad) > 0) {
				response.sendRedirect(request.getContextPath() + "/StructureController");
			} else {
				response.sendRedirect(request.getContextPath() + "/error404.jsp");
			}

		} catch (Exception e) {
			System.out.println(
					"Error en " + this.getClass().getName() + " .resgistrar() \n" + e.getMessage().toString());
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
