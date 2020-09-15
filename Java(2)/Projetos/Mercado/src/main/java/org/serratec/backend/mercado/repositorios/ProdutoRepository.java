package org.serratec.backend.mercado.repositorios;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.mercado.entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	Optional<Produto> findByCodigoDeBarras(Integer codigoDeBarras);
	List<Produto> findByNome(String nome);
}
