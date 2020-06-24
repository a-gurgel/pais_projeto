package command;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import service.UsuarioService;
import arquivoLog.AlgoritmoCripto;

public class Cadastrar implements Command{
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome = request.getParameter("username");
		String senha = request.getParameter("password");
		
		Usuario usuario = new Usuario();
		usuario.setUsername(nome);
		
		AlgoritmoCripto crypto = new AlgoritmoCripto();

		try {
			String senhaCrypto = crypto.cryptoSHA(senha);
			usuario.setPassword(senhaCrypto);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		UsuarioService service = new UsuarioService();
		
		try {
			int id = service.cadastrar(usuario);	
			
			if(id != -1) response.sendRedirect("Login.jsp");
			else response.sendRedirect("Registrar.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}


