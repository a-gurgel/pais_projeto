package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import dao.PaisDao;
import model.Pagamento;

@TestMethodOrder(OrderAnnotation.class)
class PaisDaoTest {

	Pagamento mock, pais, pais2;
	PaisDao dao;
	ArrayList<Pagamento> paises;
	static int idPaisCriado;
	
	@BeforeEach
	void setUp() throws Exception {
		mock = new Pagamento(2, "Brazil", 5000, 44.44);
		dao = new PaisDao();
		pais = new Pagamento("Germany", 4000, 60.00);
		pais2 = new Pagamento(1,	"Uruguai",	200, 112.00);
	}

	@Test
	@Order(4)
	void testIncluir() {
		try {
			int id = dao.incluir(pais);
			mock = dao.carregar(id);
			pais.setId(id);
			idPaisCriado = id;
			assertEquals(pais ,mock,"Verificando se a inclusão do país esta funcionando corretamente");

			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Test@Order(5)
	void testAtualizar() {
		pais2.setId(idPaisCriado);
		pais2.setArea(pais.getArea());
		pais2.setNome(pais.getNome());
		pais2.setPopulacao(pais.getPopulacao());
		dao.atualizar(pais2);
		
		pais = dao.carregar(pais2.getId());
		
		assertEquals(pais2, pais, "Verificando se a atualização do país esta funcionando corretamente");
	}

	
	@Test
	@Order(6)
	void testExcluir() {
		pais.setId(idPaisCriado);
		dao.excluir(pais);
		
		pais = new Pagamento();
		
		pais2 = dao.carregar(pais.getId());
		
		assertEquals(pais2, pais, "Verificando se o pais foi deletado com sucesso");
	}
	
	@Test
	@Order(3)
	void testBuscar() {
		pais = dao.carregar(2);
		assertEquals(mock ,pais,"Verificando se o pais buscado esta funcionando corretamente" );
	}

	@Test
	@Order(2)
	void testRetornarMaiorHabitantes() {
		pais2.setId(68);
		pais2.setNome("china");
		pais2.setPopulacao(99999999);
		pais2.setArea(99999.00);
		
		pais = dao.maiorPopulacao();
		assertEquals(pais2 ,pais,"Verificando o pais com o maior numero de habitantes" );
	}

	@Test
	@Order(1)
	void testRetornarMenorArea() {
		pais2.setId(67);
		pais2.setNome("Australia");
		pais2.setPopulacao(1);
		pais2.setArea(0.00);
		
		pais = dao.menorArea();
		assertEquals(pais2 ,pais,"Verificando o pais com o maior numero de habitantes" );
	}

	@Test
	@Order(0)
	void testRetornarTresPaises() {
		try {
			paises = dao.vetorTresPaises();
	
			assertEquals(3, paises.size(), "Verificando se o metodo retorna um array de tres paises");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
