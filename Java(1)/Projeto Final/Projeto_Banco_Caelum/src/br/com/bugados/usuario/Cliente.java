package br.com.bugados.usuario;

public class Cliente {
	
	protected String nome;
	protected int cpf;
	protected int senha;
	
	public Cliente() {
	}
	
	public Cliente (String nome, int senha, int cpf) {
		this.nome = nome;
		this.senha = senha;
		this.cpf = cpf;
	}
	
	public boolean login(String password, int login) {
		int saidaPassword = Integer.parseInt(password);
		
		if (this.senha == saidaPassword && this.cpf == login) {
			System.out.println("Acesso permitido !");
			return true;
		} else if (this.cpf != login) {
			System.out.println("Usu�rio n�o encontrado");
			return false;
		} else if (this.senha != saidaPassword) {
			System.out.println("Senha inv�lida");
			return false;
		} else {
			System.out.println("Usu�rio n�o cadastrado");
			return false;
		}
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", senha=" + senha + ", cpf=" + cpf + "]";
	}
	
	
}
