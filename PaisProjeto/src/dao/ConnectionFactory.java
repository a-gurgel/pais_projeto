package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	//singleton da conexão - thread safe
	private static final ThreadLocal<Connection> conn = new ThreadLocal<>();
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	// Obtém conexão com o banco de dados
	public static Connection obterConexao() throws SQLException {
		String servidor = "localhost";
		String porta = "3306";
		String database = "pais";
		if (conn.get() == null){
			conn.set(DriverManager
					.getConnection("jdbc:mysql://"+servidor+":"+porta+"/"+database+"?useTimezone=true&serverTimezone=UTC", "root", "root"));
		}
		return conn.get();
	}
	public static void fecharConexao() throws SQLException {
		if(conn.get() != null){
			conn.get().close();
			conn.set(null);
		}
	}
}