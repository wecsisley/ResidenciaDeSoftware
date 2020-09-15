package org.serratec.backend.mercado.servicos;

import org.serratec.backend.mercado.entidades.ProdutoVendido;
import org.serratec.backend.mercado.exceptions.DataNotFoundException;
import org.serratec.backend.mercado.repositorios.ProdutoVendidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoVendidoService {

  @Autowired private ProdutoVendidoRepository produtoVendidoRepository;

  private ProdutoVendido findById(Integer id) throws DataNotFoundException {
    Optional<ProdutoVendido> produtoVendido = produtoVendidoRepository.findById(id);
    if (produtoVendido.isPresent()) {
      return produtoVendido.get();
    }
    throw new DataNotFoundException(id);
  }

  public ProdutoVendido buscaPorId(Integer id) throws DataNotFoundException {
    return findById(id);
  }

  public List<ProdutoVendido> buscaTodos() {
    return produtoVendidoRepository.findAll();
  }

  @Transactional
  public ProdutoVendido incluiProdutoVendido(ProdutoVendido produtoVendido) {
    return produtoVendidoRepository.save((produtoVendido));
  }

  @Transactional
  public ProdutoVendido atualizadorProdutoVendido(Integer id, ProdutoVendido produtoVendido)
      throws DataNotFoundException {
    ProdutoVendido produtoVendidoBanco = findById(id);
    produtoVendidoBanco.setId(produtoVendido.getId());
    return produtoVendidoRepository.save(produtoVendidoBanco);
  }

  public void apagaProdutoVendido(Integer id) throws DataNotFoundException {
    ProdutoVendido produtoVendido = findById(id);
    produtoVendidoRepository.delete(produtoVendido);
  }
}
