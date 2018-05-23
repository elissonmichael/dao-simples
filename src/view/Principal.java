package view;

import java.sql.SQLException;
import dao.PessoaDAO;
import modelo.Pessoa;

public class Principal {
	public static void main(String[] args) throws SQLException {
		for(Pessoa pessoa : PessoaDAO.listar()) {
			System.out.println(pessoa.id + " - " + pessoa.nome);
		}
	}

}
