package br.com.bugados.funcionario;

public class Diretor extends Funcionario {

	@Override
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
}
