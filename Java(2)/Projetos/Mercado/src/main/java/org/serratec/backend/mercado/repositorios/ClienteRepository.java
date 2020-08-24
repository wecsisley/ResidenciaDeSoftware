package org.serratec.backend.mercado.repositorios;

import org.serratec.backend.mercado.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
