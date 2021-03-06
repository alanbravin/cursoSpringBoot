package com.nelioalves.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.domain.Pedido;

public interface EmailService {
	void sendOrderConfirmationEmail(Pedido pedido);
	void sendEmail(SimpleMailMessage message);
	
	void sendOrderConfirmationHtmlEmail(Pedido pedido);
	void sendHtmlEmail(MimeMessage message);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
