package com.alanvieceli.cursouml.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alanvieceli.cursouml.domains.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
