package service;

import java.util.ArrayList;

import dao.PaisDao;
import model.Pagamento;


public class PaisService {

	PaisDao dao;

	public PaisService() {
		dao = new PaisDao();
	}

	public int criar(Pagamento pais) throws Exception {
		return dao.incluir(pais);
	}
	
	public void atualizar(Pagamento pais) {
		dao.atualizar(pais);
	}
	
	public void excluir(Pagamento pais) {
		dao.excluir(pais);
	}
	
	public Pagamento carregar(int id) {
		Pagamento pais = dao.carregar(id);
		return pais;
	}
	
	public Pagamento maiorPopulacao() {
		Pagamento pais = dao.maiorPopulacao();
		return pais;
	}
	
	public Pagamento menorArea() {
		Pagamento pais = dao.menorArea();
		return pais;
	}
	
	public ArrayList<Pagamento> vetorTresPaises() {
		try {
			ArrayList<Pagamento> pais = dao.vetorTresPaises();
			return pais;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Pagamento> carregarTodos() throws Exception {
		ArrayList<Pagamento> to = dao.retornarTodosPaises();
		return to;
	}

}


