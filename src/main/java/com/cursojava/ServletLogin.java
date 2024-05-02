package com.cursojava;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ServletLogin
 */
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/registro.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Obtener el parámetro que indica qué servlet secundario invocar
				if (request.getParameter("register") != null) {

					String parametro = request.getParameter("register");
					// Redirigir a los servlets secundarios según la acción proporcionada
					if (parametro != null) {
						if (parametro.equals("no")) {
							  //session.invalidate();
			                    request.setAttribute("errorMessage", "Usuario o contraseña incorrectos");
			                    RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			                    rd.forward(request, response);     
						}
						if (parametro.equals("si")) {
		                    request.setAttribute("errorMessage", "Invalid user or password");
		                    RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		                    rd.forward(request, response);     
						}
					}
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("ServletCursos");
					HttpSession session = request.getSession();
					Login login = new Login(request.getParameter("user_name"), request.getParameter("user_password"));
					session.setAttribute("login", login);

					rd.forward(request, response);
				}
		
	}

}
