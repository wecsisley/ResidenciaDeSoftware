package org.serratec.backend.mercado.controllers;

import org.serratec.backend.mercado.entidades.Produto;
import org.serratec.backend.mercado.exceptions.DataNotFoundException;
import org.serratec.backend.mercado.servicos.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

  @Autowired ProdutoService produtoService;

  @GetMapping
  public List<Produto> buscaTodos() {
    return produtoService.buscaTodos();
  }

  @GetMapping("/id")
  public Produto buscaPorId(@PathVariable Integer id) throws DataNotFoundException {
    return produtoService.buscaPorId(id);
  }

  @PostMapping
  public Produto inclui(@Valid @RequestBody Produto produto) {
    return produtoService.incluiProduto(produto);
  }

  @PutMapping("/id")
  public Produto atualiza(@PathVariable Integer id, @Valid @RequestBody Produto produto)
      throws DataNotFoundException {
    return produtoService.atualizaProduto(id, produto);
  }

  @DeleteMapping
  public ResponseEntity apaga(@PathVariable Integer id) throws DataNotFoundException {
    produtoService.apagaProduto(id);
    return ResponseEntity.ok().build();
  }
}
