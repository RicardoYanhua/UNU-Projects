package com.unu.WebApplication.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

import com.unu.WebApplication.beans.Asistencia;
import com.unu.WebApplication.beans.Trabajador;
import com.unu.WebApplication.models.AreaModel;
import com.unu.WebApplication.models.AsistenciaModel;
import com.unu.WebApplication.models.ProfesionModel;
import com.unu.WebApplication.models.TrabajadorModel;

@WebServlet("/AsistenciaController")
public class AsistenciaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//AsistenciaModel model = new AsistenciaModel();
	AsistenciaModel model_asis = new AsistenciaModel();
	TrabajadorModel model = new TrabajadorModel();
	AreaModel modelArea = new AreaModel();
	ProfesionModel modelProfesion = new ProfesionModel();
	
    public AsistenciaController() {super();}
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String operacion = request.getParameter("op") == null ? "nuevo" : request.getParameter("op");
			
			switch (operacion) {
			
			case "nuevo": 
				nuevaAsistencia(request,response);
				break;
			case "registrar":
				registrar(request,response);
				break;
			/*
			case "obtener":
				obtenerTrabajador(request,response);
				break;
			case "modificar":
				modificarTrabajador(request,response);
				break;
			case "eliminar":
				eliminarTrabajador(request,response);
				break;*/
			default:
				nuevaAsistencia(request,response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    private void nuevaAsistencia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("lista", model.listarTrabajador());
			request.getRequestDispatcher("/Asistencia/registroAsistencia.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    
    private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			
			String[] ids = request.getParameterValues("idtrabajador");
			
			System.out.println("Lenght ids : " + ids.length);
			
			for (String id : ids) {
				System.out.println("this is a id : " + id);
				Asistencia asistencia = new Asistencia();
				asistencia.setIdTrabajador(Integer.parseInt(id));
				asistencia.setCondicion(request.getParameter("condicion"));
				asistencia.setFecha(Date.valueOf(request.getParameter("fecha")).toLocalDate());
				asistencia.setJustificacion(request.getParameter("justificacion"));
				
				model_asis.registrarAsistencia(asistencia);
			}
			
			response.sendRedirect(request.getContextPath() + "/TrabajadorController?op=listaTrabajador");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    /*
    private void nuevoTrabajador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("listaArea", modelArea.listaArea());
			request.setAttribute("listaProfesion", modelProfesion.listaProfesion());
			request.getRequestDispatcher("/Trabajador/registrarTrabajador.jsp").forward(request, response);
			//response.sendRedirect(request.getContextPath() + "/Trabajador/registrarTrabajador.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    private void listarTrabajador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("listaTrabajador", model.listarTrabajador());
			request.getRequestDispatcher("/Trabajador/registroTrabajador.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    private void obtenerTrabajador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			int idTrabajador = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("trabajador", model.obtenerTrabajador(idTrabajador));
			request.setAttribute("listaArea", modelArea.listaArea());
			request.setAttribute("listaProfesion", modelProfesion.listaProfesion());
			request.getRequestDispatcher("/Trabajador/modificarTrabajador.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    private void eliminarTrabajador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			int idTrabajador = Integer.parseInt(request.getParameter("id"));
			
			if(model.eliminarTrabajador(idTrabajador) >0) {
				System.out.println("Trabajador Registrado Correctamente");
				
			}else {
				System.out.println("Error de Insercion");
			}
			
			response.sendRedirect(request.getContextPath() + "/TrabajadorController?op=listarTrabajador");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    private void modificarTrabajador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			Trabajador nuevoTrabajador = new Trabajador();
			nuevoTrabajador.setIdTrabajador(Integer.parseInt(request.getParameter("idtrabajador")));
			nuevoTrabajador.setDni(request.getParameter("dni"));

			nuevoTrabajador.setFecha(Date.valueOf(request.getParameter("fecha")).toLocalDate());
			
			nuevoTrabajador.setNombres(request.getParameter("nombres"));
			
			nuevoTrabajador.setIdArea(Integer.parseInt(request.getParameter("idarea")));
			
			nuevoTrabajador.setnAfp(request.getParameter("nafp"));
			
			nuevoTrabajador.setCodEsalud(request.getParameter("codEsalud"));
			nuevoTrabajador.setSueldo(Double.parseDouble(request.getParameter("sueldo")));
			nuevoTrabajador.setIdProfesion(Integer.parseInt(request.getParameter("idprofesion")));
			
			if(model.modificarTrabajador(nuevoTrabajador) >0) {
				System.out.println("Trabajador Registrado Correctamente");
				
			}else {
				System.out.println("Error de Insercion");
			}
			
			response.sendRedirect(request.getContextPath() + "/TrabajadorController?op=listarTrabajador");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
