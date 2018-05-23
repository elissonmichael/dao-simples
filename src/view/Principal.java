package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.FabricaDeConexao;

public class Principal {

	public static void main(String[] args) throws SQLException {
		Connection conexao = new FabricaDeConexao().conectar();

		String sql = "INSERT INTO Pessoa (nome) VALUES (?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setString(1, "Élisson Michael");
        stmt.execute();
        stmt.close();

		conexao.close();
	}

}
