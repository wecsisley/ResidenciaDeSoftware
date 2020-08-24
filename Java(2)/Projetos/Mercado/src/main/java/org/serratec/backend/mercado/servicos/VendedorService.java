package org.serratec.backend.mercado.servicos;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.backend.mercado.entidades.Vendedor;
import org.serratec.backend.mercado.exceptions.DataNotFoundException;
import org.serratec.backend.mercado.repositorios.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	private Vendedor findById(Integer id) throws DataNotFoundException{
		Optional<Vendedor> vendedor = vendedorRepository.findById(id);
		if(vendedor.isPresent()) {
			return vendedor.get();
		}
		throw new DataNotFoundException(id);
	}
	
	public Vendedor buscaPorId(Integer id) throws DataNotFoundException {
		return findById(id);
	}
	
	public List<Vendedor> buscaTodos(){
		return vendedorRepository.findAll();
	}
	
	@Transactional
	public Vendedor incluiVendedor(Vendedor vendedor) {
		return vendedorRepository.save(vendedor);
	}
	
	@Transactional
	public Vendedor atualizadorVendedor(Integer id, Vendedor vendedor) throws DataNotFoundException{
		Vendedor vendedorBanco = findById(id);
		vendedorBanco.setNome(vendedor.getNome());
		vendedorBanco.setMatricula(vendedor.getMatricula());
		return vendedorRepository.save(vendedorBanco);
	}
	
	public void apagaVendedor(Integer id) throws DataNotFoundException{
		Vendedor vendedor = findById(id);
		vendedorRepository.delete(vendedor);
	}
}
