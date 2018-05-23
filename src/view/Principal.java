package view;

import java.sql.SQLException;

import modelo.Pessoa;

public class Principal {

	public static void main(String[] args) throws SQLException {
		Pessoa pessoa = new Pessoa("Élisson");
		pessoa.DAO().salvar();
	}

}
