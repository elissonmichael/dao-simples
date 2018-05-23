import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
        Connection conexao = DriverManager.getConnection(
                "jdbc:mysql://localhost/javabd?autoReconnect=true&useSSL=false", 
                "transeletron", "mysql");
	    System.out.println("Conectado!");
	    conexao.close();

	}

}