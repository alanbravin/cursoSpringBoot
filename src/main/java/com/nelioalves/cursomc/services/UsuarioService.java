package com.nelioalves.cursomc.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.nelioalves.cursomc.security.UsuarioSS;

public class UsuarioService {
	public static UsuarioSS authenticated() {
		try {
			return (UsuarioSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}
}
