package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pagamento;
import service.PaisService;

public class ExcluirPais implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		
		String nome = request.getParameter("nome");
		String pPopulacao = request.getParameter("populacao");
		String pArea = request.getParameter("area");
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
		HttpSession session = request.getSession();
		RequestDispatcher view = null;

		service.excluir(pais);

		@SuppressWarnings("unchecked")
		ArrayList<Pagamento> lista = (ArrayList<Pagamento>) session.getAttribute("lista");
		lista.remove(busca(pais, lista));
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarPaises.jsp");

		view.forward(request, response);

	}

	public int busca(Pagamento pais, ArrayList<Pagamento> lista) {
		Pagamento to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == pais.getId()) {
				return i;
			}
		}
		return -1;
	}

}
