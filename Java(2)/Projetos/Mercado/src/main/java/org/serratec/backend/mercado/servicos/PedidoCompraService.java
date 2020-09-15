package org.serratec.backend.mercado.servicos;

import org.serratec.backend.mercado.entidades.PedidoCompra;
import org.serratec.backend.mercado.exceptions.DataNotFoundException;
import org.serratec.backend.mercado.repositorios.PedidoCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoCompraService {

  @Autowired private PedidoCompraRepository pedidoCompraRepository;

  private PedidoCompra findById(Integer id) throws DataNotFoundException {
    Optional<PedidoCompra> pedidoCompra = pedidoCompraRepository.findById(id);
    if (pedidoCompra.isPresent()) {
      return pedidoCompra.get();
    }
    throw new DataNotFoundException(id);
  }

  public PedidoCompra buscaPorId(Integer id) throws DataNotFoundException {
    return findById(id);
  }

  public List<PedidoCompra> buscaTodos() {
    return pedidoCompraRepository.findAll();
  }

  @Transactional
  public PedidoCompra incluiPedidoCompra(PedidoCompra pedidoCompra) {
    return pedidoCompraRepository.save(pedidoCompra);
  }

  @Transactional
  public PedidoCompra atualizadorPedidoCompra(Integer id, PedidoCompra pedidoCompra)
      throws DataNotFoundException {
    PedidoCompra pedidocompraBanco = findById(id);
    pedidocompraBanco.setId(pedidocompraBanco.getId());
    return pedidoCompraRepository.save(pedidocompraBanco);
  }

  public void apagaPedidoCompra(Integer id) throws DataNotFoundException {
    PedidoCompra pedidoCompra = findById(id);
    pedidoCompraRepository.delete(pedidoCompra);
  }
}
