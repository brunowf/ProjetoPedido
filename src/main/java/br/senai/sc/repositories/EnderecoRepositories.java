package br.senai.sc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senai.sc.domain.Endereco;

@Repository
public interface EnderecoRepositories extends JpaRepository<Endereco, Integer>{

}
