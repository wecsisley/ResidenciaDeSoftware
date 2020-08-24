package org.serratec.java2backend.service;

import org.serratec.java2backend.Conta.Conta;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

	
	public Conta getAll(Conta essaConta) {
		return essaConta;
	}
	
	public Double consultaSaldo(Conta conta) {
		return conta.getSaldo();
	}
	
	public boolean saca(Conta essaConta, Double valorDeSaque ) {
		if(valorDeSaque > essaConta.getSaldo()) {
			System.out.println("Saldo insuficiênte");
			return false;
		}else {
			System.out.printf("Saque no valor de: R$%.2f%n", valorDeSaque + " foi realizado com sucesso !");
			essaConta.setSaldo(essaConta.getSaldo() - valorDeSaque);
			return true;
		}
	}
	
	public boolean deposita(Conta essaConta, Double valorDeDeposito) {
		if(valorDeDeposito <= 0) {
			System.out.println("Impossível depositar valores negativos ou zerados");
			return false;
		}else {
			System.out.printf("Deposito no valor de: R$%.2f%n", valorDeDeposito + " realizado com sucesso !");
			return true;
		}
	}
}
