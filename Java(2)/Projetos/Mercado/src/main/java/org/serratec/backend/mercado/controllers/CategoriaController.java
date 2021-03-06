package org.serratec.backend.mercado.controllers;

import org.serratec.backend.mercado.entidades.Categoria;
import org.serratec.backend.mercado.exceptions.DataNotFoundException;
import org.serratec.backend.mercado.servicos.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

  @Autowired CategoriaService categoriaService;

  @GetMapping
  public List<Categoria> buscaTodos() {
    return categoriaService.buscaTodos();
  }

  @GetMapping("/id")
  public Categoria buscaPorId(@PathVariable Integer id) throws DataNotFoundException {
    return categoriaService.buscaPorId(id);
  }

  @PostMapping
  public Categoria inclui(@Valid @RequestBody Categoria categoria) {
    return categoriaService.incluiCategoria(categoria);
  }

  @PutMapping("/id")
  public Categoria atualiza(@PathVariable Integer id, @Valid @RequestBody Categoria categoria)
      throws DataNotFoundException {
    return categoriaService.atualizadorCategoria(id, categoria);
  }

  @DeleteMapping("/id")
  public ResponseEntity apaga(@PathVariable Integer id) throws DataNotFoundException {
    categoriaService.apagaCategoria(id);
    return ResponseEntity.ok().build();
  }
}
