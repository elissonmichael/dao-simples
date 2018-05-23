package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {
	public Connection conectar() {
		try {
			return DriverManager.getConnection(
			        "jdbc:mysql://localhost/javabd?useSSL=false", 
			        "transeletron", "mysql");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}