package org.serratec.java2backend.Conta;

public class Conta {
	
	private int numero;
	private String titular;
	private Double saldo;
	
	public Conta() {
		super();
	}

	public Conta(int numero, String titular, Double saldo) {
		super();
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
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
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		 this.saldo = saldo;
	}
}
