package org.serratec.backend.mercado.controllers;

import java.util.List;

import javax.validation.Valid;

import org.serratec.backend.mercado.entidades.Fornecedor;
import org.serratec.backend.mercado.exceptions.DataNotFoundException;
import org.serratec.backend.mercado.servicos.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

	@Autowired
	FornecedorService fornecedorService;

	@GetMapping
	public List<Fornecedor> buscaTodos() {
		return fornecedorService.buscaTodos();
	}

	@GetMapping("/id")
	public Fornecedor buscaPorId(@PathVariable Integer id) throws DataNotFoundException {
		return fornecedorService.buscarPorId(id);
	}

	@PostMapping
	public Fornecedor inclui(@Valid @RequestBody Fornecedor fornecedor) {
		return fornecedorService.incluiFornecedor(fornecedor);
	}

	@PutMapping("/id")
	public Fornecedor atualiza(@PathVariable Integer id, @Valid @RequestBody Fornecedor fornecedor)
			throws DataNotFoundException {
		return fornecedorService.atualizadorFornecedor(id, fornecedor);
	}

	@DeleteMapping("/id")
	public ResponseEntity apaga(@PathVariable Integer id) throws DataNotFoundException {
		fornecedorService.apagaFornecedor(id);
		return ResponseEntity.ok().build();
	}

}
