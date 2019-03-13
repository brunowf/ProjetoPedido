package br.senai.sc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.senai.sc.domain.Categoria;
import br.senai.sc.domain.Cidade;
import br.senai.sc.domain.Estado;
import br.senai.sc.domain.Produto;
import br.senai.sc.repositories.CategoriaRepositories;
import br.senai.sc.repositories.CidadeRepositories;
import br.senai.sc.repositories.EstadoRepositories;
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

	@Override
	public void run(String... args) throws Exception {
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
	}

}
