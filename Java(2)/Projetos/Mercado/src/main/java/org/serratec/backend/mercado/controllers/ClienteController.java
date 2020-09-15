package org.serratec.backend.mercado.controllers;

import org.serratec.backend.mercado.entidades.Cliente;
import org.serratec.backend.mercado.exceptions.DataNotFoundException;
import org.serratec.backend.mercado.servicos.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

  @Autowired ClienteService clienteService;

  @GetMapping
  public List<Cliente> buscaTodos() {
    return clienteService.buscaTodos();
  }

  @GetMapping("/id")
  public Cliente buscaPorId(@PathVariable Integer id) throws DataNotFoundException {
    return clienteService.buscaPorId(id);
  }

  @PostMapping
  public Cliente inclui(@Valid @RequestBody Cliente cliente) {
    return clienteService.incluiCliente(cliente);
  }

  @PutMapping("/id")
  public Cliente atualiza(@PathVariable Integer id, @Valid @RequestBody Cliente cliente)
      throws DataNotFoundException {
    return clienteService.atualizadorCliente(id, cliente);
  }

  @DeleteMapping("/id")
  public ResponseEntity apaga(@PathVariable Integer id) throws DataNotFoundException {
    clienteService.apagaCliente(id);
    return ResponseEntity.ok().build();
  }
}
