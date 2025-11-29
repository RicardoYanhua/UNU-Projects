package com.unu.poo2.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/EditorialController")
public class EditorialController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public EditorialController() {
        super();
        
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String operacion = request.getParameter("op") == null ? "listar" : request.getParameter("op");
			
			switch (operacion) {
			case "listar":
				listarEditorial(request,response);
				break;

			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error en " + e.getClass().getName() + ".processRequest() \n" + e.getMessage().toString());
		}
	}
    
    private void listarEditorial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		//request.setAttribute("listaAutores", modelAutor.listaAutor());
			request.getRequestDispatcher("/Editorial/listaEditorial.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error en " + e.getClass().getName() + ".listarEditorial() \n" + e.getMessage().toString());
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
