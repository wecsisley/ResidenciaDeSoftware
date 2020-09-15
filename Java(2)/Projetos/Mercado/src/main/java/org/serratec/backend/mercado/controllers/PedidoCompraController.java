package org.serratec.backend.mercado.controllers;

import org.serratec.backend.mercado.entidades.PedidoCompra;
import org.serratec.backend.mercado.exceptions.DataNotFoundException;
import org.serratec.backend.mercado.servicos.PedidoCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pedido_compra")
public class PedidoCompraController {

  @Autowired PedidoCompraService pedidoCompraService;

  @GetMapping
  public List<PedidoCompra> buscaTodos() {
    return pedidoCompraService.buscaTodos();
  }

  @GetMapping("/id")
  public PedidoCompra buscaPorId(@PathVariable Integer id) throws DataNotFoundException {
    return pedidoCompraService.buscaPorId(id);
  }

  @PostMapping
  public PedidoCompra inblui(@Valid @RequestBody PedidoCompra pedidoCompra) {
    return pedidoCompraService.incluiPedidoCompra(pedidoCompra);
  }

  @PutMapping("/id")
  public PedidoCompra atualiza(
      @PathVariable Integer id, @Valid @RequestBody PedidoCompra pedidoCompra)
      throws DataNotFoundException {
    return pedidoCompraService.atualizadorPedidoCompra(id, pedidoCompra);
  }

  @DeleteMapping("/id")
  public ResponseEntity apaga(@PathVariable Integer id) throws DataNotFoundException {
    pedidoCompraService.apagaPedidoCompra(id);
    return ResponseEntity.ok().build();
  }
}
