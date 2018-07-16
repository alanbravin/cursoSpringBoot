package com.nelioalves.cursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.domain.Cidade;
import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.domain.Endereco;
import com.nelioalves.cursomc.domain.Estado;
import com.nelioalves.cursomc.domain.ItemPedido;
import com.nelioalves.cursomc.domain.Pagamento;
import com.nelioalves.cursomc.domain.PagamentoComBoleto;
import com.nelioalves.cursomc.domain.PagamentoComCartao;
import com.nelioalves.cursomc.domain.Pedido;
import com.nelioalves.cursomc.domain.Produto;
import com.nelioalves.cursomc.domain.enums.EstadoPagamento;
import com.nelioalves.cursomc.domain.enums.TipoCliente;
import com.nelioalves.cursomc.repository.CategoriaRepository;
import com.nelioalves.cursomc.repository.CidadeRepository;
import com.nelioalves.cursomc.repository.ClienteRepository;
import com.nelioalves.cursomc.repository.EnderecoRepository;
import com.nelioalves.cursomc.repository.EstadoRepository;
import com.nelioalves.cursomc.repository.ItemPedidoRepository;
import com.nelioalves.cursomc.repository.PagamentoRepository;
import com.nelioalves.cursomc.repository.PedidoRepository;
import com.nelioalves.cursomc.repository.ProdutoRepository;

@Service
public class DBService {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public void instantiateTestDataBase() throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Categoria informatica = new Categoria(null, "Informática");
		Categoria escritorio = new Categoria(null, "Escritório");
		Categoria camaMesaBanho = new Categoria(null, "Cama mesa e banho");
		Categoria eletronicos = new Categoria(null, "Eletrônicos");
		Categoria jardinagem = new Categoria(null, "Jardinagem");
		Categoria decoracao = new Categoria(null, "Decoração");
		Categoria perfumaria = new Categoria(null, "Perfumaria");
		Categoria teste = new Categoria(null, "Teste");
		categoriaRepository.saveAll(Arrays.asList(informatica, escritorio, camaMesaBanho, eletronicos, jardinagem, decoracao, perfumaria, teste));
		
		Produto produto1 = new Produto(null, "Computador", 2000D);
		Produto produto2 = new Produto(null, "Impressora", 800D);
		Produto produto3 = new Produto(null, "Mouse", 80D);
		Produto produto4 = new Produto(null, "Mesa de Escritório", 300D);
		Produto produto5 = new Produto(null, "Toalha", 50D);
		Produto produto6 = new Produto(null, "Colcha", 200D);
		Produto produto7 = new Produto(null, "TV true color", 1200D);
		Produto produto8 = new Produto(null, "Roçadeira", 800D);
		Produto produto9 = new Produto(null, "Abajour", 100D);
		Produto produto10 = new Produto(null, "Pendente", 180D);
		Produto produto11 = new Produto(null, "Shampoo", 90D);
		
		produto1.getCategorias().addAll(Arrays.asList(informatica, eletronicos));
		produto2.getCategorias().addAll(Arrays.asList(informatica, escritorio, eletronicos));
		produto3.getCategorias().addAll(Arrays.asList(informatica, eletronicos));
		produto4.getCategorias().addAll(Arrays.asList(escritorio));
		produto5.getCategorias().addAll(Arrays.asList(camaMesaBanho));
		produto6.getCategorias().addAll(Arrays.asList(camaMesaBanho));
		produto7.getCategorias().addAll(Arrays.asList(eletronicos));
		produto8.getCategorias().addAll(Arrays.asList(jardinagem));
		produto9.getCategorias().addAll(Arrays.asList(decoracao));
		produto10.getCategorias().addAll(Arrays.asList(decoracao));
		produto11.getCategorias().addAll(Arrays.asList(perfumaria));
		
		produtoRepository.saveAll(
				Arrays.asList(
						produto1, produto2, produto3, produto4, 
						produto5, produto6, produto7, produto8, 
						produto9, produto10, produto11
				)
		);
		
		Estado saoPaulo = new Estado(null, "São Paulo");
		Estado minasGerais = new Estado(null, "Minas Gerais");
		estadoRepository.saveAll(Arrays.asList(saoPaulo, minasGerais));
		
		Cidade uberlandia = new Cidade(null, "Uberlândia", minasGerais);
		Cidade cidadeSaoPaulo = new Cidade(null, "São Paulo", saoPaulo);
		Cidade campinas = new Cidade(null, "Campinas", saoPaulo);
		cidadeRepository.saveAll(Arrays.asList(uberlandia, cidadeSaoPaulo, campinas));
		
		Cliente cliente1 = new Cliente(null, "Maria Silva", "alan.resender@gmail.com", "36378912377", TipoCliente.PESSOAFISICA, bCryptPasswordEncoder.encode("123456"));
		cliente1.getTelefones().add("27363323");
		cliente1.getTelefones().add("93838393");
		clienteRepository.saveAll(Arrays.asList(cliente1));
		
		Endereco endereco1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220634", cliente1, uberlandia);
		Endereco endereco2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cliente1, cidadeSaoPaulo);
		enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));
		

		Pedido pedido1 = new Pedido(
				null, 
				simpleDateFormat.parse("30/09/2017 10:32"), 
				cliente1, 
				endereco1);
		
		Pedido pedido2 = new Pedido(
				null, 
				simpleDateFormat.parse("10/10/2017 19:35"), 
				cliente1, 
				endereco2);
		
		Pagamento pagamento1 = new PagamentoComCartao(
				null, 
				EstadoPagamento.QUITADO, 
				pedido1, 
				6);
		pedido1.setPagamento(pagamento1);
		
		Pagamento pagamento2 = new PagamentoComBoleto(
				null, 
				EstadoPagamento.PENDENTE, 
				pedido2, 
				simpleDateFormat.parse("20/10/2017 00:00"),
				null);
		pedido2.setPagamento(pagamento2);
		
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
		pagamentoRepository.saveAll(Arrays.asList(pagamento1, pagamento2));
		
		ItemPedido itemPedido1 = new ItemPedido(pedido1, produto1, 0D, 1, 2000D);
		ItemPedido itemPedido2 = new ItemPedido(pedido1, produto3, 0D, 2, 80D);
		ItemPedido itemPedido3 = new ItemPedido(pedido2, produto2, 100D, 1, 800D);
		
		pedido1.getItens().addAll(Arrays.asList(itemPedido1, itemPedido2));
		pedido2.getItens().addAll(Arrays.asList(itemPedido3));
		
		itemPedidoRepository.saveAll(Arrays.asList(itemPedido1, itemPedido2, itemPedido3));
	}
}
