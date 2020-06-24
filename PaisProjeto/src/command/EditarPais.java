package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pagamento;
import service.PaisService;

public class EditarPais implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String populacao = request.getParameter("populacao");
		String area = request.getParameter("area");
		int pId = -1;
		long pPopulacao = -1;
		double pArea = -1;

		try {
			pId = Integer.parseInt(id);
		} catch (NumberFormatException e) {
		}

		try {
			pPopulacao = Long.parseLong(populacao);
		} catch (NumberFormatException e) {
		}

		try {
			try {
				pArea = Double.parseDouble(area);
			} catch (NullPointerException e) {
			}
		} catch (NumberFormatException e) {
		}

		Pagamento pais = new Pagamento();
		pais.setId(pId);
		pais.setNome(pNome);
		pais.setPopulacao(pPopulacao);
		pais.setArea(pArea);

		PaisService ps = new PaisService();
		pais = ps.carregar(pais.getId());
		RequestDispatcher view = null;

		request.setAttribute("pais", pais);
		view = request.getRequestDispatcher("AlterarPais.jsp");

		view.forward(request, response);

	}

}
