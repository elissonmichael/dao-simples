package view;

import java.sql.Connection;
import java.sql.SQLException;

import conexao.FabricaDeConexao;

public class Principal {

	public static void main(String[] args) throws SQLException {
		Connection conexao = new FabricaDeConexao().conectar();
		System.out.println("Conexão aberta!");
		conexao.close();
	}

}
