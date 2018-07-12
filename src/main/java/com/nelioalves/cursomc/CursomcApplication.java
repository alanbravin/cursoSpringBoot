package com.nelioalves.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
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
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Categoria informatica = new Categoria(null, "Informática");
		Categoria escritorio = new Categoria(null, "Escritório");
		categoriaRepository.saveAll(Arrays.asList(informatica, escritorio));
		
		Produto computador = new Produto(null, "Computador", 2000D);
		Produto impressora = new Produto(null, "Impressora", 800D);
		Produto mouse = new Produto(null, "Mouse", 80D);
		
		computador.getCategorias().add(informatica);
		impressora.getCategorias().addAll(Arrays.asList(informatica, escritorio));
		mouse.getCategorias().add(informatica);
		produtoRepository.saveAll(Arrays.asList(computador, impressora, mouse));
		
		Estado saoPaulo = new Estado(null, "São Paulo");
		Estado minasGerais = new Estado(null, "Minas Gerais");
		estadoRepository.saveAll(Arrays.asList(saoPaulo, minasGerais));
		
		Cidade uberlandia = new Cidade(null, "Uberlândia", minasGerais);
		Cidade cidadeSaoPaulo = new Cidade(null, "São Paulo", saoPaulo);
		Cidade campinas = new Cidade(null, "Campinas", saoPaulo);
		cidadeRepository.saveAll(Arrays.asList(uberlandia, cidadeSaoPaulo, campinas));
		
		Cliente cliente1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
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
		
		ItemPedido itemPedido1 = new ItemPedido(pedido1, computador, 0D, 1, 2000D);
		ItemPedido itemPedido2 = new ItemPedido(pedido1, mouse, 0D, 1, 80D);
		ItemPedido itemPedido3 = new ItemPedido(pedido2, impressora, 100D, 1, 800D);
		
		pedido1.getItens().addAll(Arrays.asList(itemPedido1, itemPedido2));
		pedido2.getItens().addAll(Arrays.asList(itemPedido3));
		
		itemPedidoRepository.saveAll(Arrays.asList(itemPedido1, itemPedido2, itemPedido3));
	}
	
	
}
