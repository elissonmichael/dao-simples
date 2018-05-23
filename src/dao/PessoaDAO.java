package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import conexao.FabricaDeConexao;
import modelo.Pessoa;

public class PessoaDAO {
	private Connection conexao;
	private Pessoa pessoa;
	
	public PessoaDAO (Pessoa pessoa){
		this.pessoa = pessoa;
		conexao = new FabricaDeConexao().conectar();
	}

	public void salvar() throws SQLException {
		String sql = "INSERT INTO Pessoa (nome) VALUES (?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, this.pessoa.nome);
        stmt.execute();
        stmt.close();
	}
	
}
