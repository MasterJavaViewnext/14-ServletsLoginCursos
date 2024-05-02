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
		List<Login> lista = (ArrayList<Login>) session.getAttribute("lista");

		if (lista != null) {

			if (lista.contains(login)) {
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
		System.out.println("POST de cusos");
		HttpSession session = request.getSession();
		Login login = (Login) session.getAttribute("login");
		login.setCurso(request.getParameter("curso"));
		System.out.println(login.getCursos());
		request.setAttribute("cursos", login.getCursos());
		request.getRequestDispatcher("/views/cursos.jsp").forward(request, response);
	}

}
