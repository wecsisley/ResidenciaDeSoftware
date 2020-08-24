package org.serratec.java2backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import src.main.java.org.serratec.java2backend.Conta.Conta;
import src.main.java.org.serratec.java2backend.service.ContaService;

@RestController
@RequestMapping("/Conta")
public class ContaController {
	
	@Autowired
	private ContaService contaService;
	
	@GetMapping
	public Conta getAll(@PathVariable Conta essaConta) {
		return contaService.getAll(essaConta);
	}
	
	@GetMapping
	public void getSaca(@PathVariable Conta essaConta,@PathVariable Double valorDeSaque) {
		contaService.saca(essaConta, valorDeSaque);
	}
}
