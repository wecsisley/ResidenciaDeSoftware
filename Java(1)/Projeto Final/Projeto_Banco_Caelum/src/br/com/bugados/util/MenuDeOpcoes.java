package br.com.bugados.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import br.com.bugados.conta.Conta;
import br.com.bugados.conta.ContaCorrente;
import br.com.bugados.conta.ContaPoupanca;
import br.com.bugados.conta.MapaDasContas;
import br.com.bugados.funcionario.Funcionario;
import br.com.bugados.usuario.Cliente;

public class MenuDeOpcoes {

	public static void menuCliente(int cpfLogin, Map<Integer, Conta> mapConta, Map<Integer, Cliente> mapCliente,
			Map<Integer, Funcionario> mapFuncionario) {
		boolean clienteCadastrado;
		int controle = 1;
		int contDeposita = 0;
		int contSaca = 0;
		int contTransfere = 0;
		double valorSeguro = 0;

		Conta conta1 = mapConta.get(cpfLogin);

		while (controle == 1) {

			if (conta1.getTipo() == 1) {

				ContaCorrente conta = (br.com.bugados.conta.ContaCorrente) mapConta.get(cpfLogin);

				String entrada = JOptionPane
						.showInputDialog("------- TIPO DE OPERA��O -------" + "\n\n 1 - Dep�sito" + "\n 2 - Saque"
								+ "\n 3 - Transfer�ncia" + "\n 4 - Consulta Saldo" + "\n 5 - Contratar Seguro de Vida"
								+ "\n 6 - Extrato de tarifas" + "\n 7 - Sair" + "\n                     BugadosBank\n");
				int saida = Integer.parseInt(entrada);

				if (saida == 1) {
					String entradaDeposito = JOptionPane.showInputDialog("Digite o valor que deseja depositar:");
					double valorDeposito = Double.parseDouble(entradaDeposito);
					conta.deposita(valorDeposito);

					MapaDasContas.atualizaTxt(conta);

					contDeposita = contDeposita + 1;
				} else if (saida == 2) {
					String entradaSaque = JOptionPane.showInputDialog("Digite o valor que deseja sacar:");
					double valorSaque = Double.parseDouble(entradaSaque);
					if (conta.saca(valorSaque)) {

						MapaDasContas.atualizaTxt(conta);

						contSaca = contSaca + 1;
					} else {
						conta.consultaSaldo();
					}
				} else if (saida == 3) {
					int cpfDestino = InteracaoUsuario.lerInteiros("Informe o cpf da conta destino: ");
					clienteCadastrado = mapCliente.containsKey(cpfDestino);
					if (clienteCadastrado) {
						Conta contaDestino = mapConta.get(cpfDestino);
						double valorTransferido = InteracaoUsuario.lerDoubles("Informe o valor � ser transferido: ");
						if (conta.transferePara(contaDestino, valorTransferido)) {

							System.out.printf("Valor transferido foi de: R$ %.2f%n", valorTransferido);
							System.out.print("Saldo atual de " + conta.getTitular() + " ");
							conta.consultaSaldo();
							MapaDasContas.atualizaTxt(conta);
							MapaDasContas.atualizaTxt(contaDestino);

							contTransfere = contTransfere + 1;
						} else {
							conta.consultaSaldo();
						}
					}
				} else if (saida == 4) {
					System.out.print("Saldo atual de " + conta.getTitular() + ": ");
					conta.consultaSaldo();
				} else if (saida == 5) {

					valorSeguro = InteracaoUsuario.lerDoubles("Informe o valor que deseja assegurar: ");

					if (conta.getSaldo() >= valorSeguro * 0.2) {

						System.out.printf("Valor assegurado: R$ %.2f%n", valorSeguro);
						System.out.println("valor da ap�lice: R$ " + conta.seguroDeVida(valorSeguro));

					} else {
						System.out.println("Saldo insuficiente");
					}

				} else if (saida == 6) {
					System.out.print("Total gasto em " + contDeposita + " dep�sitos com taxa de R$ 0,10: ");
					System.out.printf("R$ %.2f%n", (contDeposita * 0.10));

					System.out.print("Total gasto em " + contSaca + " saques com taxa de R$ 0,10: ");
					System.out.printf("R$ %.2f%n", (contSaca * 0.10));

					System.out.print("Total gasto em " + contTransfere + " transfer�ncias com taxa de R$ 0,20: ");
					System.out.printf("R$ %.2f%n", (contTransfere * 0.20));

					System.out.printf("Tarifa Seguro de vida: R$ %.2f%n", (valorSeguro * 0.2));

					System.out.printf("Total de tarifas cobradas: R$ %.2f%n",
							(conta.consultaTotalTaxas() + (valorSeguro * 0.2)));

				} else if (saida == 7) {
					controle = 2;
				}
			}

			if (conta1.getTipo() == 2) {

				ContaPoupanca conta = (br.com.bugados.conta.ContaPoupanca) mapConta.get(cpfLogin);

				String entrada = JOptionPane.showInputDialog("------- TIPO DE OPERA��O -------" + "\n\n 1 - Dep�sito"
						+ "\n 2 - Saque" + "\n 3 - Simula��o rendimento poupan�a" + "\n 4 - Transfer�ncia"
						+ "\n 5 - Consulta Saldo" + "\n 6 - Contratar Seguro de Vida" + "\n 7 - Sair"
						+ "\n                     BugadosBank\n");
				int saida = Integer.parseInt(entrada);
				if (saida == 1) {
					String entradaDeposito = JOptionPane.showInputDialog("Digite o valor que deseja depositar:");
					double valorDeposito = Double.parseDouble(entradaDeposito);
					conta.deposita(valorDeposito);

					MapaDasContas.atualizaTxt(conta);

					contDeposita = contDeposita + 1;
				} else if (saida == 2) {
					String entradaSaque = JOptionPane.showInputDialog("Digite o valor que deseja sacar:");
					double valorSaque = Double.parseDouble(entradaSaque);
					if (conta.saca(valorSaque)) {
						conta.consultaSaldo();
						MapaDasContas.atualizaTxt(conta);

						contSaca = contSaca + 1;
					} else {
						conta.consultaSaldo();
					}
				} else if (saida == 3) {
					conta.poupancudos();
				} else if (saida == 4) {
					int cpfDestino = InteracaoUsuario.lerInteiros("Informe o cpf da conta destino: ");
					clienteCadastrado = mapCliente.containsKey(cpfDestino);
					if (clienteCadastrado) {
						Conta contaDestino = mapConta.get(cpfDestino);
						double valorTransferido = InteracaoUsuario.lerDoubles("Informe o valor � ser transferido: ");
						if (conta.transferePara(contaDestino, valorTransferido)) {
							System.out.printf("Valor transferido foi de: R$ %.2f%n", valorTransferido);
							System.out.print("Saldo atual de " + conta.getTitular());
							conta.consultaSaldo();

							MapaDasContas.atualizaTxt(conta);
							MapaDasContas.atualizaTxt(contaDestino);

							contTransfere = contTransfere + 1;
						} else {
							conta.consultaSaldo();
						}
					}
				} else if (saida == 5) {
					System.out.print("Saldo atual de " + conta.getTitular() + ": ");
					conta.consultaSaldo();
				} else if (saida == 6) {

					valorSeguro = InteracaoUsuario.lerDoubles("Informe o valor que deseja assegurar: ");

					if (conta.getSaldo() >= valorSeguro * 0.2) {

						System.out.printf("Valor assegurado: R$ %.2f%n", valorSeguro);
						System.out.println("valor da ap�lice: R$ " + conta.seguroDeVida(valorSeguro));

					} else {
						System.out.println("Saldo insuficiente");
					}

				} else if (saida == 7) {

					controle = 2;
				}
			}
		}
		System.out.println("\n|--------------------------------|");
		System.out.println("|                                |");
		System.out.println("|          BugadosBank           |");
		System.out.println("|                                |");
		System.out.println("|--------------------------------|");
	}

	public static void menuGerente(int cpfLogin, Map<Integer, Conta> mapConta, Map<Integer, Cliente> mapCliente,
			Map<Integer, Funcionario> mapFuncionario) {
		boolean clienteCadastrado;
		int controle = 1;
		int contDeposita = 0;
		int contSaca = 0;
		int contTransfere = 0;
		double valorSeguro = 0;

		Conta conta1 = mapConta.get(cpfLogin);

		while (controle == 1) {

			if (conta1.getTipo() == 1) {

				ContaCorrente conta = (br.com.bugados.conta.ContaCorrente) mapConta.get(cpfLogin);

				String entrada = JOptionPane.showInputDialog("------- TIPO DE OPERA��O -------" + "\n\n 1 - Dep�sito"
						+ "\n 2 - Saque" + "\n 3 - Transfer�ncia" + "\n 4 - Consulta Saldo"
						+ "\n 5 - Contratar Seguro de Vida" + "\n 6 - Consulta tarifas" + "\n 7 - Relat�rio Gerente"
						+ "\n 8 - Sair" + "\n                     BugadosBank\n");
				int saida = Integer.parseInt(entrada);

				if (saida == 1) {
					String entradaDeposito = JOptionPane.showInputDialog("Digite o valor que deseja depositar:");
					double valorDeposito = Double.parseDouble(entradaDeposito);
					conta.deposita(valorDeposito);

					MapaDasContas.atualizaTxt(conta);

					contDeposita = contDeposita + 1;
				} else if (saida == 2) {
					String entradaSaque = JOptionPane.showInputDialog("Digite o valor que deseja sacar:");
					double valorSaque = Double.parseDouble(entradaSaque);
					if (conta.saca(valorSaque)) {

						MapaDasContas.atualizaTxt(conta);

						contSaca = contSaca + 1;
					} else {
						conta.consultaSaldo();
					}
				} else if (saida == 3) {
					int cpfDestino = InteracaoUsuario.lerInteiros("Informe o cpf da conta destino: ");
					clienteCadastrado = mapCliente.containsKey(cpfDestino);
					if (clienteCadastrado) {
						Conta contaDestino = mapConta.get(cpfDestino);
						double valorTransferido = InteracaoUsuario.lerDoubles("Informe o valor � ser transferido: ");
						if (conta.transferePara(contaDestino, valorTransferido)) {
							System.out.printf("Valor transferido foi de: R$ %.2f%n", valorTransferido);
							System.out.print("Saldo atual de " + conta.getTitular());
							conta.consultaSaldo();

							MapaDasContas.atualizaTxt(conta);
							MapaDasContas.atualizaTxt(contaDestino);

							contTransfere = contTransfere + 1;
						} else {
							conta.consultaSaldo();
						}
					}
				} else if (saida == 4) {
					System.out.print("Saldo atual de " + conta.getTitular() + ": ");
					conta.consultaSaldo();
				} else if (saida == 5) {

					valorSeguro = InteracaoUsuario.lerDoubles("Informe o valor que deseja assegurar: ");

					if (conta.getSaldo() >= valorSeguro * 0.2) {

						System.out.printf("Valor assegurado: R$ %.2f%n", valorSeguro);
						System.out.println("valor da ap�lice: R$ " + conta.seguroDeVida(valorSeguro));

					} else {
						System.out.println("Saldo insuficiente");
					}

				} else if (saida == 6) {
					System.out.print("Total gasto em " + contDeposita + " dep�sitos com taxa de R$ 0,10: ");
					System.out.printf("R$ %.2f%n", (contDeposita * 0.10));

					System.out.print("Total gasto em " + contSaca + " saques com taxa de R$ 0,10: ");
					System.out.printf("R$ %.2f%n", (contSaca * 0.10));

					System.out.print("Total gasto em " + contTransfere + " transfer�ncias com taxa de R$ 0,20: ");
					System.out.printf("R$ %.2f%n", (contTransfere * 0.20));

					System.out.printf("Tarifa Seguro de vida: R$ %.2f%n", (valorSeguro * 0.2));

					System.out.printf("Total de tarifas cobradas: R$ %.2f%n",
							(conta.consultaTotalTaxas() + (valorSeguro * 0.2)));

				} else if (saida == 7) {

					for (Conta c : mapConta.values()) {
						if (c.getAgencia() == conta.getAgencia()) {
							System.out.println(c);
						}
					}

				} else if (saida == 8) {
					controle = 2;
				}
			}

			if (conta1.getTipo() == 2) {

				ContaPoupanca conta = (br.com.bugados.conta.ContaPoupanca) mapConta.get(cpfLogin);

				String entrada = JOptionPane.showInputDialog("------- TIPO DE OPERA��O -------" + "\n\n 1 - Dep�sito"
						+ "\n 2 - Saque" + "\n 3 - Simula��o rendimento poupan�a" + "\n 4 - Transfer�ncia"
						+ "\n 5 - Consulta Saldo" + "\n 6 - Contratar Seguro de Vida" + "\n 7 - Relat�rio Gerente"
						+ "\n 8 - Sair" + "\n                     BugadosBank\n");
				int saida = Integer.parseInt(entrada);
				if (saida == 1) {
					String entradaDeposito = JOptionPane.showInputDialog("Digite o valor que deseja depositar:");
					double valorDeposito = Double.parseDouble(entradaDeposito);
					conta.deposita(valorDeposito);

					MapaDasContas.atualizaTxt(conta);

					contDeposita = contDeposita + 1;
				} else if (saida == 2) {
					String entradaSaque = JOptionPane.showInputDialog("Digite o valor que deseja sacar:");
					double valorSaque = Double.parseDouble(entradaSaque);
					if (conta.saca(valorSaque)) {

						MapaDasContas.atualizaTxt(conta);

						contSaca = contSaca + 1;
					} else {
						conta.consultaSaldo();
					}
				} else if (saida == 3) {
					conta.poupancudos();
				} else if (saida == 4) {
					int cpfDestino = InteracaoUsuario.lerInteiros("Informe o cpf da conta destino: ");
					clienteCadastrado = mapCliente.containsKey(cpfDestino);
					if (clienteCadastrado) {
						Conta contaDestino = mapConta.get(cpfDestino);
						double valorTransferido = InteracaoUsuario.lerDoubles("Informe o valor � ser transferido: ");
						if (conta.transferePara(contaDestino, valorTransferido)) {
							System.out.printf("Valor transferido foi de: R$ %.2f%n", valorTransferido);
							System.out.print("Saldo atual de " + conta.getTitular());
							conta.consultaSaldo();

							MapaDasContas.atualizaTxt(conta);
							MapaDasContas.atualizaTxt(contaDestino);

							contTransfere = contTransfere + 1;
						} else {
							conta.consultaSaldo();
						}
					}
				} else if (saida == 5) {
					System.out.print("Saldo atual de " + conta.getTitular() + ": ");
					conta.consultaSaldo();
				} else if (saida == 6) {

					valorSeguro = InteracaoUsuario.lerDoubles("Informe o valor que deseja assegurar: ");

					if (conta.getSaldo() >= valorSeguro * 0.2) {

						System.out.printf("Valor assegurado: R$ %.2f%n", valorSeguro);
						System.out.println("valor da ap�lice: R$ " + conta.seguroDeVida(valorSeguro));

					} else {
						System.out.println("Saldo insuficiente");
					}

				} else if (saida == 7) {

					for (Conta c : mapConta.values()) {
						if (c.getAgencia() == conta.getAgencia()) {
							System.out.println(c);
						}
					}

				} else if (saida == 8) {
					controle = 2;
				}
			}
		}
		System.out.println("\n|--------------------------------|");
		System.out.println("|                                |");
		System.out.println("|          BugadosBank           |");
		System.out.println("|                                |");
		System.out.println("|--------------------------------|");
	}

	public static void menuDiretor(int cpfLogin, Map<Integer, Conta> mapConta, Map<Integer, Cliente> mapCliente,
			Map<Integer, Funcionario> mapFuncionario) {
		boolean clienteCadastrado;
		int controle = 1;
		int contDeposita = 0;
		int contSaca = 0;
		int contTransfere = 0;
		double valorSeguro = 0;

		Conta conta1 = mapConta.get(cpfLogin);

		while (controle == 1) {

			if (conta1.getTipo() == 1) {

				ContaCorrente conta = (br.com.bugados.conta.ContaCorrente) mapConta.get(cpfLogin);

				String entrada = JOptionPane.showInputDialog("------- TIPO DE OPERA��O -------" + "\n\n 1 - Dep�sito"
						+ "\n 2 - Saque" + "\n 3 - Transfer�ncia" + "\n 4 - Consulta Saldo"
						+ "\n 5 - Contratar Seguro de Vida" + "\n 6 - Consulta tarifas" + "\n 7 - Relat�rio Gerente"
						+ "\n 8 - Relat�rio Dirietor" + "\n 9 - Sair" + "\n                     BugadosBank\n");
				int saida = Integer.parseInt(entrada);

				if (saida == 1) {
					String entradaDeposito = JOptionPane.showInputDialog("Digite o valor que deseja depositar:");
					double valorDeposito = Double.parseDouble(entradaDeposito);
					conta.deposita(valorDeposito);

					MapaDasContas.atualizaTxt(conta);

					contDeposita = contDeposita + 1;
				} else if (saida == 2) {
					String entradaSaque = JOptionPane.showInputDialog("Digite o valor que deseja sacar:");
					double valorSaque = Double.parseDouble(entradaSaque);
					if (conta.saca(valorSaque)) {

						MapaDasContas.atualizaTxt(conta);

						contSaca = contSaca + 1;
					} else {
						conta.consultaSaldo();
					}
				} else if (saida == 3) {
					int cpfDestino = InteracaoUsuario.lerInteiros("Informe o cpf da conta destino: ");
					clienteCadastrado = mapCliente.containsKey(cpfDestino);
					if (clienteCadastrado) {
						Conta contaDestino = mapConta.get(cpfDestino);
						double valorTransferido = InteracaoUsuario.lerDoubles("Informe o valor � ser transferido: ");
						if (conta.transferePara(contaDestino, valorTransferido)) {
							System.out.printf("Valor transferido foi de: R$ %.2f%n", valorTransferido);
							System.out.print("Saldo atual de " + conta.getTitular());
							conta.consultaSaldo();

							MapaDasContas.atualizaTxt(conta);
							MapaDasContas.atualizaTxt(contaDestino);

							contTransfere = contTransfere + 1;
						} else {
							conta.consultaSaldo();
						}
					}
				} else if (saida == 4) {
					System.out.print("Saldo atual de " + conta.getTitular() + ": ");
					conta.consultaSaldo();
				} else if (saida == 5) {

					valorSeguro = InteracaoUsuario.lerDoubles("Informe o valor que deseja assegurar: ");

					if (conta.getSaldo() >= valorSeguro * 0.2) {

						System.out.printf("Valor assegurado: R$ %.2f%n", valorSeguro);
						System.out.println("valor da ap�lice: R$ " + conta.seguroDeVida(valorSeguro));

					} else {
						System.out.println("Saldo insuficiente");
					}

				} else if (saida == 6) {
					System.out.print("Total gasto em " + contDeposita + " dep�sitos com taxa de R$ 0,10: ");
					System.out.printf("R$ %.2f%n", (contDeposita * 0.10));

					System.out.print("Total gasto em " + contSaca + " saques com taxa de R$ 0,10: ");
					System.out.printf("R$ %.2f%n", (contSaca * 0.10));

					System.out.print("Total gasto em " + contTransfere + " transfer�ncias com taxa de R$ 0,20: ");
					System.out.printf("R$ %.2f%n", (contTransfere * 0.20));

					System.out.printf("Tarifa Seguro de vida: R$ %.2f%n", (valorSeguro * 0.2));

					System.out.printf("Total de tarifas cobradas: R$ %.2f%n",
							(conta.consultaTotalTaxas() + (valorSeguro * 0.2)));

				} else if (saida == 7) {

					for (Conta c : mapConta.values()) {
						if (c.getAgencia() == conta.getAgencia()) {
							System.out.println(c);
						}
					}

				} else if (saida == 8) {
					System.out.println("Relat�rio de contas cadastradas no banco: ");

					List<Conta> listaContas = new ArrayList<Conta>(mapConta.values());
					listaContas.sort(Comparator.comparing(Conta::getTitular));
					for (int i = 0; i < listaContas.size(); i++) {
						listaContas.get(i);

						System.out.println(listaContas.get(i));
					}

				} else if (saida == 9) {
					controle = 2;
				}
			}

			if (conta1.getTipo() == 2) {

				ContaPoupanca conta = (br.com.bugados.conta.ContaPoupanca) mapConta.get(cpfLogin);

				String entrada = JOptionPane.showInputDialog("------- TIPO DE OPERA��O -------" + "\n\n 1 - Dep�sito"
						+ "\n 2 - Saque" + "\n 3 - Simula��o rendimento poupan�a" + "\n 4 - Transfer�ncia"
						+ "\n 5 - Consulta Saldo" + "\n 6 - Contratar Seguro de Vida" + "\n 7 - Relat�rio Gerente"
						+ "8 - Relat�rio Diretor" + "\n 9 - Sair" + "\n                     BugadosBank\n");
				int saida = Integer.parseInt(entrada);
				if (saida == 1) {
					String entradaDeposito = JOptionPane.showInputDialog("Digite o valor que deseja depositar:");
					double valorDeposito = Double.parseDouble(entradaDeposito);
					conta.deposita(valorDeposito);

					MapaDasContas.atualizaTxt(conta);

					contDeposita = contDeposita + 1;
				} else if (saida == 2) {
					String entradaSaque = JOptionPane.showInputDialog("Digite o valor que deseja sacar:");
					double valorSaque = Double.parseDouble(entradaSaque);
					if (conta.saca(valorSaque)) {

						MapaDasContas.atualizaTxt(conta);

						contSaca = contSaca + 1;
					} else {
						conta.consultaSaldo();
					}
				} else if (saida == 3) {
					conta.poupancudos();
				} else if (saida == 4) {
					int cpfDestino = InteracaoUsuario.lerInteiros("Informe o cpf da conta destino: ");
					clienteCadastrado = mapCliente.containsKey(cpfDestino);
					if (clienteCadastrado) {
						Conta contaDestino = mapConta.get(cpfDestino);
						double valorTransferido = InteracaoUsuario.lerDoubles("Informe o valor � ser transferido: ");
						if (conta.transferePara(contaDestino, valorTransferido)) {
							System.out.printf("Valor transferido foi de: R$ %.2f%n", valorTransferido);
							System.out.print("Saldo atual de " + conta.getTitular());
							conta.consultaSaldo();

							MapaDasContas.atualizaTxt(conta);
							MapaDasContas.atualizaTxt(contaDestino);

							contTransfere = contTransfere + 1;
						} else {
							conta.consultaSaldo();
						}
					}
				} else if (saida == 5) {
					System.out.print("Saldo atual de " + conta.getTitular() + ": ");
					conta.consultaSaldo();
				} else if (saida == 6) {

					valorSeguro = InteracaoUsuario.lerDoubles("Informe o valor que deseja assegurar: ");

					if (conta.getSaldo() >= valorSeguro * 0.2) {

						System.out.printf("Valor assegurado: R$ %.2f%n", valorSeguro);
						System.out.println("valor da ap�lice: R$ " + conta.seguroDeVida(valorSeguro));

					} else {
						System.out.println("Saldo insuficiente");
					}

				} else if (saida == 7) {

					for (Conta c : mapConta.values()) {
						if (c.getAgencia() == conta.getAgencia()) {
							System.out.println(c);
						}
					}

				} else if (saida == 8) {

					System.out.println("Relat�rio de contas cadastradas no banco: ");

					List<Conta> listaContas = new ArrayList<Conta>(mapConta.values());
					listaContas.sort(Comparator.comparing(Conta::getTitular));
					for (int i = 0; i < listaContas.size(); i++) {
						listaContas.get(i);

						System.out.println(listaContas.get(i));
					}

				} else if (saida == 9) {
					controle = 2;
				}
			}
		}
		System.out.println("\n|--------------------------------|");
		System.out.println("|                                |");
		System.out.println("|          BugadosBank           |");
		System.out.println("|                                |");
		System.out.println("|--------------------------------|");
	}

	public static void menuPresidente(int cpfLogin, Map<Integer, Conta> mapConta, Map<Integer, Cliente> mapCliente,
			Map<Integer, Funcionario> mapFuncionario) {
		boolean clienteCadastrado;
		int controle = 1;
		int contDeposita = 0;
		int contSaca = 0;
		int contTransfere = 0;
		double valorSeguro = 0;

		Conta conta1 = mapConta.get(cpfLogin);

		while (controle == 1) {

			if (conta1.getTipo() == 1) {

				ContaCorrente conta = (br.com.bugados.conta.ContaCorrente) mapConta.get(cpfLogin);

				String entrada = JOptionPane.showInputDialog("------- TIPO DE OPERA��O -------" + "\n\n 1 - Dep�sito"
						+ "\n 2 - Saque" + "\n 3 - Transfer�ncia" + "\n 4 - Consulta Saldo"
						+ "\n 5 - Contratar Seguro de Vida" + "\n 6 - Consulta tarifas" + "\n 7 - Relat�rio Gerente"
						+ "\n 8 - Relat�rio Diretor" + "\n 9 - Relat�rio Presidente" + "\n 0 - Sair"
						+ "\n                     BugadosBank\n");
				int saida = Integer.parseInt(entrada);

				if (saida == 1) {
					String entradaDeposito = JOptionPane.showInputDialog("Digite o valor que deseja depositar:");
					double valorDeposito = Double.parseDouble(entradaDeposito);
					conta.deposita(valorDeposito);

					MapaDasContas.atualizaTxt(conta);

					contDeposita = contDeposita + 1;
				} else if (saida == 2) {
					String entradaSaque = JOptionPane.showInputDialog("Digite o valor que deseja sacar:");
					double valorSaque = Double.parseDouble(entradaSaque);
					if (conta.saca(valorSaque)) {

						MapaDasContas.atualizaTxt(conta);

						contSaca = contSaca + 1;
					} else {
						conta.consultaSaldo();
					}
				} else if (saida == 3) {
					int cpfDestino = InteracaoUsuario.lerInteiros("Informe o cpf da conta destino: ");
					clienteCadastrado = mapCliente.containsKey(cpfDestino);
					if (clienteCadastrado) {
						Conta contaDestino = mapConta.get(cpfDestino);
						double valorTransferido = InteracaoUsuario.lerDoubles("Informe o valor � ser transferido: ");
						if (conta.transferePara(contaDestino, valorTransferido)) {
							System.out.printf("Valor transferido foi de: R$ %.2f%n", valorTransferido);
							System.out.print("Saldo atual de " + conta.getTitular());
							conta.consultaSaldo();

							MapaDasContas.atualizaTxt(conta);
							MapaDasContas.atualizaTxt(contaDestino);

							contTransfere = contTransfere + 1;
						} else {
							conta.consultaSaldo();
						}
					}
				} else if (saida == 4) {
					System.out.print("Saldo atual de " + conta.getTitular() + ": ");
					conta.consultaSaldo();
				} else if (saida == 5) {

					valorSeguro = InteracaoUsuario.lerDoubles("Informe o valor que deseja assegurar: ");

					if (conta.getSaldo() >= valorSeguro * 0.2) {

						System.out.printf("Valor assegurado: R$ %.2f%n", valorSeguro);
						System.out.println("valor da ap�lice: R$ " + conta.seguroDeVida(valorSeguro));

					} else {
						System.out.println("Saldo insuficiente");
					}

				} else if (saida == 6) {

					System.out.print("Total gasto em " + contDeposita + " dep�sitos com taxa de R$ 0,10: ");
					System.out.printf("R$ %.2f%n", (contDeposita * 0.10));

					System.out.print("Total gasto em " + contSaca + " saques com taxa de R$ 0,10: ");
					System.out.printf("R$ %.2f%n", (contSaca * 0.10));

					System.out.print("Total gasto em " + contTransfere + " transfer�ncias com taxa de R$ 0,20: ");
					System.out.printf("R$ %.2f%n", (contTransfere * 0.20));

					System.out.printf("Tarifa Seguro de vida: R$ %.2f%n", (valorSeguro * 0.2));

					System.out.printf("Total de tarifas cobradas: R$ %.2f%n",
							(conta.consultaTotalTaxas() + (valorSeguro * 0.2)));

				} else if (saida == 7) {

					for (Conta c : mapConta.values()) {
						if (c.getAgencia() == conta.getAgencia()) {
							System.out.println(c);
						}
					}

				} else if (saida == 8) {

					System.out.println("Relat�rio de contas cadastradas no banco: ");

					List<Conta> listaContas = new ArrayList<Conta>(mapConta.values());
					listaContas.sort(Comparator.comparing(Conta::getTitular));
					for (int i = 0; i < listaContas.size(); i++) {
						listaContas.get(i);

						System.out.println(listaContas.get(i));
					}

				} else if (saida == 9) {

					double total = 0;
					for (Conta c : mapConta.values()) {
						total = total + c.getSaldo();
					}

					System.out.printf("Capital total armazenado no banco: R$ %.2f", total);
					System.out.println();

				} else if (saida == 0) {
					controle = 2;
				}
			}

			if (conta1.getTipo() == 2) {

				ContaPoupanca conta = (br.com.bugados.conta.ContaPoupanca) mapConta.get(cpfLogin);

				String entrada = JOptionPane.showInputDialog("------- TIPO DE OPERA��O -------" + "\n\n 1 - Dep�sito"
						+ "\n 2 - Saque" + "\n 3 - Simula��o rendimento poupan�a" + "\n 4 - Transfer�ncia"
						+ "\n 5 - Consulta Saldo" + "\n 6 - Contratar Seguro de Vida" + "\n 7 - Relat�rio Gerente"
						+ "\n 8 - Relat�rio Diretor" + "\n 9 - Relat�rio Presidente" + "\n 0 - Sair"
						+ "\n                     BugadosBank\n");
				int saida = Integer.parseInt(entrada);
				if (saida == 1) {
					String entradaDeposito = JOptionPane.showInputDialog("Digite o valor que deseja depositar:");
					double valorDeposito = Double.parseDouble(entradaDeposito);
					conta.deposita(valorDeposito);

					MapaDasContas.atualizaTxt(conta);

					contDeposita = contDeposita + 1;
				} else if (saida == 2) {
					String entradaSaque = JOptionPane.showInputDialog("Digite o valor que deseja sacar:");
					double valorSaque = Double.parseDouble(entradaSaque);
					if (conta.saca(valorSaque)) {

						MapaDasContas.atualizaTxt(conta);

						contSaca = contSaca + 1;
					} else {
						conta.consultaSaldo();
					}
				} else if (saida == 3) {
					conta.poupancudos();
				} else if (saida == 4) {
					int cpfDestino = InteracaoUsuario.lerInteiros("Informe o cpf da conta destino: ");
					clienteCadastrado = mapCliente.containsKey(cpfDestino);
					if (clienteCadastrado) {
						Conta contaDestino = mapConta.get(cpfDestino);
						double valorTransferido = InteracaoUsuario.lerDoubles("Informe o valor � ser transferido: ");
						if (conta.transferePara(contaDestino, valorTransferido)) {
							System.out.printf("Valor transferido foi de: R$ %.2f%n", valorTransferido);
							System.out.print("Saldo atual de " + conta.getTitular() + ": ");
							conta.consultaSaldo();

							MapaDasContas.atualizaTxt(conta);
							MapaDasContas.atualizaTxt(contaDestino);

							contTransfere = contTransfere + 1;
						} else {
							conta.consultaSaldo();
						}
					}
				} else if (saida == 5) {
					System.out.print("Saldo atual de " + conta.getTitular() + ": ");
					conta.consultaSaldo();
				} else if (saida == 6) {

					valorSeguro = InteracaoUsuario.lerDoubles("Informe o valor que deseja assegurar: ");

					if (conta.getSaldo() >= valorSeguro * 0.2) {

						System.out.printf("Valor assegurado: R$ %.2f%n", valorSeguro);
						System.out.println("valor da ap�lice: R$ " + conta.seguroDeVida(valorSeguro));

					} else {
						System.out.println("Saldo insuficiente");
					}

				} else if (saida == 7) {
					int contador = 0;
					for (Conta c : mapConta.values()) {
						if (c.getAgencia() == conta.getAgencia()) {
							System.out.println(c);
							contador = contador + 1;
						}
					}
					System.out.println("N�mero de contas gerenciadas: " + contador + " contas.");

				} else if (saida == 8) {
					System.out.println("Relat�rio de contas cadastradas no banco: ");

					List<Conta> listaContas = new ArrayList<Conta>(mapConta.values());
					listaContas.sort(Comparator.comparing(Conta::getTitular));
					for (int i = 0; i < listaContas.size(); i++) {
						listaContas.get(i);

						System.out.println(listaContas.get(i));
					}

				} else if (saida == 9) {

					double total = 0;
					for (Conta c : mapConta.values()) {
						total = total + c.getSaldo();
					}

					total = total + (valorSeguro * 0.2);

					System.out.printf("Capital total armazenado no banco: R$ %.2f", total);
					System.out.println();

				} else if (saida == 0) {
					controle = 2;
				}
			}
		}
		System.out.println("\n|--------------------------------|");
		System.out.println("|                                |");
		System.out.println("|          BugadosBank           |");
		System.out.println("|                                |");
		System.out.println("|--------------------------------|");
	}
}
