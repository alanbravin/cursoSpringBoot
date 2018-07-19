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
import com.nelioalves.cursomc.domain.enums.Perfil;
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
		Produto produto12 = new Produto(null, "Produto 12", 10D);
		Produto produto13 = new Produto(null, "Produto 13", 10D);
		Produto produto14 = new Produto(null, "Produto 14", 10D);
		Produto produto15 = new Produto(null, "Produto 15", 10D);
		Produto produto16 = new Produto(null, "Produto 16", 10D);
		Produto produto17 = new Produto(null, "Produto 17", 10D);
		Produto produto18 = new Produto(null, "Produto 18", 10D);
		Produto produto19 = new Produto(null, "Produto 19", 10D);
		Produto produto20 = new Produto(null, "Produto 20", 10D);
		Produto produto21 = new Produto(null, "Produto 21", 10D);
		Produto produto22 = new Produto(null, "Produto 22", 10D);
		Produto produto23 = new Produto(null, "Produto 23", 10D);
		Produto produto24 = new Produto(null, "Produto 24", 10D);
		Produto produto25 = new Produto(null, "Produto 25", 10D);
		Produto produto26 = new Produto(null, "Produto 26", 10D);
		Produto produto27 = new Produto(null, "Produto 27", 10D);
		Produto produto28 = new Produto(null, "Produto 28", 10D);
		Produto produto29 = new Produto(null, "Produto 29", 10D);
		Produto produto30 = new Produto(null, "Produto 30", 10D);
		Produto produto31 = new Produto(null, "Produto 31", 10D);
		Produto produto32 = new Produto(null, "Produto 32", 10D);
		Produto produto33 = new Produto(null, "Produto 33", 10D);
		Produto produto34 = new Produto(null, "Produto 34", 10D);
		Produto produto35 = new Produto(null, "Produto 35", 10D);
		Produto produto36 = new Produto(null, "Produto 36", 10D);
		Produto produto37 = new Produto(null, "Produto 37", 10D);
		Produto produto38 = new Produto(null, "Produto 38", 10D);
		Produto produto39 = new Produto(null, "Produto 39", 10D);
		Produto produto40 = new Produto(null, "Produto 40", 10D);
		Produto produto41 = new Produto(null, "Produto 41", 10D);
		Produto produto42 = new Produto(null, "Produto 42", 10D);
		Produto produto43 = new Produto(null, "Produto 43", 10D);
		Produto produto44 = new Produto(null, "Produto 44", 10D);
		Produto produto45 = new Produto(null, "Produto 45", 10D);
		Produto produto46 = new Produto(null, "Produto 46", 10D);
		Produto produto47 = new Produto(null, "Produto 47", 10D);
		Produto produto48 = new Produto(null, "Produto 48", 10D);
		Produto produto49 = new Produto(null, "Produto 49", 10D);
		Produto produto50 = new Produto(null, "Produto 50", 10D);
		
		
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
		produto12.getCategorias().addAll(Arrays.asList(informatica));
		produto13.getCategorias().addAll(Arrays.asList(informatica));
		produto14.getCategorias().addAll(Arrays.asList(informatica));
		produto15.getCategorias().addAll(Arrays.asList(informatica));
		produto16.getCategorias().addAll(Arrays.asList(informatica));
		produto17.getCategorias().addAll(Arrays.asList(informatica));
		produto18.getCategorias().addAll(Arrays.asList(informatica));
		produto19.getCategorias().addAll(Arrays.asList(informatica));
		produto20.getCategorias().addAll(Arrays.asList(informatica));
		produto21.getCategorias().addAll(Arrays.asList(informatica));
		produto22.getCategorias().addAll(Arrays.asList(informatica));
		produto23.getCategorias().addAll(Arrays.asList(informatica));
		produto24.getCategorias().addAll(Arrays.asList(informatica));
		produto25.getCategorias().addAll(Arrays.asList(informatica));
		produto26.getCategorias().addAll(Arrays.asList(informatica));
		produto27.getCategorias().addAll(Arrays.asList(informatica));
		produto28.getCategorias().addAll(Arrays.asList(informatica));
		produto29.getCategorias().addAll(Arrays.asList(informatica));
		produto30.getCategorias().addAll(Arrays.asList(informatica));
		produto31.getCategorias().addAll(Arrays.asList(informatica));
		produto32.getCategorias().addAll(Arrays.asList(informatica));
		produto33.getCategorias().addAll(Arrays.asList(informatica));
		produto34.getCategorias().addAll(Arrays.asList(informatica));
		produto35.getCategorias().addAll(Arrays.asList(informatica));
		produto36.getCategorias().addAll(Arrays.asList(informatica));
		produto37.getCategorias().addAll(Arrays.asList(informatica));
		produto38.getCategorias().addAll(Arrays.asList(informatica));
		produto39.getCategorias().addAll(Arrays.asList(informatica));
		produto40.getCategorias().addAll(Arrays.asList(informatica));
		produto41.getCategorias().addAll(Arrays.asList(informatica));
		produto42.getCategorias().addAll(Arrays.asList(informatica));
		produto43.getCategorias().addAll(Arrays.asList(informatica));
		produto44.getCategorias().addAll(Arrays.asList(informatica));
		produto45.getCategorias().addAll(Arrays.asList(informatica));
		produto46.getCategorias().addAll(Arrays.asList(informatica));
		produto47.getCategorias().addAll(Arrays.asList(informatica));
		produto48.getCategorias().addAll(Arrays.asList(informatica));
		produto49.getCategorias().addAll(Arrays.asList(informatica));
		produto50.getCategorias().addAll(Arrays.asList(informatica));
		
		produtoRepository.saveAll(
				Arrays.asList(
						produto1, produto2, produto3, produto4, 
						produto5, produto6, produto7, produto8, 
						produto9, produto10, produto11, produto12, 
						produto13, produto14, produto15, produto16,
						produto17, produto18, produto19, produto20,
						produto21, produto22, produto23, produto24,
						produto25, produto26, produto27, produto28,
						produto29, produto30, produto31, produto32,
						produto33, produto34, produto35, produto36,
						produto37, produto38, produto39, produto40,
						produto41, produto42, produto43, produto44,
						produto45, produto46, produto47, produto48,
						produto49, produto50
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
		
		Cliente cliente2 = new Cliente(null, "Ana Costa", "alan.rufino@objective.com.br", "04691331980", TipoCliente.PESSOAFISICA, bCryptPasswordEncoder.encode("123456"));
		cliente2.addPerfil(Perfil.ADMIN);
		cliente2.getTelefones().add("32222323");
		cliente2.getTelefones().add("999998888");
		
		clienteRepository.saveAll(Arrays.asList(cliente1, cliente2));
		
		
		Endereco endereco1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220634", cliente1, uberlandia);
		Endereco endereco2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cliente1, cidadeSaoPaulo);
		Endereco endereco3 = new Endereco(null, "Rua Galáxia", "47", "Casa", "Jd Universo", "87060430", cliente2, cidadeSaoPaulo);
		enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2, endereco3));
		

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
