package org.serratec.backend.mercado.controllers;

import java.util.List;

import javax.validation.Valid;

import org.serratec.backend.mercado.entidades.Vendedor;
import org.serratec.backend.mercado.exceptions.DataNotFoundException;
import org.serratec.backend.mercado.servicos.VendedorService;
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
@RequestMapping("/vendedor")
public class VendedorController {

	@Autowired
	VendedorService vendedorService;
	
	@GetMapping
	public List<Vendedor> buscaTodos(){
		return vendedorService.buscaTodos();
	}
	
	@GetMapping("/id")
	public Vendedor buscaPorId(@PathVariable Integer id) throws DataNotFoundException {
		return vendedorService.buscaPorId(id);
	}
	
	@PostMapping
	public Vendedor inclui(@Valid @RequestBody Vendedor vendedor) {
		return vendedorService.incluiVendedor(vendedor);
	}
	
	@PutMapping("/id")
	public Vendedor atualiza(@PathVariable Integer id, @Valid @RequestBody Vendedor vendedor) throws DataNotFoundException{
		return vendedorService.atualizadorVendedor(id, vendedor);
	}
	
	@DeleteMapping("/id")
	public ResponseEntity apaga(@PathVariable Integer id) throws DataNotFoundException {
		vendedorService.apagaVendedor(id);
		return ResponseEntity.ok().build();
	}
}
