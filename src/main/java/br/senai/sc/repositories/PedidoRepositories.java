package br.senai.sc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senai.sc.domain.Pedido;

@Repository
public interface PedidoRepositories extends JpaRepository<Pedido, Integer>{

}
