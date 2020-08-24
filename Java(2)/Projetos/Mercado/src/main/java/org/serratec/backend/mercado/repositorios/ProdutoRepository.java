package org.serratec.backend.mercado.repositorios;

import java.util.Optional;

import org.serratec.backend.mercado.entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	@Query("select 1 from produto 1 where 1.codigoDeBarras=:CodigoDeBarras")
	Optional<Produto> findaBycodigoDeBarras(@Param("codigoDeBarras") Integer codigoDeBarras);

}
