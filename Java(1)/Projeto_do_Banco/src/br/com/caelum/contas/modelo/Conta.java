package br.com.caelum.contas.modelo;

import javax.swing.JOptionPane;

public abstract class Conta {

	protected int numero;
	protected int agencia;
	protected String titular;
	protected String dataAbertura;
	protected double saldo;
	protected final double SELIC = 0.025;
	protected double TARIFAS = 0.00;

	public double getSaldo() {
		return saldo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public abstract String consultaTipo();

	public double consultaTarifas() {
		return TARIFAS;
	}

	public double cobraTarifas() {
		this.saldo = this.saldo - TARIFAS;
		return this.saldo;
	}

	public void saca(double valor) {
		if (this.saldo < valor) {
			System.out.printf("\nSaldo insuficiente para realizar o saque" + "\nSeu saldo atual � de: R$ %.2f%n",
					this.saldo + ".");
		} else {
			System.out.printf("\n" + this.titular + ": " + "\nValor do saque: R$ %.2f%n", (valor - TARIFAS));
			this.saldo = this.saldo - TARIFAS;
			System.out.printf("Seu saldo atual � de: R$ %.2f%n", (this.saldo - valor));
		}
	}

	public void deposita(double quantidade) {
		this.saldo += quantidade;
	}

	public void rendimentoMensal() {
		double saldoAtual = this.saldo;
		if (saldoAtual > 0) {
			this.saldo = this.saldo * SELIC + this.saldo;
			System.out.printf("Saldo ap�s rendimentos: R$ %.2f", this.saldo);
		} else {
		}
	}

	public void consultaSaldo() {
		System.out.printf("Saldo Atual de " + this.titular + ": R$ %.2f%n", this.saldo);
	}

	public void preencheConta() {

		String entradaTitular = JOptionPane.showInputDialog("Informe o nome do t�tular: ");
		String entradaNuemro = JOptionPane.showInputDialog("Informe o numero para a conta: ");
		int saidaNumero = Integer.parseInt(entradaNuemro);
		String entradaAgencia = JOptionPane.showInputDialog("Informe o numero para a agencia: ");
		int saidaAgencia = Integer.parseInt(entradaAgencia);

		this.titular = entradaTitular;
		this.numero = saidaNumero;
		this.agencia = saidaAgencia;
	}

	public void transferePara(Conta destino, double valor) {
		if (this.saldo >= valor) {
			destino.saldo = destino.saldo + valor;
			this.saldo = this.saldo - valor;
			System.out.println("\nTrnasfer�ncia realizada com sucesso !");
		} else {
			System.out.println(
					"Saldo insufici�nte para realizar a transferencia" + " seu saldo atual � de: " + this.saldo);
		}
	}

	public void recuperaDados() {
		System.out.println("\n\nDados da conta recuperados: ");
		System.out.print("\nT�tular da conta: " + this.titular);
		System.out.print("\nN�mero da conta: " + this.numero);
		System.out.print("\nAg�ncia: " + this.agencia);
		System.out.printf("\nSaldo Atual: R$ %.2f", this.saldo);
		System.out.print("\nRendimento mensal: " + this.SELIC + "%");
		System.out.print("\nData de abertura: " + this.dataAbertura);
	}
}
