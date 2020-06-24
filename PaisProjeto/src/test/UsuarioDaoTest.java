package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.UsuarioDao;
import model.Usuario;

public class UsuarioDaoTest {
	
	UsuarioDao dao;
	Usuario usuario;
	Usuario novoUsuario;
	
	@BeforeEach
	public void setUp() throws Exception{
		usuario = new Usuario("ananda", "ananda");
		novoUsuario = new Usuario("anandaGurgel", "ananda");
		dao = new UsuarioDao();
	}
	
	@Test
	void testValidar() {
		boolean usuarioValidado = dao.validar(usuario);
		assertTrue("Validar Usuário", usuarioValidado);
	}

	@Test
	void testCadastrar() {
		try {
			dao.cadastrar(novoUsuario);
			usuario = dao.buscar(novoUsuario);
			
			assertEquals("Verificando a função de cadastrar", novoUsuario, usuario);
			
			dao.excluir(novoUsuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
