package br.com.caelum.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.GeradorDeContas;
import br.com.caelum.pessoa.Cliente;

public class TestesLeitorCSV {

	public static void main(String[] args) throws IOException {

		String linha;
		int cpf = 0;
		String nome = "";

		GeradorDeContas instaciaContas = new GeradorDeContas();
		Conta novaConta = instaciaContas;

		Cliente novoCliente = new Cliente();

		BufferedReader csvReader = new BufferedReader(new FileReader("csvCliente.csv"));
		linha = csvReader.readLine();

		String[] data;
		
		Map<Integer, String> map = new HashMap<>();

		while ((linha = csvReader.readLine()) != null) {
			linha = linha.replace("\"", "");

			data = linha.split(";");

			 nome = data[0];
			String tipo = data[3];
			 cpf = Integer.parseInt(data[1]);
			int senha = Integer.parseInt(data[2]);
			int numero = Integer.parseInt(data[4]);
			int agencia = Integer.parseInt(data[5]);
			
			novaConta.setTitular(data[0]);
			novaConta.setNumero(numero);
			novaConta.setAgencia(agencia);
			novaConta.setTipo(tipo);
			
			novoCliente.setNome(nome);
			novoCliente.setCpf(cpf);
			novoCliente.setSenha(senha);
			
			/*System.out.println("\nNome: " + novoCliente.getNome() + " / CPF: " + novoCliente.getCpf() + " / Senha: "
					+ novoCliente.getSenha() + " / Numero: " + novaConta.getNumero() + " / Agencia: " + novaConta.getAgencia()
					+ " / Tipo: " + novaConta.getTipo());*/
		}
		map.put(cpf, nome);
		for(String key : map.values()) {
			System.out.println(key);
		}
		csvReader.close();
	}
}
