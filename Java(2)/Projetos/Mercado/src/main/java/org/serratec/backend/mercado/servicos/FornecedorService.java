package org.serratec.backend.mercado.servicos;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.backend.mercado.entidades.Fornecedor;
import org.serratec.backend.mercado.exceptions.DataNotFoundException;
import org.serratec.backend.mercado.repositorios.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	private Fornecedor findById(Integer id) throws DataNotFoundException {
		Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
		if (fornecedor.isPresent()) {
			return fornecedor.get();
		}
		throw new DataNotFoundException(id);
	}

	public Fornecedor buscarPorId(Integer id) throws DataNotFoundException {
		return findById(id);
	}

	public List<Fornecedor> buscaTodos() {
		return fornecedorRepository.findAll();
	}

	@Transactional
	public Fornecedor incluiFornecedor(Fornecedor fornecedor) {
		return fornecedorRepository.save(fornecedor);
	}
	
	@Transactional
	public Fornecedor atualizadorFornecedor(Integer id, Fornecedor fornecedor) throws DataNotFoundException {
		Fornecedor fornecedorBanco = findById(id);
		fornecedorBanco.setNome(fornecedor.getNome());
		return fornecedorRepository.save(fornecedorBanco);
	}
	
	public void apagaFornecedor(Integer id) throws DataNotFoundException{
		Fornecedor fornecedor  = findById(id);
		fornecedorRepository.delete(fornecedor);
	}

}
