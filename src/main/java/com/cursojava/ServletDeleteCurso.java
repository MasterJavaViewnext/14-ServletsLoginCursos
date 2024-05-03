package com.cursojava;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Collections;

/**
 * Servlet implementation class ServletDeleteCurso
 */
public class ServletDeleteCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

   	/**
   	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   	 */
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		HttpSession session = request.getSession();
   		
		Login login = (Login) session.getAttribute("login");
		login.deleteCurso(request.getParameter("delete"));
		request.getRequestDispatcher("ServletCursos").forward(request, response);
   	}


}
