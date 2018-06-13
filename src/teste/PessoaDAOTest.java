package teste;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import dao.PessoaDAO;
import modelo.Pessoa;

class PessoaDAOTest {
	private Pessoa fulano;
	private Pessoa sicrano;

	@BeforeEach
	void setUp() {
		fulano = new Pessoa("Fulano");		
		fulano.DAO().salvar();
		sicrano = new Pessoa("Sicrano");		
		sicrano.DAO().salvar();
	}
	
	@AfterEach
	void tearDown() {
		fulano.DAO().excluir();
		sicrano.DAO().excluir();
	}
	
	@Test
	void testSalvarEmUmaNovaInstanciaCriaUmNovoRegistro() {
		Pessoa fulanoNoBanco = PessoaDAO.encontrar(fulano.id);
		assertEquals(fulano.toString(), fulanoNoBanco.toString());
	}

	@Test
	void testSalvarAposEdicaoAlteraRegistroExistente() {
		int idAnterior = fulano.id;
		fulano.nome = "Sicrano";
		fulano.DAO().salvar();
		Pessoa fulanoNoBanco = PessoaDAO.encontrar(fulano.id);
		assertEquals(fulano.id, idAnterior);
		assertEquals(fulano.toString(), fulanoNoBanco.toString());
	}
	
	@Test
	void testListar() {
		ArrayList<String> pessoasNoBanco = new ArrayList<String>();
		for(Pessoa pessoa : PessoaDAO.listar())
			pessoasNoBanco.add(pessoa.toString());
		assertEquals(Arrays.asList(fulano.toString(), 
								   sicrano.toString()),
					 pessoasNoBanco);
	}
	
	@Test
	void testFiltro() {
		ArrayList<String> pessoasNoBanco = new ArrayList<String>();
		for(Pessoa pessoa : PessoaDAO.filtrar("nome", "Fulano"))
			pessoasNoBanco.add(pessoa.toString());
		assertEquals(Arrays.asList(fulano.toString()), 
					 pessoasNoBanco);
	}
}
