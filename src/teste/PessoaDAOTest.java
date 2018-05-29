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
	
	@BeforeEach
	void setUp() {
		fulano = new Pessoa("Fulano");		
		fulano.DAO().salvar();
	}
	
	@AfterEach
	void tearDown() {
		fulano.DAO().excluir();
	}
	
	@Test
	void testSalvar() {
		Pessoa fulanoNoBanco = PessoaDAO.encontrar(fulano.id);
		assertEquals(fulano.toString(), fulanoNoBanco.toString());
	}

	@Test
	void testListar() {
		ArrayList<String> pessoasNoBanco = new ArrayList<String>();
		for(Pessoa pessoa : PessoaDAO.listar())
			pessoasNoBanco.add(pessoa.toString());
		assertEquals(pessoasNoBanco, Arrays.asList(fulano.toString()));
	}
}
