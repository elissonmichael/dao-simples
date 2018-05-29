package view;
import dao.PessoaDAO;
import modelo.Pessoa;

public class Principal {
	
	public static void exemploDeUso() {
		Pessoa fulano = new Pessoa("Fulano");
		fulano.DAO().salvar();
		Pessoa sicrano = new Pessoa("Sicrano");
		sicrano.DAO().salvar();
		for(Pessoa pessoa : PessoaDAO.listar()) {
			System.out.println(pessoa);
			pessoa.DAO().excluir();
		}
	}
	
	public static void main(String[] args) {

	}
}
