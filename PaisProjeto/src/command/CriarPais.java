package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pagamento;
import service.PaisService;

public class CriarPais implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String nome = request.getParameter("nome");
		String pPopulacao = request.getParameter("populacao");
		String pArea = request.getParameter("area");
		// String pAcao = request.getParameter("acao");
		String pIdPais = request.getParameter("id");

		int idPais = -1;
		int populacao = 0;
		double area = 0.0;

		try {
			if (pIdPais != null)
				idPais = Integer.parseInt(pIdPais);
			if (pPopulacao != null)
				populacao = Integer.parseInt(pPopulacao);
			if (pArea != null)
				area = Double.parseDouble(pArea);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		Pagamento pais = new Pagamento();
		pais.setId(idPais);
		pais.setNome(nome);
		pais.setPopulacao(populacao);
		pais.setArea(area);

		PaisService service = new PaisService();
		RequestDispatcher view = null;

		int id;
		try {
			id = service.criar(pais);
			pais.setId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("pais", pais);
		view = request.getRequestDispatcher("Pais.jsp");
		view.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		executar(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		executar(request, response);
	}

}
