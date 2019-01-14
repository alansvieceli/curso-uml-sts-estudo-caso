package com.alanvieceli.cursouml;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alanvieceli.cursouml.domains.Categoria;
import com.alanvieceli.cursouml.domains.Cidade;
import com.alanvieceli.cursouml.domains.Cliente;
import com.alanvieceli.cursouml.domains.Endereco;
import com.alanvieceli.cursouml.domains.Estado;
import com.alanvieceli.cursouml.domains.ItemPedido;
import com.alanvieceli.cursouml.domains.Pagamento;
import com.alanvieceli.cursouml.domains.PagamentoComBoleto;
import com.alanvieceli.cursouml.domains.PagamentoComCartao;
import com.alanvieceli.cursouml.domains.Pedido;
import com.alanvieceli.cursouml.domains.Produto;
import com.alanvieceli.cursouml.domains.enums.EstadoPagamento;
import com.alanvieceli.cursouml.domains.enums.TipoCliente;
import com.alanvieceli.cursouml.repositories.CategoriaRepository;
import com.alanvieceli.cursouml.repositories.CidadeRepository;
import com.alanvieceli.cursouml.repositories.ClienteRepository;
import com.alanvieceli.cursouml.repositories.EnderecoRepository;
import com.alanvieceli.cursouml.repositories.EstadoRepository;
import com.alanvieceli.cursouml.repositories.ItemPedidoRepository;
import com.alanvieceli.cursouml.repositories.PagamentoRepository;
import com.alanvieceli.cursouml.repositories.PedidoRepository;
import com.alanvieceli.cursouml.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoUMLApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository ItemPedidoRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(CursoUMLApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Iniciando o banco de dados
		
		//****************
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2)); 
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		//****************
		Estado est1 = new Estado(null, "Minas Gerais", "MG");
		Estado est2 = new Estado(null, "São Paulo", "SP");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		//**************
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "98930710035", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("33871385", "991884406"));
		
		Cliente cli2 = new Cliente(null, "João da Luz", "joao@gmail.com", "00100597563", TipoCliente.PESSOAFISICA);
		cli2.getTelefones().addAll(Arrays.asList("33485398", "92191306"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "91170481", cli1, c1);
		Endereco e2 = new Endereco(null, "Av. Matos", "105", "Sala 33", "Centro", "80566000", cli1, c2);
		Endereco e3 = new Endereco(null, "Rua das Margaridas", "30", "CASA", "Canas", "98741360", cli2, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli2.getEnderecos().addAll(Arrays.asList(e3));
		
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));
		
		//**************
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pgto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pgto1);
		
		Pagamento pgto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pgto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pgto1, pgto2));
		
		//******************
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));		
		
		ItemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		
		
		
	}
}
