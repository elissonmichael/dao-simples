package modelo;

import dao.PessoaDAO;

public class Pessoa {
	private int id;
	public String nome;
	
	public Pessoa(String nome){
		this.nome = nome;
	}
	
	public int id() {
		return id;
	}

	public PessoaDAO DAO() {
		return new PessoaDAO(this);
	}	
}
