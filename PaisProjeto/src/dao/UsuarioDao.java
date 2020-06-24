package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDao {

	public boolean validar(Usuario usuario) {

		String sqlSelect = "SELECT username, password FROM usuario " 
		+ "WHERE username = ? and password = ?";

		try {
			Connection conn = ConnectionFactory.obterConexao();
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
				stm.setString(1, usuario.getUsername());
				stm.setString(2, usuario.getPassword());
				try (ResultSet rs = stm.executeQuery()) {
					if (rs.next()) {
						return true;
					} else {
						return false;
					}
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				// TODO: handle exception
				System.out.println(e1.getStackTrace());
			}
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
		return false;
	}

	public int cadastrar(Usuario to) throws Exception {
		int id = 0;
		String sqlInsert = "INSERT INTO usuario (username, password) values (?,?) ;";

		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert)) {
			stm.setString(1, to.getUsername());
			stm.setString(2, to.getPassword());

			stm.execute();

			try (ResultSet rs = stm.executeQuery("SELECT LAST_INSERT_ID()")) {
				if (rs.next()) {
					id = rs.getInt(1);
				}
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}

		return id;
		
	}
		
		public Usuario buscar(Usuario to) {
			String sqlSelect = "SELECT username, password FROM usuario WHERE username = ?";

			try (Connection conn = ConnectionFactory.obterConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, to.getUsername());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						to.setUsername(rs.getString("username"));
						to.setPassword(rs.getString("password"));
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return to;

		}
		
		public void excluir(Usuario to) {
			String sqlDelete = "DELETE FROM usuario where username = ?";

			try (Connection conn = ConnectionFactory.obterConexao();
					PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
				stm.setString(1, to.getUsername());
				stm.execute();

				conn.close();	
			} catch (SQLException e) {
				e.printStackTrace();
			}	

	}
}
