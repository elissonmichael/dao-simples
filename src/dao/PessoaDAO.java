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

	public void salvar() throws SQLException {
		String sql = "INSERT INTO Pessoa (nome) VALUES (?)";
        PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, this.pessoa.nome);
        stmt.execute();
        ResultSet resultSet = stmt.getGeneratedKeys();
        if (resultSet.next())
        	this.pessoa.id = resultSet.getInt(1);
        stmt.close();
	}

	public void excluir() throws SQLException {
		String sql = "DELETE FROM Pessoa WHERE id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, this.pessoa.id);
        stmt.execute();
        stmt.close();
	}
	
	public static ArrayList<Pessoa> listar() throws SQLException {
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		String sql = "SELECT * FROM Pessoa";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		ResultSet resultSet = stmt.executeQuery();
		while(resultSet.next()) 
			pessoas.add(traduzir(resultSet));
		resultSet.close();
        stmt.close();
        return pessoas;
	}
	
	
	public static Pessoa encontrar(int id) throws SQLException {
		String sql = "SELECT * FROM Pessoa WHERE id = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet resultSet = stmt.executeQuery();
		resultSet.next();
        return traduzir(resultSet);
	}
	
	private static Pessoa traduzir(ResultSet resultSet) throws SQLException {
		Pessoa pessoa = new Pessoa(resultSet.getString("nome"));
		pessoa.id = resultSet.getInt("id");
        return pessoa;
	}
	
}
