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

public class AlterarPais implements Command {

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
		} catch (NumberFormatException e) {}
		
		try {
			pPopulacao = Long.parseLong(populacao);
		} catch (NumberFormatException e) {}
		
		try {
			try {
				pArea = Double.parseDouble(area);
			}catch(NullPointerException e) {}
		} catch (NumberFormatException e) {}
		
		Pagamento pais = new Pagamento();
		pais.setId(pId);
		pais.setNome(pNome);
		pais.setPopulacao(pPopulacao);
		pais.setArea(pArea);

		PaisService ps = new PaisService();
		ps.atualizar(pais);
				
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		@SuppressWarnings("unchecked")
		ArrayList<Pagamento> lista = (ArrayList<Pagamento>) session.getAttribute("lista");
		int pos = busca(pais, lista);
		lista.remove(pos);
		lista.add(pos, pais);
		session.setAttribute("lista", lista);
		request.setAttribute("pais", pais);
		view = request.getRequestDispatcher("ListarPais.jsp");
		
		view.forward(request, response);
		
	}
	
	public int busca(Pagamento pais, ArrayList<Pagamento> lista) {
		Pagamento to;
		for(int i = 0; i < lista.size(); i++){
			to = lista.get(i);
			if(to.getId() == pais.getId()){
				return i;
			}
		}
		return -1;
	}
	
}
