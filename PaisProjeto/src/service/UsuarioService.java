package service;

import dao.UsuarioDao;
import model.Usuario;

public class UsuarioService {

	public boolean validar(Usuario usuario) {

		UsuarioDao usuarioDao = new UsuarioDao();
		return usuarioDao.validar(usuario);
	}

	public int cadastrar(Usuario usuario) {
		UsuarioDao dao = new UsuarioDao();
		try {
			return dao.cadastrar(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
