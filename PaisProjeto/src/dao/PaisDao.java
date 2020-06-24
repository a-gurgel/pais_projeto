package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Pagamento;

public class PaisDao {

	public int incluir(Pagamento to) throws Exception {
		int id = 0;
		String sqlInsert = "INSERT INTO paises(nome, populacao, area) values (?,?,?)";

		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, to.getNome());
			stm.setLong(2, to.getPopulacao());
			stm.setDouble(3, to.getArea());
			stm.execute();

			try (ResultSet rs = stm.executeQuery("SELECT LAST_INSERT_ID()")) {
				if (rs.next()) {
					id = rs.getInt(1);
				}
				conn.close();
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
			return id;
		}
	}

	public void atualizar(Pagamento to) {
		String sqlUpdate = "UPDATE paises SET nome = ?, populacao = ?, area = ? where id = ?";

		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getNome());
			stm.setLong(2, to.getPopulacao());
			stm.setDouble(3, to.getArea());
			stm.setInt(4, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Pagamento to) {
		String sqlDelete = "DELETE FROM paises where id = ?";
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getId());
			stm.execute();

			conn.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Pagamento carregar(int id) {
		Pagamento to = new Pagamento();
		String sqlSelect = "SELECT id, nome, populacao, area FROM paises WHERE id = ?";

		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setId(rs.getInt("id"));
					to.setNome(rs.getString("nome"));
					to.setPopulacao(rs.getLong("populacao"));
					to.setArea(rs.getDouble("area"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

		return to;
	}

	public Pagamento maiorPopulacao() {
		Pagamento to = new Pagamento();
		String sqlSelect = "Select id, nome, populacao, area FROM paises order by populacao desc limit 1";

		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {

			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setId(rs.getInt("id"));
					to.setNome(rs.getString("nome"));
					to.setPopulacao(rs.getLong("populacao"));
					to.setArea(rs.getDouble("area"));
				} else {
					to.setId(0);
					to.setNome(null);
					to.setPopulacao(0);
					to.setArea(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

		return to;
	}

	public Pagamento menorArea() {
		Pagamento to = new Pagamento();
		String sqlSelect = "Select id, nome, populacao, area FROM paises order by area asc limit 1";

		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {

			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setId(rs.getInt("id"));
					to.setNome(rs.getString("nome"));
					to.setPopulacao(rs.getLong("populacao"));
					to.setArea(rs.getDouble("area"));
				} else {
					to.setId(0);
					to.setNome(null);
					to.setPopulacao(0);
					to.setArea(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

		return to;
	}

	public ArrayList<Pagamento> vetorTresPaises() throws Exception {
		ArrayList<Pagamento> paises = new ArrayList<Pagamento>();

		String sqlSelect = "SELECT * FROM paises limit 3";
		
		try (Connection conn = ConnectionFactory.obterConexao();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Pagamento to = new Pagamento(
						rs.getInt("id"),
						rs.getString("nome"),
						rs.getLong("populacao"),
						rs.getDouble("area")
					);
					paises.add(to);
				}
				conn.close();
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}

		return paises;	
	}
		
	
	public ArrayList<Pagamento> retornarTodosPaises() throws Exception {	
	ArrayList<Pagamento> paises = new ArrayList<Pagamento>();

	String sqlSelect = "SELECT * FROM paises";
	
	try (Connection conn = ConnectionFactory.obterConexao();
		 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
		try (ResultSet rs = stm.executeQuery()) {
			while (rs.next()) {
				Pagamento to = new Pagamento(
					rs.getInt("id"),
					rs.getString("nome"),
					rs.getLong("populacao"),
					rs.getDouble("area")
				);
				paises.add(to);
			}
			conn.close();
		} catch (SQLException ex) {
			throw new Exception(ex.getMessage());
		}
	} catch (SQLException e) {
		throw new Exception(e.getMessage());
	}

	return paises;
	}
}
