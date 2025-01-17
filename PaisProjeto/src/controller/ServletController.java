package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;

@WebServlet("/controller.do")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doExecutar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			request.setCharacterEncoding("UTF-8");
			Command comando =
					(Command) Class.forName("command." + request.getParameter("command")).newInstance();

			comando.executar(request, response);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doExecutar(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doExecutar(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
}
