package modelo;

import dao.PessoaDAO;

public class Pessoa {
	public int id;
	public String nome;
	
	public Pessoa(String nome){
		this.nome = nome;
	}
	
	public String toString() {
		return id + " - " + nome;
	}
	
	public PessoaDAO DAO() {
		return new PessoaDAO(this);
	}	
}
