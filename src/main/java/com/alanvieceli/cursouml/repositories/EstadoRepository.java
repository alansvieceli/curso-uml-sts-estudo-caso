package com.alanvieceli.cursouml.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alanvieceli.cursouml.domains.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}
