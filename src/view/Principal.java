package view;

import java.sql.SQLException;
import dao.PessoaDAO;
import modelo.Pessoa;

public class Principal {
	public static void main(String[] args) throws SQLException {
		Pessoa pessoa = PessoaDAO.encontrar(5);
		pessoa.DAO().excluir();
	}

}
