package br.senai.sc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senai.sc.domain.Cidade;

@Repository
public interface CidadeRepositories extends JpaRepository<Cidade, Integer> {

}
