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
 * Servlet implementation class ServletCursos
 */
public class ServletCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Login login = (Login) session.getAttribute("login");
		ArrayList<Login> lista = (ArrayList)session.getAttribute("lista");
		
		if (lista != null) {

			if (lista.contains(login)) {
				login = lista.get(lista.indexOf(login));
				session.setAttribute("login", login);
				request.setAttribute("cursos", login.getCursos());
				request.getRequestDispatcher("/views/cursos.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("ServletLogin?register=no").forward(request, response);
				;
			}
		} else {
			request.getRequestDispatcher("/ServletLogin?register=no").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("GET de cursos");
		HttpSession session = request.getSession();
		Login login = (Login) session.getAttribute("login");
		if (request.getParameter("curso") != null) {
			//((Login)session.getAttribute("login")).setCurso(request.getParameter("curso"));
			login.setCurso(request.getParameter("curso"));
		}
		request.getRequestDispatcher("/views/cursos.jsp").forward(request, response);
	}

}
