package com.nelioalves.cursomc.services;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nelioalves.cursomc.domain.Cidade;
import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.domain.Endereco;
import com.nelioalves.cursomc.domain.enums.TipoCliente;
import com.nelioalves.cursomc.dto.ClienteDTO;
import com.nelioalves.cursomc.dto.ClienteNewDTO;
import com.nelioalves.cursomc.repository.ClienteRepository;
import com.nelioalves.cursomc.repository.EnderecoRepository;
import com.nelioalves.cursomc.services.exceptions.DataIntegrityException;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Cliente> findAll() {
		return repository.findAll();
	}
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id));
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
	
	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = repository.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}
	
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		
		return repository.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um cliente que possua registros vinculados!");
		}
	}
	
	public Cliente fromDto(ClienteDTO objDTO) {
		return new Cliente(objDTO.getId(),
				objDTO.getNome(),
				objDTO.getEmail(),
				null, null);
	}
	
	public Cliente fromDto(ClienteNewDTO objDTO) {
		Cliente cliente = new Cliente(null,
				objDTO.getNome(),
				objDTO.getEmail(),
				objDTO.getCpfOuCnpj(), 
				TipoCliente.toEnum(objDTO.getTipo()));
		
		Cidade cidade = new Cidade(objDTO.getCidadeId(), null, null);
		
		Endereco endereco = new Endereco(
				null, 
				objDTO.getLogradouro(),
				objDTO.getNumero(),
				objDTO.getComplemento(),
				objDTO.getBairro(),
				objDTO.getCep(),
				cliente,
				cidade);
		
		cliente.getEnderecos().add(endereco);
		cliente.getTelefones().add(objDTO.getTelefone1());
		
		if (objDTO.getTelefone2() != null) {
			cliente.getTelefones().add(objDTO.getTelefone2());
		}
		
		if (objDTO.getTelefone3() != null) {
			cliente.getTelefones().add(objDTO.getTelefone3());
		}
		
		return cliente;
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
}
