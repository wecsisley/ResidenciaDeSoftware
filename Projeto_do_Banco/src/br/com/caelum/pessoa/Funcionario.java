package br.com.caelum.pessoa;

public abstract class Funcionario {

	protected String nome;
	protected String cpf;
	protected double salario;

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Funcionario(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSalario() {
		return salario;
	}

	public abstract double getBonificacao();

	public void imprimeSalario() {
		System.out.print("Salario " + this.nome + ": ");
		System.out.printf("%.2f%n", (this.salario + getBonificacao()));
	}

	public void consultaBonificacao() {
		System.out.printf("Bonifica��o " + this.nome + ": %.2f%n", this.getBonificacao());
	}
}
