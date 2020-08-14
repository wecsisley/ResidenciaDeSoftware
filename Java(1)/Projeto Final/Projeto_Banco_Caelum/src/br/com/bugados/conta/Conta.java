package br.com.bugados.conta;

import javax.swing.JOptionPane;

import br.com.bugados.exceptions.DepositoIndevido;
import br.com.bugados.impostos.SeguroDeVida;

public abstract class Conta implements SeguroDeVida{

	protected String titular;
	protected int numero;
	protected int agencia;
	protected int tipo;
	protected int cpf;
	protected double saldo;

	public Conta() {

	}

	public Conta(int cpf, int numero, int agencia, double saldo, int tipo) {
		this.cpf = cpf;
		this.numero = numero;
		this.agencia = agencia;
		this.saldo = saldo;
		this.tipo = tipo;
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

	public void consultaTipo() {

	}

	public void deposita(double valor) {
		if(valor > 0.1) {
		this.saldo += valor ;
		}else {
			throw new DepositoIndevido("Valor de deposito invalido");
		}
	}

	public boolean saca(double valor) {
		if (this.saldo < valor) {
			System.out.println("Saldo insuficiente!!!");
			return false;
		} else {
			this.saldo -= valor;
			return true;
		}
	}

	public boolean transferePara(Conta destino, double valor) {
		if (this.saldo >= valor) {
			destino.saldo = destino.saldo + valor;
			this.saldo = this.saldo - valor;
			return true;
		} else {
			System.out.println("N�o h� saldo suficiente para transferir esse valor!!!");
			return false;
		}
	}

	public void menuOpcoes(double valorSaca, double valorDeposito, Conta destino, double valorTransferido) {
		this.saca(valorSaca);
		this.deposita(valorDeposito);
		this.transferePara(destino, valorTransferido);
		this.consultaSaldo();
	}

	public void consultaSaldo() {
		System.out.printf("R$ %.2f%n", this.saldo);
	}

	public void atualiza(double taxaSelic) {
		this.saldo += this.saldo * taxaSelic;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public int getCpfTitular() {
		return cpf;
	}

	public void setCpfTitular(int cpf) {
		this.cpf = cpf;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
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

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Conta [titular=" + titular + ", numero=" + numero + ", agencia=" + agencia + ", tipo=" + tipo
				+ ", cpfTitular=" + cpf + ", saldo=" + saldo + "]";
	}

}
