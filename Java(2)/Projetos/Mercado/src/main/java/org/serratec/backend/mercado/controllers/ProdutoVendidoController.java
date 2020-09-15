package org.serratec.backend.mercado.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.serratec.backend.mercado.entidades.ProdutoVendido;
import org.serratec.backend.mercado.exceptions.DataNotFoundException;
import org.serratec.backend.mercado.servicos.ProdutoVendidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/produto_vendido")
public class ProdutoVendidoController {

  @Autowired ProdutoVendidoService produtoVendidoService;

  @GetMapping
  public List<ProdutoVendido> buscaTodos() throws JsonProcessingException {
    return produtoVendidoService.buscaTodos();
  }

  @GetMapping("/id")
  public ProdutoVendido buscaPorId(@PathVariable Integer id) throws DataNotFoundException {
    return produtoVendidoService.buscaPorId(id);
  }

  @PostMapping
  public ProdutoVendido atualiza(@Valid @RequestBody ProdutoVendido produtoVendido) {
    return produtoVendidoService.incluiProdutoVendido(produtoVendido);
  }

  @PutMapping("/id")
  public ProdutoVendido atualiza(
      @PathVariable Integer id, @Valid @RequestBody ProdutoVendido produtoVendido)
      throws DataNotFoundException {
    return produtoVendidoService.atualizadorProdutoVendido(id, produtoVendido);
  }

  @DeleteMapping("/id")
  public ResponseEntity apaga(@PathVariable Integer id) throws DataNotFoundException {
    produtoVendidoService.apagaProdutoVendido(id);
    return ResponseEntity.ok().build();
  }
}
