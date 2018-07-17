package com.nelioalves.cursomc.resources;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomc.security.JWTUtil;
import com.nelioalves.cursomc.security.UsuarioSS;
import com.nelioalves.cursomc.services.UsuarioService;

@RestController
@RequestMapping(value="/auth")
public class AuthResource {
	@Autowired
	private JWTUtil jwtUtil;
	
	@RequestMapping(value="/refresh_token", method=RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UsuarioSS usuarioLogado = UsuarioService.authenticated();
		String token = jwtUtil.generateToken(usuarioLogado.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		
		return ResponseEntity.noContent().build();
	}
}
