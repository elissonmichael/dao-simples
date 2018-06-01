package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexao.FabricaDeConexao;
import modelo.Pessoa;

public class PessoaDAO {
	private static Connection conexao = new FabricaDeConexao().conectar();
	private Pessoa pessoa;
	
	public PessoaDAO (Pessoa pessoa){
		this.pessoa = pessoa;
	}

	public void salvar() {
		if(pessoa.id != 0) {
			alterarRegistro();
		} else {
			criarRegistro();
		}
	}

	public void excluir() {
		String sql = "DELETE FROM Pessoa WHERE id=?";
		try {
	        PreparedStatement stmt = conexao.prepareStatement(sql);
	        stmt.setInt(1, pessoa.id);
	        stmt.execute();
	        stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static ArrayList<Pessoa> listar() {
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		String sql = "SELECT * FROM Pessoa";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet resultSet = stmt.executeQuery();
			while(resultSet.next()) 
				pessoas.add(objeto(resultSet));
			resultSet.close();
	        stmt.close();
	        return pessoas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
		
	public static Pessoa encontrar(int id) {
		String sql = "SELECT * FROM Pessoa WHERE id = ?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet resultSet = stmt.executeQuery();
			resultSet.next();
	        return objeto(resultSet);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static Pessoa objeto(ResultSet resultSet) {
		try {
			Pessoa pessoa = new Pessoa(resultSet.getString("nome"));
			pessoa.id = resultSet.getInt("id");
	        return pessoa;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void criarRegistro() {
		String sql = "INSERT INTO Pessoa (nome) VALUES (?)";
		try {
	        PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	        stmt.setString(1, pessoa.nome);
	        stmt.execute();
	        ResultSet resultSet = stmt.getGeneratedKeys();
	        if (resultSet.next()) pessoa.id = resultSet.getInt(1);
	        stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void alterarRegistro() {
		String sql = "UPDATE Pessoa SET nome=? WHERE id=?";
		try {
	        PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	        stmt.setString(1, pessoa.nome);
	        stmt.setInt(2, pessoa.id);
	        stmt.execute();
	        stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
