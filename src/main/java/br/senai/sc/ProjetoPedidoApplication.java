package br.senai.sc;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.senai.sc.domain.Categoria;
import br.senai.sc.domain.Cidade;
import br.senai.sc.domain.Cliente;
import br.senai.sc.domain.Endereco;
import br.senai.sc.domain.Estado;
import br.senai.sc.domain.ItemPedido;
import br.senai.sc.domain.PagamentoComBoleto;
import br.senai.sc.domain.PagamentoComCartao;
import br.senai.sc.domain.Pedido;
import br.senai.sc.domain.Produto;
import br.senai.sc.domain.enums.EstadoPagamento;
import br.senai.sc.domain.enums.TipoCliente;
import br.senai.sc.repositories.CategoriaRepositories;
import br.senai.sc.repositories.CidadeRepositories;
import br.senai.sc.repositories.ClienteRepositories;
import br.senai.sc.repositories.EnderecoRepositories;
import br.senai.sc.repositories.EstadoRepositories;
import br.senai.sc.repositories.ItemPedidoRepositories;
import br.senai.sc.repositories.PagamentoRepositories;
import br.senai.sc.repositories.PedidoRepositories;
import br.senai.sc.repositories.ProdutoRepositories;

@SpringBootApplication
public class ProjetoPedidoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProjetoPedidoApplication.class, args);
	}
	
	@Autowired
	private CategoriaRepositories categoriaRepo;
	
	@Autowired
	private ProdutoRepositories produtoRepo;
	
	@Autowired
	private EstadoRepositories estadoRepo;
	
	@Autowired
	private CidadeRepositories cidadeRepo;
	
	@Autowired
	private EnderecoRepositories enderecoRepo;
	
	@Autowired
	private PedidoRepositories pedidoRepo;

	@Autowired
	private ClienteRepositories clienteRepo;
	
	@Autowired
	private ItemPedidoRepositories itempedidoRepo;
	
	@Autowired
	private PagamentoRepositories pagamentoRepo;
	
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Categoria cat1 = new Categoria(null, "informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		p1.getCategorias().add(cat1);
		cat1.getProdutos().add(p1);
		p2.getCategorias().add(cat1);
		cat1.getProdutos().add(p2);
		p2.getCategorias().add(cat2);
		cat2.getProdutos().add(p2);
		p3.getCategorias().add(cat2);
		cat2.getProdutos().add(p3);
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null ,"Uberlândia", est1);
		Cidade c2 = new Cidade(null ,"São Paulo", est2);
		Cidade c3 = new Cidade(null ,"Campinas", est2);
		
		est1.getCidades().add(c1);
		est2.getCidades().add(c2);
		est2.getCidades().add(c3);

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		
		Endereco e1 = new Endereco(null, "Rua flores", "300", "Apto 203", "Jardim", "38220834",c1,cli1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012",c2,cli1);
		cli1.getTelefones().add("27363323");
		cli1.getTelefones().add("93838393");
		
		cli1.getEnderecos().add(e1);
		cli1.getEnderecos().add(e2);
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"),cli1,e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"),cli1,e2);
		
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.0, 1, 2000.0);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		PagamentoComCartao pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		
		PagamentoComBoleto pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sd.parse("20/10/2017"), null); 
		ped2.setPagamento(pagto2);
		
		categoriaRepo.save(cat1);
		categoriaRepo.save(cat2);
		produtoRepo.save(p1);
		produtoRepo.save(p2);
		produtoRepo.save(p3);
		estadoRepo.save(est1);
		estadoRepo.save(est2);
		cidadeRepo.save(c1);
		cidadeRepo.save(c2);
		cidadeRepo.save(c3);
		clienteRepo.save(cli1);
		enderecoRepo.save(e1);
		enderecoRepo.save(e2);
		pedidoRepo.save(ped1);
		pedidoRepo.save(ped2);
		itempedidoRepo.save(ip1);
		itempedidoRepo.save(ip2);
		itempedidoRepo.save(ip3);
		pagamentoRepo.save(pagto1);
	}

}
