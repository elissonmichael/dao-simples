package view;
import dao.PessoaDAO;
import modelo.Pessoa;

public class Principal {
	public static void exemploDeCriacao() {
		Pessoa fulano = new Pessoa("Fulano");
		fulano.DAO().salvar(); 
		new Pessoa("Sicrano").DAO().salvar();
	}

	public static void exemploDePesquisaComFiltro() {
		for(Pessoa pessoa : PessoaDAO.filtrar("nome", "Sicrano"))
			System.out.println("Filtro: " + pessoa);
	}
	
	public static void exemploDeListagemCompleta() {
		for(Pessoa pessoa : PessoaDAO.listar())
			System.out.println(pessoa);	
	}
	
	public static void exemploDeExclusao() {
		for(Pessoa pessoa : PessoaDAO.listar())
			pessoa.DAO().excluir();
	}
	
	public static void main(String[] args) {

	}
}
