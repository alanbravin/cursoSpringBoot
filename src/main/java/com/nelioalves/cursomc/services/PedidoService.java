package com.nelioalves.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Pedido;
import com.nelioalves.cursomc.repository.PedidoRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repository;
	
	public Pedido find(Integer id) {
		return repository.findById(id)
			.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id));
	}
}
