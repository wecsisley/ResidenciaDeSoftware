package org.serratec.backend.mercado.servicos;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.backend.mercado.entidades.Fornecedor;
import org.serratec.backend.mercado.entidades.Produto;
import org.serratec.backend.mercado.exceptions.DataNotFoundException;
import org.serratec.backend.mercado.repositorios.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	private Produto findById(Integer id) throws DataNotFoundException {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isPresent()) {
			return produto.get();
		}
		throw new DataNotFoundException(id);
	}

	private Produto findByCodigoDeBarras(Integer codigoDeBarras) throws DataNotFoundException {
		Optional<Produto> produto = produtoRepository.findaBycodigoDeBarras(codigoDeBarras);
		if (produto.isPresent()) {
			return produto.get();
		}
		throw new DataNotFoundException(codigoDeBarras);
	}

	public Produto buscaPorCodigoDeBarras(Integer codigoDeBarras) throws DataNotFoundException {
		return findByCodigoDeBarras(codigoDeBarras);
	}

	public List<Produto> buscaTodos() {
		return produtoRepository.findAll();
	}

	@Transactional
	public Produto incluiProduto(Produto produto) {
		Optional<Produto> optionalProdutoBanco = produtoRepository.findaBycodigoDeBarras(produto.getCodigoDeBarras());
		if (optionalProdutoBanco.isPresent()) {
			Produto produtoBanco = optionalProdutoBanco.get();
			produtoBanco.setNome(produto.getNome());
			return produtoRepository.save(produto);
		}
		return produtoRepository.save(produto);
	}

	@Transactional
	public Produto atualizaProduto(Integer id, Produto produto) throws DataNotFoundException {
		Produto produtoBanco = findById(id);
		produtoBanco.setNome(produtoBanco.getNome());
		produtoBanco.setCategoria(produtoBanco.getCategoria());
		produtoBanco.setDataFabricacao(produtoBanco.getDataFabricacao());
		produtoBanco.setFornecedor(produtoBanco.getFornecedor());
		return produtoRepository.save(produtoBanco);

	}

}
