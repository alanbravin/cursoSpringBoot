package com.nelioalves.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Estado;
import com.nelioalves.cursomc.repository.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	EstadoRepository repository;
	
	public List<Estado> findAll() {
		return repository.findAllByOrderByNome();
	}	
}