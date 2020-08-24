package org.serratec.backend.mercado.servicos;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.backend.mercado.entidades.Categoria;
import org.serratec.backend.mercado.exceptions.DataNotFoundException;
import org.serratec.backend.mercado.repositorios.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	private Categoria findById(Integer id) throws DataNotFoundException {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if (categoria.isPresent()) {
			return categoria.get();
		}
		throw new DataNotFoundException(id);
	}
	
	public Categoria buscaPorId(Integer id) throws DataNotFoundException{
		return findById(id);
	}
	
	public List<Categoria> buscaTodos(){
		return categoriaRepository.findAll();
	}
	
	@Transactional
	public Categoria incluiCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	@Transactional
	public Categoria atualizadorCategoria(Integer id, Categoria categoria) throws DataNotFoundException{
		Categoria categoriaBanco = findById(id);
		categoriaBanco.setNome(categoria.getNome());
		categoriaBanco.setDescricao(categoria.getDescricao());
		return categoriaRepository.save(categoriaBanco);
	}
	
	public void apagaCategoria(Integer id) throws DataNotFoundException{
		Categoria categoria = findById(id);
		categoriaRepository.delete(categoria);
	}
}
