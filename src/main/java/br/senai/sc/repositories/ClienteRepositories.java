package br.senai.sc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senai.sc.domain.Cliente;

@Repository
public interface ClienteRepositories extends JpaRepository<Cliente, Integer>{

}
