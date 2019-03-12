package br.senai.sc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.senai.sc.domain.Categoria;
import br.senai.sc.domain.Produto;
import br.senai.sc.repositories.CategoriaRepositories;
import br.senai.sc.repositories.ProdutoRepositories;

@SpringBootApplication
public class ProjetoPedidoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProjetoPedidoApplication.class, args);
	}
	
	@Autowired
	private CategoriaRepositories repo;
	
	@Autowired
	private ProdutoRepositories rep;

	@Override
	public void run(String... args) throws Exception {
		Categoria c = new Categoria(null, "informática");
		Categoria d = new Categoria(null, "Escritório");
		Produto e = new Produto(null, "Teclado", 22.00);
		Produto f = new Produto(null, "Mouse", 35.50);
		repo.save(c);
		repo.save(d);
		rep.save(e);
		rep.save(f);
	}

}
