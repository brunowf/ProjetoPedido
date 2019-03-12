package br.senai.sc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senai.sc.domain.Produto;

@Repository
public interface ProdutoRepositories extends JpaRepository<Produto, Integer>{

}
