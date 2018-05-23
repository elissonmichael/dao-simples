package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.FabricaDeConexao;
import modelo.Pessoa;

public class PessoaDAO {
	private static Connection conexao = new FabricaDeConexao().conectar();
	private Pessoa pessoa;
	
	public PessoaDAO (Pessoa pessoa){
		this.pessoa = pessoa;
	}

	public void salvar() throws SQLException {
		String sql = "INSERT INTO Pessoa (nome) VALUES (?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, this.pessoa.nome);
        stmt.execute();
        stmt.close();
	}
	
	public static ArrayList<Pessoa> listar() throws SQLException {
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		String sql = "SELECT * FROM Pessoa";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		ResultSet resultSet = stmt.executeQuery();
		while(resultSet.next()) {
			String nome = resultSet.getString("nome");
			Pessoa pessoa = new Pessoa(nome);
			pessoas.add(pessoa);
		}
		resultSet.close();
        stmt.close();
        return pessoas;
	}
	
}
