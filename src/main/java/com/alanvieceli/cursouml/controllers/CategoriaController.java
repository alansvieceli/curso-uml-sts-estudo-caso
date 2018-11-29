package com.alanvieceli.cursouml.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alanvieceli.cursouml.domains.Categoria;
import com.alanvieceli.cursouml.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService serv;
	
	@GetMapping(value="{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Categoria obj = serv.buscar(id);
		
		return ResponseEntity.ok().body(obj);
	}

}
