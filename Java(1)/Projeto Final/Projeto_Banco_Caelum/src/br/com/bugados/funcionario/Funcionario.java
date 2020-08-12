package br.com.bugados.funcionario;

import br.com.bugados.usuario.Cliente;

public class Funcionario extends Cliente {
	
	protected String cargo;
	
	public Funcionario () {
		
	}
	
	public Funcionario(String nome, String cargo, int cpf, int senha) {
		this.nome = nome;
		this.cargo = cargo;
		this.cpf = cpf;
		this.senha = senha;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Funcionario [cargo=" + cargo + "]";
	}
	
}
