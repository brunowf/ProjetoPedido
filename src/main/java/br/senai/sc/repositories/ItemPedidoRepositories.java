package br.senai.sc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senai.sc.domain.ItemPedido;

@Repository
public interface ItemPedidoRepositories extends JpaRepository<ItemPedido, Integer>{

}
