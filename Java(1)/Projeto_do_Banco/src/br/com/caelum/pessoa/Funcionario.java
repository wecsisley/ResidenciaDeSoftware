package br.com.caelum.pessoa;

public abstract class Funcionario extends Cliente{

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

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
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
		System.out.printf("Bonificação " + this.nome + ": %.2f%n", this.getBonificacao());
	}
}
