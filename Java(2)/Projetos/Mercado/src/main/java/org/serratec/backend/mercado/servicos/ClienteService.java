package org.serratec.backend.mercado.servicos;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.backend.mercado.entidades.Cliente;
import org.serratec.backend.mercado.exceptions.DataNotFoundException;
import org.serratec.backend.mercado.repositorios.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	private Cliente findById(Integer id) throws DataNotFoundException{
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if(cliente.isPresent()) {
			return cliente.get();
		}
		throw new DataNotFoundException(id);
	}
	
	public Cliente buscaPorId(Integer id) throws DataNotFoundException{
		return findById(id);
	}
	
	public List<Cliente> buscaTodos(){
		return clienteRepository.findAll();
	}
	
	@Transactional
	public Cliente incluiCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public Cliente atualizadorCliente(Integer id, Cliente cliente) throws DataNotFoundException{
		Cliente clienteBanco = findById(id);
		clienteBanco.setNome(cliente.getNome());
		clienteBanco.setTelefone(cliente.getTelefone());
		clienteBanco.setCpf(cliente.getCpf());
		clienteBanco.setRua(cliente.getRua());
		clienteBanco.setNumero(cliente.getNumero());
		clienteBanco.setBairro(cliente.getBairro());
		clienteBanco.setCep(cliente.getCep());
		clienteBanco.setComplemento(cliente.getComplemento());
		clienteBanco.setCidade(cliente.getCidade());
		clienteBanco.setEstado(cliente.getEstado());
		return clienteRepository.save(clienteBanco);
	}
	
	public void apagaCliente(Integer id) throws DataNotFoundException{
		Cliente cliente = findById(id);
		clienteRepository.delete(cliente);
	}
}
