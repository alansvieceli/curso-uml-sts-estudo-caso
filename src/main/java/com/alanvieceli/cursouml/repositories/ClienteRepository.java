package com.alanvieceli.cursouml.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alanvieceli.cursouml.domains.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
